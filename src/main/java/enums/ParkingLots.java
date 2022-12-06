package enums;

public enum ParkingLots {
    GENERAL(50),
    EMPLOYEE(75),
    RESERVED(100);

    private final int ticketFee;

    ParkingLots(int ticketFee) {
        this.ticketFee = ticketFee;
    }

    public static void main(String[] args) {
        System.out.println("These are the ticket fees");
        for (ParkingLots o : ParkingLots.values()) {
            System.out.println(o + " $" + o.getFee());
        }
    }

    int getFee() {
        return ticketFee * 2;
    }
}
