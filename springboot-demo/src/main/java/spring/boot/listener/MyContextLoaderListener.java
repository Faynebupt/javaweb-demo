package spring.boot.listener;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * Created by 张少昆 on 2017/11/14.
 */
public class MyContextLoaderListener extends ContextLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent event){
//        super.contextInitialized(event);
        System.out.println("我的？");
    }
}
