package vn.tmt.springboot_web_casestudy.entity;

import javax.persistence.*;

@Entity
@Table(name = "contract_details")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Long id;

    @Column(name = "quantity")
    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "accompanied_service_id")
    private Accompanied accompanied;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Accompanied getAccompanied() {
        return accompanied;
    }

    public void setAccompanied(Accompanied accompanied) {
        this.accompanied = accompanied;
    }

    public ContractDetail() {
    }
}
