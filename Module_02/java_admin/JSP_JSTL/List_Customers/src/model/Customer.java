package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String birthday;
    private String Address;
    private String image;
    private static List<Customer> list;

    static {
        list = new ArrayList<>();
        list.add(new Customer("Trieu", "12/05/2000", "QN","img/countryside1.jfif"));
        list.add(new Customer("Trieu", "12/05/2000", "QN","img/countryside2.jfif"));
        list.add(new Customer("Trieu", "12/05/2000", "QN","img/countryside3.jfif"));
        list.add(new Customer("Trieu", "12/05/2000", "QN","img/countryside4.jfif"));
        list.add(new Customer("Trieu", "12/05/2000", "QN","img/countryside5.jfif"));
        list.add(new Customer("Trieu", "12/05/2000", "QN","img/countryside6.jfif"));
    }
    public Customer() {

    }
    public static List<Customer> getCustomers() {
        return list;
    }

    public Customer(String name, String birthday, String address, String image) {
        this.name = name;
        this.birthday = birthday;
        Address = address;
        this.image = image;
    }
    public Customer(String name, String birthday, String address ) {
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

