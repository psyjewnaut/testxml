package testxml.entities;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name = "ITEM")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hierarchy {

    @XmlAttribute(name = "ID")
    private int id;

    @XmlAttribute(name = "OBJECTID")
    private String objectID;

    @XmlAttribute(name = "PARENTOBJID")
    private String parentObjID;

    @XmlAttribute(name = "CHANGEID")
    private int changeID;

    @XmlAttribute(name = "PREVID")
    private int prevID;

    @XmlAttribute(name = "NEXTID")
    private int nextID;

    @XmlAttribute(name = "UPDATEDATE")
    private String updateDate;

    @XmlAttribute(name = "STARTDATE")
    private String startDate;

    @XmlAttribute(name = "ENDDATE")
    private String endDate;

    @XmlAttribute(name = "ISACTUAL")
    private boolean isActual;

    @XmlAttribute(name = "ISACTIVE")
    private boolean isActive;


}
