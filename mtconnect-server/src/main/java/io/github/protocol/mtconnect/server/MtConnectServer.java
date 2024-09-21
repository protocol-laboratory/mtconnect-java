package io.github.protocol.mtconnect.server;

import io.github.shoothzj.http.facade.server.HttpServer;
import io.github.shoothzj.http.facade.server.HttpServerFactory;

import java.util.concurrent.CompletableFuture;

public class MtConnectServer {
    private final MtConnectServerConfiguration config;

    private final HttpServer httpServer;

    public MtConnectServer(MtConnectServerConfiguration configuration) {
        this.config = configuration;
        this.httpServer = HttpServerFactory.createHttpServer(config.httpConfig());
    }

    public CompletableFuture<Void> start() {
        return httpServer.start();
    }
}
