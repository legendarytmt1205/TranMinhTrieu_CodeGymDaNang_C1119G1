package vn.tmt.springboot_web_casestudy.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @NotEmpty(message = "Tên không được để trống")
    @Size(min = 2, max = 30, message = "Length from 2 to 30")
    @Column(name = "full_name")
    private String fullName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "birthday")
    private Date birthday;

    @NotEmpty(message = "CMND không được để trống")
    @Pattern(regexp = "(^([0-9]{9})$)|(^([0-9]{12})$)", message = "CMND Không đúng định dạng")
    @Column(name = "id_card")
    private String id_card;

    @NotEmpty(message = "SDT không được để trống")
    @Pattern(regexp = "((090|091|84+090|84+091)+([1-9]{7}))", message = "SDT Không đúng định dạng")
    @Column(name = "phone_number")
    private String phone_number;

    @NotEmpty(message = "Email không được để trống")
    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Email chưa đúng định dạng")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Địa chỉ không được để trống")
    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "type_customer_id")
    private TypeCustomer typeCustomer;

    @OneToMany(targetEntity = Contract.class, mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Customer() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String full_name) {
        this.fullName = full_name;
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

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "FuramaCustomer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", id_card='" + id_card + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", furamaTypeCustomer=" + typeCustomer +
                '}';
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        if (customer.getBirthday() == null) {
            errors.rejectValue("birthday", "customer.birthday");
        }
    }
}
