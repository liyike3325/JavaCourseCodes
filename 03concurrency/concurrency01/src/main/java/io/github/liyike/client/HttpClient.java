package io.github.liyike.client;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * httpclient客户端
 */
public class HttpClient {

    public static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static String getAsString(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response1 = null;
        try {
            response1 = httpclient.execute(httpGet);
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            return EntityUtils.toString(entity1, "UTF-8");
        } finally {
            if (null != response1) {
                response1.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8888/hello";
        String text = HttpClient.getAsString(url);
        System.out.println(text);
    }
}
