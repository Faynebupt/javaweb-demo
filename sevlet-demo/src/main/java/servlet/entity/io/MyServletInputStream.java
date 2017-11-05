package servlet.entity.io;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 张少昆 on 2017/11/5.
 */
public class MyServletInputStream extends ServletInputStream {
    private BufferedInputStream bis;

    public MyServletInputStream(InputStream in){
        bis = new BufferedInputStream(in);
    }

    public MyServletInputStream(BufferedInputStream in){
        bis = in;
        // try{
        //     bis.reset();
        // } catch(IOException e){
        //     e.printStackTrace();
        // }
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public boolean isReady(){
        return false;
    }

    @Override
    public void setReadListener(ReadListener readListener){

    }

    //TODO
    @Override
    public int read() throws IOException{
        return bis.read();
    }

    @Override
    public boolean markSupported(){
        return bis.markSupported();
    }

    @Override
    public synchronized void mark(int readlimit){
        bis.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException{
        bis.reset();
    }

    @Override
    public int available() throws IOException{
        return bis.available();
    }
}
