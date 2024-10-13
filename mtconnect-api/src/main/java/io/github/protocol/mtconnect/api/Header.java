package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Header {
    @JacksonXmlProperty(isAttribute = true)
    private String creationTime;

    @JacksonXmlProperty(isAttribute = true)
    private String sender;

    @JacksonXmlProperty(isAttribute = true)
    private String instanceId;

    @JacksonXmlProperty(isAttribute = true)
    private int bufferSize;

    @JacksonXmlProperty(isAttribute = true)
    private String version;

    @JacksonXmlProperty(isAttribute = true)
    private long nextSequence;

    @JacksonXmlProperty(isAttribute = true)
    private long firstSequence;

    @JacksonXmlProperty(isAttribute = true)
    private long lastSequence;
}
