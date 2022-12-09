package enums;

public enum ClassLevels {
    FRESHMAN,
    SOPHOMORE,
    JUNIOR,
    SENIOR;

    ClassLevels() {
    }

    public boolean canTakeCSElectives(ClassLevels o) {
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
