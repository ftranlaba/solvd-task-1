package sql.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.dao.entity.city.CityDaoMysql;
import sql.dao.entity.city.ICityDao;
import sql.dao.entity.country.CountryDaoMysql;
import sql.dao.entity.country.ICountryDao;
import sql.dao.entity.manufacturer.IManufacturerDao;
import sql.dao.entity.manufacturer.ManufacturerDaoMysql;
import sql.datamodels.entity.City;
import sql.datamodels.entity.Country;
import sql.datamodels.entity.Manufacturer;

import java.util.List;

public class ServiceMysql implements IService { // String url, String user, String pass, int size
    private static final ICityDao cityDao = new CityDaoMysql();
    private static final ICountryDao countryDao = new CountryDaoMysql();
    private static final IManufacturerDao manufacturerDao = new ManufacturerDaoMysql();
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
