
import java.io.*;
import java.net.*;

class lab9client {

    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(
                s.getOutputStream(), true);

        BufferedReader kb = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.print("Enter message: ");
        String msg = kb.readLine();

        out.println(msg);
        System.out.println("Server: " + in.readLine());

        s.close();
    }
}
