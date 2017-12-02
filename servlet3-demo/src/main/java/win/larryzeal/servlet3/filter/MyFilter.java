package win.larryzeal.servlet3.filter;

import win.larryzeal.servlet3.Consts;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by 张少昆 on 2017/11/29.
 */
// 不是/**？  还可以使用servlet！    TODO serlvet是async，filter也要是async的才行
//分发类型：默认request，就是说其他的如forward、async、include、error都不拦截。
@WebFilter( urlPatterns = "/*", asyncSupported = true, dispatcherTypes = {DispatcherType.REQUEST} )
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        System.out.println("win.larryzeal.servlet3.filter.MyFilter is inited");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        System.out.println("过滤器过滤中");
        request.setAttribute(Consts.KEY, LocalDateTime.now());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy(){
    }
}
