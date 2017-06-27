package dao;

import tables.Country;
import tables.SouveniresOfVendor;
import tables.Vendor;
import tables.VendorCountry;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class VendorDao {

    @PersistenceContext
    private EntityManager em;

    public List<VendorCountry> findAll() {
        return em.createNamedQuery("Vendor.findAll").getResultList();
    }

    public List<SouveniresOfVendor> findVendorsOfChosenSouvenirByYear(Integer souvenirId, Integer year) {
        Query namedQuery = em.createNamedQuery("Vendor.findVendorsOfSouvenirByYear");
        namedQuery.setParameter("souvenirId", souvenirId);
        namedQuery.setParameter("year", year);
        return namedQuery.getResultList();
    }

    public List<SouveniresOfVendor> findVendorsByPriceOfSouvenires(Double souvenirPrice) {
        Query namedQuery = em.createNamedQuery("Vendor.findVendorsByPrice");
        namedQuery.setParameter("price", souvenirPrice);
        return namedQuery.getResultList();
    }

    public void deleteVendor(Integer vendorId) {
        Query namedQuery = em.createNamedQuery("Vendor.deleteVendor");
        namedQuery.setParameter("vendorId", vendorId);
        namedQuery.executeUpdate();
    }

    public Vendor addVendor(Vendor vendor) {

        em.persist(vendor);
        return vendor;
    }

    public VendorCountry addVendorCountry(Integer vendorId, Integer countryId) {
        Vendor vendor = em.find(Vendor.class, vendorId);
        Country country = em.find(Country.class, countryId);

        VendorCountry vc = new VendorCountry();
        vc.setVendor(vendor);
        vc.setCountry(country);

        em.persist(vc);
        return vc;
    }

}
