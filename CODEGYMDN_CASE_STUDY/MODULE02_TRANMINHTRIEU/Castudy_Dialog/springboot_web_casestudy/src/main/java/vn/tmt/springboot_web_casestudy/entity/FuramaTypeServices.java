package vn.tmt.springboot_web_casestudy.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_services")
public class FuramaTypeServices {
    @Id
    @Column(name = "type_service_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type_services_name")
    private String type_services_name;

    @OneToMany(targetEntity = FuramaService.class)
    private List<FuramaService> furamaServices;
//    @OneToMany(mappedBy = "furamaTypeServices", cascade = CascadeType.ALL)
//    private List<FuramaService> furamaServices;

    public List<FuramaService> getFuramaServices() {
        return furamaServices;
    }

    public void setFuramaServices(List<FuramaService> furamaServices) {
        this.furamaServices = furamaServices;
    }

    public FuramaTypeServices() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getType_services_name() {
        return type_services_name;
    }

    public void setType_services_name(String type_services_name) {
        this.type_services_name = type_services_name;
    }
}
