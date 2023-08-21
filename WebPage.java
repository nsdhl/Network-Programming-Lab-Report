import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebPage {
    public static void main(String[] args) {
        String urlString = "https://www.example.com";
        try {
            URL url = new URL(urlString);

            URLConnection connection = url.openConnection();

            String contentType = connection.getHeaderField("Content-Type");
            System.out.println("Content Type: " + contentType);

            int contentLength = connection.getContentLength();
            System.out.println("Content Length: " + contentLength + " bytes");

            long lastModified = connection.getLastModified();
            System.out.println("Last Modified: " + lastModified);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}