import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Timer;
import java.util.TimerTask;

public class Sender {
    public static void main(String[] args) {
        try {
            // 1. Specify the port to send the multicast message
            int port = 8888;

            // 2. Specify the multicast group's address
            InetAddress group = InetAddress.getByName("224.0.0.1");

            // 3. Create a MulticastSocket without binding to a specific port
            MulticastSocket socket = new MulticastSocket();

            // 4. Create an array of different messages to send
            String[] messages = {
                "Hello from the sender!",
                "This is a multicast message.",
                "Welcome to the multicast group!"
            };

            // 5. Create a TimerTask to send messages every second
            TimerTask sendTask = new TimerTask() {
                int currentIndex = 0;

                @Override
                public void run() {
                    try {
                        // 6. Get the current message from the array
                        String message = messages[currentIndex];

                        // 7. Convert the message to bytes
                        byte[] buffer = message.getBytes();

                        // 8. Create a DatagramPacket containing the message, group address, and port
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);

                        // 9. Send the packet to the multicast group
                        socket.send(packet);

                        // 10. Print the message sent
                        System.out.println("Sent: " + message);

                        // 11. Update the index to send the next message in the array
                        currentIndex = (currentIndex + 1) % messages.length;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            // 12. Create a Timer to schedule the TimerTask to run every second
            Timer timer = new Timer();
            timer.schedule(sendTask, 0, 1000);

            // Wait for user input to stop sending messages
            System.out.println("Press Enter to stop sending messages...");
            System.in.read();

            // 13. Cancel the Timer and close the socket after sending the message
            timer.cancel();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}