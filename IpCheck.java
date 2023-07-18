import java.net.*;

public class IpCheck {
    public static void main(String[] args) {
        try {
            byte[] byteAddress = { (byte) 202, 45, (byte) 146, 67 };
            InetAddress less = InetAddress.getByAddress(byteAddress);
            System.out.println(InetAddress.getByAddress(byteAddress));
            getVersion(less);

        } catch (UnknownHostException ex) {
            System.out.println(ex);
        }

    }

    public static int getVersion(InetAddress ia) {
        byte[] address = ia.getAddress();
        if (address.length == 4) {
            return 4;
        } else if (address.length == 16) {
            return 6;
        } else {
            return -1;
        }
    }

}