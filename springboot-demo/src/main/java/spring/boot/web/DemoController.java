package spring.boot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张少昆 on 2017/11/4.
 */
@RestController
@RequestMapping( "/spring" )
public class DemoController {

    @GetMapping( "/get" )
    public Map get(@RequestParam( "name" ) String name){
        System.out.println("客户端请求了：name=[" + name + "]!");
        Map<String, String> map = new HashMap<String, String>(2);
        map.put("name", name);
        map.put("something", "whatever");

        return map;
    }

    @PostMapping( "/post" )
    public Map map(@RequestParam( "name" ) String name, @RequestParam( "password" ) String passwd){
        Map<String, String> map = new HashMap<String, String>(2);
        map.put("name", name);
        map.put("password", passwd);

        return map;
    }
}
