package http;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yanxiaonan on 17/7/6.
 */
public class HttpResponse extends HttpBase{
    private HttpRequest request;
    public HttpResponse(HttpRequest request){
        super();
        this.request = request;
    }

    public void sendHtmlFile(){
        byte[] b = null;
        try {
            b = Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/webroot"+this.request.getPath()));
        } catch (NoSuchFileException e) {
            b = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setProtocol(this.request.getProtocol());
        this.setVersion(this.request.getVersion());
        if(b == null){
            this.setStatus("404");
        }else {
            String html = new String(b);
            this.setBody(html);
            this.addHeader("Content-Type", "text/html");
            this.addHeader("Content-Length", String.valueOf(html.length()));
            this.setStatus("200");
        }

    }

    public String buildResponse(){
        //first line
        StringBuffer responseString = new StringBuffer();
        responseString.append(this.getProtocol().toUpperCase());
        responseString.append("/");
        responseString.append(this.getVersion());
        responseString.append(" ");
        responseString.append(this.getStatus() + " OK");
        responseString.append("\r\n");

        //headers
        Iterator<String> it = this.getHeaders().keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            String value = this.getHeader(key);
            responseString.append(": ");
            responseString.append(value);
            responseString.append("\r\n");
        }

        //break between header and body
        responseString.append("\r\n");

        if(this.getHeader("Content-Length") != null && this.getHeader("Content-Length").equals("") == false){
            responseString.append(this.getBody());
        }
        return responseString.toString();
    }
}
