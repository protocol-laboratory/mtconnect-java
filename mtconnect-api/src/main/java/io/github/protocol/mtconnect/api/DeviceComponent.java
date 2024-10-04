package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "id")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Axes.class, name = "axes"),
        @JsonSubTypes.Type(value = Controller.class, name = "cont"),
})
public class DeviceComponent {
    @JacksonXmlProperty(isAttribute = true)
    protected String id;

    @JacksonXmlProperty(isAttribute = true)
    protected String name;
}
