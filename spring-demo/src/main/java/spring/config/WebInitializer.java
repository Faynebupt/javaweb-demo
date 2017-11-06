package spring.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;

/**
 * Created by 张少昆 on 2017/11/6.
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses(){
        return new Class[]{MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings(){
        return new String[]{"/"};
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException{
        //  *************** 解决编码问题 ***************
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding(StandardCharsets.UTF_8.displayName());
        encodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic encodingFilterRegistration = servletContext.addFilter("encodingFilter", encodingFilter);
        encodingFilterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.ERROR, DispatcherType.ASYNC), false, "/*");

        super.onStartup(servletContext);
    }
}
