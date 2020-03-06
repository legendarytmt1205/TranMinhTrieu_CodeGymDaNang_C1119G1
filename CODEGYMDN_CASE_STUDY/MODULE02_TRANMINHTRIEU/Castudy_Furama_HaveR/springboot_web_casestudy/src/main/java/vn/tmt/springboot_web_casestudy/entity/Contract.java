package vn.tmt.springboot_web_casestudy.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contracts")
public class Contract implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;


    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "contract_date")
    private Date contractDay;

    //    @NotNull(message = "Ngày kết thúc không được để trống")
    //@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "contract_date_end")
    private Date contractEndDay;

    //@Pattern(regexp = "^(\\d*\\.)?\\d+$", message = "Tiền đặt phải là số dương")
    @Positive(message = "Tiền đặt cọc phải là số dương")
    //@NumberFormat(style = NumberFormat.Style.CURRENCY)
    @NotNull(message = "vui lòng nhập số tiền")
    @Column(name = "deposit")
    private Double deposit;

    //@Pattern(regexp = "^(\\d*\\.)?\\d+$", message = "Tổng tiền phải là số dương")
    @Positive(message = "Tổng tiền phải là số dương")
    //@NumberFormat(style = NumberFormat.Style.CURRENCY))
    @NotNull(message = "vui lòng nhập số tiền")
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

    @OneToMany(targetEntity = ContractDetail.class, mappedBy = "contract", cascade = CascadeType.ALL)
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


    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        if (contract.getContractDay() == null || contract.getContractEndDay() == null
                || contract.getContractDay().compareTo(contract.getContractEndDay()) > 0
                || contract.getContractEndDay().compareTo(new java.util.Date()) > 0)
        {
            errors.rejectValue("contractDay", "contract.startDay");
            errors.rejectValue("contractEndDay", "contract.EndDay");
        }
    }
}
