package win.larryzeal.servlet3.servlet;

import win.larryzeal.servlet3.Consts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 张少昆 on 2017/11/29.
 */
@WebServlet( urlPatterns = "/some" )
public class SomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        super.doGet(req, resp);
        Object attribute = req.getAttribute(Consts.KEY);
        System.out.println(Consts.KEY + ": " + String.valueOf(attribute));

        resp.sendRedirect("/");//就是为了演示，么意义
    }
}
