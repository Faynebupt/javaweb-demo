package win.larryzeal.servlet3;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * FIXME 奇怪，这个接口要怎么用？需要SPI吗？还真是 。。。
 * 注意，是在classpath下的META-INF，而非WEB下的
 * <p>
 * Created by 张少昆 on 2017/11/29.
 */
//@HandlesTypes( value = {Servlet.class, Filter.class, ServletContextListener.class} )
@HandlesTypes( value = {ServletRegistration.class, FilterRegistration.class} )//Spring管理的servlet、filter注册应该就是这么做的吧
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException{
        System.out.println("servlet container启动中");
        System.out.println("传进来的class集合是：" + c);
    }
}
