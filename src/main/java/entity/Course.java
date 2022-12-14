package entity;

import enums.BuildingNumbers;

import java.time.LocalTime;
import java.util.Objects;

public class Course {
    // Creates 1 and only 1 array in memory where Course objects can reference from to allow prettier printing
    private static final String[] daysArray = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private String courseTitle;
    private String major;
    // days will be a String representation of 7 bits. Ex: "0101000" will represent Monday and Wednesday
    private String days;
    private LocalTime time;
    private BuildingNumbers location;

    public Course() {
        this.courseTitle = "";
        this.major = "";
        this.days = "";
        this.time = LocalTime.of(0, 0);
        this.location = BuildingNumbers.B101;
    }

    public Course(String courseTitle, String major, String days, LocalTime time, BuildingNumbers location) {
        this.courseTitle = courseTitle;
        this.major = major;
        this.days = days;
        this.time = time;
        this.location = location;
    }

    public static String[] getDaysArray() {
        return daysArray;
    }

    public static boolean isDaysValid(String days) {
        if (days.equals("") || days.length() != 7) {
            return false;
        }

        for (int i = 0; i < days.length(); i++) {
            if (days.charAt(i) != '0' && days.charAt(i) != '1') {
                return false;
            }
        }
        return true;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BuildingNumbers getLocation() {
        return location;
    }

    public void setLocation(BuildingNumbers location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseTitle.equals(course.courseTitle) && major.equals(course.major) && days.equals(course.days) && time.equals(course.time) && location == course.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseTitle, major, days, time, location);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Course{" +
                "courseTitle='" + courseTitle + '\'' +
                ", major='" + major + '\'' +
                ", days='" + this.getTranslatedDays() + '\'' +
                ", time=" + time +
                ", location=" + location +
                '}';
    }

    public String getTranslatedDays() {
        if (days.equals("0000000")) {
            return "No days were assigned";
        }
        String output = "";
        for (int i = 0; i < days.length(); i++) {
            if (days.charAt(i) == '1') {
                output += daysArray[i];
                output += ", "; // length 2
            }
        }
        output = output.substring(0, output.length() - 2);
        return output;
    }
}
