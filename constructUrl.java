import java.net.*;

public class constructUrl {
    public static void main(String[] args) throws MalformedURLException {
        URL u = new URL("https://github.com/nsdhl");
        System.out.println(u.getProtocol());
        System.out.println(u.getHost());
        System.out.println(u.getPort());
        System.out.println(u.getPath());
        System.out.println(u.getFile());
        System.out.println(u.getQuery());
        System.out.println(u.getUserInfo());
        System.out.println(u.getDefaultPort());
        System.out.println(u.getAuthority());
        System.out.println(u.getRef());

        // Using Relative URL

        URL u2 = new URL(u, "index.html");
        System.out.println(u2);

    }
}
