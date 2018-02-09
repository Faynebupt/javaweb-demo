package spring.web;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张少昆 on 2018/2/9.
 */
@RestController
@RequestMapping( "/date" )
public class DateController {

    @RequestMapping( "/1" )
    public Map test1(){
        HashMap hashMap = new HashMap();
        hashMap.put("date", new Date());

        return hashMap;
    }

    //提示没有 字符串-日期的转换器
    @RequestMapping( "/2" )
    public Map test2(@RequestParam( "date" ) Date date){
        System.out.println("date received: " + date);
        HashMap hashMap = new HashMap();
        hashMap.put("date", new Date());

        return hashMap;
    }

    //ok，现在好了
    @RequestMapping( "/3" )
    public Map test3(@RequestParam( "date" ) @DateTimeFormat( pattern = "yyyyMMdd" ) Date date){
        System.out.println("date received: " + date);
        HashMap hashMap = new HashMap();
        hashMap.put("date", new Date());

        return hashMap;
    }
}
