package io.github.protocol.mtconnect.server;

import io.github.shoothzj.http.facade.core.HttpRequest;
import io.github.shoothzj.http.facade.core.HttpResponse;
import io.github.shoothzj.http.facade.server.RequestHandler;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Getter
@Setter
public class MtRequestProcessor implements RequestHandler {
    private MtConnectServerConfiguration serverCfg;

    private Map<String, MtHandler> handlerMap = new HashMap<>();

    public MtRequestProcessor(MtConnectServerConfiguration serverCfg) {
        this.serverCfg = serverCfg;

        handlerMap.put("/asset", new MtHandlerImpl());
        handlerMap.put("/current", new MtHandlerImpl());
    }

    @Override
    public CompletableFuture<HttpResponse> handle(HttpRequest request) {
        return null;
    }
}
