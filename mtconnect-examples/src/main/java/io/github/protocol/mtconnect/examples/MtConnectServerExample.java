package io.github.protocol.mtconnect.examples;

import io.github.openfacade.http.HttpServerConfig;
import io.github.openfacade.http.HttpServerEngine;
import io.github.protocol.mtconnect.server.MtConnectServer;
import io.github.protocol.mtconnect.server.MtConnectServerConfiguration;
import io.github.protocol.mtconnect.server.impl.MemoryMtProcessor;

public class MtConnectServerExample {
    public static void main(String[] args) {
        MtConnectServerConfiguration configuration = new MtConnectServerConfiguration();
        HttpServerConfig httpServerConfig = new HttpServerConfig.Builder()
                .engine(HttpServerEngine.Vertx)
                .host("127.0.0.1")
                .port(36633)
                .build();
        configuration.setHttpConfig(httpServerConfig);
        configuration.setMtProcessor(new MemoryMtProcessor());
        MtConnectServer mtConnectServer = new MtConnectServer(configuration);
        mtConnectServer.start().join();
    }
}
