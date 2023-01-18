package sql.datamodels.entity;

import sql.xml.JAXB.JAXBDateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Timestamp;
import java.util.Objects;

@XmlRootElement(name = "Order")
@XmlType(propOrder = {"startDate", "endDate"})
public class Order {
    Timestamp startDate, endDate;

    public Order() {
    }

    public Order(Timestamp startDate, Timestamp endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Order(Object[] arr) {
        this.startDate = (Timestamp) arr[0];
        this.endDate = (Timestamp) arr[1];
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    @XmlElement(name = "startDate")
    @XmlJavaTypeAdapter( JAXBDateAdapter.class )
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    @XmlElement(name = "endDate")
    @XmlJavaTypeAdapter( JAXBDateAdapter.class )
    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(startDate, order.startDate) && Objects.equals(endDate, order.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    @Override
    public String toString() {
        return "Order{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
