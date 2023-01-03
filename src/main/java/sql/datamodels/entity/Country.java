package sql.datamodels.entity;

public class Country extends Entity{
    public Country(String name) {
        super(name);
    }

    public Country(Object[] arr){
        super(arr[0] + "");
    }

    public Country() {
        super();
    }
}
