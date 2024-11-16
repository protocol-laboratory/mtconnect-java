package io.github.protocol.mtconnect.common;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.InputStream;

public class XmlUtil {

    private static final XmlMapper xmlMapper = new XmlMapper();

    public static <T> T fromXml(String xml, Class<T> clazz) throws Exception {
        return xmlMapper.readValue(xml, clazz);
    }

    public static <T> T fromXml(InputStream xml, Class<T> clazz) throws Exception {
        return xmlMapper.readValue(xml, clazz);
    }

    public static String toXml(Object obj) throws Exception {
        return xmlMapper.writeValueAsString(obj);
    }
}
