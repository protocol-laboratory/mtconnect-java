package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Error {
    @JacksonXmlProperty(isAttribute = true, localName = "errorCode")
    private String errorCode;

    @JacksonXmlText
    private String text;
}
