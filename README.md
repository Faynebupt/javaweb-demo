##HTTP 消息的组成
    起始行
    消息头
    空行
    [可选的消息体]

##例子
    GET 请求
        GET /xxx/xxx/xxx.html HTTP/1.1  
        Accept: */*  
        Accept-Language: zh-CN  
        User-Agent: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1) ; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; InfoPath.2; CIBA; Tablet PC 2.0)  
        Accept-Encoding: gzip, deflate  
        Host: www.xxxxx.com  
        Connection: Keep-Alive  
        Cookie: xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx 
        [最后是空白行，必须有]         
######
    POST 请求
        POST /submit.do HTTP/1.1  
        Accept: */*  
        Accept-Language: zh-CN  
        User-Agent: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1) ; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; InfoPath.2; CIBA; Tablet PC 2.0)  
        Accept-Encoding: gzip, deflate  
        Content-Type: application/x-www-form-urlencoded;charset=utf-8
        Host: www.xxxxx.com  
        Connection: Keep-Alive  
        Cookie: xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx 
        [空白行，必须有]     
        name=xxx&age=xxx&pwd=xxx
######
    响应
        HTTP/1.1 200 OK  
        Cache-Control: private  
        Content-Type: text/html; charset=utf-8  
        Content-Encoding: gzip  
        Server: nginx/1.11  
        Date: Mon, 20 Sep 2010 04:28:12 GMT  
        Content-Length: 55555  
        [空白行，必须有]     
        <html>....</html>
        


        