package io.github.protocol.mtconnect.server;

import io.github.protocol.mtconnect.api.Device;
import io.github.protocol.mtconnect.api.MTConnectDevices;
import io.github.protocol.mtconnect.common.XmlUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

class MTConnectDevicesDecodeTest {
    @Test
    void testMTConnectDevicesDecode() throws Exception {

        InputStream xmlInputStream = MTConnectFileUtil.readFile("mtconnect_devices.xml");
        MTConnectDevices mtConnectDevices = XmlUtil.fromXml(xmlInputStream, MTConnectDevices.class);

        Assertions.assertNotNull(mtConnectDevices);
        Assertions.assertNotNull(mtConnectDevices.getHeader());
        Assertions.assertEquals("2010-03-13T08:02:38+00:00", mtConnectDevices.getHeader().getCreationTime());
        Assertions.assertEquals("localhost", mtConnectDevices.getHeader().getSender());
        Assertions.assertEquals("1268463594", mtConnectDevices.getHeader().getInstanceId());
        Assertions.assertEquals(131072, mtConnectDevices.getHeader().getBufferSize());
        Assertions.assertEquals("1.1", mtConnectDevices.getHeader().getVersion());

        Assertions.assertNotNull(mtConnectDevices.getDevices());
        Assertions.assertEquals(1, mtConnectDevices.getDevices().size());
        Device device = mtConnectDevices.getDevices().get(0);
        Assertions.assertEquals("dev", device.getId());
        Assertions.assertEquals("VMC-4Axis", device.getName());
        Assertions.assertEquals("XXX111", device.getUuid());
    }
}
