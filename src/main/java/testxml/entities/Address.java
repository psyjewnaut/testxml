package testxml.entities;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name = "OBJECT")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlAttribute(name = "ID")
    private int id;

    @XmlAttribute(name = "OBJECTID")
    private String objectID;

    @XmlAttribute(name = "OBJECTGUID")
    private String objectGUID;

    @XmlAttribute(name = "CHANGEID")
    private int changeID;

    @XmlAttribute(name = "NAME")
    private String name;

    @XmlAttribute(name = "TYPENAME")
    private String typename;

    @XmlAttribute(name = "LEVEL")
    private int level;

    @XmlAttribute(name = "OPERTYPEID")
    private int opertypeID;

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
