package dao;

import tables.Souvenir;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class SouvenirDao {

    @PersistenceContext
    private EntityManager em;

    public List<Souvenir> findAll() {
        return em.createNamedQuery("Souvenir.findAll").getResultList();
    }

    public Souvenir addSouvenir(String souvenirName, Double price) {

        Souvenir s = new Souvenir();
        s.setSouvenirName(souvenirName);
        s.setPrice(price);
        s.setDate(new Date());

        em.persist(s);
        return s;
    }
}
