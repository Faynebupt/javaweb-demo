#Servlet 3 
###收获
    1. ServletContainerInitializer 对应容器初始化时的操作。  
    2. ServletContextListener 对应ServletContext创建、销毁时的操作。
    
###注册方式
    1. Servlet注册方式：
        1. web.xml
        2. @WebServlet
        3. 任何能拿到ServletContext的地方
        
    2. Filter注册方式：
        1. web.xml
        2. @WebFilter
        3. 任何能拿到ServletContext的地方
        
    3. Listener注册方式：
        1. web.xml
        2. @WebListener
        3. 任何能拿到ServletContext的地方
        
##但是
    一般都是以ServletContainerInitializer为入口！        


##关于异步Servlet
    1. 异步Servlet其实就是让Servlet线程提前返回，但不返回响应 -- 而是交由异步线程去处理。
    2. 注意，此时不能使用Content-Length header，因为长度不定。
    3. 注意，此时通常使用Transfer-Encoding:chunked和Content-Type:chunked。

##几个Servlet作用说明
    1. IndexServlet 首页，返回classpath:index.html。
    2. SomeServlet 测试MyFilter用的，简单的重定向到首页。
    3. AsyncServlet 测试Servlet的异步操作 - 最基本的。
    4. AsyncServlet 测试Servlet的异步操作 - 深入一点。
    5. RequestDispatcherForwardServlet 测试req.getRequestDispatcher("").forward
    6. RequestDispatcherIncludeServlet 测试req.getRequestDispatcher("").include
    7. RequestDispatcherTargetServlet 用于5和6的测试！注意，不能返回完整的<html>，否则include可能报错。
    8. PostServlet 用于测试post form请求的参数获取。
    9. PartServlet 用于测试文件上传。Servlet3很好。