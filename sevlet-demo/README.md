##两个Servlet：  
    SimpleServlet 是直接实现Servlet基类，自己去实现所有的功能（其实仅实现了一小部分）。  
    DemoServlet 是实现了HttpServlet，无需处理底层的代码，直接负责业务逻辑即可。

##说明    
    如果要使用tomcat容器启动
        ①请将servlet-api的依赖范围设为provided。
        ②请将servlet.web.SimpleServlet.service方法的输出改为out.write(httpmsg.getBytes("utf-8"))。
    如果要使用Container类启动，反过来操作即可。
    
    