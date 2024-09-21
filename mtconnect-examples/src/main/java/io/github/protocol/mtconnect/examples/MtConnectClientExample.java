package io.github.protocol.mtconnect.examples;

import io.github.protocol.mtconnect.client.MtConnectClient;
import io.github.protocol.mtconnect.client.MtConnectClientConfiguration;

public class MtConnectClientExample {
    public static void main(String[] args) {
        MtConnectClientConfiguration configuration = new MtConnectClientConfiguration();
        new MtConnectClient(configuration);
    }
}
