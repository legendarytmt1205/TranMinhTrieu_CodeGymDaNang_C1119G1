package vn.tmt.springboot_web_casestudy.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_services")
public class TypeServices {
    @Id
    @Column(name = "type_service_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_services_name")
    private String type_services_name;

    @OneToMany(targetEntity = Services.class)
    private List<Services> services;
//    @OneToMany(mappedBy = "furamaTypeServices", cascade = CascadeType.ALL)
//    private List<FuramaService> furamaServices;

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public TypeServices() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getType_services_name() {
        return type_services_name;
    }

    public void setType_services_name(String type_services_name) {
        this.type_services_name = type_services_name;
    }
}
