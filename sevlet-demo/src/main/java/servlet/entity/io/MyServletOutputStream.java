package servlet.entity.io;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by 张少昆 on 2017/11/5.
 */
public class MyServletOutputStream extends ServletOutputStream {
    private BufferedOutputStream bos;

    public MyServletOutputStream(OutputStream out){
        bos = new BufferedOutputStream(out);
    }

    @Override
    public boolean isReady(){
        return false;
    }

    @Override
    public void setWriteListener(WriteListener writeListener){
    }

    @Override
    public void write(int b) throws IOException{
        bos.write(b);
    }

    @Override
    public void print(String s) throws IOException{
        int length = s.length();
        for(int i=0;i<length;++i){
            write(s.charAt(i));
        }
    }

    @Override
    public void close() throws IOException{
        bos.flush();
        isClosed=true;
    }

    private boolean isClosed=false;

    public boolean isClosed(){
        return isClosed;
    }
}
