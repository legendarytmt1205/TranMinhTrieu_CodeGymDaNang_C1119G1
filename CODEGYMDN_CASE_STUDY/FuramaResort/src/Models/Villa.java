package Models;

public class Villa extends Services {
    private String roomStandard;
    private double areaPool;
    private String utilitiesDescription;
    private int numberOfFloors;

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
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

    public Villa(String id, String nameServices, Double areaUsed, Double rentalCosts
            , int numberOfPeople, String typeRent, String roomStandard
            , double areaPool, String utilitiesDescription, int numberOfFloors) {
        super(id, nameServices, areaUsed, rentalCosts, numberOfPeople, typeRent);
        this.roomStandard = roomStandard;
        this.areaPool = areaPool;
        this.utilitiesDescription = utilitiesDescription;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa() {
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
                + "\nareaPool: " + this.getAreaPool()
                + "\nutilities: " + this.getUtilitiesDescription();
    }
}


