package io.github.protocol.mtconnect.server;

import io.github.shoothzj.http.facade.core.HttpMethod;
import io.github.shoothzj.http.facade.server.HttpServer;
import io.github.shoothzj.http.facade.server.HttpServerFactory;

import java.util.concurrent.CompletableFuture;

public class MtConnectServer {
    private final MtConnectServerConfiguration config;

    private final HttpServer httpServer;

    private final MtRequestProcessor mtRequestProcessor;

    public MtConnectServer(MtConnectServerConfiguration configuration) {
        this.config = configuration;
        this.httpServer = HttpServerFactory.createHttpServer(config.httpConfig());
        this.mtRequestProcessor = new MtRequestProcessor(configuration);
    }

    public CompletableFuture<Void> start() {
        mtRequestProcessor.getHandlerMap().entrySet().forEach(entry -> {
            httpServer.addRoute(entry.getKey(), HttpMethod.GET, mtRequestProcessor);
        });
        return httpServer.start();
    }
}
