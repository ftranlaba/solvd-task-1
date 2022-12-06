package enums;

public enum AllowedMaterials {
    PENCIL(true),
    PEN(false),
    LAPTOP(false),
    PAPER(true),
    NOTES(true);

    private final boolean isAllowed;

    AllowedMaterials(boolean isAllowed) {
        this.isAllowed = isAllowed;
    }

    public static void main(String[] args) {
        System.out.println("These are the rules for the materials on exam day");
        for (AllowedMaterials o : AllowedMaterials.values()) {
            System.out.println(o + " " + o.isAllowed());
        }
    }

    public boolean isAllowed() {
        return isAllowed;
    }
}
