package io.github.protocol.mtconnect.server;

import java.io.InputStream;

public class MTConnectFileUtil {
    public static InputStream readFile(String filePath) {
        return MTConnectFileUtil.class.getClassLoader().getResourceAsStream(filePath);
    }
}
