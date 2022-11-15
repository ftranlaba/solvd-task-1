package task1;

import java.util.List;
import java.util.ArrayList;

public class University {
    private String name;
    private int yearFounded;
    private List<Person> personList;
    private List<Program> programList;

    public University() {
        this.name = "";
        this.yearFounded = -1;
        this.personList = new ArrayList<>();
        this.programList = new ArrayList<>();
    }

    public University(String name, int yearFounded, List<Person> personList, List<Program> programList) {
        this.name = name;
        this.yearFounded = yearFounded;
        this.personList = personList;
        this.programList = programList;
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

    public List<Program> getProgramList() {
        return programList;
    }

    public void setProgramList(List<Program> programList) {
        this.programList = programList;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", yearFounded=" + yearFounded +
                ", personList=" + personList +
                ", programList=" + programList +
                '}';
    }
}