package Controllers;

import Commons.FuncWriteAndReadFileCSV;
import Commons.ValidateData;
import Models.persons.Customers;
import Models.persons.Employees;
import Models.services.House;
import Models.services.Room;
import Models.services.Services;
import Models.services.Villa;
import SortData.ComparatorCustomer;

import java.io.IOException;
import java.util.*;

public class ControllerDetail {

    private static Scanner sc = new Scanner(System.in);
    private static boolean checkShowOrAdd = true;
    private static List<Customers> listCustomer;

    //region Add new object
    public static Services addNewServies(Services service) {

        service.setId(UUID.randomUUID().toString().replace("-", ""));

        //Tên dịch vụ
        do {
            System.out.println("Enter Services Name");
            service.setNameServices(sc.nextLine());
        }
        while (!ValidateData.validateNameService(service.getNameServices()));

        //Diện tích sử dụng
        while (true) {
            try {
                System.out.println("Enter Area Used");
                service.setAreaUsed(sc.nextDouble());
                while (!ValidateData.validateAreaUsedAndPool(service.getAreaUsed())) {
                    System.out.println("Enter Area Used");
                    service.setAreaUsed(sc.nextDouble());
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu nhập vào sai định dạng");
                sc.nextLine();
            }
        }

        //Chi phí phải trả
        while (true) {
            try {
                System.out.println("Enter Rental Costs");
                service.setRentalCosts(sc.nextDouble());
                while (!ValidateData.validateRentalCosts(service.getRentalCosts())) {
                    System.out.println("Enter Rental Costs");
                    service.setRentalCosts(sc.nextDouble());
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu nhập vào sai định dạng");
                sc.nextLine();
            }
        }

        //số lượng người đi tối đa

        while (true) {
            try {
                System.out.println("Enter Number Of People");
                service.setNumberOfPeople(sc.nextInt());
                while (!ValidateData.validateNumberOfPeople(service.getNumberOfPeople())) {
                    System.out.println("Enter Number Of People");
                    service.setNumberOfPeople(sc.nextInt());
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu nhập vào sai định dạng");
                sc.nextLine();
            }
        }

        //loại chi phí
        do {
            System.out.println("Enter TypeRent");
            sc.nextLine();
            service.setTypeRent(sc.nextLine());
        } while (!ValidateData.validateNameService(service.getTypeRent()));

        return service;
    }

    public static void addNewVilla() throws IOException {

        Services villa = new Villa();

        addNewServies(villa);

        //tiêu chuẩn phòng
        do {
            System.out.println("Enter Room Standard");
            ((Villa) villa).setRoomStandard(sc.nextLine());
        } while (!ValidateData.validateNameService(((Villa) villa).getRoomStandard()));

        //diện tích hồ bơi
        while (true) {
            try {
                System.out.println("Enter Pool Area");
                ((Villa) villa).setAreaPool(sc.nextDouble());
                while (!ValidateData.validateAreaUsedAndPool(((Villa) villa).getAreaPool())) {
                    System.out.println("Enter Pool Area");
                    ((Villa) villa).setAreaPool(sc.nextDouble());
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu nhập vào sai định dạng");
                sc.nextLine();
            }
        }

        //mô tả tiện ích
        System.out.println("Enter Utilities Description");
        sc.nextLine();
        ((Villa) villa).setUtilitiesDescription(sc.nextLine());

        //số tầng
        while (true) {
            try {
                System.out.println("Enter Number Of Floors");
                ((Villa) villa).setNumberOfFloors(sc.nextInt());
                while (!ValidateData.validatenumberOfFloor(((Villa) villa).getNumberOfFloors())) {
                    System.out.println("Enter Number Of Floors");
                    ((Villa) villa).setNumberOfFloors(sc.nextInt());
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu nhập vào sai định dạng");
                sc.nextLine();
            }
        }

        FuncWriteAndReadFileCSV.writeVillaCSV((Villa) villa);
        MainController.backToMenu();
    }

    public static void addNewHouse() throws IOException {
        Services house = new House();
        addNewServies(house);
        //tiêu chuẩn phòng
        do {
            System.out.println("Enter Room Standard");
            ((House) house).setRoomStandard(sc.nextLine());
        } while (!ValidateData.validateNameService(((House) house).getRoomStandard()));

        //Mô tả tiện ích khác
        System.out.println("Enter Utilities Description");
        ((House) house).setUtilitiesDescription(sc.nextLine());

        //số tầng
        while (true) {
            try {
                System.out.println("Enter Number Of Floors");
                ((House) house).setNumberOfFloors(sc.nextInt());
                while (!ValidateData.validatenumberOfFloor(((House) house).getNumberOfFloors())) {
                    System.out.println("Enter Number Of Floors");
                    ((House) house).setNumberOfFloors(sc.nextInt());
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu nhập vào sai định dạng");
                sc.nextLine();
            }
        }
        FuncWriteAndReadFileCSV.writeHouseCSV((House) house);
        MainController.backToMenu();
    }

    public static void addNewRoom() throws IOException {
        Services room = new Room();
        addNewServies(room);
        //Dịch vụ đi kèm

        do {
            System.out.println("Enter Free Services");
            ((Room) room).setFreeServices(sc.nextLine());
        } while (!ValidateData.validateAccompaniedService(((Room) room).getFreeServices()));


        FuncWriteAndReadFileCSV.writeRoomCSV((Room) room);
        MainController.backToMenu();
    }

    public static void addNewCustomer() throws IOException {
        Customers customer = new Customers();

        customer.setId(UUID.randomUUID().toString().replace("-", ""));

        //enter name
        do {
            System.out.println("Enter Name");
            customer.setName(sc.nextLine());
        } while (!ValidateData.validateCustomerName(customer.getName()));

        //enter birthday
        do {
            System.out.println("Enter birthday");
            customer.setBirthday(sc.nextLine());
        } while (!ValidateData.validateBirthday(customer.getBirthday()));

        //enter gender
        do {
            System.out.println("Enter gender");
            customer.setGender(sc.nextLine());

        } while (!ValidateData.validateGender(customer.getGender().toLowerCase()));
        customer.setGender(ValidateData.genderPerson);

        //enter IdCard
        do {
            System.out.println("Enter idCard");
            customer.setIdCard(sc.nextLine());
        } while (!ValidateData.validateIDCard(customer.getIdCard()));

        do {
            System.out.println("Enter phone");
            customer.setPhone(sc.nextLine());
        } while (!ValidateData.validatePhone(customer.getPhone()));

        //enter email
        do {
            System.out.println("Enter email");
            customer.setEmail(sc.nextLine());
        } while (!ValidateData.validateEmail(customer.getEmail()));

        //enter customerType
        System.out.println("Enter customerType");
        customer.setCustomerType(sc.nextLine());

        //Enter address
        System.out.println("Enter address");
        customer.setAddress(sc.nextLine());

        FuncWriteAndReadFileCSV.writeCustmerCSV(customer);
        MainController.backToMenu();
    }

    //endregion

    //region show information of all
    public static void showAllVilla() throws IOException {
        List<Villa> listVilla = FuncWriteAndReadFileCSV.readVillaCSV();
        for (int i = 0; i < listVilla.size(); i++) {
            System.out.print((i + 1) + ". \t");
            System.out.print(listVilla.get(i).showInfor());
            System.out.println();
            System.out.println("********************************");
        }
        MainController.backToMenu();
    }

    public static void showInfoCustomer() throws IOException {
        List<Customers> listCustomer = FuncWriteAndReadFileCSV.readCustomerCSV();
        //Collections.sort(listCustomer, new ComparatorCustomer());
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.print((i + 1) + ". \t");
            System.out.print(listCustomer.get(i).showInfor());
            System.out.println();
            System.out.println("********************************");
        }
        if (checkShowOrAdd) {
            MainController.backToMenu();
        }
    }

    public static void showAllHouse() throws IOException {
        List<House> listHouse = FuncWriteAndReadFileCSV.readHouseCSV();
        for (int i = 0; i < listHouse.size(); i++) {
            System.out.print((i + 1) + ". \t");
            System.out.print(listHouse.get(i).showInfor());
            System.out.println();
            System.out.println("********************************");
        }
        MainController.backToMenu();
    }

    public static void showAllRoom() throws IOException {
        List<Room> listRoom = FuncWriteAndReadFileCSV.readRoomCSV();
        for (int i = 0; i < listRoom.size(); i++) {
            System.out.print((i + 1) + ". \t");
            System.out.print(listRoom.get(i).showInfor());
            System.out.println();
            System.out.println("********************************");
        }
        MainController.backToMenu();
    }

    public static void showAllNameVillaNotDuplicate() throws IOException {
        String pathFileVilla = "src/Data/villa.csv";
        Set<String> setNameVilla = FuncWriteAndReadFileCSV.getNameServiceFromFileCSV(pathFileVilla);
        for (String name : setNameVilla) {
            System.out.println("*****************************");
            System.out.println(name);
        }
        MainController.displayMainMenu();
    }

    public static void showAllNameHouseNotDuplicate() throws IOException {
        String pathFileHouse = "src/Data/house.csv";
        Set<String> setNameHouse = FuncWriteAndReadFileCSV.getNameServiceFromFileCSV(pathFileHouse);
        for (String name : setNameHouse) {
            System.out.println("*****************************");
            System.out.println(name);
        }
        MainController.displayMainMenu();
    }

    public static void showAllNameRoomNotDuplicate() throws IOException {
        String pathFileRoom = "src/Data/room.csv";
        Set<String> setNameRoom = FuncWriteAndReadFileCSV.getNameServiceFromFileCSV(pathFileRoom);
        for (String name : setNameRoom) {
            System.out.println("*****************************");
            System.out.println(name);
        }
        MainController.displayMainMenu();
    }

    public static void showInformationEmployees() throws IOException {
        Map<String, Employees> employeeMap;
        employeeMap = new HashMap<>();
        employeeMap.put("E-001", new Employees("001", "Trần Minh Triều", "32", "123456789"));
        employeeMap.put("E-002", new Employees("002", "Lê Ngọc Huy", "25", "125856789"));
        employeeMap.put("E-003", new Employees("003", "Nguyễn Văn Kiến Đen", "22", "123659847"));
        employeeMap.put("E-004", new Employees("004", "Lê Đình Quốc", "27", "123584692"));
        employeeMap.put("E-005", new Employees("005", "Trương Văn Toàn", "24", "0236594856"));
        employeeMap.put("E-006", new Employees("006", "Tống Công Minh", "20", "26532546"));
        employeeMap.put("E-007", new Employees("007", "Nguyễn Duy Vũ", "22", "1236958745"));
        employeeMap.put("E-008", new Employees("008", "Mai Quốc Việt", "23", "12365985"));
        employeeMap.put("E-009", new Employees("009", "Nguyễn Duy Hiền", "22", "123658459"));
        employeeMap.put("E-010", new Employees("010", "Lâm Văn Hùng", "22", "203265925"));
        employeeMap.put("E-011", new Employees("001", "Trần Minh Triều", "42", "1230006789"));
        List<Employees> employees = new ArrayList<>(employeeMap.values());
        List<Employees> strList = new ArrayList<>(employeeMap.values());
        for (Employees employee : employees) {
            System.out.println("--------------------------------------------------------------");
            System.out.println(employee.showInfor());
            System.out.println();
        }
        MainController.displayMainMenu();
    }

    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }


    //endregion

    //region Booking resort
    public static void addNewBookingResort() throws IOException {
        checkShowOrAdd = false;
        showInfoCustomer();
        listCustomer = FuncWriteAndReadFileCSV.readCustomerCSV();
        System.out.print("Enter customer you want booking by number: ");
        int numChoice = sc.nextInt();
        while ((numChoice < 1) || (numChoice > listCustomer.size())) {
            System.out.println("Size of list Customer: " + listCustomer.size() + ", choice: " + numChoice);
            System.out.print("Enter again your choice: ");
            numChoice = sc.nextInt();
        }
        Customers customer = listCustomer.get(numChoice - 1);
        System.out.println("1. Booking Villa\n2. Booking House \n3. Booking Room");
        int choiceBooking = sc.nextInt();
        while (choiceBooking < 1 || choiceBooking > 3) {
            System.out.println("Vui lòng chọn đúng dịch vụ Booking!");
            System.out.println();
            System.out.println("1. Booking Villa\n2. Booking House \n3. Booking Room");
            choiceBooking = sc.nextInt();
        }
        switch (choiceBooking) {
            case 1: {
                List<Villa> villas;
                villas = FuncWriteAndReadFileCSV.readVillaCSV();
                for (int i = 0; i < villas.size(); i++) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Number: " + (i + 1));
                    System.out.println(villas.get(i).showInfor());
                }
                System.out.print("Enter choice booking Villa:");
                Villa villa = villas.get(sc.nextInt() - 1);
                customer.setServiceUse(villa.getId());
                break;
            }
            case 2: {

                break;
            }
            case 3: {

                break;
            }
            default: {
                MainController.displayMainMenu();
            }
        }
        FuncWriteAndReadFileCSV.writeCsvFileBooking(customer);
//        List<Customers> listBooking = FuncWriteAndReadFileCSV.readCsvFileBooking();
//        listBooking.add(customer);
        MainController.displayMainMenu();
    }
    //endregion
    public String getAll() {
        return null;
    }

}
