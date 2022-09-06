package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;


import java.util.Collection;
import java.util.List;

public class AdminResource {
    private static AdminResource adminResource=null ;
    public Customer getCustomer(String email){
       return(CustomerService.getCustomer(email));
    }
    public  static void addRoom(List<IRoom> rooms){
        for(IRoom room:rooms) {
            ReservationService.addRoom(room);
        }

    }
    public static Collection<IRoom>getALLRooms(){
        return ReservationService.getALLRooms();
    }
    public static Collection<Customer>getALLCustomers(){
        return(CustomerService.getAllCustomers());
    }
    public  static void displayALLReservations(){
        ReservationService rs=new ReservationService();
        rs.print_AllReservations();
    }
}
