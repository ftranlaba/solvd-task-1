package sql.datamodels.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import sql.datamodels.BaseDataModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(propOrder = {"zipcode"})
public abstract class Zipcode extends BaseDataModel {
    @JsonProperty
    int zipcode;

    public Zipcode() {
        super(0);
    }

    public Zipcode(int zipcode) {
        super(0);
        this.zipcode = zipcode;
    }

    public Zipcode(int id, int zipcode) {
        super(id);
        this.zipcode = zipcode;
    }

    public int getZipcode() {
        return zipcode;
    }

    @XmlElement(name = "zipcode")
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zipcode zipcode1 = (Zipcode) o;
        return zipcode == zipcode1.zipcode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipcode);
    }

    @Override
    public String toString() {
        return "Zipcode{" +
                "zipcode=" + zipcode +
                '}';
    }


}
