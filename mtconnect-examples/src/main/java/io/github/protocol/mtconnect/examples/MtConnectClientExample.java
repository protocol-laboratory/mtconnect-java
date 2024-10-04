package io.github.protocol.mtconnect.examples;

import io.github.openfacade.http.HttpClientConfig;
import io.github.protocol.mtconnect.client.MtConnectClient;
import io.github.protocol.mtconnect.client.MtConnectClientConfiguration;

public class MtConnectClientExample {
    public static void main(String[] args) {
        MtConnectClientConfiguration configuration = new MtConnectClientConfiguration();
        HttpClientConfig httpClientConfig = new HttpClientConfig.Builder().build();
        configuration.setHttpConfig(httpClientConfig);
        MtConnectClient mtConnectClient = new MtConnectClient(configuration);
    }
}
