package Controllers;

import Commons.FuncWriteAndReadFileCSV;
import Commons.ValidateData;
import Models.persons.Customers;
import Models.services.Services;
import Models.services.Villa;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;

public class MainController {
    private static Scanner sc = new Scanner(System.in);
    private static boolean valBolean;

    public static void displayMainMenu() throws IOException {
        System.out.println("Do you want choose!"
                + "\n1.Add New Services"
                + "\n2.Show Services"
                + "\n3.Add New Customer"
                + "\n4.Show Information Customer"
                + "\n5.Add New Booking Resort"
                + "\n6.Show Information Employees"
                + "\n7.Exit");
        switch (sc.nextLine()) {
            case "1":
                addNewServiesMenu();
                break;
            case "2":
                showServices();
                break;
            case "3":
                ControllerDetail.addNewCustomer();
                break;
            case "4":
                ControllerDetail.showInfoCustomer();
                break;
            case "5":
                ControllerDetail.addNewBookingResort();
                break;
            case "6":
                ControllerDetail.showInformationEmployees();
                break;
            case "7":
                System.exit(0);
                break;
            default:
                System.out.println("error!!!");
                backToMenu();
                break;
        }
    }

    public static void backToMenu() throws IOException {
        System.out.println("Enter to display mainMenu!!!");
        sc.nextLine();
        displayMainMenu();
    }

    public static void addNewServiesMenu() throws IOException {
        System.out.println("Do you want choose?"
                + "\n1.Add New Villa"
                + "\n2.Add New House"
                + "\n3.Add New Room"
                + "\n4.Back to menu"
                + "\n5.Exit");
        switch (sc.nextLine()) {
            case "1":
                ControllerDetail.addNewVilla();
                break;
            case "2":
                ControllerDetail.addNewHouse();
                break;
            case "3":
                ControllerDetail.addNewRoom();
                break;
            case "4":
                backToMenu();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("error! Enter to continue add new servies");
                sc.nextLine();
                addNewServiesMenu();
        }
    }

    public static void showServices() throws IOException {
        System.out.println("Do you want choose?"
                + "\n1.Show All Villa"
                + "\n2.Show All House"
                + "\n3.Show All Room"
                + "\n4.Show All Name Villa Not Duplicate"
                + "\n5.Show All Name House Not Duplicate"
                + "\n6.Show All Name Name Not Duplicate"
                + "\n7.Back to menu"
                + "\n8.Exit");


        switch (sc.nextLine()) {
            case "1":
                ControllerDetail.showAllVilla();
                break;
            case "2":
                ControllerDetail.showAllHouse();
                break;
            case "3":
                ControllerDetail.showAllRoom();
                break;
            case "4":
                ControllerDetail.showAllNameVillaNotDuplicate();
                break;
            case "5":
                ControllerDetail.showAllNameHouseNotDuplicate();
                break;
            case "6":
                ControllerDetail.showAllNameRoomNotDuplicate();
                break;
            case "7":
                backToMenu();
                break;
            case "8":
                System.exit(0);
                break;
            default:
                System.out.println("error! Enter to continue show Services");
                sc.nextLine();
                addNewServiesMenu();
        }
    }
}
