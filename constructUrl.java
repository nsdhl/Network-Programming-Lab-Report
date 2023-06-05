import java.net.*;

public class constructUrl {
    public static void main(String[] args) throws MalformedURLException {
        URL u = new URL("https://github.com/nsdhl");
        System.out.println( u.getProtocol());
        System.out.println( u.getHost());
        System.out.println( u.getPort());
        System.out.println( u.getPath());
        System.out.println( u.getFile());
        System.out.println( u.getQuery());
        System.out.println( u.getUserInfo());
        System.out.println( u.getDefaultPort());
        System.out.println( u.getAuthority());
        System.out.println( u.getRef());


        // Using Relative URL
        URL u1 = new URL (u, "hahaha.html");
        System.out.println(u1);

        URL u2 = new URL (u, "hyaaaaaa.html");
        System.out.println(u2);

        
    }
}
