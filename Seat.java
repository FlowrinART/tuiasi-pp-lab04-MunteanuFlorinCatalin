package model;

public class Seat {

    private int seatNumber;
    private boolean reserved;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.reserved = false;
    }

    public boolean reserve() {
        if (!reserved) {
            reserved = true;
            return true;
        }
        return false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}