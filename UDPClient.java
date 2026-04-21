import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.print("Enter message: ");
            String msg = br.readLine();

            byte[] send = msg.getBytes();

            InetAddress ip = InetAddress.getByName("localhost");

            DatagramPacket dpSend =
                new DatagramPacket(send, send.length, ip, 5000);

            ds.send(dpSend);

            byte[] receive = new byte[1024];

            DatagramPacket dpReceive =
                new DatagramPacket(receive, receive.length);

            ds.receive(dpReceive);

            String reply = new String(
                    dpReceive.getData(),
                    0,
                    dpReceive.getLength());

            System.out.println("Server says: " + reply);

            ds.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}