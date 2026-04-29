package servlet;

import model.DBUtil;
import model.Blog;
import model.BolgDao;
import model.User;
import model.UserDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BolgDao bolgDao = new BolgDao();
        String respJson = "";
        String blogId = req.getParameter("blogId");
        if(blogId == null){
            //请求中没有query String，请求来自博客列表页
            //查询数据库，得到博客列表
            List<Blog> blogs = bolgDao.getBlogs();
            //把博客列表数据按照json格式返回
            respJson = objectMapper.writeValueAsString(blogs);
        }else{
            //请求中存在query string，请求来自博客详情页
            Blog blog = bolgDao.getBlog(Integer.parseInt(blogId));
            respJson = objectMapper.writeValueAsString(blog);
        }
        System.out.println("respJson:"+respJson);
        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(respJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.读取请求中的参数
        req.setCharacterEncoding("UTF8");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if(title == null || title.length()==0 || content == null || content.length() == 0){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前传过来的标题或正文为空！无法新增博客！");
            return;
        }
        //2.从会话中，拿到当前登录的用户userId
        HttpSession session = req.getSession(false);
        if(session == null){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前用户未登录！");
            return;
        }
        User user = (User)session.getAttribute("user");
        if(user == null){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前用户未登录！");
            return;
        }
        //3.构造blog对象
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        //获取当前登录用户的userId
        blog.setUserId(user.getUserId());
        //插入到数据中
        BolgDao bolgDao = new BolgDao();
        bolgDao.insert(blog);
        //5.返回302的从定向正文报文，跳转到博客列表页
        resp.sendRedirect("blog_list.html");
    }
}
