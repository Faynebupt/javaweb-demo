package servlet.entity;

/**
 * Created by 张少昆 on 2017/11/5.
 */
public class Header {
    private String key;
    private String value;

    public Header(){
    }

    public Header(String key, String value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString(){
        return "Header{" +
                       "key='" + key + '\'' +
                       ", value='" + value + '\'' +
                       '}';
    }
}
