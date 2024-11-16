package io.github.protocol.mtconnect.server;

import io.github.protocol.mtconnect.api.MTConnectStreams;
import io.github.protocol.mtconnect.common.XmlUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

class MTConnectStreamsDecodeTest {

    @Test
    void testMTConnectStreamsParsing() throws Exception {

        InputStream xmlInputStream = MTConnectFileUtil.readFile("mtconnect_streams.xml");

        MTConnectStreams mtConnectStreams = XmlUtil.fromXml(xmlInputStream, MTConnectStreams.class);

        // Validate MTConnectStreams object
        Assertions.assertNotNull(mtConnectStreams);
        Assertions.assertEquals("urn:mtconnect.org:MTConnectStreams:1.1 http://www.mtconnect.org/schemas/MTConnectStreams_1.1.xsd", mtConnectStreams.getSchemaLocation());

        // Validate Header
        Assertions.assertNotNull(mtConnectStreams.getHeader());
        Assertions.assertEquals("2010-04-06T06:53:34+00:00", mtConnectStreams.getHeader().getCreationTime());
        Assertions.assertEquals("localhost", mtConnectStreams.getHeader().getSender());
        Assertions.assertEquals("1270534765", mtConnectStreams.getHeader().getInstanceId());
        Assertions.assertEquals(16, mtConnectStreams.getHeader().getBufferSize());
        Assertions.assertEquals("1.1", mtConnectStreams.getHeader().getVersion());
        Assertions.assertEquals(19, mtConnectStreams.getHeader().getNextSequence());
        Assertions.assertEquals(3, mtConnectStreams.getHeader().getFirstSequence());
        Assertions.assertEquals(18, mtConnectStreams.getHeader().getLastSequence());

        // Validate DeviceStream
        Assertions.assertNotNull(mtConnectStreams.getDeviceStreams());
        Assertions.assertEquals(1, mtConnectStreams.getDeviceStreams().size());

        // Validate ComponentStream
        var deviceStream = mtConnectStreams.getDeviceStreams().get(0);
        Assertions.assertEquals("minimal", deviceStream.getName());
        Assertions.assertEquals("1", deviceStream.getUuid());

        var componentStream = deviceStream.getComponentStreams().get(0);
        Assertions.assertEquals("Device", componentStream.getComponent());
        Assertions.assertEquals("minimal", componentStream.getName());
        Assertions.assertEquals("d", componentStream.getComponentId());

        // Validate Events and Condition
        Assertions.assertNotNull(componentStream.getEvents());
        Assertions.assertEquals(1, componentStream.getEvents().size());
    }
}
