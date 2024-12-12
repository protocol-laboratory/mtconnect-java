package io.github.protocol.mtconnect.server;

import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.iotda.v5.IoTDAClient;
import com.huaweicloud.sdk.iotda.v5.model.ListDevicesResponse;
import com.huaweicloud.sdk.iotda.v5.model.QueryDeviceSimplify;
import io.github.openfacade.http.HttpClientConfig;
import io.github.openfacade.http.HttpServerConfig;
import io.github.openfacade.http.HttpServerEngine;
import io.github.protocol.mtconnect.api.MTConnectDevices;
import io.github.protocol.mtconnect.client.MTConnectClient;
import io.github.protocol.mtconnect.client.MTConnectClientConfiguration;
import io.github.protocol.mtconnect.server.impl.IoTDAMtProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.ExecutionException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class IoTDAServerTest {

    private IoTDAClient mockClient;
    private final String localHost = "127.0.0.1";

    @BeforeEach
    public void setUp() {
        mockClient = Mockito.mock(IoTDAClient.class);

        ListDevicesResponse rsp = new ListDevicesResponse();
        QueryDeviceSimplify mockDevice = new QueryDeviceSimplify();
        mockDevice.setDeviceId("mock_device_id");
        mockDevice.setDeviceName("mock_device_name");
        rsp.addDevicesItem(mockDevice);
        when(mockClient.listDevices(any())).thenReturn(rsp);
    }

    // start iotda server
    private MTConnectServer startIoTDAServer(int port) {

        MTConnectServerConfiguration configuration = new MTConnectServerConfiguration();
        HttpServerConfig httpServerConfig = new HttpServerConfig.Builder()
                .engine(HttpServerEngine.Vertx)
                .host("127.0.0.1")
                .port(port)
                .build();
        configuration.setHttpConfig(httpServerConfig);
        IoTDAMtProcessor ioTDAMtProcessor = new IoTDAMtProcessor.Builder()
                .setAk("mock_ak")
                .setSk("mock_sk")
                .setEndpoint("mock_endpoint")
                .setIoTDAClient(mockClient)
                .build();

        configuration.setMtProcessor(ioTDAMtProcessor);
        MTConnectServer mtConnectServer = new MTConnectServer(configuration);
        mtConnectServer.start().join();

        return mtConnectServer;
    }

    @Test
    public void testDevices() throws ExecutionException, InterruptedException {
        int inputPort = 36633;
        MTConnectServer mtConnectServer = startIoTDAServer(inputPort);
        int port = mtConnectServer.httpPort();
        Assertions.assertEquals(inputPort, port);

        MTConnectClientConfiguration configuration = new MTConnectClientConfiguration();
        HttpClientConfig httpClientConfig = new HttpClientConfig.Builder().build();
        configuration.setHttpConfig(httpClientConfig);
        configuration.setHost(localHost);
        configuration.setPort(port);
        MTConnectClient mtConnectClient = new MTConnectClient(configuration);

        MTConnectDevices resp = mtConnectClient.devices();
        Assertions.assertEquals("mock_device_id", resp.getDevices().get(0).getId());
        Assertions.assertEquals("mock_device_name", resp.getDevices().get(0).getName());
    }

    @Test
    public void testException() throws ExecutionException, InterruptedException {
        ServiceResponseException e = new ServiceResponseException(400, "errorCode", "errorMsg", "requestId");

        when(mockClient.listDevices(any())).thenThrow(e);

        MTConnectServer mtConnectServer = startIoTDAServer(0);
        int port = mtConnectServer.httpPort();

        MTConnectClientConfiguration configuration = new MTConnectClientConfiguration();
        HttpClientConfig httpClientConfig = new HttpClientConfig.Builder().build();
        configuration.setHttpConfig(httpClientConfig);
        configuration.setHost(localHost);
        configuration.setPort(port);
        MTConnectClient mtConnectClient = new MTConnectClient(configuration);

        MTConnectDevices resp = mtConnectClient.devices();
        Assertions.assertEquals(resp.getDevices(), null);
    }
}
