package enums;

public enum Algorithms {
    QUICKSORT("O(n^2)"),
    MERGESORT("O(n log(n))"),
    BUBBLESORT("O(n^2)");

    String worstCase;
    Algorithms(String s){
        worstCase = s;
    }

    public static void main(String[] args) {
        System.out.println("These are algorithms and their worst case");
        for (Algorithms o : Algorithms.values()) {
            System.out.println(o + " " + o.getRunTime());
        }
    }

    String getRunTime(){
        return worstCase;
    }

}
