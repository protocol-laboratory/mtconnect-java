package io.github.protocol.mtconnect.server.impl;

import io.github.protocol.mtconnect.api.AssetRequest;
import io.github.protocol.mtconnect.api.AssetResponse;
import io.github.protocol.mtconnect.server.MtProcessor;

/**
 * MemoryMtProcessor is a simple implementation of MtProcessor that stores all the data in memory.
 */
public class MemoryMtProcessor implements MtProcessor {
    @Override
    public AssetResponse asset(AssetRequest assetRequest) {
        return null;
    }
}
