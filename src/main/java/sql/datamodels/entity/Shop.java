package sql.datamodels.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Shop")
public class Shop extends Zipcode {
    public Shop(int zipcode) {
        super(zipcode);
    }

    public Shop(Object[] arr) {
        super(Integer.parseInt(arr[0] + ""));
    }

    public Shop() {
        super();
    }

}
