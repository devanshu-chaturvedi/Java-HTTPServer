import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHTTPServer {
    public static void main(String[] args) {
        try {
            final ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Listening for connections on port 8080....");
            while(true){
                final Socket client = serverSocket.accept();
                /*InputStreamReader isr = new InputStreamReader(client.getInputStream());
                BufferedReader reader = new BufferedReader(isr);
                String line = reader.readLine();
                while(!line.isEmpty()){
                    System.out.println(line);
                    line = reader.readLine();
                }*/
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                System.out.println(httpResponse);
                client.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
