package io.github.protocol.mtconnect.client;

import io.github.openfacade.http.HttpClient;
import io.github.openfacade.http.HttpClientFactory;
import io.github.openfacade.http.HttpResponse;
import io.github.protocol.mtconnect.api.MTConnectAssets;
import io.github.protocol.mtconnect.api.MTConnectDevices;
import io.github.protocol.mtconnect.common.XmlUtil;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MTConnectClient {
    private final MTConnectClientConfiguration config;

    private final HttpClient httpClient;

    public MTConnectClient(MTConnectClientConfiguration configuration) {
        this.config = configuration;
        this.httpClient = HttpClientFactory.createHttpClient(configuration.httpConfig());
    }

    public MTConnectAssets assets() throws ExecutionException, InterruptedException {
        String url = String.format("http://%s:%s/assets", config.host(), config.port());
        CompletableFuture<HttpResponse> future = httpClient.get(url);

        CompletableFuture<MTConnectAssets> resp = future.thenCompose(response -> {
            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                try {
                    String string = new String(response.body(), StandardCharsets.UTF_8);
                    MTConnectAssets body = XmlUtil.fromXml(string, MTConnectAssets.class);
                    return CompletableFuture.completedFuture(body);
                } catch (Exception e) {
                    return CompletableFuture.failedFuture(e);
                }
            } else {
                return CompletableFuture.failedFuture(new Exception("http error: " + Arrays.toString(response.body())));
            }
        });

        return resp.get();
    }

    public MTConnectDevices devices() throws ExecutionException, InterruptedException {
        String url = String.format("http://%s:%s/devices", config.host(), config.port());
        CompletableFuture<HttpResponse> future = httpClient.get(url);

        CompletableFuture<MTConnectDevices> resp = future.thenCompose(response -> {
            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                try {
                    String string = new String(response.body(), StandardCharsets.UTF_8);
                    MTConnectDevices body = XmlUtil.fromXml(string, MTConnectDevices.class);
                    return CompletableFuture.completedFuture(body);
                } catch (Exception e) {
                    return CompletableFuture.failedFuture(e);
                }
            } else {
                return CompletableFuture.failedFuture(new Exception("http error: " + Arrays.toString(response.body())));
            }
        });

        return resp.get();
    }
}
