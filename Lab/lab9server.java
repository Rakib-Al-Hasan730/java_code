
import java.io.*;
import java.net.*;

class lab9server {

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server waiting...");

        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(
                s.getOutputStream(), true);

        String msg = in.readLine();
        out.println(msg.toUpperCase());

        s.close();
        ss.close();
    }
}
