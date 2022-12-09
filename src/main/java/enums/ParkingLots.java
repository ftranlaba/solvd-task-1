package enums;

public enum ParkingLots {
    GENERAL(50),
    EMPLOYEE(75),
    RESERVED(100);

    private final int ticketFee;

    ParkingLots(int ticketFee) {
        this.ticketFee = ticketFee;
    }

    public int getFee() {
        return ticketFee * 2;
    }
}
