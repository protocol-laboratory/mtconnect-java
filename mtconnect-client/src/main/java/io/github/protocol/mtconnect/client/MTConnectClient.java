package io.github.protocol.mtconnect.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.openfacade.http.HttpClient;
import io.github.openfacade.http.HttpClientFactory;
import io.github.openfacade.http.HttpResponse;
import io.github.protocol.mtconnect.api.MTConnectDevices;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MTConnectClient {
    private final MTConnectClientConfiguration config;

    private final HttpClient httpClient;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public MTConnectClient(MTConnectClientConfiguration configuration) {
        this.config = configuration;
        this.httpClient = HttpClientFactory.createHttpClient(configuration.httpConfig());
    }
    
    public MTConnectDevices deivce(String Id) {
        return null;
    };

    public static <T> T toObject(String json, Class<T> type) throws JsonProcessingException {
        if (json == null || json.isEmpty()) {
            return null;
        }
        return MAPPER.readValue(json, type);
    }

    public MTConnectDevices deivces() throws ExecutionException, InterruptedException {
        String url = String.format("http://%s:%s/devices", config.host(), config.port());
        CompletableFuture<HttpResponse> future = httpClient.get(url);

        CompletableFuture<MTConnectDevices> resp = future.thenCompose(response -> {
            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                try {
                    MTConnectDevices body = toObject(Arrays.toString(response.body()), MTConnectDevices.class);
                    return CompletableFuture.completedFuture(body);
                } catch (JsonProcessingException e) {
                    return CompletableFuture.failedFuture(e);
                }
            } else {
                return CompletableFuture.failedFuture(new Exception("http error: " + Arrays.toString(response.body())));
            }
        });

        return resp.get();
    };
}
