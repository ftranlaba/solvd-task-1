package sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.datamodels.entity.City;
import sql.service.IService;
import sql.service.ServiceMyBatis;

import java.util.List;

public class ServiceTestDriver {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    public static void main(String[] args) {
        IService service = new ServiceMyBatis();
        service.createCity(new City("Los Angeles"));
        service.createCity(new City("New York"));
        service.createCity(new City("Miami"));
        service.createCity(new City("San Francisco"));
        List<City> list = service.readAllCities();
        for (City o : list) {
            LOGGER.info(o.getName());
        }
    }
}