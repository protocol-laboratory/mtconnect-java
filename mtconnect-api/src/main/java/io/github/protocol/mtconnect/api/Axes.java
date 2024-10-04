package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Axes extends DeviceComponent {
    @JacksonXmlElementWrapper(localName = "Components")
    private List<AxesComponent> linearComponents;
}
