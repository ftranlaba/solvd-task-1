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

    public boolean isAllowed() {
        return isAllowed;
    }
}
