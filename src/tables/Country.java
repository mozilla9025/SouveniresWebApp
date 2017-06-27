package tables;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Basic
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "country")
    private Collection<VendorCountry> vendors;

    public Collection<VendorCountry> getVendors() {
        return vendors;
    }

    public void setVendors(Collection<VendorCountry> vendors) {
        this.vendors = vendors;
    }
}
