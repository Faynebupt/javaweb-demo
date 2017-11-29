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
