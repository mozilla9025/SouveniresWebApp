package beans;

import dao.CountryDao;
import tables.Country;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CountryBean implements Serializable {

    @EJB
    CountryDao countryDAO;

    Country tmpCountry = new Country();

    public List<Country> getCountries() {
        return countryDAO.findAll();
    }

    public String addCountry() {
        countryDAO.addCountry(tmpCountry);
        tmpCountry.setName(null);
        return null;
    }

    public Country getTmpCountry() {
        return tmpCountry;
    }

    public void setTmpCountry(Country tmpCountry) {
        this.tmpCountry = tmpCountry;
    }

}
