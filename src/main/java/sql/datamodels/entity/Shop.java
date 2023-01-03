package sql.datamodels.entity;

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
