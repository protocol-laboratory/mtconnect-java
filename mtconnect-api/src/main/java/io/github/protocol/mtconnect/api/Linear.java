package io.github.protocol.mtconnect.api;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
class Linear extends AxesComponent {
    @JacksonXmlElementWrapper(localName = "DataItems")
    private List<DataItem> dataItems;
}
