package dao;

import tables.Country;
import tables.Vendor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CountryDao {

    @PersistenceContext
    private EntityManager em;

    public List<Country> findAll() {
        return em.createNamedQuery("Country.findAll").getResultList();
    }


    public Country addCountry(Country country) {

        em.persist(country);
        return country;
    }

}
