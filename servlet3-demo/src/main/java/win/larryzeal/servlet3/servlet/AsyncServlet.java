package win.larryzeal.servlet3.servlet;

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
 * TODO 作用其上的filter也必须是异步的！
 * 结论：Servlet所谓的异步，就是让Servlet先返回，而将具体的共组交由其他线程负责。
 * 页面的表现就是先返回一部分，其他的慢慢返回 - 同一个请求 ！
 * <p>
 * Servlet 3.0 还为异步处理提供了一个监听器，使用 AsyncListener 接口表示。
 * onStartAsync、onError、onTimeout、onComplete。
 * ctx.addListener(new AsyncListener() {})即可注册Listener。
 * <p>
 * Created by 张少昆 on 2017/12/2.
 */
@WebServlet( asyncSupported = true, urlPatterns = "/async" )
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("进入Servlet的时间：" + LocalDateTime.now() + ".<br/>");
        writer.flush();

        AsyncContext asyncContext = req.startAsync();  //Servlet 3.0 还为异步处理提供了一个监听器，使用 AsyncListener 接口表示
        AsyncServlet.asyncProcess(asyncContext, true);

        writer.println("结束Servlet的时间：" + LocalDateTime.now() + ".<br/>");
        writer.flush();
    }

    /**
     * 模拟异步处理 - 注意，这里会自行返回响应！！！
     *
     * @param asyncContext 异步上下文
     * @param doComplete   异步线程中是否执行asyncContext.complete()
     */
    public static void asyncProcess(AsyncContext asyncContext, boolean doComplete){
        new Thread(() -> {
            try{
                PrintWriter writer = asyncContext.getResponse().getWriter();
                Thread.sleep(1000 * 3);
                writer.write("...async executing: " + LocalDateTime.now() + ".<br/>");
                writer.flush();
            } catch(IOException e){
                e.printStackTrace();
            } catch(InterruptedException e){
                e.printStackTrace();
            } finally{
                if(doComplete){
                    asyncContext.complete(); //TODO 已经完成了，就不能dispatch
                }
            }
        }).start();
    }
}
