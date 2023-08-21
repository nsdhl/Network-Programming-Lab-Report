import java.io.*;
import java.net.*;

public class SourceViewer {
    public static void main(String[] args) {
        String urlString = "https://www.example.com"; // Replace with the desired URL

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;

                System.out.println("Source code:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } else {
                System.out.println("Error: Unable to retrieve source code.");
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}