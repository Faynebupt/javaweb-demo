package socket.util;

/**
 * Created by 张少昆 on 2017/11/4.
 */
public class HttpMessageUtil {
    public static String extract(String httpMsg){
        // 仅示意两种请求方式，其他还有PUT/HEAD/PATCH/DELETE/OPTIONS/TRACE/CONNECT
        if(httpMsg.startsWith("GET") || httpMsg.startsWith("get")){
            System.out.println("该消息是请求消息，请求方式为GET！");
        } else if(httpMsg.startsWith("POST") || httpMsg.startsWith("post")){
            System.out.println("该消息是请求消息，请求方式为POST！");
        } else{ // 如果不是请求，那就是响应了。同样，仅示意HTTP/1.0和HTTP/1.1，至于HTTPS或者其他协议就无视了。
            if(httpMsg.startsWith("HTTP/1.0") || httpMsg.startsWith("http/1.0")){
                System.out.println("该消息是响应消息，响应协议为HTTP/1.0");
            } else if(httpMsg.startsWith("HTTP/1.1") || httpMsg.startsWith("HTTP/1.1")){
                System.out.println("该消息是响应消息，响应协议为HTTP/1.1");
            } else{
                System.out.println("未知消息，不做处理");
                return "";
            }
        }

        // 获取第一行
        String uri_query = httpMsg.substring(0, httpMsg.indexOf("\n"));
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

        int blankline = httpMsg.indexOf("\n\n");


        return "";
    }
}
