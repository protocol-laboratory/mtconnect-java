package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmergencyStop extends Event {
    @JacksonXmlText
    private String value;
}
