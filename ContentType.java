import java.io.*;
import java.net.*;
import java.util.*;

public class ContentType {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                URL u = new URL(args[i]);
                URLConnection uc = u.openConnection();
                System.out.println("Content type: " + uc.getContentType());
                if (uc.getContentEncoding() != null) {
                    System.out.println("Content Encoding: " + uc.getContentEncoding());
                }
                if (uc.getDate() != 0) {
                    System.out.println("Date: " + new Date(uc.getDate()));
                }
                if (uc.getLastModified() != 0) {
                    System.out.println("Last modified: " + new Date(uc.getLastModified()));
                }
                if (uc.getExpiration() != 0) {
                    System.out.println("Expiration date: " + new Date(uc.getExpiration()));
                }
                if (uc.getContentLength() != -1) {
                    System.out.println("Content length: " + uc.getContentLength());
                }
                if (uc.getContentType() != null) {
                    System.out.println("Content type: " + uc.getContentType());
                }
                if (uc.getURL() != null) {
                    System.out.println("URL: " + uc.getURL());
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[i] + " is not a URL I understand.");
            } catch (IOException ex) {
                System.err.println("Error opening connection to " + args[i] + ": " + ex.getMessage());
            }
        }
    }
}
