package socket.web;


import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 * 多次请求示意。
 * Created by 张少昆 on 2017/11/4.
 */
public class Server {
    public static final int PORT = 8080;
    private static ServerSocket serverSocket = null;

    public static void main(String[] args) throws IOException{
        Server.start();
    }

    private Server(){}

    /**
     * @throws IOException
     */
    public static void start() throws IOException{
        if(serverSocket == null){
            serverSocket = new ServerSocket(PORT);
            System.out.println("---------服务器已启动@" + LocalDateTime.now() + "---------");
        }
        while(true){
            Socket conn = serverSocket.accept();
            new Thread(() -> {
                try{
                    process(conn);
                } catch(IOException e){
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
    public static void process(Socket conn) throws IOException{
        // 处理来信
        BufferedInputStream in = new BufferedInputStream(conn.getInputStream());

        int available = in.available();
        byte[] bytes = new byte[available];
        int len = in.read(bytes);// -1 if eof

        System.out.println("收到的消息是：------------------");
        System.out.println(new String(bytes));
        System.out.println("------------------");

        // 准备去信
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        // out.write("来自服务器的响应@" + LocalDateTime.now());
        out.write(Server.response);
        out.flush();
        out.close();
        conn.close();
    }

    public static final String response = "HTTP/1.1 200 OK\n" +
                                                  "Content-Type: text/html\n" +
                                                  "\n" +
                                                  Server.entity;
    public static final String entity = "<!DOCTYPE html>\n" +
                                          "<html lang=\"en\">\n" +
                                          "\n" +
                                          "<head>\n" +
                                          "    <meta charset=\"UTF-8\">\n" +
                                          "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                                          "    <title>Response from Server</title>\n" +
                                          "</head>\n" +
                                          "\n" +
                                          "<body>\n" +
                                          "    <fieldset>\n" +
                                          "        <legend>赵敏信息</legend>\n" +
                                          "        <label for=\"name\">原名\n" +
                                          "            <input type=\"text\" name=\"name\" value=\"敏敏穆特尔\">\n" +
                                          "        </label>\n" +
                                          "        <br>\n" +
                                          "        <label for=\"from\">出处\n" +
                                          "            <input type=\"text\" name=\"from\" value=\"倚天屠龙记\">\n" +
                                          "        </label>\n" +
                                          "        <br>\n" +
                                          "    </fieldset>\n" +
                                          "\n" +
                                          "</body>\n" +
                                          "\n" +
                                          "</html>";

}
