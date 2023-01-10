package sql.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.datamodels.entity.City;
import sql.datamodels.entity.Country;
import sql.datamodels.entity.Manufacturer;
import sql.datamodels.entity.State;
import sql.datamodels.person.Customer;
import sql.datamodels.person.Employee;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;

public class ParseXML {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    public static void main(String[] args) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        String path = "src/main/resources/sql.xml";
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));
            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    LOGGER.info(startElement.getName().getLocalPart());
                    switch (startElement.getName().getLocalPart()) {
                        case "customer":
                            Customer objCustomer = parseCustomer(reader);
                            LOGGER.info(objCustomer);
                            break;
                        case "employee":
                            Employee objEmployee = parseEmployee(reader);
                            LOGGER.info(objEmployee);
                            break;
                        case "state":
                            State objState = parseState(reader);
                            LOGGER.info(objState);
                            break;
                        case "city":
                            City objCity = parseCity(reader);
                            LOGGER.info(objCity);
                            break;
                        case "country":
                            Country objCountry = parseCountry(reader);
                            LOGGER.info(objCountry);
                            break;
                        case "manufacturer":
                            Manufacturer objManufacturer = parseManufacturer(reader);
                            LOGGER.info(objManufacturer);
                            break;
                    }

                }
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public static String getElementData(XMLEventReader reader) throws XMLStreamException {
        reader.nextEvent();
        reader.nextEvent();
        String output = reader.nextEvent().asCharacters().getData();
        reader.nextEvent();
        return output;
    }

    public static Employee parseEmployee(XMLEventReader reader) throws XMLStreamException {
        String firstName = getElementData(reader);
        String lastName = getElementData(reader);
        String address = getElementData(reader);
        String phoneType = getElementData(reader);
        String phoneNumber = getElementData(reader);
        String zipcode = getElementData(reader);
        return new Employee(firstName, lastName, address, phoneType, phoneNumber, Integer.parseInt(zipcode));
    }

    public static Customer parseCustomer(XMLEventReader reader) throws XMLStreamException {
        String firstName = getElementData(reader);
        String lastName = getElementData(reader);
        String address = getElementData(reader);
        String phoneType = getElementData(reader);
        String phoneNumber = getElementData(reader);
        String zipcode = getElementData(reader);
        return new Customer(firstName, lastName, address, phoneType, phoneNumber, Integer.parseInt(zipcode));
    }

    public static State parseState(XMLEventReader reader) throws XMLStreamException {
        String name = getElementData(reader);
        return new State(name);
    }

    public static City parseCity(XMLEventReader reader) throws XMLStreamException {
        String name = getElementData(reader);
        return new City(name);
    }

    public static Country parseCountry(XMLEventReader reader) throws XMLStreamException {
        String name = getElementData(reader);
        return new Country(name);
    }

    public static Manufacturer parseManufacturer(XMLEventReader reader) throws XMLStreamException {
        String name = getElementData(reader);
        String year = getElementData(reader);
        return new Manufacturer(name, Integer.parseInt(year));
    }
}
