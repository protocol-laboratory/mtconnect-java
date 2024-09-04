package io.github.protocol.mtconnect.client.vertx;

import io.vertx.core.Vertx;

public class MtConnectClient {
    private final Vertx vertx;

    public MtConnectClient() {
        this.vertx = Vertx.vertx();
    }
}
