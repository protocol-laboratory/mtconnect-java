package io.github.protocol.mtconnect.examples;

import io.github.openfacade.http.HttpClientConfig;
import io.github.protocol.mtconnect.client.MTConnectClient;
import io.github.protocol.mtconnect.client.MTConnectClientConfiguration;

public class MTConnectClientExample {
    public static void main(String[] args) {
        MTConnectClientConfiguration configuration = new MTConnectClientConfiguration();
        HttpClientConfig httpClientConfig = new HttpClientConfig.Builder().build();
        configuration.setHttpConfig(httpClientConfig);
        MTConnectClient mtConnectClient = new MTConnectClient(configuration);
    }
}
