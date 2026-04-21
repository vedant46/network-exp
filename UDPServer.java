import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(5000);

            byte[] receive = new byte[1024];

            System.out.println("UDP Server started...");
            System.out.println("Waiting for client message...");

            DatagramPacket dpReceive =
                new DatagramPacket(receive, receive.length);

            ds.receive(dpReceive);

            String msg = new String(dpReceive.getData(), 0,
                    dpReceive.getLength());

            System.out.println("Client says: " + msg);

            String reply = "Message received successfully";

            byte[] send = reply.getBytes();

            DatagramPacket dpSend =
                new DatagramPacket(
                    send,
                    send.length,
                    dpReceive.getAddress(),
                    dpReceive.getPort()
                );

            ds.send(dpSend);

            ds.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}