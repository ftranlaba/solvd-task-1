package sql.service;

import sql.datamodels.entity.City;
import sql.datamodels.entity.Country;
import sql.datamodels.entity.Manufacturer;

import java.util.List;

public interface IService {
    City findCity(int id);

    List<City> findAllCities();

    void createCity(City o);

    Country findCountry(int id);

    List<Country> findAllCountries();

    Manufacturer findManufacturer(int id);

    List<Manufacturer> findAllManufacturers();

}
