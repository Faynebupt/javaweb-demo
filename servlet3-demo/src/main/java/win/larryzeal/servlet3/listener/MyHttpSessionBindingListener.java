package win.larryzeal.servlet3.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 奇怪，这个和attributeListener什么区别？
 * Created by 张少昆 on 2017/12/3.
 */
public class MyHttpSessionBindingListener implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event){

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event){

    }
}
