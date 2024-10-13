package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "dataItemId")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Availability.class, name = "avail"),
        @JsonSubTypes.Type(value = EmergencyStop.class, name = "estop"),
        @JsonSubTypes.Type(value = Execution.class, name = "execution"),
})
public class Event {
    @JacksonXmlProperty(isAttribute = true)
    protected String dataItemId;

    @JacksonXmlProperty(isAttribute = true)
    protected long sequence;

    @JacksonXmlProperty(isAttribute = true)
    protected String timestamp;
}
