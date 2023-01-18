package sql.datamodels.entity;

import java.util.Objects;

public abstract class Zipcode {
    int zipcode;

    public Zipcode() {
    }

    public Zipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public int getZipcode() {
        return zipcode;
    }

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
