package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {

    //private field that refers to the object
    private static ReservationService reservationObject = new ReservationService();

    //constructor for the Singleton Class
    private ReservationService(){};

    //Method that allows us to create only one object
    //and access the object as needed

    public static ReservationService getReservation(){
        return reservationObject;
    }

    //Collections to store, retrieve and process data
    private Map<String, IRoom> rooms = new HashMap<String, IRoom>();
    private Map<String, Collection<Reservation>> hotelReservations = new HashMap<String, Collection<Reservation>>();

    //Adding a room to an IRoom HashMap
    public void addRoom (IRoom room){
        rooms.put(room.getRoomNumber(), room);
    }

    //Retrieving a room from an IRoom HashMap
    public IRoom getARoom(IRoom roomId){
        return rooms.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room,
                                    Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation (customer, room, checkInDate, checkOutDate);
        Collection<Reservation> customerReservation = this.getCustomersReservation(customer);
        customerReservation.add(reservation);
        hotelReservations.put(customer.getEmail(), customerReservation);
        return reservation;
    }

//    public  Collection<IRoom> findRooms(Date checkIn, Date checkOut){
        public  void findRooms(Date checkIn, Date checkOut){
//        Collection<Reservation> allReservations = new LinkedList<>();

            for (Map.Entry<String, Collection<Reservation>> entry : this.hotelReservations.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
//        return
    }

    private Collection<Reservation> getCustomersReservation(Customer customer) {
        return hotelReservations.get(customer.getEmail());
    }


}
