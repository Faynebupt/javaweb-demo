package servlet.entity;

/**
 * Created by 张少昆 on 2017/11/5.
 */
public class ReqLine {
    private String method;
    private String uri;
    private String query;
    private String schema;

    public String getMethod(){
        return method;
    }

    public void setMethod(String method){
        this.method = method;
    }

    public String getUri(){
        return uri;
    }

    public void setUri(String uri){
        this.uri = uri;
    }

    public String getQuery(){
        return query;
    }

    public void setQuery(String query){
        this.query = query;
    }

    public String getSchema(){
        return schema;
    }

    public void setSchema(String schema){
        this.schema = schema;
    }

    /**
     * 返回原内容格式
     * @return
     */
    public String string(){
        if(query == null){
            return method + " " + uri + " " + schema;
        }
        return method + " " + uri + "?" + query + " " + schema;
    }

    @Override
    public String toString(){
        return "ReqLine{" +
                       "method='" + method + '\'' +
                       ", uri='" + uri + '\'' +
                       ", query='" + query + '\'' +
                       ", schema='" + schema + '\'' +
                       '}';
    }
}
