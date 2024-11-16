package io.github.protocol.mtconnect.server;

import io.github.protocol.mtconnect.api.MTConnectError;
import io.github.protocol.mtconnect.common.XmlUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

class MTConnectErrorDecodeTest {

    @Test
    void testMTConnectErrorDecode() throws Exception {
        InputStream xmlInputStream = MTConnectFileUtil.readFile("mtconnect_error.xml");
        MTConnectError mtConnectError = XmlUtil.fromXml(xmlInputStream, MTConnectError.class);

        // Validate MTConnectError object
        Assertions.assertNotNull(mtConnectError);
        Assertions.assertEquals("urn:mtconnect.org:MTConnectError:1.1 http://www.mtconnect.org/schemas/MTConnectError_1.1.xsd", mtConnectError.getSchemaLocation());

        // Validate Header object
        Assertions.assertNotNull(mtConnectError.getHeader());
        Assertions.assertEquals("2010-03-12T12:33:01", mtConnectError.getHeader().getCreationTime());
        Assertions.assertEquals("localhost", mtConnectError.getHeader().getSender());
        Assertions.assertEquals("1.1", mtConnectError.getHeader().getVersion());
        Assertions.assertEquals(131072, mtConnectError.getHeader().getBufferSize());
        Assertions.assertEquals("1268463594", mtConnectError.getHeader().getInstanceId());

        // Validate Errors list
        Assertions.assertNotNull(mtConnectError.getErrors());
        Assertions.assertEquals(2, mtConnectError.getErrors().size());

        // Validate individual errors
        Assertions.assertEquals("OUT_OF_RANGE", mtConnectError.getErrors().get(0).getErrorCode());
        Assertions.assertEquals("Argument was out of range", mtConnectError.getErrors().get(0).getText());
        Assertions.assertEquals("INVALID_XPATH", mtConnectError.getErrors().get(1).getErrorCode());
        Assertions.assertEquals("Bad path", mtConnectError.getErrors().get(1).getText());
    }
}
