package vn.tmt.springboot_web_casestudy.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_customers")
public class FuramaTypeCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "type_customer_id")
    private Long id;

    @Column(name = "type_customer_name")
    private String type_customer_name;

    @OneToMany(targetEntity = FuramaCustomer.class)
    private List<FuramaCustomer> furamaCustomers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType_customer_name() {
        return type_customer_name;
    }

    public void setType_customer_name(String type_customer_name) {
        this.type_customer_name = type_customer_name;
    }

    public List<FuramaCustomer> getFuramaCustomers() {
        return furamaCustomers;
    }

    public void setFuramaCustomers(List<FuramaCustomer> furamaCustomers) {
        this.furamaCustomers = furamaCustomers;
    }

    public FuramaTypeCustomer() {

    }
}
