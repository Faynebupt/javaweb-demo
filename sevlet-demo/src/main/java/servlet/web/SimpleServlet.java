package servlet.web;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by 张少昆 on 2017/11/4.
 */
public class SimpleServlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException{
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig(){
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
        // String protocol = req.getProtocol();
        // String scheme = req.getScheme();
        // String serverName = req.getServerName();
        // int serverPort = req.getServerPort();
        // Map<String, String[]> parameterMap = req.getParameterMap();
        //
        // System.out.println(protocol);
        // System.out.println(scheme);
        // System.out.println(serverName);
        // System.out.println(serverPort);
        // System.out.println(parameterMap);

        ServletInputStream in = req.getInputStream();
        int available = in.available();//
        if(available > 0){
            byte[] bytes = new byte[available];
            int len = in.read(bytes);
            System.out.println("收到的消息：\n------------------------\n" + new String(bytes) + "\n------------------------");
        }

        // 这些东西无效，因为方法没有编写
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=utf-8");

        // 获取输出流，以便输出内容（到客户端）
        ServletOutputStream out = res.getOutputStream();
        String html = "<html>" +
                              "<head>" +
                              "<title>Servlet DEMO</title>" +
                              "</head>" +
                              "<body>" +
                              "<h1>IF BY A MIRACLE, HELLO THERE - from <font color='red'>SimpleServlet</font></h1>" +
                              "@" + LocalDateTime.now() +
                              "</body>" +
                              "</html>";
        String httpmsg="HTTP/1.1 200 OK\n"+
                               "Content-Type: text/html; charset=utf-8\n"+
                               "\n"+
                               html;
        out.write(html.getBytes("utf-8"));//thymeleaf
        // out.write(httpmsg.getBytes("utf-8"));
        out.flush();
        out.close();
    }


    @Override
    public String getServletInfo(){
        return "servlet.web.SimpleServlet";
    }


    @Override
    public void destroy(){
    }


}
