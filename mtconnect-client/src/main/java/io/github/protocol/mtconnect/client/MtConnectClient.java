package io.github.protocol.mtconnect.client;

import io.github.openfacade.http.HttpClient;
import io.github.openfacade.http.HttpClientFactory;

public class MtConnectClient {
    private final MtConnectClientConfiguration config;

    private final HttpClient httpClient;

    public MtConnectClient(MtConnectClientConfiguration configuration) {
        this.config = configuration;
        this.httpClient = HttpClientFactory.createHttpClient(configuration.httpConfig());
    }
}
