package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ToolLifeCycle {

    @JacksonXmlProperty(isAttribute = true, localName = "deviceUuid")
    private String deviceUuid;

    @JacksonXmlProperty(isAttribute = true, localName = "toolId")
    private String toolId;

    @JacksonXmlText
    private String text;
}
