package sql.datamodels.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "State")
public class State extends Entity {
    public State(String name) {
        super(0, name);
    }

    public State(int id, String name) {
        super(id, name);
    }

    public State(Object[] arr) {
        super(0, arr[0] + "");
    }

    public State() {
        super();
    }

}
