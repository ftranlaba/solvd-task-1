package sql.datamodels.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "City")
public class City extends Entity {
    public City(String name) {
        super(0, name);
    }

    public City(int id, String name) {
        super(id, name);
    }

    public City(Object[] arr) {
        super(0, arr[0] + "");
    }

    public City() {
        super();
    }
}
