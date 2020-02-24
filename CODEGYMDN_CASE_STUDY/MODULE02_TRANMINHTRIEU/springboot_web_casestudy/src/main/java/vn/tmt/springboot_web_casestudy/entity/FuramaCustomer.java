package vn.tmt.springboot_web_casestudy.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customers")
public class FuramaCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthday;

    @Column(name = "id_card")
    private String id_card;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;


    @ManyToOne
    @JoinColumn(name = "type_customer_id")
    private FuramaTypeCustomer furamaTypeCustomer;

    public FuramaCustomer() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public FuramaTypeCustomer getFuramaTypeCustomer() {
        return furamaTypeCustomer;
    }

    public void setFuramaTypeCustomer(FuramaTypeCustomer furamaTypeCustomer) {
        this.furamaTypeCustomer = furamaTypeCustomer;
    }
}
