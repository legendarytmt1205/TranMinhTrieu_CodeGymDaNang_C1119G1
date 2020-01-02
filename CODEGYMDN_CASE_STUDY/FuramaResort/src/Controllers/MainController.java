package Controllers;
import Commons.FuncWriteFileCSV;
import Models.Services;
import Models.Villa;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class MainController {
    private static Scanner sc = new Scanner(System.in);

    public static void displayMainMenu() {
        System.out.println("Do you want choose!"
                + "\n1.Add New Services"
                + "\n2.Show Services"
                + "\n3.Exit");
        switch (sc.nextLine()) {
            case "1":
                addNewServiesMenu();
                break;
            case "2":
                showServices();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("error!!!");
                backToMenu();
                break;
        }
    }

    private static void backToMenu() {
        System.out.println("Enter to display mainMenu!!!");
        sc.nextLine();
        displayMainMenu();
    }

    private static void addNewServiesMenu() {
        System.out.println("Do you want choose?"
                + "\n1.Add New Villa"
                + "\n2.Add New House"
                + "\n3.Add New Room"
                + "\n4.Back to menu"
                + "\n5.Exit");
        switch (sc.nextLine()) {
            case "1":
                addNewVilla();
                break;
            case "2":
                addNewHouse();
                break;
            case "3":
                addNewRoom();
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

    private static void addNewServies(Services service) {
        service.setId(UUID.randomUUID().toString().replace("-",""));
        System.out.println("Enter Services Name");
        service.setNameServices(sc.nextLine());

        System.out.println("Enter Area Used");
        service.setAreaUsed(sc.nextDouble());
        //sc.nextLine();

        System.out.println("Enter Rental Costs");
        service.setRentalCosts(sc.nextDouble());
        //sc.nextLine();

        System.out.println("Enter Number Of Floors");
        service.setNumberOfPeople(sc.nextInt());
        sc.nextLine();

        System.out.println("Enter Number Of Floors");
        service.setTypeRent(sc.nextLine());
        sc.nextLine();
    }

    private static void addNewVilla() {
        //Villa villa1 = new Villa();
        Services villa = new Villa();

        addNewServies(villa);
        System.out.println("Enter Room Standard");
        ((Villa)villa).setRoomStandard(sc.nextLine());

        System.out.println("Enter Pool Area");
        ((Villa)villa).setAreaPool(sc.nextDouble());
        sc.nextLine();

        System.out.println("Enter Utilities Description");
        ((Villa)villa).setUtilitiesDescription(sc.nextLine());

        System.out.println("Enter Number Of Floors");
        ((Villa)villa).setNumberOfPeople(sc.nextInt());

        ArrayList<Villa> listVilla = new ArrayList<Villa>();
        listVilla.add((Villa) villa);

    }

    private static void addNewHouse() {

    }

    private static void addNewRoom() {

    }

    private static void showServices() {

    }
}
