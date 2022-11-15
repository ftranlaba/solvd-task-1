public class Gardener extends CleaningStaff{
    private int totalFlowersTended;

    public Gardener() {
        super();
        this.totalFlowersTended = 0;
    }
    @Override
    public void doWork(){
        System.out.println("Gardener is tending to flowers");
    }

    public Gardener(String firstName, String lastName, double salary, int hours, String tool, int totalFlowersTended) {
        super(firstName, lastName, salary, hours, tool);
        this.totalFlowersTended = totalFlowersTended;
    }

    public int getTotalFlowersTended() {
        return totalFlowersTended;
    }

    public void setTotalFlowersTended(int totalFlowersTended) {
        this.totalFlowersTended = totalFlowersTended;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Gardener{" +
                "totalFlowersTended=" + totalFlowersTended +
                '}';
    }
}