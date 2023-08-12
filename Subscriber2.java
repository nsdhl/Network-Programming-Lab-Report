import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Subscriber2 {
    public static void main(String[] args) {
        try {
            // 1. Specify the port to listen for multicast messages
            int port = 8888;

            // 2. Specify the multicast group's address
            InetAddress group = InetAddress.getByName("224.0.0.1");

            // 3. Create a MulticastSocket and join the specified multicast group
            MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(group);

            // 4. Create a buffer to hold the incoming message
            byte[] buffer = new byte[256];

            // 5. Create a DatagramPacket to receive the incoming message
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // 6. Print instructions for the user
            System.out.println("Press Enter to stop listening for Subscriber 2...");

            // 7. Receive and print messages in a loop until Enter is pressed
            while (true) {
                try {
                    // Set a small timeout to check for user input
                    socket.setSoTimeout(500);

                    // Receive the packet (blocking call until a message is received or timeout)
                    socket.receive(packet);

                    // Convert the received data to a String and print the message
                    String message = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("Subscriber 2 received: " + message);
                } catch (java.net.SocketTimeoutException e) {
                    // Check if Enter key is pressed
                    int available = System.in.available();
                    if (available > 0) {
                        System.in.read(); // Consume the Enter key
                        break; // Exit the loop and stop listening
                    }
                }
            }

            // 8. Leave the multicast group and close the socket
            socket.leaveGroup(group);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}