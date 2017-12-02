package win.larryzeal.servlet3.servlet;

import win.larryzeal.servlet3.Consts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试request dispatcher到底是什么。
 * 怎么感觉forward和include没啥区别？
 * http://blog.csdn.net/huo2007201019/article/details/7584241
 * forward方法和include方法的区别：
 * forward方法调用后在响应中的没有提交的内容被自动消除。将请求转发给其他的Servlet后，由被调用的Servlet负责对请求做出响应，而原先Servlet的执行则终止。
 * include方法使原先的Servlet和转发到的Servlet都可以输出响应信息，即原先的Servlet还可以继续输出响应信息。
 * <p>
 * Created by 张少昆 on 2017/11/29.
 */
@WebServlet( urlPatterns = "/dispatcher/forward" )
public class RequestDispatcherForwardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //        super.doGet(req, resp);
        Object attribute = req.getAttribute(Consts.KEY);
        System.out.println(Consts.KEY + ": " + String.valueOf(attribute));

        //如果之前或者之后输出了内容，会出错！
        // PrintWriter writer = resp.getWriter();
        // writer.println("forward或include 之前");
        // writer.flush();
        req.getRequestDispatcher("/dispatcher/target").forward(req, resp); //转发。本servlet的所有输出都么有啦！！！
        // req.getRequestDispatcher("/dispatcher-b").include(req, resp); //包含 呀呀呀 是把其他的包含进来，不会修改原有的req、resp
        // writer.println("forward或include 之后");
        // writer.flush();
    }
}
