import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by yanxiaonan on 16/3/25.
 */
public class Test {
    public static void main(String args[]) throws IOException {

            Socket s = new Socket("127.0.0.1", 8033);
            s.getOutputStream().write("xxx\n".getBytes());

            String responseString = new BufferedReader(new InputStreamReader(s.getInputStream())).readLine();

            System.out.println(responseString);
            s.close();
    }
}
