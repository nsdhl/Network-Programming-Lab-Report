import java.io.IOException;
import java.net.*;

public class GoogleByName {
    public static void main(String[] args) {

        try {

            InetAddress[] Address = InetAddress.getAllByName("192.168.0.1");
            // System.out.println("anAddress is:" + Address);
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println("Local Host Address is:" + localHostAddress);

            for (InetAddress ipAddress : Address) {
                boolean reachable = ipAddress.isReachable(4000);
                if (reachable) {
                    System.out.println(ipAddress.getHostAddress());
                    System.out.println(ipAddress.getHostName());
                }

                else {
                    System.out.println(ipAddress + "is");
                }

                System.out.println("array of id address" + "" + ipAddress.getHostAddress());
                System.out.println("array of id address" + "" + ipAddress.getHostName());

            }

        } catch (

        UnknownHostException ex) {
            System.out.println("Could not find www.google.com" + ex);
        } catch (IOException e) {
            System.out.println("IOException occured");
        }
    }

}