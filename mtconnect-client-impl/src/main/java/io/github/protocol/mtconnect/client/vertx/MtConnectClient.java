package io.github.protocol.mtconnect.client.vertx;

import io.github.protocol.mtconnect.client.api.MtConnectClientConfiguration;
import io.github.shoothzj.http.client.facade.HttpClient;
import io.github.shoothzj.http.client.facade.HttpClientFactory;

public class MtConnectClient {
    private final MtConnectClientConfiguration config;

    private final HttpClient httpClient;

    public MtConnectClient(MtConnectClientConfiguration configuration) {
        this.config = configuration;
        this.httpClient = HttpClientFactory.createHttpClient(configuration.httpConfig());
    }
}
