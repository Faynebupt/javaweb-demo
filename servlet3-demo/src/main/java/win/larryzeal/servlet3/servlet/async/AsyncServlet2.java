package win.larryzeal.servlet3.servlet.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * 练习异步Servlet。
 * 测试dispatch到底是怎么回事！
 * <p>
 * Created by 张少昆 on 2017/12/2.
 */
@WebServlet( asyncSupported = true, urlPatterns = "/async2" )
public class AsyncServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("进入Servlet的时间：" + LocalDateTime.now() + ".<br/>");
        writer.flush();
        //下面这俩，到底干啥的？
        // req.getRequestDispatcher("").forward(req, resp);
        // req.getRequestDispatcher("").include(req, resp);

        AsyncContext asyncContext = req.startAsync();  //Servlet 3.0 还为异步处理提供了一个监听器，使用 AsyncListener 接口表示
        // AsyncContext asyncContext1 = req.startAsync(req, resp);//奇怪，这个和上面的什么区别？？？
        AsyncServlet.asyncProcess(asyncContext, false);
        //TODO 这个到底干啥的？
        // 而且，前提是不能在异步中complete，否则报错！是IllegalStateException！
        // 报错也就罢了，为什么重复输出？？？而且是同一个response！有意思
        // 如果异步中不complete，也会报错，两种错误，输出流空指针，是因为这里提前分派了吗？
        // TODO 归根结底，只能在异步中始终，不能在异步之前的servlet中使用！
        // asyncContext.dispatch();

        writer.println("结束Servlet的时间：" + LocalDateTime.now() + ".<br/>");
        writer.flush();
    }


}
