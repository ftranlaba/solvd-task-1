package entity;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

import person.Person;

public class University {
    private String name;
    private int yearFounded;
    private List<Person> personList;

    public University() {
        this.name = "";
        this.yearFounded = -1;
        this.personList = new ArrayList<>();
    }

    public University(String name, int yearFounded, List<Person> personList) {
        this.name = name;
        this.yearFounded = yearFounded;
        this.personList = personList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", yearFounded=" + yearFounded +
                ", personList=" + personList +
                '}';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        University that = (University) object;
        return yearFounded == that.yearFounded && name.equals(that.name) && personList.equals(that.personList);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, yearFounded, personList);
    }
}