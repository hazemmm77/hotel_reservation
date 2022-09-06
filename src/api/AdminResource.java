package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;


import java.util.Collection;
import java.util.List;

public class AdminResource {
    private static AdminResource adminResource=null ;
    public static AdminResource getInstance()
    {
        if (adminResource == null)
            adminResource = new AdminResource();

        return adminResource;
    }
    public Customer getCustomer(String email){
       return(CustomerService.getCustomer(email));
    }
    public  void addRoom(List<IRoom> rooms){
        for(IRoom room:rooms) {
            ReservationService rs=ReservationService.getInstance();
            rs.addRoom(room);
        }

    }
    public static Collection<IRoom>getALLRooms(){
        ReservationService rs=ReservationService.getInstance();
        return rs.getALLRooms();
    }
    public static Collection<Customer>getALLCustomers(){
        return(CustomerService.getAllCustomers());
    }
    public  static void displayALLReservations(){
        ReservationService rs=ReservationService.getInstance();
        rs.print_AllReservations();
    }
}
