package servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取会话，从会话中拿到用户信息
        HttpSession session = req.getSession(false);
        if(session == null){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("用户未登录！");
            return;
        }
        User user = (User) session.getAttribute("user");
        if(user == null){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("用户未登录！");
            return;
        }
        //用户登录，将用户信息转成jason格式返回
        resp.setContentType("application/jason;charset=utf8");
        //user中含有password，防止泄露，限制为空
        user.setPassword("");
        String respJason = objectMapper.writeValueAsString(user);
        resp.getWriter().write(respJason);
    }
}
