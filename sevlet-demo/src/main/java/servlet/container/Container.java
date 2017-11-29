package servlet.container;


import servlet.entity.HttpMsg;
import servlet.entity.ReqLine;
import servlet.entity.io.MyServletInputStream;
import servlet.entity.io.MyServletOutputStream;
import servlet.entity.io.MyServletRequest;
import servlet.entity.io.MyServletResponse;
import servlet.web.DemoServlet;
import servlet.web.SimpleServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet Container的作用，主要就是负责连接的创建与释放，从而使得用户可以专注于业务逻辑。
 * <p>
 * Created by 张少昆 on 2017/11/5.
 */
public class Container {

    public static void main(String[] args) throws IOException{
        // 创建容器
        Container container = new Container();
        // 注册 servlet - url 映射关系。注：实际应该通过读取web.xml中的内容进行。
        container.register(new SimpleServlet(), "/simple");
        container.register(new DemoServlet(), "/demo");
        // 启动服务
        container.start();
    }

    /*** 存储uri与servlet之间的关系*/
    private final Map<String, Servlet> MAPPING = new HashMap<>();

    /**
     * 注册 uri和servlet的关系。
     *
     * @param servlet
     * @param mapping
     */
    public void register(Servlet servlet, String mapping){
        MAPPING.put(mapping, servlet);
    }
    /*** 网络监听端口 */
    public static final int PORT = 8080;
    private static ServerSocket serverSocket = null;

    /**
     * 开启网络服务。
     *
     * @throws IOException
     */
    public void start() throws IOException{
        if(serverSocket == null){
            serverSocket = new ServerSocket(PORT);
            System.out.println("---------服务器已启动@" + LocalDateTime.now() + "---------");
        }
        while(true){
            Socket conn = serverSocket.accept();//等待连接建立
            new Thread(() -> { //开启线程，以便处理同时处理多个连接
                try{
                    processConn(conn);//处理连接
                } catch(IOException e){
                    e.printStackTrace();
                } catch(ServletException e){
                    e.printStackTrace();
                }
            }).start();
        }
    }

    /**
     * 处理socket连接
     *
     * @param conn socket连接
     * @throws IOException
     */
    public void processConn(Socket conn) throws IOException, ServletException{
        // 获取输入流
        BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
        int available = in.available();
        in.mark(available + 1024);
        byte[] bytes = new byte[available];
        // 读取输入流中的内容
        int len = in.read(bytes);// -1 if eof
        in.reset();// 复位
        String msg = new String(bytes); //接收到的消息全部
        // System.out.println("是否包含\\r\\n: " + msg.contains("\r\n"));//TODO

        HttpMsg httpMsg = processHttpMsg(msg);
        ReqLine reqLine = processLine(httpMsg.getLine());//请求行

        // 根据请求行的uri找到具体的Servlet
        Servlet servlet = MAPPING.get(reqLine.getUri());

        // 调用Servlet的service方法
        MyServletRequest req = new MyServletRequest(new MyServletInputStream(in));
        MyServletResponse res = new MyServletResponse(new MyServletOutputStream(conn.getOutputStream()));
        servlet.service(req, res);

        conn.close();
    }

    /**
     * 解析HTTP消息。判断是GET还是POST请求，或者是HTTP/1.0还是HTTP/1.1响应。
     *
     * @param msg
     */
    public static HttpMsg processHttpMsg(String msg){
        // 仅示意两种请求方式，其他还有PUT/HEAD/PATCH/DELETE/OPTIONS/TRACE/CONNECT
        if(msg.startsWith("GET") || msg.startsWith("get")){
            System.out.println("该消息是请求消息，请求方式为GET！");
        } else if(msg.startsWith("POST") || msg.startsWith("post")){
            System.out.println("该消息是请求消息，请求方式为POST！");
        } else{ // 如果不是请求，那就是响应了。同样，仅示意HTTP/1.0和HTTP/1.1，至于HTTPS或者其他协议就无视了。
            if(msg.startsWith("HTTP/1.0") || msg.startsWith("http/1.0")){
                System.out.println("该消息是响应消息，响应协议为HTTP/1.0");
            } else if(msg.startsWith("HTTP/1.1") || msg.startsWith("HTTP/1.1")){
                System.out.println("该消息是响应消息，响应协议为HTTP/1.1");
            } else{
                System.out.println("未知消息，不做处理");
            }
        }
        HttpMsg obj = new HttpMsg();
        // System.out.println("HTTP MESSAGE: \n------------------------\n" + msg + "\n------------------------");

        // 获取第一行
        String line = msg.substring(0, msg.indexOf("\r\n"));//FIXME 可能\n，没有\r
        obj.setLine(line);
        String headers = msg.substring(msg.indexOf("\r\n") + 1, msg.indexOf("\r\n\r\n"));//FIXME 可能\n，没有\r
        obj.setHeaders(headers);

        String body = msg.substring(msg.indexOf("\r\n\r\n") + 4);//FIXME 可能\n，没有\r
        obj.setBody(body);
        return obj;
    }

    /**
     * 解析第一行（仅示意 解析请求）
     *
     * @param line
     */
    public static ReqLine processLine(String line){
        String[] arr = line.split("[\\?\\s]");// 有问号
        String method = arr[0];
        String uri = arr[1];
        String schema = null;
        String query = null;
        if(arr.length == 3){
            schema = arr[2];
        } else if(arr.length == 4){
            query = arr[2];
            schema = arr[3];
        }
        // System.out.println(String.format("method:[%s],uri:[%s],query:[%s],schema:[%s]", method, uri, query, schema));

        ReqLine obj = new ReqLine();
        obj.setMethod(method);
        obj.setUri(uri);
        obj.setQuery(query);
        obj.setSchema(schema);

        return obj;
    }

}
