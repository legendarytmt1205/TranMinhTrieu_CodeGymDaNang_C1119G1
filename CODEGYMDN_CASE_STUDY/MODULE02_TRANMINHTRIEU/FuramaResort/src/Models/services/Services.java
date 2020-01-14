package Models.services;

public abstract class Services {
    private String id;
    private String nameServices;
    private Double areaUsed;
    private Double rentalCosts;
    private int numberOfPeople;
    private String typeRent;

    public Services() {
    }

    public Services(String id, String nameServices, Double areaUsed, Double rentalCosts, int numberOfPeople, String typeRent) {
        this.id = id;
        this.nameServices = nameServices;
        this.areaUsed = areaUsed;
        this.rentalCosts = rentalCosts;
        this.numberOfPeople = numberOfPeople;
        this.typeRent = typeRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public Double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(Double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public Double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(Double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public abstract String showInfor();
}
