package sql.datamodels.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlRootElement(name = "Product")
@XmlType(propOrder = {"price", "amount"})
public class Product extends Entity {
    int price, amount;

    public Product() {
    }

    public Product(String name, int price, int amount) {
        super(name);
        this.price = price;
        this.amount = amount;
    }

    public Product(Object[] arr) {
        super(arr[0] + "");
        this.price = Integer.parseInt(arr[1] + "");
        this.amount = Integer.parseInt(arr[2] + "");
    }

    public Product(int price, int amount) {
        this.price = price;
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    @XmlElement(name = "price")
    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    @XmlElement(name = "amount")
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return price == product.price && amount == product.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price, amount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", amount=" + amount +
                '}';
    }
}
