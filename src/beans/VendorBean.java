package beans;

import dao.VendorDao;
import tables.SouveniresOfVendor;
import tables.Vendor;
import tables.VendorCountry;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class VendorBean implements Serializable {

    @EJB
    VendorDao vendorDao;

    Integer countryId;
    Integer souvenirId;
    Integer year;
    Integer vendorId;
    Double souvenirPrice;

    Vendor tempVendor = new Vendor();

    List<SouveniresOfVendor> vendorList;
    List<SouveniresOfVendor> vendorListByPrice;

    public List<VendorCountry> getVendors() {
        return vendorDao.findAll();
    }

    public String addVendor() {
        vendorDao.addVendor(tempVendor);
        vendorDao.addVendorCountry(tempVendor.getId(), countryId);
        tempVendor.setVendorName(null);
        return null;
    }

    public Vendor getTempVendor() {
        return tempVendor;
    }

    public void setTempVendor(Vendor tempVendor) {
        this.tempVendor = tempVendor;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public List<SouveniresOfVendor> getVendorList() {
        return vendorList;
    }

    public void setVendorList(List<SouveniresOfVendor> vendorList) {
        this.vendorList = vendorList;
    }

    public Integer getSouvenirId() {
        return souvenirId;
    }

    public void setSouvenirId(Integer souvenirId) {
        this.souvenirId = souvenirId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Double getSouvenirPrice() {
        return souvenirPrice;
    }

    public void setSouvenirPrice(Double souvenirPrice) {
        this.souvenirPrice = souvenirPrice;
    }

    public List<SouveniresOfVendor> getVendorListByPrice() {
        return vendorListByPrice;
    }

    public void setVendorListByPrice(List<SouveniresOfVendor> vendorListByPrice) {
        this.vendorListByPrice = vendorListByPrice;
    }

    public String findVendorsOfChosenSouvenirByYear() {
        vendorList = vendorDao.findVendorsOfChosenSouvenirByYear(souvenirId, year);
        return null;
    }

    public String deleteVendor() {
        vendorDao.deleteVendor(vendorId);
        return null;
    }

    public String findVendorsByPriceOfSouvenires() {
        vendorListByPrice = vendorDao.findVendorsByPriceOfSouvenires(souvenirPrice);
        return null;
    }

}
