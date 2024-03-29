import java.net.*;
import java.util.Enumeration;

public class interfaceProgram {
    public static void main(String[] args) throws SocketException {

        Enumeration<NetworkInterface> myInterfaces = NetworkInterface.getNetworkInterfaces();
        System.out.println("Enum object:" + myInterfaces);

        while (myInterfaces.hasMoreElements()) {
            NetworkInterface ni = myInterfaces.nextElement();
            System.out.println(ni);
            System.out.println("Display Name is:" + ni.getDisplayName());
            byte[] macAddress = ni.getHardwareAddress();
            if (macAddress != null) {
                for (byte i : macAddress) {

                    System.out.format("%02X", i).append(":");
                }
            } else {
                System.out.println("No MAC Address");
            }

        }

        
    }
}

// June -4-2023
