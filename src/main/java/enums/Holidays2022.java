package enums;

public enum Holidays2022 {
    LABORDAY("09-05-2022"),
    COLUMBUSDAY("10-10-2022"),
    THANKSGIVINGDAY("11-24-2022"),
    CHRISTMASDAY("12-25-2022"),
    NEWYEARS("12-31-2022");

    String date;

    Holidays2022(String s) {
        date = s;
    }

    public static void main(String[] args) {
        System.out.println("These are the days where school is closed");
        for (Holidays2022 o : Holidays2022.values()) {
            System.out.println(o + " " + o.getDate());
        }
    }

    String getDate() {
        return date;
    }
}