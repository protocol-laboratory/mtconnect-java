package io.github.protocol.mtconnect.server;

import io.github.openfacade.http.HttpClientConfig;
import io.github.openfacade.http.HttpServerConfig;
import io.github.openfacade.http.HttpServerEngine;
import io.github.protocol.mtconnect.api.Device;
import io.github.protocol.mtconnect.api.MTConnectDevices;
import io.github.protocol.mtconnect.client.MTConnectClient;
import io.github.protocol.mtconnect.client.MTConnectClientConfiguration;
import io.github.protocol.mtconnect.server.impl.MemoryMtProcessor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

public class MTConnectDeviceTest {

    private int port;
    private final String localHost = "127.0.0.1";

    // start memery server
    private MemoryMtProcessor startMemoryServer() {
        MTConnectServerConfiguration configuration = new MTConnectServerConfiguration();
        HttpServerConfig httpServerConfig = new HttpServerConfig.Builder()
                .engine(HttpServerEngine.Vertx)
                .host(localHost)
                .port(0)
                .build();
        configuration.setHttpConfig(httpServerConfig);
        MemoryMtProcessor mtProcessor = new MemoryMtProcessor();
        configuration.setMtProcessor(mtProcessor);
        MTConnectServer mtConnectServer = new MTConnectServer(configuration);
        mtConnectServer.start().join();

        port = mtConnectServer.getHttpPort();

        return mtProcessor;
    }

    @Test
    public void testDevices() throws ExecutionException, InterruptedException {
        MemoryMtProcessor memoryMtProcessor = startMemoryServer();
        MTConnectDevices devices = new MTConnectDevices();
        Device device = new Device();

        devices.setDevices(Collections.singletonList(device));
        memoryMtProcessor.updateDevice(devices);

        MTConnectClientConfiguration configuration = new MTConnectClientConfiguration();
        HttpClientConfig httpClientConfig = new HttpClientConfig.Builder().build();
        configuration.setHttpConfig(httpClientConfig);
        configuration.setHost(localHost);
        configuration.setPort(port);
        MTConnectClient mtConnectClient = new MTConnectClient(configuration);

        // use client show device
        MTConnectDevices resp = mtConnectClient.deivces();
        System.out.println(resp.getDevices());
    }
}
