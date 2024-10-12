package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CuttingTool {

    @JacksonXmlProperty(isAttribute = true, localName = "serialNumber")
    private String serialNumber;

    @JacksonXmlProperty(isAttribute = true, localName = "timestamp")
    private String timestamp;

    @JacksonXmlProperty(isAttribute = true, localName = "assetId")
    private String assetId;

    @JacksonXmlProperty(localName = "Description")
    private String description;

    @JacksonXmlProperty(localName = "ToolDefinition")
    private String toolDefinition;

    @JacksonXmlProperty(localName = "ToolLifeCycle")
    private ToolLifeCycle toolLifeCycle;
}
