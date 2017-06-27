package tables;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NamedQueries({
        @NamedQuery(name = "Vendor.findVendorsByPrice",
                query = "SELECT v FROM SouveniresOfVendor v HAVING max(v.souvenir.price)<:price"),
        @NamedQuery(name = "Vendor.findVendorsOfSouvenirByYear",
                query = "SELECT sv FROM SouveniresOfVendor sv " +
                        "WHERE sv.souvenir.id = :souvenirId and sv.souvenir.date = :year"),
        @NamedQuery(name = "Vendor.findAll",
                query = "SELECT v FROM VendorCountry v"),
        @NamedQuery(name = "Vendor.deleteVendor",
                query = "DELETE FROM SouveniresOfVendor v WHERE v.vendor.id = :vendorId")

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

    @OneToOne(mappedBy = "vendor", optional = false)
    private VendorCountry country;

    public VendorCountry getCountry() {
        return country;
    }

    public void setCountry(VendorCountry country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "vendor")
    private Collection<SouveniresOfVendor> souvenires;

    public Collection<SouveniresOfVendor> getSouvenires() {
        return souvenires;
    }

    public void setSouvenires(Collection<SouveniresOfVendor> souvenires) {
        this.souvenires = souvenires;
    }
}
