package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by 张少昆 on 2017/11/6.
 */
@EnableWebMvc
@Configuration
@ComponentScan( basePackages = "spring.web",
                includeFilters = @ComponentScan.Filter( type = FilterType.ANNOTATION, classes = Controller.class ) )
public class MvcConfig {

    // 使用common multipart
    @Bean
    public MultipartResolver commonMultipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        //...
        return resolver;
    }

    // 使用standard servlet multipart ，二选一即可
    // @Bean
    public MultipartResolver servletMultipartResolver(){
        StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
        //...
        return resolver;
    }
}
