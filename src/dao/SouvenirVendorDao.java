package dao;

import tables.Souvenir;
import tables.SouvenirVendor;
import tables.Vendor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SouvenirVendorDao {

    @PersistenceContext
    EntityManager em;

    public boolean add(Integer souvenirId, Integer vendorId) {
        Vendor v = em.find(Vendor.class, vendorId);
        Souvenir s = em.find(Souvenir.class, souvenirId);

        if (v == null || s == null)
            return false;

        SouvenirVendor sv = new SouvenirVendor();
        sv.setVendor(v);
        s.setVendor(sv);
        em.persist(sv);
        return true;
    }

}
