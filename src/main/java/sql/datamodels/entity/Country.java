package sql.datamodels.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Country")
public class Country extends Entity {
    public Country(String name) {
        super(name);
    }

    public Country(Object[] arr) {
        super(arr[0] + "");
    }

    public Country() {
        super();
    }
}
