package person.student;

import person.Person;

public abstract class Student extends Person {
    private String studentId;
    

    public Student() {
        super();
        this.studentId = "";
    }

    public Student(String firstName, String lastName, String studentId) {
        super(firstName, lastName);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                '}';
    }
}