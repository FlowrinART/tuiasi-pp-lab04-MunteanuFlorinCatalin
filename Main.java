import model.*;
import model.Movie;
import model.Seat;
import model.ShowTime;
import payment.*;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        Movie movie = new Movie("Avatar", 180);

        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat(1));
        seats.add(new Seat(2));

        ShowTime showTime = new ShowTime(movie, "18:00", seats);

        BankAccount account = new BankAccount(100);

        PaymentMethod payment = new CardPayment(account);

        TicketService ticketService = new TicketService();

        Ticket ticket = ticketService.buyTicket(seats.get(0), showTime, 30, payment);

        if (ticket != null) {
            System.out.println("Ticket purchased for seat " + ticket.getSeat().getSeatNumber());
        }
    }
}