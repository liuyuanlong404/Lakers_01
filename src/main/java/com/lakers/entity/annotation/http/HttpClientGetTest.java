package com.lakers.entity.annotation.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;

/**
 * Created on 2022/11/14 09:54
 *
 * @author lakers
 */
public class HttpClientGetTest {

    static HttpClient httpClient = HttpClient.newHttpClient();

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String url = "https://test-waka.api.waka2020.com/platform/areas/list/430000";
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                .header("User-Agent", "Java HttpClient")
                .header("Accept", "*/*")
                .timeout(Duration.ofSeconds(5L))
                .POST(HttpRequest.BodyPublishers.noBody())
                .version(HttpClient.Version.HTTP_2).build();
        HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        // HTTP允许重复的Header，因此一个Header可对应多个Value:
        Map<String, List<String>> headers = httpResponse.headers().map();
        for (String header : headers.keySet()) {
            System.out.println(header + ": " + headers.get(header).get(0));
        }
        System.out.println(httpResponse.body().substring(0, 1024) + "...");
    }
}
