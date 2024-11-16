package io.github.protocol.mtconnect.server;

import io.github.openfacade.http.HttpServerConfig;
import lombok.Setter;

@Setter
public class MTConnectServerConfiguration {
    private HttpServerConfig httpConfig;

    private MTProcessor mtProcessor;

    public MTConnectServerConfiguration() {
    }

    public HttpServerConfig httpConfig() {
        return httpConfig;
    }

    public MTProcessor mtHandler() {
        return mtProcessor;
    }
}
