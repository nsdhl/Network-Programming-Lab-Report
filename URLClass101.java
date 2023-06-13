import java.net.*;
import java.io.*;

public class URLClass101 {
    public static void main(String[] args) throws IOException {
        URL u = new URL("http://www.google.com");
        URLConnection uc = u.openConnection();
        try {
            InputStream is = uc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            int c;
            while ((c = isr.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println(isr.getEncoding());
            System.out.println(isr.read());
            System.out.println(isr.getClass());
            System.out.println(isr.hashCode());
            System.out.println(isr.toString());
        } catch (IOException ex) {
        }
    }
}