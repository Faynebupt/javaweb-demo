package spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by 张少昆 on 2017/11/6.
 */
@EnableWebMvc
@Configuration
@ComponentScan( basePackages = "spring.web",
                includeFilters = @ComponentScan.Filter( type = FilterType.ANNOTATION, classes = Controller.class ) )
public class MvcConfig {

}
