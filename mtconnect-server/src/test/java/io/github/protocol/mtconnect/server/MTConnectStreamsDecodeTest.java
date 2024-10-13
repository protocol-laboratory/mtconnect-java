package io.github.protocol.mtconnect.server;

import io.github.protocol.mtconnect.api.MTConnectStreams;
import io.github.protocol.mtconnect.common.XmlUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MTConnectStreamsDecodeTest {

    @Test
    void testMTConnectStreamsParsing() throws Exception {
        String xml = """
                <?xml version="1.0" encoding="UTF-8"?>
                <MTConnectStreams xmlns:m="urn:mtconnect.org:MTConnectStreams:1.1"
                  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                  xmlns="urn:mtconnect.org:MTConnectStreams:1.1"
                  xsi:schemaLocation="urn:mtconnect.org:MTConnectStreams:1.1 http://www.mtconnect.org/schemas/MTConnectStreams_1.1.xsd">

                  <Header creationTime="2010-04-06T06:53:34+00:00" sender="localhost"
                    instanceId="1270534765" bufferSize="16" version="1.1" nextSequence="19"
                    firstSequence="3" lastSequence="18" />

                  <Streams>
                    <DeviceStream name="minimal" uuid="1">
                      <ComponentStream component="Device" name="minimal" componentId="d">
                        <Events>
                          <Availability dataItemId="avail" sequence="5" timestamp="2010-04-06T06:19:35.153141">AVAILABLE</Availability>
                        </Events>
                      </ComponentStream>

                      <ComponentStream component="Controller" name="controller" componentId="c1">
                        <Events>
                          <EmergencyStop dataItemId="estop" sequence="9" timestamp="2010-04-06T06:20:05.153230">RESET</EmergencyStop>
                        </Events>
                        <Condition>
                          <Normal dataItemId="system" sequence="13" timestamp="2010-04-06T06:21:35.153784" type="SYSTEM" />
                        </Condition>
                      </ComponentStream>

                      <ComponentStream component="Path" name="path" componentId="p1">
                        <Events>
                          <Execution dataItemId="execution" sequence="14" timestamp="2010-04-06T06:22:05.153741">ACTIVE</Execution>
                        </Events>
                      </ComponentStream>
                    </DeviceStream>
                  </Streams>
                </MTConnectStreams>
                """;

        MTConnectStreams mtConnectStreams = XmlUtil.fromXml(xml, MTConnectStreams.class);

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
