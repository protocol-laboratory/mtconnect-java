package io.github.protocol.mtconnect.server;

import io.github.openfacade.http.HttpMethod;
import io.github.openfacade.http.HttpRequest;
import io.github.openfacade.http.HttpResponse;
import io.github.openfacade.http.HttpServer;
import io.github.openfacade.http.HttpServerFactory;
import io.github.openfacade.http.SyncRequestHandler;
import io.github.protocol.mtconnect.api.AssetRequest;
import io.github.protocol.mtconnect.api.MTConnectAssets;
import io.github.protocol.mtconnect.common.XmlUtil;
import io.netty.handler.codec.http.HttpResponseStatus;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

public class MTConnectServer {
    private final MTConnectServerConfiguration config;

    private final HttpServer httpServer;

    private final MTProcessor mtProcessor;

    public MTConnectServer(MTConnectServerConfiguration configuration) {
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
            MTConnectAssets mtConnectAssets = mtProcessor.asset(new AssetRequest());
            // convert the response to http response
            String body;
            try {
                body = XmlUtil.toXml(mtConnectAssets);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return new HttpResponse(HttpResponseStatus.OK.code(), body.getBytes(StandardCharsets.UTF_8));
        }
    }
}
