package vn.tmt.springboot_web_casestudy.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accompanied_services")
public class Accompanied {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accompanied_service_id")
    private Long id;

    @Column(name = "accompanied_service_name")
    private String accompaniedName;

    @Column(name = "price")
    private Double price;

    @Column(name = "unit")
    private String unit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccompaniedName() {
        return accompaniedName;
    }

    public void setAccompaniedName(String accompaniedName) {
        this.accompaniedName = accompaniedName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Accompanied() {

    }

    @Column(name = "accompanied_service_status")
    private String status;

    @OneToMany(targetEntity = ContractDetail.class)
    private List<ContractDetail> contractDetails;
}
