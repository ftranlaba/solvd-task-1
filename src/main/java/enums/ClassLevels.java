package enums;

public enum ClassLevels {
    FRESHMAN,
    SOPHOMORE,
    JUNIOR,
    SENIOR;

    ClassLevels() {
    }

    public static void main(String[] args) {
        System.out.println("These are the class levels that are able to take CS electives");
        for (ClassLevels o : ClassLevels.values()) {
            System.out.println(o + " " + o.canTakeCSElectives(o));
        }
    }

    boolean canTakeCSElectives(ClassLevels o) {
        switch (o) {
            case FRESHMAN:
            case SOPHOMORE:
                return false;
            case JUNIOR:
            case SENIOR:
                return true;
        }
        return false;
    }
}
