package Commons;

import Models.persons.Customers;
import Models.services.House;
import Models.services.Room;
import Models.services.Villa;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class FuncWriteAndReadFileCSV {

    private static final char COMMA_DELIMITER = ',';
    private static final String[] HEADER_DEFAULT_VILLA = {"id", "nameServices", "areaUsed", "rentalCosts", "numberOfPeople", "typeRent", "roomStandard", "areaPool", "utilities"};
    private static final String[] HEADER_DEFAULT_HOUSE = {"id", "nameServices", "areaUsed", "rentalCosts", "numberOfPeople", "typeRent", "roomStandard", "utilitiesDescription", "numberOfFloors"};
    private static final String[] HEADER_DEFAULT_ROOM = {"id", "nameServices", "areaUsed", "rentalCosts", "numberOfPeople", "typeRent", "freeServices"};
    private static final String[] HEADER_DEFAULT_CUSTOMER = {"id", "name", "birthday", "gender", "idCard", "phone", "email", "customerType", "address", "useService"};
    private static final String[] HEADER_DEFAULT_BOOKING = {"id", "name", "birthday", "gender", "idCard", "phone", "email", "customerType", "address", "useService"};

    //region CSV villa
    public static void writeVillaCSV(Villa villa) {
        try {
            List<Villa> oldVilla = readVillaCSV();
            Writer writer = Files.newBufferedWriter(Paths.get("src/Data/villa.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_VILLA));
            if (oldVilla != null) {
                for (Villa villaItem : oldVilla) {
                    csvPrinter.printRecord(
                            villaItem.getId(),
                            villaItem.getNameServices(),
                            villaItem.getAreaUsed(),
                            villaItem.getRentalCosts(),
                            villaItem.getNumberOfPeople(),
                            villaItem.getTypeRent(),
                            villaItem.getRoomStandard(),
                            villaItem.getAreaPool(),
                            villaItem.getUtilitiesDescription()
                    );
                }
            }
            csvPrinter.printRecord(
                    villa.getId(),
                    villa.getNameServices(),
                    villa.getAreaUsed(),
                    villa.getRentalCosts(),
                    villa.getNumberOfPeople(),
                    villa.getTypeRent(),
                    villa.getRoomStandard(),
                    villa.getAreaPool(),
                    villa.getUtilitiesDescription()
            );

            csvPrinter.flush();
            System.out.println("Write csv file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Villa> readVillaCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("src/Data/villa.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_VILLA).withIgnoreHeaderCase().withTrim());
        List<Villa> oldVillas = new ArrayList<>();
        int i = 0;
        for (CSVRecord csvRecords : csvParser) {
            //ignore header
            if (i == 0) {
                i++;
            } else {
                Villa villa = new Villa();
                villa.setId(csvRecords.get(0));
                villa.setNameServices(csvRecords.get(1));
                villa.setAreaUsed(Double.parseDouble(csvRecords.get(2)));
                villa.setRentalCosts(Double.parseDouble(csvRecords.get(3)));
                villa.setNumberOfPeople(Integer.parseInt(csvRecords.get(4)));
                villa.setTypeRent(csvRecords.get(5));
                villa.setRoomStandard(csvRecords.get(6));
                villa.setAreaPool(Double.parseDouble(csvRecords.get(7)));
                villa.setUtilitiesDescription(csvRecords.get(8));
                oldVillas.add(villa);
            }
        }
        return oldVillas;
    }
    //endregion

    //region CSV House
    public static void writeHouseCSV(House house) {
        try {
            List<House> oldHouse = readHouseCSV();
            Writer writer = Files.newBufferedWriter(Paths.get("src/Data/house.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_HOUSE));
            if (oldHouse != null) {
                for (House houseItem : oldHouse) {
                    csvPrinter.printRecord(
                            houseItem.getId(),
                            houseItem.getNameServices(),
                            houseItem.getAreaUsed(),
                            houseItem.getRentalCosts(),
                            houseItem.getNumberOfPeople(),
                            houseItem.getTypeRent(),
                            houseItem.getRoomStandard(),
                            houseItem.getUtilitiesDescription(),
                            houseItem.getNumberOfFloors()
                    );
                }
            }
            csvPrinter.printRecord(
                    house.getId(),
                    house.getNameServices(),
                    house.getAreaUsed(),
                    house.getRentalCosts(),
                    house.getNumberOfPeople(),
                    house.getTypeRent(),
                    house.getRoomStandard(),
                    house.getUtilitiesDescription(),
                    house.getNumberOfFloors()
            );

            csvPrinter.flush();
            System.out.println("Write csv file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<House> readHouseCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("src/Data/house.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_HOUSE).withIgnoreHeaderCase().withTrim());
        List<House> oldVHouses = new ArrayList<>();
        int i = 0;
        for (CSVRecord csvRecords : csvParser) {
            //ignore header
            if (i == 0) {
                i++;
            } else {
                House house = new House();
                house.setId(csvRecords.get(0));
                house.setNameServices(csvRecords.get(1));
                house.setAreaUsed(Double.parseDouble(csvRecords.get(2)));
                house.setRentalCosts(Double.parseDouble(csvRecords.get(3)));
                house.setNumberOfPeople(Integer.parseInt(csvRecords.get(4)));
                house.setTypeRent(csvRecords.get(5));
                house.setRoomStandard(csvRecords.get(6));
                house.setUtilitiesDescription(csvRecords.get(7));
                house.setNumberOfFloors(Integer.parseInt(csvRecords.get(8)));
                oldVHouses.add(house);
            }
        }
        return oldVHouses;
    }
    //endregion

    //region CSV Room
    public static void writeRoomCSV(Room room) {
        try {
            List<Room> oldRooms = readRoomCSV();
            Writer writer = Files.newBufferedWriter(Paths.get("src/Data/room.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_HOUSE));
            if (oldRooms != null) {
                for (Room roomItem : oldRooms) {
                    csvPrinter.printRecord(
                            roomItem.getId(),
                            roomItem.getNameServices(),
                            roomItem.getAreaUsed(),
                            roomItem.getRentalCosts(),
                            roomItem.getNumberOfPeople(),
                            roomItem.getTypeRent(),
                            roomItem.getFreeServices()
                    );
                }
            }
            csvPrinter.printRecord(
                    room.getId(),
                    room.getNameServices(),
                    room.getAreaUsed(),
                    room.getRentalCosts(),
                    room.getNumberOfPeople(),
                    room.getTypeRent(),
                    room.getFreeServices()
            );

            csvPrinter.flush();
            System.out.println("Write csv file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Room> readRoomCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("src/Data/room.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_ROOM).withIgnoreHeaderCase().withTrim());
        List<Room> oldRooms = new ArrayList<>();
        int i = 0;
        for (CSVRecord csvRecords : csvParser) {
            //ignore header
            if (i == 0) {
                i++;
            } else {
                Room room = new Room();
                room.setId(csvRecords.get(0));
                room.setNameServices(csvRecords.get(1));
                room.setAreaUsed(Double.parseDouble(csvRecords.get(2)));
                room.setRentalCosts(Double.parseDouble(csvRecords.get(3)));
                room.setNumberOfPeople(Integer.parseInt(csvRecords.get(4)));
                room.setTypeRent(csvRecords.get(5));
                room.setFreeServices(csvRecords.get(6));
                oldRooms.add(room);
            }
        }
        return oldRooms;
    }
    //endregion

    //region CSV customer
    public static void writeCustmerCSV(Customers customer) {
        try {
            List<Customers> oldCustomers = readCustomerCSV();
            Writer writer = Files.newBufferedWriter(Paths.get("src/Data/customer.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_CUSTOMER));
            if (oldCustomers != null) {
                for (Customers customerItem : oldCustomers) {
                    csvPrinter.printRecord(
                            customerItem.getId(),
                            customerItem.getName(),
                            customerItem.getBirthday(),
                            customerItem.getGender(),
                            customerItem.getIdCard(),
                            customerItem.getPhone(),
                            customerItem.getEmail(),
                            customerItem.getCustomerType(),
                            customerItem.getAddress(),
                            customerItem.getServiceUse()
                    );
                }
            }
            csvPrinter.printRecord(
                    customer.getId(),
                    customer.getName(),
                    customer.getBirthday(),
                    customer.getGender(),
                    customer.getIdCard(),
                    customer.getPhone(),
                    customer.getEmail(),
                    customer.getCustomerType(),
                    customer.getAddress(),
                    customer.getServiceUse()
            );

            csvPrinter.flush();
            System.out.println("Write csv file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customers> readCustomerCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("src/Data/customer.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_CUSTOMER).withIgnoreHeaderCase().withTrim());
        List<Customers> oldCustomers = new ArrayList<>();
        int i = 0;
        for (CSVRecord csvRecords : csvParser) {
            //ignore header
            if (i == 0) {
                i++;
            } else {
                Customers customer = new Customers();
                customer.setId(csvRecords.get(0));
                customer.setName(csvRecords.get(1));
                customer.setBirthday(csvRecords.get(2));
                customer.setGender(csvRecords.get(3));
                customer.setIdCard(csvRecords.get(4));
                customer.setPhone(csvRecords.get(5));
                customer.setEmail(csvRecords.get(6));
                customer.setCustomerType(csvRecords.get(7));
                customer.setAddress(csvRecords.get(8));
                customer.setServiceUse(csvRecords.get(9));
                oldCustomers.add(customer);
            }
        }
        return oldCustomers;
    }
    //endregion

    //region CSV Booking
    public static void writeCsvFileBooking(Customers customer) {
        try {
            List<Customers> customers = readCsvFileBooking();
            Writer writer = Files.newBufferedWriter(Paths.get("src/Data/booking.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_BOOKING));
            if (customers != null) {
                for (Customers customer1 : customers) {
                    csvPrinter.printRecord(Arrays.asList(customer1.getId(), customer1.getName(), customer1.getBirthday(), customer1.getGender()
                            , customer1.getIdCard(), customer1.getPhone(), customer1.getEmail(), customer1.getCustomerType(),
                            customer1.getAddress(), customer1.getServiceUse()));
                }
            }
            csvPrinter.printRecord(Arrays.asList(customer.getId(), customer.getName(), customer.getBirthday(), customer.getGender()
                    , customer.getIdCard(), customer.getPhone(), customer.getEmail(), customer.getCustomerType(),
                    customer.getAddress(), customer.getServiceUse()));
            csvPrinter.flush();
            System.out.println("Write csv file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customers> readCsvFileBooking() {
        List<Customers> customers = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get("src/Data/booking.csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_BOOKING).withIgnoreHeaderCase().withTrim());
            int i = 0;
            for (CSVRecord csvRecords : csvParser) {
                if (i == 0) {
                    i++;
                } else {
                    Customers customer = new Customers();
                    customer.setId(csvRecords.get(0));
                    customer.setName(csvRecords.get(1));
                    customer.setBirthday(csvRecords.get(2));
                    customer.setGender(csvRecords.get(3));
                    customer.setIdCard(csvRecords.get(4));
                    customer.setPhone(csvRecords.get(5));
                    customer.setEmail(csvRecords.get(6));
                    customer.setCustomerType(csvRecords.get(7));
                    customer.setAddress(csvRecords.get(8));
                    customer.setServiceUse(csvRecords.get(9));
                    customers.add(customer);
                }
            }
            return customers;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //endregion

    //region CSV name service
    public static Set<String> getNameServiceFromFileCSV(String path) {
        String line = "";
        Set<String> setNameService = new TreeSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(String.valueOf(COMMA_DELIMITER));
                setNameService.add(arr[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return setNameService;
    }
    //endregion
}

