package servlet.entity.io;

import servlet.entity.io.MyServletInputStream;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * Created by 张少昆 on 2017/11/5.
 */
public class MyServletRequest implements ServletRequest {
    //TODO
    private MyServletInputStream inputStream;
    private BufferedReader bufferedReader;

    //TODO
    public MyServletRequest(MyServletInputStream inputStream){
        this.inputStream = inputStream;
        this.bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public Object getAttribute(String name){
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames(){
        return null;
    }

    @Override
    public String getCharacterEncoding(){
        return null;
    }

    @Override
    public void setCharacterEncoding(String env) throws UnsupportedEncodingException{

    }

    @Override
    public int getContentLength(){
        return 0;
    }

    @Override
    public long getContentLengthLong(){
        return 0;
    }

    @Override
    public String getContentType(){
        return null;
    }

    //TODO
    @Override
    public ServletInputStream getInputStream() throws IOException{
        return inputStream;
    }


    @Override
    public String getParameter(String name){
        return null;
    }

    @Override
    public Enumeration<String> getParameterNames(){
        return null;
    }

    @Override
    public String[] getParameterValues(String name){
        return new String[0];
    }

    @Override
    public Map<String, String[]> getParameterMap(){
        return null;
    }

    private String protocol;
    private String schema;
    // TODO
    @Override
    public String getProtocol(){
        return protocol;
    }

    // TODO
    @Override
    public String getScheme(){
        return schema;
    }

    @Override
    public String getServerName(){
        return null;
    }

    @Override
    public int getServerPort(){
        return 0;
    }

    // TODO
    @Override
    public BufferedReader getReader() throws IOException{
        return this.bufferedReader;
    }

    @Override
    public String getRemoteAddr(){
        return null;
    }

    @Override
    public String getRemoteHost(){
        return null;
    }

    @Override
    public void setAttribute(String name, Object o){

    }

    @Override
    public void removeAttribute(String name){

    }

    @Override
    public Locale getLocale(){
        return null;
    }

    @Override
    public Enumeration<Locale> getLocales(){
        return null;
    }

    @Override
    public boolean isSecure(){
        return false;
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path){
        return null;
    }

    @Override
    public String getRealPath(String path){
        return null;
    }

    @Override
    public int getRemotePort(){
        return 0;
    }

    @Override
    public String getLocalName(){
        return null;
    }

    @Override
    public String getLocalAddr(){
        return null;
    }

    @Override
    public int getLocalPort(){
        return 0;
    }

    @Override
    public ServletContext getServletContext(){
        return null;
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException{
        return null;
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException{
        return null;
    }

    @Override
    public boolean isAsyncStarted(){
        return false;
    }

    @Override
    public boolean isAsyncSupported(){
        return false;
    }

    @Override
    public AsyncContext getAsyncContext(){
        return null;
    }

    @Override
    public DispatcherType getDispatcherType(){
        return null;
    }
}
