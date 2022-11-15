package com.lakers.entity.annotation.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * Created on 2022/11/14 11:23
 *
 * @author lakers
 */
public class HttpClientPostTest {

    static HttpClient httpClient = HttpClient.newBuilder().build();

    public static void main(String[] args) throws Exception {
        String url = "https://test-waka.api.waka2020.com/store/backstage/businessCat/statusUpdate";
        String body = "{\n" +
                "  \"id\": 55,\n" +
                "  \"status\": 0\n" +
                "}";
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                // 设置Header:
                .header("Accept", "*/*").header("Content-Type", "application/json")
                // 设置token
                .header("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtZWNoYSIsImV4cCI6MTY2ODQ3NzYyMSwidHlwZSI6IkFETUlOX1BMQVRGT1JNIiwiaWF0IjoxNjY4MzkxMjIxLCJ1c2VySWQiOjF9.ePYu42ZlTIfU0xRATDZUu-cSLlpqza0IsjSnwd-gkzQ")
                // 设置超时:
                .timeout(Duration.ofSeconds(5))
                // 设置版本:
                .version(HttpClient.Version.HTTP_2)
                // 使用POST并设置body
                .POST(HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
