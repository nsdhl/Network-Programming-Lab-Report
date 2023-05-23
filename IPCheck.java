import java.net.*;
public class IPCheck {
    public static void main(String[] args) {
        try {
            byte[] byteAddress = {(byte)202,45,(byte)146,67};
            String ipv6Address = "fe80::e4a2:66da:8619:c3ea";
            InetAddress less = InetAddress.getByName(ipv6Address);
           System.out.println(InetAddress.getByAddress(byteAddress));
          System.out.println( "ipv6 " + getVersion(less));

        }
        catch(UnknownHostException ex){
            System.out.println(ex);
        }



    }
    public static int getVersion(InetAddress ia){
        byte[] address = ia.getAddress();
        if(address.length == 4){
            return 4;
        }
        else if(address.length == 16){
            return 6;
        }
        else{
            return -1;
        }
    }
}
