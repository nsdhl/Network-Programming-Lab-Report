import java.net.*;
import java.util.Enumeration;

public class networkinterfaceGetter {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> myInterfaces = NetworkInterface.getNetworkInterfaces();
        System.out.println("Enum object:" + myInterfaces);

        while (myInterfaces.hasMoreElements()) {
            NetworkInterface ni = myInterfaces.nextElement();
            System.out.println("Interface Name is:" + ni.getName());
            System.out.println("Display Name is:" + ni.getDisplayName());
            System.out.println("Mtu is:" + ni.getMTU());
            System.out.println("Is up:" + ni.isUp());
            System.out.println("Is virtual:" + ni.isVirtual());
            System.out.println("Supports MC"+ni.supportsMulticast());

        }
    }
}
