import java.net.InetAddress;

public class MyAddress {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLoopbackAddress();
            System.out.println("Loopback address: " + address);
        } catch (Exception e) {
            System.out.println("Could not find www.google.com" + e);
        }
    }
}
