package win.larryzeal.servlet3;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

/**
 * TODO listener注册方式：
 * ①web.xml；②@WebListener；③任何能拿到servlet context的地方。
 * <p>
 * Created by 张少昆 on 2017/11/29.
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event){
        System.out.println(event.getServletContext().getServletContextName() + " is initialized!");
        //TODO 可以做你想做的任何事...注册listener、filter、servlet都行，或者其他的操作
//        ServletRegistration
//        FilterRegistration
    }

    @Override
    public void contextDestroyed(ServletContextEvent event){
        System.out.println(event.getServletContext().getServletContextName() + " is shutting down!");
    }
}
