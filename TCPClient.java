import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.print("Enter message: ");
            String msg = userInput.readLine();

            out.println(msg);

            String reply = in.readLine();

            System.out.println("Server says: " + reply);

            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}