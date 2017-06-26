package tables;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Souvenir.findAll",
                query = "SELECT s FROM Souvenir s"),
        @NamedQuery(name = "Souvenir.souveniresByVendor",
                query = "SELECT s FROM Souvenir s WHERE s.vendor.id = " +
                        "(SELECT v.id FROM Vendor v WHERE v.vendorName = :vendorName)"),
        @NamedQuery(name = "Souvenir.souveniresByCountry",
                query = "SELECT s FROM Souvenir s " +
                        "WHERE s.vendor.vendor.country = :countryName")})
public class Souvenir {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Basic
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private SouvenirVendor vendor;

    public SouvenirVendor getVendor() {
        return vendor;
    }

    public void setVendor(SouvenirVendor vendor) {
        this.vendor = vendor;
    }
}
