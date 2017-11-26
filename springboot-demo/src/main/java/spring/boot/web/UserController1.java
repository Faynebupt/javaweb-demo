package spring.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.boot.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 测试 @ModelAttribute
 * <p>
 * Created by 张少昆 on 2017/11/25.
 */
@Controller
@RequestMapping( "/user" )
public class UserController1 {
    @RequestMapping( "/1" )
    @ResponseBody
    public User test1(@ModelAttribute( "user" ) User user){ // 前缀"user."无效，除非声明@ModelAttribute method
        System.out.println(user);
        return user;
    }

    @RequestMapping( "/2" )
    @ResponseBody
    public User test2(@ModelAttribute( "user2" ) User user){ // 前缀"user."无效，除非声明@ModelAttribute method
        System.out.println(user);
        return user;
    }

    @RequestMapping( "/3" )
    @ResponseBody
    public User test3(User user){ // 前缀"user."无效，除非声明@ModelAttribute method
        System.out.println(user);
        return user;
    }

    //卧槽，果然是Controller method执行就执行
    @ModelAttribute( "user" ) //利用这个名字，可以有多个@ModelAttribute method，这样可以不必执着于一个
    public User user(@RequestParam( "user.name" ) String name,
                     @RequestParam( "user.pwd" ) String pwd,
                     @RequestParam( "user.age" ) Integer age){
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        user.setAge(age);
        System.out.println("---------------------1");
        return user;
    }

    //卧槽，果然是Controller method执行就执行
    @ModelAttribute( "user2" ) //利用这个名字，可以有多个@ModelAttribute method，这样可以不必执着于一个
    public User user2(@RequestParam( "user.name" ) String name,
                      @RequestParam( "user.pwd" ) String pwd,
                      @RequestParam( "user.age" ) Integer age){
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        user.setAge(age);
        System.out.println("---------------------2");
        return user;
    }


}
