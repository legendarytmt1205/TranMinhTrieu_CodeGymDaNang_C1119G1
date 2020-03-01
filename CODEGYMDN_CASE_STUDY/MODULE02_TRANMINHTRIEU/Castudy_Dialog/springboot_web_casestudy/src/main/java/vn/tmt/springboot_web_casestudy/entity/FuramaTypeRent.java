package vn.tmt.springboot_web_casestudy.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_rents")
public class FuramaTypeRent {
    @Id
    @Column(name = "type_rent_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type_rent_name")
    private String type_rent_name;

    @OneToMany(targetEntity = FuramaService.class)
    private List<FuramaService> furamaServices;

    public FuramaTypeRent() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getType_rent_name() {
        return type_rent_name;
    }

    public void setType_rent_name(String type_rent_name) {
        this.type_rent_name = type_rent_name;
    }

    public List<FuramaService> getFuramaServices() {
        return furamaServices;
    }

    public void setFuramaServices(List<FuramaService> furamaServices) {
        this.furamaServices = furamaServices;
    }
}
