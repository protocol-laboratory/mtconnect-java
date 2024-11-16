package io.github.protocol.mtconnect.examples;

import io.github.openfacade.http.HttpServerConfig;
import io.github.openfacade.http.HttpServerEngine;
import io.github.protocol.mtconnect.server.MTConnectServer;
import io.github.protocol.mtconnect.server.MTConnectServerConfiguration;
import io.github.protocol.mtconnect.server.impl.IoTDAMtProcessor;

public class MTConnectIoTDAServerExample {
    public static void main(String[] args) {
        MTConnectServerConfiguration configuration = new MTConnectServerConfiguration();
        HttpServerConfig httpServerConfig = new HttpServerConfig.Builder()
                .engine(HttpServerEngine.Vertx)
                .host("127.0.0.1")
                .port(36633)
                .build();
        configuration.setHttpConfig(httpServerConfig);
        configuration.setMtProcessor(new IoTDAMtProcessor("your_ak", "your_sk"));
        MTConnectServer mtConnectServer = new MTConnectServer(configuration);
        mtConnectServer.start().join();
    }
}