package sql.datamodels.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Country")
public class Country extends Entity {
    public Country(String name) {
        super(0, name);
    }

    public Country(int id, String name) {
        super(id, name);
    }


    public Country(Object[] arr) {
        super(0, arr[0] + "");
    }

    public Country() {
        super();
    }
}
