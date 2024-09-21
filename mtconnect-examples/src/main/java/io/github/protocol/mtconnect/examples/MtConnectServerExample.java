package io.github.protocol.mtconnect.examples;

import io.github.protocol.mtconnect.server.MtConnectServer;
import io.github.protocol.mtconnect.server.MtConnectServerConfiguration;

public class MtConnectServerExample {
    public static void main(String[] args) {
        MtConnectServerConfiguration configuration = new MtConnectServerConfiguration();
        MtConnectServer mtConnectServer = new MtConnectServer(configuration);
        mtConnectServer.start().join();
    }
}
