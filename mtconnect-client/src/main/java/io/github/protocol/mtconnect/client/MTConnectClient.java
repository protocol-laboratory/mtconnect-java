package io.github.protocol.mtconnect.client;

import io.github.openfacade.http.HttpClient;
import io.github.openfacade.http.HttpClientFactory;

public class MTConnectClient {
    private final MTConnectClientConfiguration config;

    private final HttpClient httpClient;

    public MTConnectClient(MTConnectClientConfiguration configuration) {
        this.config = configuration;
        this.httpClient = HttpClientFactory.createHttpClient(configuration.httpConfig());
    }
}
