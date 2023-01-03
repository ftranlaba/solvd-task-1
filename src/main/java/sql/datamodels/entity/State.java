package sql.datamodels.entity;

public class State extends Entity{
    public State(String name) {
        super(name);
    }

    public State(Object[] arr){
        super(arr[0] + "");
    }

    public State() {
        super();
    }

}
