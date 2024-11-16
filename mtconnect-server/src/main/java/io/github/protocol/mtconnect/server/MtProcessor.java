package io.github.protocol.mtconnect.server;

import io.github.protocol.mtconnect.api.AssetRequest;
import io.github.protocol.mtconnect.api.DeviceRequest;
import io.github.protocol.mtconnect.api.MTConnectAssets;
import io.github.protocol.mtconnect.api.MTConnectDevices;

public interface MtProcessor {
    MTConnectAssets asset(AssetRequest assetRequest);
    MTConnectDevices device(DeviceRequest deviceRequest);
}
