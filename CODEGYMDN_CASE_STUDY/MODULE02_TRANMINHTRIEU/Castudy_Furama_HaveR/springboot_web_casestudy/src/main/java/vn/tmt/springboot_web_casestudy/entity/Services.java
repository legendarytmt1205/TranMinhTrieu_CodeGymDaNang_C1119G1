package vn.tmt.springboot_web_casestudy.entity;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "services")
public class Services {
        @Id
        @Column(name = "service_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "service_name")
        private String serviceName;

        @Column(name = "service_status")
        private String service_status;


        @Column(name = "area_used")
        private int area_used;


        @Pattern(regexp = "^[1-9]+\\d+$", message = "Số tầng phải là số nguyên dương")
        //@NumberFormat(style = NumberFormat.Style.DEFAULT)
        @Column(name = "number_floors")
        private int number_floors;

        @Pattern(regexp = "^[1-9]+\\d+$", message = "Số người phải là số nguyên dương")
        //@NumberFormat(style = NumberFormat.Style.DEFAULT)
        @Column(name = "number_max_people")
        private int number_max_people;


        //@Pattern(regexp = "\\d{1,3}[,\\.]?(\\d{1,2})?", message = "Chi phí thuê phải là số dương")
        @Column(name = "rental_costs")
        private Double rental_costs;

        @ManyToOne
        @JoinColumn(name = "type_rent_id")
        private TypeRent typeRent;

        @ManyToOne
        @JoinColumn(name = "type_service_id")
        private TypeServices typeServices;

        @OneToMany(targetEntity = Contract.class, mappedBy = "services",cascade = CascadeType.ALL)
        private List<Contract> contracts;

        public List<Contract> getContracts() {
                return contracts;
        }

        public void setContracts(List<Contract> contracts) {
                this.contracts = contracts;
        }

        public Services() {

        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getId() {
                return id;
        }

        public String getServiceName() {
                return serviceName;
        }

        public void setServiceName(String service_name) {
                this.serviceName = service_name;
        }

        public String getService_status() {
                return service_status;
        }

        public void setService_status(String service_status) {
                this.service_status = service_status;
        }

        public int getArea_used() {
                return area_used;
        }

        public void setArea_used(int area_used) {
                this.area_used = area_used;
        }

        public int getNumber_floors() {
                return number_floors;
        }

        public void setNumber_floors(int number_floors) {
                this.number_floors = number_floors;
        }

        public int getNumber_max_people() {
                return number_max_people;
        }

        public void setNumber_max_people(int number_max_people) {
                this.number_max_people = number_max_people;
        }

        public Double getRental_costs() {
                return rental_costs;
        }

        public void setRental_costs(Double rental_costs) {
                this.rental_costs = rental_costs;
        }

        public TypeRent getTypeRent() {
                return typeRent;
        }

        public void setTypeRent(TypeRent typeRent) {
                this.typeRent = typeRent;
        }

        public TypeServices getTypeServices() {
                return typeServices;
        }

        public void setTypeServices(TypeServices typeServices) {
                this.typeServices = typeServices;
        }

        @Override
        public String toString() {
                return "Services{" +
                        "id=" + id +
                        ", serviceName='" + serviceName + '\'' +
                        ", service_status='" + service_status + '\'' +
                        ", area_used=" + area_used +
                        ", number_floors=" + number_floors +
                        ", number_max_people=" + number_max_people +
                        ", rental_costs=" + rental_costs +
                        ", typeRent=" + typeRent +
                        ", typeServices=" + typeServices +
                        '}';
        }
}

