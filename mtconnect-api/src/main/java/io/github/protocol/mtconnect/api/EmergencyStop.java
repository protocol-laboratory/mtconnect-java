package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmergencyStop {

    @JacksonXmlProperty(isAttribute = true, localName = "dataItemId")
    private String dataItemId;

    @JacksonXmlProperty(isAttribute = true, localName = "sequence")
    private String sequence;

    @JacksonXmlProperty(isAttribute = true, localName = "timestamp")
    private String timestamp;

    @JacksonXmlProperty
    private String value;
}
