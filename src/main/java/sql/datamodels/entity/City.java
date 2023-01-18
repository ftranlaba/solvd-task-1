package sql.datamodels.entity;

public class City extends Entity {
    public City(String name) {
        super(name);
    }

    public City(Object[] arr) {
        super(arr[0] + "");
    }

    public City() {
        super();
    }
}
