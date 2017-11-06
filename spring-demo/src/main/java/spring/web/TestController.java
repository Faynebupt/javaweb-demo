package spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张少昆 on 2017/11/6.
 */
@Controller
@RequestMapping( "/test" )
public class TestController {


    @RequestMapping( value = "/a" )
    @ResponseBody
    public Map a(){
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        return map;
    }
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //

    @RequestMapping( value = "/b", produces = "text/html;charset=utf-8" )
    @ResponseBody //这个，不是返回json的意思，而是返回response body！你指定produce什么，它就是什么！
    public String b(){
        String html = "<html>" +
                              "<head>" +
                              "<title>Servlet DEMO</title>" +
                              "</head>" +
                              "<body>" +
                              "<h1>IF BY A MIRACLE, HELLO THERE - from <font color='red'>TestController#b</font></h1>" +
                              "@" + LocalDateTime.now() +
                              "</body>" +
                              "</html>";
        return html;
    }
}
