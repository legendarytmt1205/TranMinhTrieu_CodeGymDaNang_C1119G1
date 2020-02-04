package model;

import java.util.ArrayList;
import java.util.List;

public class Customers {
    private String name;
    private String birthday;
    private String Address;
    private String image;
    private static List<Customers> list;

    static {
        list = new ArrayList<>();
        list.add(new Customers("Trieu", "12/05/2000", "QN"));
        list.add(new Customers("Trieu", "12/05/2000", "QN"));
//        list.add(new Customers("Trieu", "12/05/2000", "QN"));
//        list.add(new Customers("Trieu", "12/05/2000", "QN"));
//        list.add(new Customers("Trieu", "12/05/2000", "QN"));
//        list.add(new Customers("Trieu", "12/05/2000", "QN"));
    }
    public Customers() {

    }
    public static List<Customers> getCustomers() {
        return list;
    }

    public Customers(String name, String birthday, String address, String image) {
        this.name = name;
        this.birthday = birthday;
        Address = address;
        this.image = image;
    }
    public Customers(String name, String birthday, String address ) {
        this.name = name;
        this.birthday = birthday;
        Address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

