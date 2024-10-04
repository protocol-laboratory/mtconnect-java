package io.github.protocol.mtconnect.server;

import io.github.openfacade.http.HttpServerConfig;
import lombok.Setter;

@Setter
public class MtConnectServerConfiguration {
    private HttpServerConfig httpConfig;

    public MtConnectServerConfiguration() {
    }

    public HttpServerConfig httpConfig() {
        return httpConfig;
    }
}
