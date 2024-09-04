package io.github.protocol.mtconnect.server.vertx;

import io.vertx.core.Vertx;

public class MtConnectServer {
    private final Vertx vertx;

    public MtConnectServer() {
        this.vertx = Vertx.vertx();
    }
}
