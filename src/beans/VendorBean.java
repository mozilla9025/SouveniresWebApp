package beans;

import dao.VendorDao;
import tables.Vendor;

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

    Vendor tempVendor = new Vendor();

    public List<Vendor> getVendors() {
        return vendorDao.findAll();
    }

    public String addVendor() {

        vendorDao.addVendor(tempVendor);
        tempVendor = new Vendor();
        return null;
    }

    public Vendor getTempVendor() {
        return tempVendor;
    }

    public void setTempVendor(Vendor tempVendor) {
        this.tempVendor = tempVendor;
    }

}
