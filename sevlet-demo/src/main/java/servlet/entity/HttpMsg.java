package servlet.entity;

/**
 * Created by 张少昆 on 2017/11/5.
 */
public class HttpMsg {
    private String line;
    private String headers; // 简化示意！
    private String body;

    public String getLine(){
        return line;
    }

    public void setLine(String line){
        this.line = line;
    }

    public String getHeaders(){
        return headers;
    }

    public void setHeaders(String headers){
        this.headers = headers;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }

    /**
     * 返回原内容格式
     *
     * @return
     */
    public String str(){
        if(body == null){
            return line + "\n" + headers + "\n\n";
        }
        return line + "\n" + headers + "\n\n" + body;
    }

    @Override
    public String toString(){
        return "HttpMsg{" +
                       "line='" + line + '\'' +
                       ", headers=" + headers +
                       "\n" +   // blank line
                       ", body='" + body + '\'' +
                       '}';
    }
}
