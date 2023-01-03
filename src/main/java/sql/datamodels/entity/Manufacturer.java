package sql.datamodels.entity;

import java.util.Objects;

public class Manufacturer extends Entity {
    private int year;

    public Manufacturer(String name, int year) {
        super(name);
        this.year = year;
    }

    public Manufacturer(Object[] arr) {
        super(arr[0] + "");
        year = Integer.parseInt(arr[1] + "");
    }

    public Manufacturer() {
        super();
        this.year = 0;
    }

    public int getYear() {
        return year;
    }

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
