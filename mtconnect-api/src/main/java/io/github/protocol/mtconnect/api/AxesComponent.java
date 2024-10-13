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
        @JsonSubTypes.Type(value = Linear.class, name = "x"),
        @JsonSubTypes.Type(value = Linear.class, name = "y"),
        @JsonSubTypes.Type(value = Linear.class, name = "z"),
        @JsonSubTypes.Type(value = Rotary.class, name = "a"),
        @JsonSubTypes.Type(value = Rotary.class, name = "c"),
})
public class AxesComponent {
    @JacksonXmlProperty(isAttribute = true)
    protected String id;

    @JacksonXmlProperty(isAttribute = true)
    protected String name;
}
