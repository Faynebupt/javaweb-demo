package servlet.web;


import org.junit.Test;
import servlet.container.Container;

/**
 * Created by 张少昆 on 2017/11/5.
 */
public class ContainerTest {
    @Test
    public void processLine(){
        String line="GET http://localhost:8080/demo/get?name=jenny&age=10 HTTP/1.1";
        Container.processLine(line);
    }
}