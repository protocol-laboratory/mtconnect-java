package io.github.protocol.mtconnect.server.impl;

import io.github.protocol.mtconnect.api.AssetRequest;
import io.github.protocol.mtconnect.api.AssetResponse;
import io.github.protocol.mtconnect.api.MTConnectAssets;
import io.github.protocol.mtconnect.server.MtProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * MemoryMtProcessor is a simple implementation of MtProcessor that stores all the data in memory.
 */
public class MemoryMtProcessor implements MtProcessor {

    Map<String, MTConnectAssets> mtConnectAssetsMap = new HashMap<>();

    @Override
    public AssetResponse asset(AssetRequest assetRequest) {
        MTConnectAssets assets = mtConnectAssetsMap.get(assetRequest.getId());
        AssetResponse assetResponse = new AssetResponse();
        assetResponse.setAssets(assets);
        return assetResponse;
    }
}
