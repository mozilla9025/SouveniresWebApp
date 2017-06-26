package dao;

import tables.Vendor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class VendorDao {

    @PersistenceContext
    private EntityManager em;

    public List<Vendor> findAll() {
        return em.createNamedQuery("Vendor.findAll").getResultList();
    }

    public Vendor addVendor(Vendor v) {

        em.persist(v);
        return v;
    }
}
