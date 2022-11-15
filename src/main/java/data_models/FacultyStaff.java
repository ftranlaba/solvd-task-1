public abstract class FacultyStaff extends Staff{
    private String bookUsed;

    public FacultyStaff() {
        super();
        this.bookUsed = "";
    }

    public FacultyStaff(String firstName, String lastName, String bookUsed) {
        super(firstName, lastName);
        this.bookUsed = bookUsed;
    }

    public String getBookUsed() {
        return bookUsed;
    }

    public void setBookUsed(String bookUsed) {
        this.bookUsed = bookUsed;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "FacultyStaff{" +
                "bookUsed='" + bookUsed + '\'' +
                '}';
    }
}