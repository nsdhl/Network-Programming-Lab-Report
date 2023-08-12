import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class NetworkServerWLogging {
    // 1. Define a static logger instance for the class "NetworkServer"
    private static final Logger LOGGER = Logger.getLogger(NetworkServerWLogging.class.getName());

    public static void main(String[] args) {
        // 2. Set up logging to save logs to local file
        setupLogging();

        LOGGER.info("Starting Network Server...");
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // 3. Log an informational message with the port number the server is listening on
            LOGGER.info("Server listening on port " + port);

            while (true) {
                // 4. Wait for a client to connect and accept the connection
                Socket clientSocket = serverSocket.accept();
                // 5. Log an informational message when a client connection is accepted,
                //    along with the client's IP address
                LOGGER.info("Accepted connection from " + clientSocket.getInetAddress());

                // 6. Create a PrintWriter to send data to the client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                // 7. Send a message to the client containing the current time
                out.println("Hello, client! Current time is: " + new Date());

                // 8. Close the client socket after sending the response
                clientSocket.close();
                // 9. Log an informational message when the connection with the client is closed,
                //    along with the client's IP address
                LOGGER.info("Connection closed with " + clientSocket.getInetAddress());
            }
        } catch (IOException e) {
            // 10. If an IOException occurs, log an error message with the exception details
            LOGGER.log(Level.SEVERE, "Error occurred in server: " + e.getMessage(), e);
        }
    }

    private static void setupLogging() {
        try {
            // 11. Create a FileHandler to save logs to a local file named "server.log"
            FileHandler fileHandler = new FileHandler("server.log");
            // 12. Create a SimpleFormatter to format the log entries
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            // 13. Attach the SimpleFormatter to the FileHandler
            fileHandler.setFormatter(simpleFormatter);
            // 14. Set the log level to capture all log levels
            LOGGER.setLevel(Level.ALL);
            // 15. Attach the FileHandler to the logger
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            // 16. If an IOException occurs during log setup, print the stack trace
            e.printStackTrace();
        }
    }
}