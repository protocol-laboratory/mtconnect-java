package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MTConnectError {
    @JacksonXmlProperty(isAttribute = true, localName = "schemaLocation")
    private String schemaLocation;

    @JacksonXmlProperty(localName = "Header")
    private Header header;

    @JacksonXmlElementWrapper(localName = "Errors")
    private List<Error> errors;
}
