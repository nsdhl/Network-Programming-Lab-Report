import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class webCache {
    private Map<String, String> cache;

    public webCache() {
        cache = new HashMap<String, String>();
    }

    public String getCacheData(String url) {
        if (cache.containsKey(url)) {
            String data = cache.get(url);
            return data;
        } else {
            return null;
        }
    }

    public void setCacheData(String url, String contents) {
        cache.put(url, contents);
    }

    public String getWebData(String url) throws MalformedURLException, IOException {
        URL u = new URL(url);
        HttpURLConnection con = (HttpURLConnection) u.openConnection();
        con.setRequestMethod("GET");

        InputStream is = con.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String dataFromReader = "";
        String line;
        try {
            while ((line = br.readLine()) != null) {
                dataFromReader += line;
            }
        } finally {
            br.close();
        }

        return dataFromReader;
    }

    public static void main(String[] args) {
        webCache cache = new webCache();
        try {
            String url = "https://www.example.com";
            String dataFromCache = cache.getCacheData(url);
            if (dataFromCache != null) {
                System.out.println("Data from cache: " + dataFromCache);
            } else {
                String webData = cache.getWebData(url);
                cache.setCacheData(url, webData);
                System.out.println("Data from web: " + webData);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

// june - 20
