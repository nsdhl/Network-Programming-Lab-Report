import java.io.*;
import java.net.*;

public class toURI {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL u = new URL("https://www.google.com");
        System.out.println(u.toURI());
    }

}


