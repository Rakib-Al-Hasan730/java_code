
import java.net.*;

class lab10server {

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] data = new byte[1024];

        System.out.println("Server waiting...");

        DatagramPacket p = new DatagramPacket(data, data.length);
        ds.receive(p);

        String msg = new String(p.getData(), 0, p.getLength());
        Thread.sleep(6);

        byte[] reply = msg.toUpperCase().getBytes();

        DatagramPacket r = new DatagramPacket(
                reply, reply.length, p.getAddress(), p.getPort());

        ds.send(r);
        ds.close();
    }
}
