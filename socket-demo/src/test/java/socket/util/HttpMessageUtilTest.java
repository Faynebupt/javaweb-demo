package socket.util;


import org.junit.Test;

/**
 * Created by 张少昆 on 2017/11/4.
 */
public class HttpMessageUtilTest {
    String msg = "GET /web/get?name=jenny&age=10 HTTP/1.1\n" +
                         "Host: localhost:8080\n" +
                         "Connection: keep-alive\n" +
                         "Cache-Control: max-age=0\n" +
                         "Upgrade-Insecure-Requests: 1\n" +
                         "User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36 Maxthon/5.1.3.2000\n" +
                         "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                         "DNT: 1\n" +
                         "Accept-Encoding: gzip, deflate\n" +
                         "Accept-Language: zh-CN\n\n";

    @Test
    public void extract() throws Exception{
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
                return;
            }
        }

        // 获取第一行
        String uri_query = msg.substring(0, msg.indexOf("\n"));
        System.out.println(uri_query);
        String[] arr = uri_query.split("[\\?\\s]");
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
        System.out.println(String.format("method:[%s],uri:[%s],query:[%s],schema:[%s]", method, uri, query, schema));

        int blankline = msg.indexOf("\n\n");


    }

}