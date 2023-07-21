package testxml.xml.objects;


import lombok.Data;
import testxml.entities.Address;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "ADDRESSOBJECTS")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressObjects {

    @XmlElement(name="OBJECT")
    private List<Address> addressList;

}
