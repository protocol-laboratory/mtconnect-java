package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

class DataItem {
    @JacksonXmlProperty(isAttribute = true)
    private String category;

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(isAttribute = true)
    private String type;

    @JacksonXmlProperty(isAttribute = true)
    private String nativeUnits;

    @JacksonXmlProperty(isAttribute = true)
    private String subType;

    @JacksonXmlProperty(isAttribute = true)
    private String units;

    @JacksonXmlElementWrapper(localName = "Constraints")
    private List<String> constraints;
}
