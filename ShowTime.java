package model;

import java.util.List;

public class ShowTime {

    private model.Movie movie;
    private String time;
    private List<model.Seat> seats;

    public ShowTime(model.Movie movie, String time, List<model.Seat> seats) {
        this.movie = movie;
        this.time = time;
        this.seats = seats;
    }

    public List<model.Seat> getSeats() {
        return seats;
    }

    public model.Movie getMovie() {
        return movie;
    }
}