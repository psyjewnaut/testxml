package testxml;

import testxml.entities.Address;
import testxml.entities.Hierarchy;
import testxml.xml.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static List<Address> addressList;
    public static List<Hierarchy> hierarchyList;


    public static void main(String[] args) throws JAXBException {
        loadXml();
        getInput();

    }

    public static void loadXml() throws JAXBException {

        File addressFile = new File(ClassLoader.getSystemResource("AS_ADDR_OBJ.xml").getFile());
        File hierarchyFile = new File(ClassLoader.getSystemResource("AS_ADM_HIERARCHY.xml").getFile());

        addressList = XmlParser.parseAddress(addressFile);
        hierarchyList = XmlParser.parseHierarchy(hierarchyFile);
    }

    public static void getInput() {



        Scanner scanner = new Scanner(System.in);
        while (true){
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
                    return;
                }
            }

            getOutput(date, ids);

        }

    }

    public static void getOutput(Date date, List<String> ids){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Stream<Address> filteredAddress = addressList.stream().filter(address -> {
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
        });


        filteredAddress.forEach(address -> {
            System.out.println(address.getObjectID() + ": " + address.getTypename() + " " + address.getName());
        });


    }



}
