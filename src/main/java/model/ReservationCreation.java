package model;

import java.util.Date;

public class ReservationCreation {
    public Reservation create(Customer customer, IRoom room, Date checkIn, Date checkOut){
        return new Reservation(customer, room, checkIn, checkOut);
    }
}
