package vn.tmt.springboot_web_casestudy.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_customers")
public class TypeCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_customer_id")
    private Long id;

    @Column(name = "type_customer_name")
    private String type_customer_name;

    @OneToMany(targetEntity = Customer.class, mappedBy = "typeCustomer", cascade = CascadeType.ALL)
    private List<Customer> customers;

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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public TypeCustomer() {

    }
}
