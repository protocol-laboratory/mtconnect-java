package io.github.protocol.mtconnect.server;

import io.github.protocol.mtconnect.api.CuttingTool;
import io.github.protocol.mtconnect.api.MTConnectAssets;
import io.github.protocol.mtconnect.common.XmlUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

class MTConnectAssetsDecodeTest {

    @Test
    void testMTConnectAssetsDecode() throws Exception {

        InputStream xmlInputStream = MTConnectFileUtil.readFile("mtconnect_assets.xml");
        MTConnectAssets mtConnectAssets = XmlUtil.fromXml(xmlInputStream, MTConnectAssets.class);

        // Validate MTConnectAssets object
        Assertions.assertNotNull(mtConnectAssets);
        Assertions.assertEquals("urn:mtconnect.org:MTConnectAssets:1.2 ../MTConnectAssets_1.2.xsd", mtConnectAssets.getSchemaLocation());

        // Validate Header object
        Assertions.assertNotNull(mtConnectAssets.getHeader());
        Assertions.assertEquals("2001-12-17T09:30:47Z", mtConnectAssets.getHeader().getCreationTime());
        Assertions.assertEquals("localhost", mtConnectAssets.getHeader().getSender());
        Assertions.assertEquals("1", mtConnectAssets.getHeader().getInstanceId());
        Assertions.assertEquals(131000, mtConnectAssets.getHeader().getBufferSize());
        Assertions.assertEquals("1.2", mtConnectAssets.getHeader().getVersion());

        // Validate CuttingTool list
        Assertions.assertNotNull(mtConnectAssets.getCuttingTools());
        Assertions.assertEquals(1, mtConnectAssets.getCuttingTools().size());

        // Validate individual CuttingTool
        CuttingTool cuttingTool = mtConnectAssets.getCuttingTools().get(0);
        Assertions.assertEquals("1234", cuttingTool.getSerialNumber());
        Assertions.assertEquals("2001-12-17T09:30:47Z", cuttingTool.getTimestamp());
        Assertions.assertEquals("1234-112233", cuttingTool.getAssetId());
        Assertions.assertEquals("Cutting Tool", cuttingTool.getDescription());
        Assertions.assertEquals("...", cuttingTool.getToolDefinition());

        // Validate ToolLifeCycle
        Assertions.assertNotNull(cuttingTool.getToolLifeCycle());
        Assertions.assertEquals("1222", cuttingTool.getToolLifeCycle().getDeviceUuid());
        Assertions.assertEquals("1234", cuttingTool.getToolLifeCycle().getToolId());
    }
}
