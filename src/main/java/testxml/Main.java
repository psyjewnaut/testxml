package testxml;

import testxml.entities.Address;
import testxml.entities.Hierarchy;
import testxml.xml.XmlParser;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static List<Address> addressList;
    public static List<Hierarchy> hierarchyList;


    public static void main(String[] args) throws JAXBException {
        loadXml();
        getInput();
        getSecondOutput();
    }

    public static void loadXml() throws JAXBException {

        File addressFile = new File(ClassLoader.getSystemResource("AS_ADDR_OBJ.xml").getFile());
        File hierarchyFile = new File(ClassLoader.getSystemResource("AS_ADM_HIERARCHY.xml").getFile());

        addressList = XmlParser.parseAddress(addressFile);
        hierarchyList = XmlParser.parseHierarchy(hierarchyFile);
    }

    public static void getInput() {

        Scanner scanner = new Scanner(System.in);
        String enteredDate;
        String enteredIds;
        Date date;
        List<String> ids;

        System.out.println("Enter date: ");
        enteredDate = scanner.nextLine();

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.parse(enteredDate);
        }catch (Exception e){
            System.out.println("date is incorrect");
            System.exit(1);
            return;
        }

        System.out.println("Enter ID:");
        enteredIds = scanner.nextLine();
        ids = Arrays.asList(enteredIds.split(", "));
        for (String id : ids){
            try {
                Integer.parseInt(id);
            }catch (Exception e){
                System.out.println("IDs is incorrect");
                System.exit(1);
                return;
            }
        }

        getOutput(date, ids);

    }

    public static void getOutput(Date date, List<String> ids){

        System.out.println("\n==================Задание 1========================\n");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        List<Address> filteredAddress = addressList.stream().filter(address -> {
            try {
                Date startDate = formatter.parse(address.getStartDate());
                Date endDate = formatter.parse(address.getEndDate());
                if (date.after(startDate) && date.before(endDate)){
                    if (ids.contains(address.getObjectID())){
                            return true;
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }

            return false;
        }).collect(Collectors.toList());

        filteredAddress.forEach(address -> {
            System.out.println(address.getObjectID() + ": " + address.getTypename() + " " + address.getName());
        });

    }

    public static void getSecondOutput(){

        System.out.println("\n==================Задание 2========================\n");
        List<String> ids = new ArrayList<>();

        List<Address> filteredList = addressList.stream()
                .filter(address -> address.getTypename().equalsIgnoreCase("проезд"))
                .filter(address -> address.isActual() || address.isActive())
                .collect(Collectors.toList());

        filteredList.forEach(address -> {
            ids.add(address.getObjectID());
        });

        List<Hierarchy> hierarchies = hierarchyList.stream()
                .filter(hierarchy -> ids.contains(hierarchy.getObjectID()))
                .collect(Collectors.toList());

        for (Hierarchy hierarchy : hierarchies){

            if (!(hierarchy.isActive() || hierarchy.isActual())){
                continue;
            }

            String parentId = hierarchy.getObjectID();
            List<String> tree = new ArrayList<>();


            while (!parentId.equals("0")){
                tree.add(parentId);
                String nextId = parentId;
                for (Hierarchy h : hierarchyList){
                    if(h.getObjectID().equals(nextId)){
                        parentId = h.getParentObjID();
                    }
                }
            }

            Collections.reverse(tree);

            String addr = "";
            for (String elem : tree){

                Address address = addressList.stream()
                        .filter(a -> a.getObjectID().equals(elem))
                        .findFirst().orElse(null);

                 addr += address.getTypename() + " " + address.getName() + ", ";
            }

            System.out.println(addr);

        }


    }

}
