package sql.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.connectionpool.JDBCConnectionPool;
import sql.dao.entity.city.CityDaoMysql;
import sql.dao.entity.city.ICityDao;
import sql.dao.entity.country.CountryDaoMysql;
import sql.dao.entity.country.ICountryDao;
import sql.dao.entity.manufacturer.IManufacturerDao;
import sql.dao.entity.manufacturer.ManufacturerDaoMysql;
import sql.datamodels.entity.City;
import sql.datamodels.entity.Country;
import sql.datamodels.entity.Manufacturer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ServiceMysql implements IService{ // String url, String user, String pass, int size
    private final static JDBCConnectionPool pool = new JDBCConnectionPool("jdbc:mysql://localhost:3306/mydb", "root", "", 10);
    private final static ICityDao cityDao = new CityDaoMysql();
    private final static ICountryDao countryDao = new CountryDaoMysql();
    private final static IManufacturerDao manufacturerDao = new ManufacturerDaoMysql();
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    @Override
    public City findCity(int id){
        Connection conn = pool.getConnection();
        City output = null;
        try {
            output = cityDao.get(conn, id).orElse(null);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        pool.returnConnection(conn);
        return output;
    }

    @Override
    public List<City> findAllCities(){
        Connection conn = pool.getConnection();
        List<City> output = null;
        try {
            output = cityDao.getAll(conn);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        pool.returnConnection(conn);
        return output;
    }

    @Override
    public void createCity(City o){
        Connection conn = pool.getConnection();
        try{
            cityDao.save(conn, o);
        }
        catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public Country findCountry(int id){
        Connection conn = pool.getConnection();
        Country output = null;
        try {
            output = countryDao.get(conn, id).orElse(null);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        pool.returnConnection(conn);
        return output;
    }

    @Override
    public List<Country> findAllCountries(){
        Connection conn = pool.getConnection();
        List<Country> output = null;
        try {
            output = countryDao.getAll(conn);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        pool.returnConnection(conn);
        return output;
    }

    @Override
    public Manufacturer findManufacturer(int id){
        Connection conn = pool.getConnection();
        Manufacturer output = null;
        try {
            output = manufacturerDao.get(conn, id).orElse(null);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        pool.returnConnection(conn);
        return output;
    }

    @Override
    public List<Manufacturer> findAllManufacturers(){
        Connection conn = pool.getConnection();
        List<Manufacturer> output = null;
        try {
            output = manufacturerDao.getAll(conn);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        pool.returnConnection(conn);
        return output;
    }
}
