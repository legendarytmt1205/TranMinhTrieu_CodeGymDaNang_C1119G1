package Models;

public class Room extends Services {

    private String freeServices;

    public Room() {
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room(String id, String nameServices, Double areaUsed, Double rentalCosts
            , int numberOfPeople, String typeRent, String freeServices) {
        super(id, nameServices, areaUsed, rentalCosts, numberOfPeople, typeRent);
        this.freeServices = freeServices;
    }

    @Override
    public String showInfor() {
        return "\nId Services: " + super.getId()
                + "\nnameServices: " + super.getNameServices()
                + "\nareaUsed: " + super.getAreaUsed()
                + "\nrentalCosts: " + super.getRentalCosts()
                + "\nnumberOfPeople: " + super.getNumberOfPeople()
                + "\ntypeRent: " + super.getNumberOfPeople()
                + "\nroomStandard: " + this.getFreeServices();
    }
}
