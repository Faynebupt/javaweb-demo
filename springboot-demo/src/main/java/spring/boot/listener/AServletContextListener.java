package spring.boot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by 张少昆 on 2017/11/14.
 */
@WebListener
public class AServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        System.out.println("=============spring.boot.listener.AServletContextListener");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){

    }
}
