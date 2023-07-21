package testxml.xml.objects;


import lombok.Data;
import testxml.entities.Hierarchy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "ITEMS")
@XmlAccessorType(XmlAccessType.FIELD)
public class HierarchyObjects {

    @XmlElement(name="ITEM")
    private List<Hierarchy> hierarchyList;

}
