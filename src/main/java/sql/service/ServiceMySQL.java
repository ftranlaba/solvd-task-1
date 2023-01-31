package sql.service;

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