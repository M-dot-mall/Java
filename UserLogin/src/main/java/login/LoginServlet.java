package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.读取请求传来的文件参数（用户名和密码）
        //  先给请求设置字符集，否则如果username是中文，此处的getParameter可能会乱码
        req.setCharacterEncoding("utf8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.验证用户名密码，一般来说，验证用户密码需要通过数据库
        //  注意：如果getParameter可能会拿到null，为了避免空指针异常，下面这种比较方式更合适的写法
        if(!"zhangsan".equals(username) || !"123".equals(password)){
            //登录失败
            //返回用户一个提示
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前用户名或密码错误");
            return;
        }
        //3.登录成功,给这个用户创建一个会话
        //  可以给回话中保存一些自定义数据，通过Attribute的方式保存
        HttpSession session = req.getSession(true);
        //  此处Attribute也是键值对，这里的内容存储什么都可以，程序员自定义
        //  数据存储好后，后续跳转到其他页面，耶稣是吧这个数据从会话中取出来
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        //4.此时相当于登录成功，让页面跳转到其他页面(重定向)
        resp.sendRedirect("index");
    }
}
