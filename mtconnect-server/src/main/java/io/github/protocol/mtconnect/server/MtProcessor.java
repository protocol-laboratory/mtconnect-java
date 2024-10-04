package io.github.protocol.mtconnect.server;

import io.github.protocol.mtconnect.api.AssetRequest;
import io.github.protocol.mtconnect.api.AssetResponse;

public interface MtProcessor {
    AssetResponse asset(AssetRequest assetRequest);
}
