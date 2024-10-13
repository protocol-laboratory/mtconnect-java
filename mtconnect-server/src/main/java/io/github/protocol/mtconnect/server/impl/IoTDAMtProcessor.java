package io.github.protocol.mtconnect.server.impl;

import io.github.protocol.mtconnect.api.AssetRequest;
import io.github.protocol.mtconnect.api.AssetResponse;
import io.github.protocol.mtconnect.server.MtProcessor;

public class IoTDAMtProcessor implements MtProcessor {
    private final String ak;

    private final String sk;

    public IoTDAMtProcessor(String ak, String sk) {
        this.ak = ak;
        this.sk = sk;
    }

    @Override
    public AssetResponse asset(AssetRequest assetRequest) {
        return null;
    }
}
