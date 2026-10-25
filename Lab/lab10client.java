
import java.io.*;
import java.net.*;

class lab10client {

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();

        BufferedReader kb = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.print("Enter message: ");
        String msg = kb.readLine();

        byte[] data = msg.getBytes();

        DatagramPacket p = new DatagramPacket(
                data, data.length,
                InetAddress.getByName("localhost"), 5000);

        ds.send(p);

        byte[] reply = new byte[1024];
        DatagramPacket r = new DatagramPacket(reply, reply.length);
        ds.receive(r);

        System.out.println("Server: "
                + new String(r.getData(), 0, r.getLength()));

        ds.close();
    }
}
