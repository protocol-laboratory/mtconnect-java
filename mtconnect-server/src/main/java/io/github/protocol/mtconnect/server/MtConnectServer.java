package io.github.protocol.mtconnect.server;

import io.github.openfacade.http.HttpMethod;
import io.github.openfacade.http.HttpServer;
import io.github.openfacade.http.HttpServerFactory;

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
