package tables;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NamedQueries({
        @NamedQuery(name = "Vendor.findAll", query = "SELECT v FROM Vendor v"),
//        @NamedQuery(name = "Vendor.vendorsByPrice",
//                query = "SELECT v FROM Vendor v INNER JOIN Souvenir s " +
//                        "ON Vendor.id = v.id GROUP BY v.id HAVING avg(s.price) < :price")
})
public class Vendor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Basic
    private String vendorName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Basic
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        country = country;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor")
    private Collection<SouvenirVendor> souvenires;

    public Collection<SouvenirVendor> getSouvenires() {
        return souvenires;
    }

    public void setSouvenires(Collection<SouvenirVendor> souvenires) {
        this.souvenires = souvenires;
    }
}
