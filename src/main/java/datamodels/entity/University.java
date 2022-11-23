package entity;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import person.Person;

public class University {
    private String name;
    private int yearFounded;
    private List<Person> personList;
    private Set<Course> courseSet;

    public University() {
        this.name = "";
        this.yearFounded = -1;
        this.personList = new ArrayList<>();
        courseSet = new HashSet<>();
    }

    public University(String name, int yearFounded, List<Person> personList, Set<Course> courseSet) {
        this.name = name;
        this.yearFounded = yearFounded;
        this.personList = personList;
        this.courseSet = courseSet;
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

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        University that = (University) object;
        return yearFounded == that.yearFounded && name.equals(that.name) && personList.equals(that.personList) && courseSet.equals(that.courseSet);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), name, yearFounded, personList, courseSet);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", yearFounded=" + yearFounded +
                ", personList=" + personList +
                ", courseSet=" + courseSet +
                '}';
    }
}