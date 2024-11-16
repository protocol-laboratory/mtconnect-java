package io.github.protocol.mtconnect.client;

import io.github.openfacade.http.HttpClientConfig;
import lombok.Setter;

@Setter
public class MTConnectClientConfiguration {
    private String host;

    private int port;

    private HttpClientConfig httpConfig;

    public MTConnectClientConfiguration() {
    }

    public String host() {
        return host;
    }

    public int port() {
        return port;
    }

    public HttpClientConfig httpConfig() {
        return httpConfig;
    }
}
