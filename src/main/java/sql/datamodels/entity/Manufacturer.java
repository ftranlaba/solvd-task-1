package sql.datamodels.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlRootElement(name = "Manufacturer")
@XmlType(propOrder = {"year"})
public class Manufacturer extends Entity {
    @JsonProperty
    private int year;

    public Manufacturer(String name, int year) {
        super(0, name);
        this.year = year;
    }

    public Manufacturer(int id, String name, int year) {
        super(id, name);
        this.year = year;
    }

    public Manufacturer(Object[] arr) {
        super(0, arr[0] + "");
        year = Integer.parseInt(arr[1] + "");
    }

    public Manufacturer() {
        super();
        this.year = 0;
    }

    public int getYear() {
        return year;
    }

    @XmlElement(name = "year")
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manufacturer that = (Manufacturer) o;
        return year == that.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), year);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "year=" + year +
                '}';
    }
}
