package io.github.protocol.mtconnect.server;

import io.github.openfacade.http.HttpMethod;
import io.github.openfacade.http.HttpRequest;
import io.github.openfacade.http.HttpResponse;
import io.github.openfacade.http.HttpServer;
import io.github.openfacade.http.HttpServerFactory;
import io.github.openfacade.http.SyncRequestHandler;

import java.util.concurrent.CompletableFuture;

public class MtConnectServer {
    private final MtConnectServerConfiguration config;

    private final HttpServer httpServer;

    private final MtProcessor mtProcessor;

    public MtConnectServer(MtConnectServerConfiguration configuration) {
        this.config = configuration;
        this.httpServer = HttpServerFactory.createHttpServer(config.httpConfig());
        this.mtProcessor = configuration.mtHandler();
    }

    public CompletableFuture<Void> start() {
        this.httpServer.addSyncRoute("/assets", HttpMethod.GET, new MtAssetsHandler());
        return httpServer.start();
    }

    class MtAssetsHandler implements SyncRequestHandler {
        @Override
        public HttpResponse handle(HttpRequest request) {
            // todo
            // read http request to mt asset request
            // call mtProcessor to get the response
            // convert the response to http response
            return null;
        }
    }
}
