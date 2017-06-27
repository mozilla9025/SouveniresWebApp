package dao;

import tables.Souvenir;
import tables.SouveniresOfVendor;
import tables.Vendor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Stateless
public class SouvenirDao {

    @PersistenceContext
    private EntityManager em;

    public List<SouveniresOfVendor> findAll() {
        return em.createNamedQuery("Souvenir.findAll").getResultList();
    }

    public List<SouveniresOfVendor> getSouveniresOfChosenVendor(Integer vendorId) {
        Query namedQuery = em.createNamedQuery("Souvenir.souveniresByVendor");
        namedQuery.setParameter("vendorId", vendorId);
        return namedQuery.getResultList();
    }

    public List<SouveniresOfVendor> getSouveniresOfCountry(Integer countryId) {
        Query namedQuery = em.createNamedQuery("Souvenir.souveniresByCountry");
        namedQuery.setParameter("countryId", countryId);
        return namedQuery.getResultList();
    }

    public Souvenir addSouvenir(Souvenir souvenir) {

        em.persist(souvenir);
        return souvenir;
    }

    public boolean addSouvenirVendor(Integer souvenirId, Integer vendorId) {
        Souvenir souvenir = em.find(Souvenir.class, souvenirId);
        Vendor vendor = em.find(Vendor.class, vendorId);

        if (souvenir == null || vendor == null)
            return false;

        SouveniresOfVendor sof = new SouveniresOfVendor();
        sof.setSouvenir(souvenir);
        sof.setVendor(vendor);

        em.persist(sof);
        return true;
    }
}
