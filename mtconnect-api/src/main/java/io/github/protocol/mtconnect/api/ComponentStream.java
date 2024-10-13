package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ComponentStream {

    @JacksonXmlProperty(isAttribute = true, localName = "component")
    private String component;

    @JacksonXmlProperty(isAttribute = true, localName = "name")
    private String name;

    @JacksonXmlProperty(isAttribute = true, localName = "componentId")
    private String componentId;

    @JacksonXmlElementWrapper(localName = "Events")
    private List<Event> events;

    @JacksonXmlElementWrapper(localName = "Condition")
    private List<Normal> normals;
}
