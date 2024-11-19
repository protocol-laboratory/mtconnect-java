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
        IoTDAMtProcessor ioTDAMtProcessor = new IoTDAMtProcessor.Builder()
                .setAk(System.getenv("CLOUD_SDK_AK"))
                .setSk(System.getenv("CLOUD_SDK_SK"))
                .setProjectId("your_project_id")
                .setEndpoint("ec138732b4.st1.iotda-app.cn-north-4.myhuaweicloud.com")
                .build();

        configuration.setMtProcessor(ioTDAMtProcessor);
        MTConnectServer mtConnectServer = new MTConnectServer(configuration);
        mtConnectServer.start().join();
    }
}
