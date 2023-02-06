package sql.datamodels.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import sql.datamodels.BaseDataModel;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

public abstract class Entity extends BaseDataModel {
    @JsonProperty
    private String name;

    public Entity(String name) {
        super(0);
        this.name = name;
    }

    public Entity(int id, String name) {
        super(id);
        this.name = name;
    }

    public Entity() {
        super(0);
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Entity entity = (Entity) o;
        return Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                '}';
    }
}
