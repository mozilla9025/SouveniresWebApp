package beans;

import dao.SouvenirVendorDao;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class SouvenirVendorBean implements Serializable {
    @EJB
    SouvenirVendorDao svd;

    Integer souvenirId;
    Integer vendorId;

    public String add() {
        svd.add(souvenirId, vendorId);
        return null;
    }

    public Integer getSouvenirId() {
        return souvenirId;
    }

    public void setSouvenirId(Integer souvenirId) {
        this.souvenirId = souvenirId;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }
}
