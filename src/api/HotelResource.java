package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.ReservationService;
import service.CustomerService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    private static HotelResource hotelResource=null ;
    public static Customer GetCustomer(String email){
       return(CustomerService.getCustomer(email));


    }
    public void CreateCustomer(String email,String firstName,String lastName){
        CustomerService.addCustomer(email,firstName,lastName);
    }
    public static IRoom getRoom(String roomNumber){
        return(ReservationService.getARoom(roomNumber));

    }
    public  static Reservation bookARoom(String customerEmail, IRoom room,Date CheckInDate,Date CheckOutDate){
        Customer customer=GetCustomer(customerEmail);
        ReservationService rs=new ReservationService();
        return(rs.reserveARoom(customer,room,CheckInDate,CheckOutDate));

    }
    public Collection<Reservation>getCustomerReservations(String customerEmail){
        Customer customer=this.GetCustomer(customerEmail);
        ReservationService rs=new ReservationService();
        return(rs.getCustomersReservation(customer));
    }
    public static Collection<IRoom>findARoom(Date CheckInDate,Date CheckOutDate){
        ReservationService rs=new ReservationService();
         return (rs.findRooms(CheckInDate,CheckOutDate));

    }
    public static Collection<Reservation>getAllReservations(){
        ReservationService rs=new ReservationService();
        return(rs.getALLResevations());
    }


}
