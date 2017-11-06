package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by 张少昆 on 2017/11/6.
 */
@Configuration
@ComponentScan( basePackages = "spring.web",
                excludeFilters = @ComponentScan.Filter( type = FilterType.ANNOTATION, classes = Controller.class ) )
public class AppConfig {

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
