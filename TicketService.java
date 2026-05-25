package service;

import model.Seat;
import model.ShowTime;
import model.Ticket;
import payment.PaymentMethod;

public class TicketService {

    public Ticket buyTicket(Seat seat, ShowTime showTime, double price, PaymentMethod paymentMethod) {

        if (!seat.reserve()) {
            System.out.println("Seat already reserved");
            return null;
        }

        if (!paymentMethod.pay(price)) {
            System.out.println("Payment failed");
            return null;
        }

        return new Ticket(seat, showTime, price);
    }
}