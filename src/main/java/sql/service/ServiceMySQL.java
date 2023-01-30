package sql.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.dao.mysql.CityDaoMySQL;
import sql.dao.ICityDAO;
import sql.dao.mysql.CountryDaoMySQL;
import sql.dao.ICountryDAO;
import sql.dao.IManufacturerDAO;
import sql.dao.mysql.ManufacturerDaoMySQL;
import sql.datamodels.entity.City;
import sql.datamodels.entity.Country;
import sql.datamodels.entity.Manufacturer;

import java.util.List;

public class ServiceMySQL implements IService { // String url, String user, String pass, int size
    private static final ICityDAO cityDao = new CityDaoMySQL();
    private static final ICountryDAO countryDao = new CountryDaoMySQL();
    private static final IManufacturerDAO manufacturerDao = new ManufacturerDaoMySQL();
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    @Override
    public City findCity(int id) {
        return cityDao.get(id).orElse(null);
    }

    @Override
    public List<City> findAllCities() {
        return cityDao.getAll();
    }

    @Override
    public void createCity(City o) {
        cityDao.save(o);
    }

    @Override
    public Country findCountry(int id) {
        return countryDao.get(id).orElse(null);
    }

    @Override
    public List<Country> findAllCountries() {
        return countryDao.getAll();
    }

    @Override
    public Manufacturer findManufacturer(int id) {
        return manufacturerDao.get(id).orElse(null);
    }

    @Override
    public List<Manufacturer> findAllManufacturers() {
        return manufacturerDao.getAll();
    }
}
