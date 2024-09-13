package io.github.protocol.mtconnect.client.api;

import io.github.shoothzj.http.client.facade.HttpClientConfig;
import lombok.Setter;

@Setter
public class MtConnectClientConfiguration {
    private String host;

    private int port;

    private HttpClientConfig httpConfig;

    public MtConnectClientConfiguration() {
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
