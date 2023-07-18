package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class AdminResource {
    private CustomerService customerService;
    private ReservationService reservationService;

    public AdminResource(CustomerService customerService, ReservationService reservationService) {
        this.customerService = customerService;
        this.reservationService = reservationService;
    }

    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms){
        for (IRoom newRoom: rooms){
            reservationService.addRoom(newRoom);
        }
    }

    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    public Set<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }

}
