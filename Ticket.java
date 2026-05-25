package model;
import java.util.*;
public class Ticket {

    private model.Seat seat;
    private model.ShowTime showTime;
    private double price;

    public Ticket(model.Seat seat, model.ShowTime showTime, double price) {
        this.seat = seat;
        this.showTime = showTime;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public model.Seat getSeat() {
        return seat;
    }
}