package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo info = new ResultInfo();

        response.setContentType("application/json;charset=utf-8");

        String checkcode = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(checkcode)) {
            //验证码错误
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //将info对象序列化为json
            String json = new ObjectMapper().writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || password == null){
            info.setFlag(false);
            info.setErrorMsg("用户名 密码 为空");
            String json = new ObjectMapper().writeValueAsString(info);
            response.getWriter().write(json);
            return;
        }

        UserService service = new UserServiceImpl();
        User u = service.login(username, password);
        if (u == null) {
            info.setFlag(false);
            info.setErrorMsg("用户名 密码 错误");
            String json = new ObjectMapper().writeValueAsString(info);
            response.getWriter().write(json);
            return;
        }
        if (!u.getStatus().equalsIgnoreCase("Y")) {
            info.setFlag(false);
            info.setErrorMsg("用户未邮箱验证");
            String json = new ObjectMapper().writeValueAsString(info);
            response.getWriter().write(json);
            return;
        }
        //将user 存入session
        request.getSession().setAttribute("user",u);

        //返回登陆成功信息
        info.setFlag(true);
        String json = new ObjectMapper().writeValueAsString(info);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
