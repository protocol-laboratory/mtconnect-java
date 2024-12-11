package io.github.protocol.mtconnect.server.impl;

import io.github.protocol.mtconnect.api.AssetRequest;
import io.github.protocol.mtconnect.api.DeviceRequest;
import io.github.protocol.mtconnect.api.MTConnectAssets;
import io.github.protocol.mtconnect.api.MTConnectDevices;
import io.github.protocol.mtconnect.server.MTProcessor;


/**
 * MemoryMtProcessor is a simple implementation of MtProcessor that stores all the data in memory.
 */
public class MemoryMtProcessor implements MTProcessor {

    private MTConnectDevices devices;
    private MTConnectAssets assets;

    @Override
    public MTConnectAssets asset(AssetRequest assetRequest) {
        return assets;
    }

    @Override
    public MTConnectDevices device(DeviceRequest deviceRequest) {
        return devices;
    }

    public void updateDevices(MTConnectDevices devices) {
        this.devices = devices;
    }

    public void updateAssets(MTConnectAssets assets) {
        this.assets = assets;
    }
}
