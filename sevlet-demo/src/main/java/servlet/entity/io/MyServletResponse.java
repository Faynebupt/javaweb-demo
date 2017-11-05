package servlet.entity.io;

import servlet.entity.io.MyServletOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * Created by 张少昆 on 2017/11/5.
 */
public class MyServletResponse implements ServletResponse {
    private MyServletOutputStream outputStream;
    private PrintWriter printWriter;

    public MyServletResponse(MyServletOutputStream outputStream){
        this.outputStream = outputStream;
        printWriter = new PrintWriter(this.outputStream);
    }

    @Override
    public String getCharacterEncoding(){
        return null;
    }

    @Override
    public String getContentType(){
        return null;
    }

    // TODO
    @Override
    public ServletOutputStream getOutputStream() throws IOException{
        return this.outputStream;
    }

    // TODO
    @Override
    public PrintWriter getWriter() throws IOException{
        return this.printWriter;
    }

    @Override
    public void setCharacterEncoding(String charset){

    }

    @Override
    public void setContentLength(int len){

    }

    @Override
    public void setContentLengthLong(long len){

    }

    @Override
    public void setContentType(String type){

    }

    @Override
    public void setBufferSize(int size){

    }

    @Override
    public int getBufferSize(){
        return 0;
    }

    @Override
    public void flushBuffer() throws IOException{

    }

    @Override
    public void resetBuffer(){

    }

    //TODO 关键
    @Override
    public boolean isCommitted(){
        return outputStream.isClosed();
    }

    @Override
    public void reset(){

    }

    @Override
    public void setLocale(Locale loc){

    }

    @Override
    public Locale getLocale(){
        return null;
    }
}
