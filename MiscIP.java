import java.net.*;

public class MiscIP {
    public static void main(String[] args){
        try{
            byte[] address ={(byte) 130,(byte) 168, 1, 1};
            InetAddress addressI = InetAddress.getByAddress(address);
            String hostName = addressI.toString();
            int inHash= addressI.hashCode();
            System.out.println("Host Name: " + hostName);
            System.out.println("Hash Code: " + inHash);
            InetAddress addressI1 = InetAddress.getByName("https://meet.google.com/");
            InetAddress addressI2 = InetAddress.getByName("https://drive.google.com/");
            if(addressI1.equals(addressI2)){
                System.out.println(addressI1 + " is same as " + addressI2);
            }
            else{
                System.out.println(addressI1 + " is same as " + addressI2);
            }

        }
        catch(UnknownHostException ex){
            System.err.println("Could not resolve " + args[0]);
        }
    }
}
    