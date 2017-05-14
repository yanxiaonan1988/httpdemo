import http.HttpWorker;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Application{
    public static void main(String args[]){

        try {
            //new and listen
            ServerSocket serverSocket = new ServerSocket(8033);
            System.out.println("listening on " + 8003);
            while(true){
                //block until accept a connection
                System.out.println("waiting for connection...");
                Socket s = serverSocket.accept();
                //solve request with HttpWorker in new thread
                HttpWorker worker = new HttpWorker(s);
                worker.start();

                //main thread will not block
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}