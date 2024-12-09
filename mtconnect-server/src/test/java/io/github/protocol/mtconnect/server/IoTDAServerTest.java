package io.github.protocol.mtconnect.server;

import com.huaweicloud.sdk.iotda.v5.IoTDAClient;
import io.github.openfacade.http.HttpServerConfig;
import io.github.openfacade.http.HttpServerEngine;
import io.github.protocol.mtconnect.server.impl.IoTDAMtProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.when;

public class IoTDAServerTest {

    private IoTDAClient mockClient;

    @BeforeEach
    public void setUp() {

        IoTDAClient mockClient = Mockito.mock(IoTDAClient.class);
        when(mockClient.newBuilder().build()).thenReturn(null);
    }

    // start memory server
    private MTConnectServer startIoTDAServer() {

        MTConnectServerConfiguration configuration = new MTConnectServerConfiguration();
        HttpServerConfig httpServerConfig = new HttpServerConfig.Builder()
                .engine(HttpServerEngine.Vertx)
                .host("127.0.0.1")
                .port(36633)
                .build();
        configuration.setHttpConfig(httpServerConfig);
        IoTDAMtProcessor ioTDAMtProcessor = new IoTDAMtProcessor.Builder()
                .setIoTDAClient(mockClient)
                .build();

        configuration.setMtProcessor(ioTDAMtProcessor);
        MTConnectServer mtConnectServer = new MTConnectServer(configuration);
        mtConnectServer.start().join();

        return mtConnectServer;
    }

    @Test
    public void testDevices() throws ExecutionException, InterruptedException {
        MTConnectServer mtConnectServer = startIoTDAServer();
        Assertions.assertTrue(mtConnectServer.httpPort() > 0);
    }
}
