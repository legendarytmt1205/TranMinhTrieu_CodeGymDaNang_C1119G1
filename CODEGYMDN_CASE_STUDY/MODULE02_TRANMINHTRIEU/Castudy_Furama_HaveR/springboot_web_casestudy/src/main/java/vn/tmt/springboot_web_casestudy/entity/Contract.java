package vn.tmt.springboot_web_casestudy.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "contract_date")
    private Date contractDay;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "contract_date_end")
    private Date contractEndDay;

    //@Pattern(regexp = "\\d{1,3}[,\\.]?(\\d{1,2})?", message = "Tiền đặt phải là số dương")
    @Column(name = "deposit")
    private Double deposit;

   // @Pattern(regexp = "\\d{1,3}[,\\.]?(\\d{1,2})?", message = "Tổng tiền phải là số dương")
    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(targetEntity = ContractDetail.class, mappedBy = "contract",cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;

    public Contract() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getContractDay() {
        return contractDay;
    }

    public void setContractDay(Date contractDay) {
        this.contractDay = contractDay;
    }

    public Date getContractEndDay() {
        return contractEndDay;
    }

    public void setContractEndDay(Date contractEndDay) {
        this.contractEndDay = contractEndDay;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
