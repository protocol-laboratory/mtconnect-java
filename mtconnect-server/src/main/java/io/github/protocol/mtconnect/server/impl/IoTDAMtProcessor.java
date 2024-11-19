package io.github.protocol.mtconnect.server.impl;

import com.huaweicloud.sdk.core.auth.AbstractCredentials;
import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.auth.ICredential;
import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.core.region.Region;
import com.huaweicloud.sdk.iotda.v5.IoTDAClient;
import com.huaweicloud.sdk.iotda.v5.model.ListDevicesRequest;
import com.huaweicloud.sdk.iotda.v5.model.ListDevicesResponse;
import io.github.protocol.mtconnect.api.AssetRequest;
import io.github.protocol.mtconnect.api.DeviceRequest;
import io.github.protocol.mtconnect.api.MTConnectAssets;
import io.github.protocol.mtconnect.api.MTConnectDevices;
import io.github.protocol.mtconnect.server.MTProcessor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class IoTDAMtProcessor implements MTProcessor {
    private String ak;
    private String sk;
    private String projectId;
    private String endpoint;
    private IoTDAClient client;

    @Override
    public MTConnectAssets asset(AssetRequest assetRequest) {
        return null;
    }

    @Override
    public MTConnectDevices device(DeviceRequest deviceRequest) {
        ListDevicesRequest request = new ListDevicesRequest();
        try {
            ListDevicesResponse response = client.listDevices(request);
            log.info(response.toString());
        } catch (ConnectionException | RequestTimeoutException e) {
            log.error(e.getMessage());
        } catch (ServiceResponseException e) {
            log.error(e.getMessage());
            log.error(String.valueOf(e.getHttpStatusCode()));
            log.error(e.getRequestId());
            log.error(e.getErrorCode());
            log.error(e.getErrorMsg());
        }
        return null;
    }

    public static class Builder {
        private final IoTDAMtProcessor ioTDAMtProcessor = new IoTDAMtProcessor();

        public Builder setAk(String ak) {
            ioTDAMtProcessor.ak = ak;
            return this;
        }
        public Builder setSk(String sk) {
            ioTDAMtProcessor.sk = sk;
            return this;
        }

        public Builder setProjectId(String projectId) {
            ioTDAMtProcessor.projectId = projectId;
            return this;
        }

        public Builder setEndpoint(String endpoint) {
            ioTDAMtProcessor.endpoint = endpoint;
            return this;
        }

        public IoTDAMtProcessor build(){

            ICredential auth = new BasicCredentials()
                    // 标准版/企业版需要使用衍生算法，基础版请删除配置"withDerivedPredicate";
                    .withDerivedPredicate(AbstractCredentials.DEFAULT_DERIVED_PREDICATE) // Used in derivative ak/sk authentication scenarios
                    .withAk(ioTDAMtProcessor.ak)
                    .withSk(ioTDAMtProcessor.sk);

            ioTDAMtProcessor.client = IoTDAClient.newBuilder()
                    .withCredential(auth)
                    // 标准版/企业版：需自行创建Region对象，基础版：请使用IoTDARegion的region对象，如"withRegion(IoTDARegion.CN_NORTH_4)"
                    .withRegion(new Region("cn-north-4", ioTDAMtProcessor.endpoint))
                    .build();

            return ioTDAMtProcessor;
        }
    }
}
