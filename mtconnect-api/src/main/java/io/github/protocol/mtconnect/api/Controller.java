package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Controller extends DeviceComponent {
    @JacksonXmlElementWrapper(localName = "DataItems")
    private List<DataItem> dataItems;

    @JacksonXmlElementWrapper(localName = "Components")
    private List<Path> path;
}
