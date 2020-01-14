package Models.services;

public class House extends Services {

    private String roomStandard;
    private String utilitiesDescription;
    private int numberOfFloors;

    public House(String id, String nameServices, Double areaUsed, Double rentalCosts
            , int numberOfPeople, String typeRent, String roomStandard
            , String utilitiesDescription, int numberOfFloors) {
        super(id, nameServices, areaUsed, rentalCosts, numberOfPeople, typeRent);
        this.roomStandard = roomStandard;
        this.utilitiesDescription = utilitiesDescription;
        this.numberOfFloors = numberOfFloors;
    }

    public House() {
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getUtilitiesDescription() {
        return utilitiesDescription;
    }

    public void setUtilitiesDescription(String utilitiesDescription) {
        this.utilitiesDescription = utilitiesDescription;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInfor() {
        return "\nId Services: " + super.getId()
                + "\nnameServices: " + super.getNameServices()
                + "\nareaUsed: " + super.getAreaUsed()
                + "\nrentalCosts: " + super.getRentalCosts()
                + "\nnumberOfPeople: " + super.getNumberOfPeople()
                + "\ntypeRent: " + super.getNumberOfPeople()
                + "\nroomStandard: " + this.getRoomStandard()
                + "\nutilities: " + this.getUtilitiesDescription()
                + "\nnumberOfFloors: " + this.getNumberOfFloors();
    }
}
