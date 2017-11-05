package servlet.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Created by 张少昆 on 2017/11/4.
 */
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // super.doGet(req, resp);//FIXME
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<html>" +
                             "<head>" +
                             "<title>doGet返回的</title>" +
                             "</head>" +
                             "<body>" +
                             "<h1>吃酸奶不舔盖 - from <font color='red'>DemoServlet</font></h1>" +
                             "@" + LocalDateTime.now() +
                             "</body></html>");
        writer.flush();

    }
}
