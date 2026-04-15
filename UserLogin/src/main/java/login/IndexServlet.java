package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.先获取到当前用户对应的会话对象，生成的页面要根据当前用户信息来构造
        HttpSession session = req.getSession(false);
        if(session == null){
            //session不存在，或者sessionId没有在hash表中找到
            resp.setContentType("text/html;charset = utf8");
            resp.getWriter().write("您当前还尚未登录！");
            return;
        }
        //2.从会话中拿到当前存储的用户信息
        //  此处强转，需要程序员自行保证，类型是靠谱的
        String username = (String) session.getAttribute("username");
        Long loginTime = (Long) session.getAttribute("loginTime");
        //3.生成一个页面，把上述数据显示在页面上
        resp.setContentType("text/html;charset=utf8");
        String respBody = "欢迎你"+username+"!您上次登录时间为："+loginTime;
        resp.getWriter().write(respBody);
    }
}
