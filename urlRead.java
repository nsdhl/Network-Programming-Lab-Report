import java.io.*;
import java.net.URL;

public class urlRead {
    public static void main(String[] args) {
        try {
            URL u = new URL("https://github.com/nsdhl");
            InputStream in = u.openStream();
            int c;
            // read is used for reading the data from the source
            while ((c = in.read()) != -1)
                System.out.write(c);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
