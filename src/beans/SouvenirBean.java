package beans;

import dao.SouvenirDao;
import tables.Souvenir;

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

    public List<Souvenir> getSouvenires() {
        return souvenirDao.findAll();
    }

    public String add() {
        souvenirDao.addSouvenir(tempSouvenir.getSouvenirName(), tempSouvenir.getPrice());
        tempSouvenir = new Souvenir();
        return null;
    }

    public Souvenir getTempSouvenir() {
        return tempSouvenir;
    }

    public void setTempSouvenir(Souvenir tempSouvenir) {
        this.tempSouvenir = tempSouvenir;
    }

}
