package spring.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.boot.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by 张少昆 on 2017/11/25.
 */
@Controller
@RequestMapping("/user")
public class UserController2 {

    //------------------------------下面测试@RequestAttribute
    @RequestMapping( "/4/save1" )
    @ResponseBody
    public User test4save1(Map model){
        User user = new User();
        user.setName("名字1");
        user.setPwd("密码");
        user.setAge(17);
        model.put("user", user);
        return user;
    }

    @RequestMapping( "/4/save2" )
    @ResponseBody
    public User test4save2(HttpServletRequest request){
        User user = new User();
        user.setName("名字2");
        user.setPwd("密码");
        user.setAge(17);
        request.setAttribute("user", user);
        return user;
    }

    @RequestMapping( "/4/save11" )
    public String test4save11(Map model){ //看来request和model是一个范围，都是request范围
        User user = new User();
        user.setName("名字11");
        user.setPwd("密码");
        user.setAge(17);
        model.put("user", user);

        return "/user/4";
    }

    @RequestMapping( "/4/save22" )
    public String test4save22(HttpServletRequest request){ //看来request和model是一个范围，都是request范围
        User user = new User();
        user.setName("名字22");
        user.setPwd("密码");
        user.setAge(17);
        request.setAttribute("user", user);
        return "/user/4";
    }

    //如果访问完test4save1或test4save2，再访问本方法，仍然报错 - 原因在于，两次访问，不是一个request！除非转发或者jsp
    @RequestMapping( "/4" )
    @ResponseBody
    public User test4(@RequestAttribute User user, BindingResult result){ //奇怪，就算异常了，也没有result吗？
        if(result.hasErrors()){
            System.err.println("吼吼 有错误发生");
        }
        System.out.println(user);
        return user;
    }
}
