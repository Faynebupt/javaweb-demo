package win.larryzeal.servlet3.servlet.post;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 如果满足条件：
 * 1. 该请求是一个 HTTP 或 HTTPS 请求。
 * 2. HTTP 方法是 POST。
 * 3. 内容类型是 application/x-www-form-urlencoded。
 * 4. 该 servlet 已经对 request 对象的任意 getParameter 方法进行了初始调用.
 * 那么，就不能通过InputStream读取数据！
 * 否则就可以！！！
 * <p>
 * Created by 张少昆 on 2017/12/3.
 */
@WebServlet( urlPatterns = "/post" )
public class PostServlet extends HttpServlet {
    //localhost:8080/post?key=qs
    //key=1&key=2&key=3
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //TODO 说明，如果使用getParameter，那只能拿到第一个value！如果不想遗漏，最好使用getParameterValues！！！
        String queryString = req.getQueryString();
        String key = req.getParameter("key");
        String[] keys = req.getParameterValues("key");

        System.out.println("query string is " + queryString); //query string is key=qs
        System.out.println("key: " + key); //key: qs
        System.out.println("keys: " + Arrays.toString(keys)); //keys: [qs, 1, 2, 3]

        ServletInputStream in = req.getInputStream();
        System.out.println("(inputStream == null) = " + (in == null)); //就算读取了parameter，in也不是null，而是没有内容啦
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while((line = br.readLine()) != null){
            System.out.println(line); //啥都拿不到，因为内容已经被读取！
        }

        PrintWriter writer = resp.getWriter();
        writer.println("hehe @" + LocalDateTime.now() + "<br/>");
        writer.flush();
        writer.close();//TODO 不能吧，否则filter不就抓瞎了
    }
}
