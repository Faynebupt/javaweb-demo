package win.larryzeal.servlet3.servlet.post;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 测试文件上传。
 * 请求格式：
 * <pre>
 *     post http://localhost:8080/part
 *     Content-Type: multipart/form-data; boundary=-------------------------acebdf13572468
 *     User-Agent: Fiddler
 *     Host: localhost:8080
 *     Content-Length: 25706
 *
 *     ---------------------------acebdf13572468
 *     Content-Disposition: form-data; name="somefile"; filename="App.ico"
 *     Content-Type: image/x-icon
 *
 *     <@INCLUDE *C:\Users\Administrator\AppData\Local\Programs\Fiddler\App.ico*@>
 *     ---------------------------acebdf13572468--
 *
 * </pre>
 * <p>
 * <p>
 * Created by 张少昆 on 2017/12/3.
 */
@MultipartConfig
@WebServlet( "/part" )
public class PartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Part part = req.getPart("somefile");
        part.write("d:/part.jpeg");
        System.out.println("name is " + part.getName());
        String submittedFileName = part.getSubmittedFileName();
        System.out.println("submitted file name is " + submittedFileName);

        InputStream inputStream = part.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while((line = bufferedReader.readLine()) != null){
            System.out.println("part相关内容：" + line);
        }

        PrintWriter writer = resp.getWriter();
        writer.println("got it!<br/>");
        writer.flush();
    }
}
