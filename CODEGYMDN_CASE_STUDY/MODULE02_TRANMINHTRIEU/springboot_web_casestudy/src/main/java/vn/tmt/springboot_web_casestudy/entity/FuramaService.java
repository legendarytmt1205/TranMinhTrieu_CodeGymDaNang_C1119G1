package vn.tmt.springboot_web_casestudy.entity;

import javax.persistence.*;

@Entity
@Table(name = "services")
public class FuramaService {
        @Id
        @Column(name = "service_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "service_name")
        private String service_name;

        @Column(name = "service_status")
        private String service_status;

        @Column(name = "area_used")
        private int area_used;

        @Column(name = "number_floors")
        private int number_floors;

        @Column(name = "number_max_people")
        private int number_max_people;

        @Column(name = "rental_costs")
        private int rental_costs;

        @ManyToOne
        @JoinColumn(name = "type_rent_id")
        private FuramaTypeRent furamaTypeRent;

        @ManyToOne
        @JoinColumn(name = "type_service_id")
        private FuramaTypeServices furamaTypeServices;

        public void setId(Long id) {
                this.id = id;
        }

        public Long getId() {
                return id;
        }

        public String getService_name() {
                return service_name;
        }

        public void setService_name(String service_name) {
                this.service_name = service_name;
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

        public int getRental_costs() {
                return rental_costs;
        }

        public void setRental_costs(int rental_costs) {
                this.rental_costs = rental_costs;
        }

        public FuramaTypeRent getFuramaTypeRent() {
                return furamaTypeRent;
        }

        public void setFuramaTypeRent(FuramaTypeRent furamaTypeRent) {
                this.furamaTypeRent = furamaTypeRent;
        }

        public FuramaTypeServices getFuramaTypeServices() {
                return furamaTypeServices;
        }

        public void setFuramaTypeServices(FuramaTypeServices furamaTypeServices) {
                this.furamaTypeServices = furamaTypeServices;
        }

        public FuramaService() {

        }
}

