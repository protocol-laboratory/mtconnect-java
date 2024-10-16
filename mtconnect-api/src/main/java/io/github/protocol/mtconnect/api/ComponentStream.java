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
    @JacksonXmlProperty(localName = "Availability")
    private List<Availability> availabilities;

    @JacksonXmlElementWrapper(localName = "Events")
    @JacksonXmlProperty(localName = "EmergencyStop")
    private List<EmergencyStop> emergencyStops;

    @JacksonXmlElementWrapper(localName = "Events")
    @JacksonXmlProperty(localName = "Execution")
    private List<Execution> executions;

    @JacksonXmlElementWrapper(localName = "Condition")
    @JacksonXmlProperty(localName = "Normal")
    private List<Normal> normals;
}
