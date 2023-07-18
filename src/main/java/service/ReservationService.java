package service;

/*
This class contains stateful services, i.e. each request depends on the previous requests,
as we need to keep track of user-specific data. Data will be stored in Collections.

To ensure the services are stateful, we'll be using Singleton objects, i.e. there is only going to be
one instance of this class created and that this instance is accessible by all parts of the application
*/

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.ReservationCreation;
import java.util.*;


public class ReservationService {
    //CREATE A SINGLETON OBJECT
    /*Create a private constructor to prevent
    other classes from creating instances of this Singleton class
    */
    private ReservationService(ReservationCreation reservationCreation) {
        this.reservationCreation = reservationCreation;
        this.rooms=new HashMap<>();
        this.reservations=new HashSet<>();
    }

    /*Create a private static instance variable which
    will hold the single instance of this Singleton class
    */
    public static ReservationService instance;

    /*Create a public static method to access the instance variable.
    This method will create the Singleton object if it doesn't exist and return the instance variable
    */
    public static ReservationService getInstance(ReservationCreation reservationCreation){
        if (instance == null){
            instance = new ReservationService(reservationCreation);
        } return instance;
    }


    //CREATE COLLECTIONS TO STORE DATA
    private Map<String, IRoom> rooms = new HashMap<>();
    private Set<Reservation> reservations = new HashSet<>();
    private ReservationCreation reservationCreation;


    //METHODS


    /*
    Method to add a room to the 'rooms' HashMap collection, passing in room object of IRoom type - which means
    the object has 'roomNumber', 'roomType', 'roomPrice' and whether it's free/not.
    Check: if any of the rooms in the rooms collection has the same room number, throw illegal argument,
    otherwise, add the new room to rooms collection.
    Additional notes: HashMap built-in methods: put(), get(), remove(), containsKey(), containsValue()
     */
    public void addRoom(IRoom room){
        if (rooms.containsKey(room.getRoomNumber())){
            throw new IllegalArgumentException("Room number " + room.getRoomNumber()+ " " + "already exists");
        } else{
            rooms.put(room.getRoomNumber(), room);
        }
    }

    /*
    Method to retrieve a room from the rooms collection by passing in roomId parameter.
    If any of the rooms' Id matches the parameter, then returns the room, otherwise, throw an illegal argument
    indicating there isn't such a room
     */

    public IRoom getARoom(String roomId){
        if(rooms.containsKey(roomId)){
            return rooms.get(roomId);
        } else{
            throw new IllegalArgumentException("There is no room with number " + roomId);
        }
    }
    /*
    Method to create a new reservation by passing in customer, room, check in date and check out date objects.
    Firstly, create a new variable (called newReservation) to contain the new reservation and call the create method of
    ReservationCreation class - Not sure why i got prompted to create a new class?
    If any of the reservations contains all the details of the new reservation, throw an illegal argument exception
    Otherwise, add the new reservation to the reservations collection.
    */
    public Reservation reserveARoom (Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation newReservation = reservationCreation.create(customer, room, checkInDate, checkOutDate);
        if (reservations. contains(newReservation)){
            throw new IllegalArgumentException("This room is reserved for these days");
        } else{
            reservations.add(newReservation);
        } return newReservation;
    }

    /*
    Method to retrieve a reservation by passing in a customer object (comprising first name, last name and email).
    Then go through each reservation in reservations collection and check if it matches the
    customer attributes being passed in. If so, add it to the collections
     */
    public Collection<Reservation> getCustomerReservation (Customer customer){
        for (Reservation aReservation: reservations){
            if (aReservation.getCustomer().equals(customer)){
                reservations.add(aReservation);
            }
        } return reservations;
    }

    public Set<Reservation> getAllReservations(){
        return reservations;
    }

    public Map<String, IRoom> getRooms(){
        return rooms;
    }


}
