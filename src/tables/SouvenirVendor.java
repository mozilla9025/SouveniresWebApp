package tables;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class SouvenirVendor {

    private Integer id;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Collection<Souvenir> souvenires;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor")
    public Collection<Souvenir> getSouvenires() {
        return souvenires;
    }

    public void setSouvenires(Collection<Souvenir> souvenires) {
        this.souvenires = souvenires;
    }

    private Vendor vendor;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
