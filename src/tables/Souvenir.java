package tables;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Souvenir.findAll",
                query = "SELECT s FROM SouveniresOfVendor s"),
        @NamedQuery(name = "Souvenir.souveniresByVendor",
                query = "SELECT s FROM SouveniresOfVendor s WHERE s.vendor.id = :vendorId"),
        @NamedQuery(name = "Souvenir.souveniresByCountry",
                query = "SELECT s FROM SouveniresOfVendor s " +
                        "WHERE s.vendor.country.country.id = :countryId")})
public class Souvenir {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Basic
    private Integer date;

    @Basic
    private Double price;

    @Basic
    private String souvenirName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSouvenirName() {
        return souvenirName;
    }

    public void setSouvenirName(String name) {
        this.souvenirName = name;
    }

    @OneToOne(mappedBy = "souvenir", optional = false)
    private SouveniresOfVendor vendor;

    public SouveniresOfVendor getVendor() {
        return vendor;
    }

    public void setVendor(SouveniresOfVendor vendor) {
        this.vendor = vendor;
    }
}
