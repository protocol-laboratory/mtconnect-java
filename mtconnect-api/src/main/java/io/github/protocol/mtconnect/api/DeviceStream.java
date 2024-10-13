package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DeviceStream {

    @JacksonXmlProperty(isAttribute = true, localName = "name")
    private String name;

    @JacksonXmlProperty(isAttribute = true, localName = "uuid")
    private String uuid;

    @JacksonXmlElementWrapper(localName = "ComponentStream", useWrapping = false)
    @JacksonXmlProperty(localName = "ComponentStream")
    private List<ComponentStream> componentStreams;
}
