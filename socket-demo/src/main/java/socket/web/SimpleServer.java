package socket.web;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;


/**
 * 一次性请求示意。
 * <p>
 * Created by 张少昆 on 2017/11/4.
 */
public class SimpleServer {
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException{
        //1. 创建服务器
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("---------服务器已启动@" + LocalDateTime.now() + "---------");

        //2. 监听请求，如有则创建socket连接
        Socket conn = serverSocket.accept();

        //3. 处理来信
        BufferedInputStream in = new BufferedInputStream(conn.getInputStream());

        byte[] bytes = new byte[1024 * 1024];// 1 MB
        int len = in.read(bytes);// -1 if eof

        System.out.println("收到的消息是：------------------");
        System.out.println(new String(bytes, 0, len));
        System.out.println("------------------");

        //4. 准备去信
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        out.write("来自服务器的响应@" + LocalDateTime.now());
        out.flush();

        //5. close
        out.close();
        conn.close();

        serverSocket.close();
    }
}
