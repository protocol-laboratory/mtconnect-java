package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

class Rotary extends AxesComponent {
    @JacksonXmlProperty(isAttribute = true)
    private String nativeName;

    @JacksonXmlElementWrapper(localName = "DataItems")
    private List<DataItem> dataItems;
}
