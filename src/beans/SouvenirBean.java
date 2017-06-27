package beans;

import dao.SouvenirDao;
import tables.Souvenir;
import tables.SouveniresOfVendor;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class SouvenirBean implements Serializable {

    @EJB
    SouvenirDao souvenirDao;
    Souvenir tempSouvenir = new Souvenir();
    Integer vendorId;
    Integer countryId;

    List<SouveniresOfVendor> souveniresOfVendor;
    List<SouveniresOfVendor> souveniresOfCountry;

    public List<SouveniresOfVendor> getAllSouvenires() {
        return souvenirDao.findAll();
    }

    public String add() {
        souvenirDao.addSouvenir(tempSouvenir);
        souvenirDao.addSouvenirVendor(tempSouvenir.getId(), vendorId);
        tempSouvenir = new Souvenir();
        return null;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Souvenir getTempSouvenir() {
        return tempSouvenir;
    }

    public void setTempSouvenir(Souvenir tempSouvenir) {
        this.tempSouvenir = tempSouvenir;
    }

    public String doGetSouveniresOfChosenVendor() {
        souveniresOfVendor = souvenirDao.getSouveniresOfChosenVendor(vendorId);
        return null;
    }

    public String doGetSouveniresOfCountry() {
        souveniresOfCountry = souvenirDao.getSouveniresOfCountry(countryId);
        return null;
    }

    public List<SouveniresOfVendor> getSouveniresOfVendor() {
        return souveniresOfVendor;
    }

    public void setSouveniresOfVendor(List<SouveniresOfVendor> souveniresOfVendor) {
        this.souveniresOfVendor = souveniresOfVendor;
    }

    public List<SouveniresOfVendor> getSouveniresOfCountry() {
        return souveniresOfCountry;
    }

    public void setSouveniresOfCountry(List<SouveniresOfVendor> souveniresOfCountry) {
        this.souveniresOfCountry = souveniresOfCountry;
    }
}
