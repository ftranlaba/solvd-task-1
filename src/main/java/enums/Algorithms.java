package enums;

public enum Algorithms {
    QUICKSORT("O(n^2)"),
    MERGESORT("O(n log(n))"),
    BUBBLESORT("O(n^2)");

    private final String worstCase;

    Algorithms(String s) {
        worstCase = s;
    }

    public String getRunTime() {
        return worstCase;
    }

}
