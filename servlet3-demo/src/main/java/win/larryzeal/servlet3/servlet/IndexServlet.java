package win.larryzeal.servlet3.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * TODO 如何注册servlet？
 * ①web.xml；②@WebServlet；③ServletContextListener中拿到servlet context即可注册。
 * ④只要能拿到servlet context，任何地方都可以！！！
 * <p>
 * Created by 张少昆 on 2017/11/29.
 */
@WebServlet( urlPatterns = {"/", "/index", "/index.html"} )
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        super.doGet(req, resp);
        System.out.println("index被访问啦");
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("index.html");
        ServletOutputStream out = resp.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        String line = null;
        while((line = br.readLine()) != null){
//            out.println(line); //FIXME 不能直接输出utf-8编码，因为tomcat默认输出iso-8859-1编码，然后转一下。。。
            out.println(new String(line.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
        }

        in.close();
        br.close();
        out.flush();
        out.close();
    }


}
