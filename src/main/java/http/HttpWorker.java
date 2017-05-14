package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by dell on 2016/3/7.
 */
public class HttpWorker extends Thread{
    private Socket srcSocket;
//    private Socket dstSocket;
//    private String httpRequest = "";
//    private String httpResponse = "";
//    private int port = 80;
//    private String hostname;


    public HttpWorker(Socket srcSocket){
        this.srcSocket = srcSocket;
    }

    @Override
    public void run(){
        try {
            System.out.println("start to solve:" + Thread.currentThread().getId());
            BufferedReader br = new BufferedReader(new InputStreamReader(srcSocket.getInputStream()));
            //just a string payload WITHOUT http spec
            String requestString = br.readLine();
            //just a string payload WITHOUT http spec
            String responseString = "Hello, " + requestString + ".";
            //write response to client
            srcSocket.getOutputStream().write(responseString.getBytes());
            //close socket
            srcSocket.close();
            System.out.println("solved");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    private void readHttpRequestFromSocket() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(srcSocket.getInputStream()));
//        String line;
//
//        while(true){
//            line = br.readLine();
//            if(line.equals("")){
//                break;
//            }
//            httpRequest = httpRequest + line + "\r\n";
//            System.out.println(line+"#");
//
//            if(line.startsWith("Host: ")){
//                String[] tokens = line.split(": ");
//                tokens = tokens[1].split(":");
//                hostname = tokens[0];
//                if(tokens.length > 1){
//                    port = Integer.valueOf(tokens[1]);
//                }
//            }
//
//            if(line.startsWith("Content-Length: ")){
//                String[] tokens = line.split(": ");
//            }
//
//
//        }
//
//    }
}
