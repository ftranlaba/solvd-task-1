package sql.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.dao.mysql.CityDAO;
import sql.dao.ICityDAO;
import sql.dao.mysql.CountryDAO;
import sql.dao.ICountryDAO;
import sql.dao.IManufacturerDAO;
import sql.dao.mysql.ManufacturerDAO;
import sql.datamodels.entity.City;
import sql.datamodels.entity.Country;
import sql.datamodels.entity.Manufacturer;

import java.util.List;
/*
public class ServiceMySQL implements IService {
    private static final ICityDAO cityDao = new CityDAO();
    private static final ICountryDAO countryDao = new CountryDAO();
    private static final IManufacturerDAO manufacturerDao = new ManufacturerDAO();
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    @Override
    public City readCity(int id) {
        return cityDao.get(id).orElse(null);
    }

    @Override
    public List<City> readAllCities() {
        return cityDao.getAll();
    }

    @Override
    public void createCity(City o) {
        cityDao.save(o);
    }

    @Override
    public Country readCountry(int id) {
        return countryDao.get(id).orElse(null);
    }

    @Override
    public List<Country> readAllCountries() {
        return countryDao.getAll();
    }

    @Override
    public Manufacturer readManufacturer(int id) {
        return manufacturerDao.get(id).orElse(null);
    }

    @Override
    public List<Manufacturer> readAllManufacturers() {
        return manufacturerDao.getAll();
    }
}
*/