package testxml.xml;

import testxml.xml.objects.AddressObjects;
import testxml.xml.objects.HierarchyObjects;
import testxml.entities.Address;
import testxml.entities.Hierarchy;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XmlParser {

    public static List<Address> parseAddress(File file) throws JAXBException {

        JAXBContext AddressContext = JAXBContext.newInstance(AddressObjects.class);
        Unmarshaller AddressUnmarshaller = AddressContext.createUnmarshaller();
        AddressObjects addressObjects = (AddressObjects) AddressUnmarshaller.unmarshal(file);

        List<Address> list = addressObjects.getAddressList();

        return list;
    }

    public static List<Hierarchy> parseHierarchy(File file) throws JAXBException {

        JAXBContext AddressContext = JAXBContext.newInstance(HierarchyObjects.class);
        Unmarshaller AddressUnmarshaller = AddressContext.createUnmarshaller();
        HierarchyObjects hierarchyObjects = (HierarchyObjects) AddressUnmarshaller.unmarshal(file);

        List<Hierarchy> list = hierarchyObjects.getHierarchyList();

        return list;
    }

}



