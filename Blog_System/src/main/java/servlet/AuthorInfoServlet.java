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
import java.io.IOException;

@WebServlet("/getAuthorInfo")
public class AuthorInfoServlet extends HttpServlet {
    private ObjectMapper objectMapper= new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.拿到请求中的blogId
        String blogId = req.getParameter("blogId");
        if(blogId == null){
            resp.setContentType("text/html:charset=utf8");
            resp.getWriter().write("请求缺少blogId!");
            return;
        }
        //2.在blog表中找到Blog对象
        BolgDao blogDao = new BolgDao();
        Blog blog = blogDao.getBlog(Integer.parseInt(blogId));
        if(blog == null){
            resp.setContentType("text/html:charset=utf8");
            resp.getWriter().write("blogId未找到！");
            return;
        }
        //3.根据blog对象中的userId,从user中查询到对象
        UserDao userDao = new UserDao();
        User user = userDao.getUserByUserId(blog.getUserId());
        if(user == null){
            resp.setContentType("text/html:charset=utf8");
            resp.getWriter().write("userId未找到！");
            return;
        }
        //4.把该user对象，返回浏览器
        //防止user密码被抓包中泄露
        user.setPassword("");
        String respJson = objectMapper.writeValueAsString(user);
        resp.setContentType("application/json:charset=utf8");
        resp.getWriter().write(respJson);
    }
}
