package sql.datamodels.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "State")
public class State extends Entity {
    public State(String name) {
        super(name);
    }

    public State(Object[] arr) {
        super(arr[0] + "");
    }

    public State() {
        super();
    }

}
