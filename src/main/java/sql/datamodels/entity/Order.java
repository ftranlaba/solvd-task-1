package sql.datamodels.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import sql.datamodels.BaseDataModel;
import sql.json.TimestampSerializer;
import sql.xml.JAXB.JAXBTimestampAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Timestamp;
import java.util.Objects;

@XmlRootElement(name = "Order")
@XmlType(propOrder = {"startDate", "endDate"})
public class Order extends BaseDataModel {
    @JsonSerialize(using = TimestampSerializer.class)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    Timestamp startDate, endDate;

    public Order() {
        super(0);
    }

    public Order(Timestamp startDate, Timestamp endDate) {
        super(0);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Order(int id, Timestamp startDate, Timestamp endDate) {
        super(id);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Order(Object[] arr) {
        super(0);
        this.startDate = (Timestamp) arr[0];
        this.endDate = (Timestamp) arr[1];
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    @XmlElement(name = "startDate")
    @XmlJavaTypeAdapter(JAXBTimestampAdapter.class)
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    @XmlElement(name = "endDate")
    @XmlJavaTypeAdapter(JAXBTimestampAdapter.class)
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
