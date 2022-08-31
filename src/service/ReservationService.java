package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ReservationService {
    static List<Reservation> reservations = new LinkedList<Reservation>();
    static List<IRoom> rooms = new LinkedList<IRoom>();

    private static ReservationService reservationService=null ;
    public static Collection<IRoom>getALLRooms()
    {
        return rooms;
    }
    public static Collection<Reservation>getALLResevations() {
        return(reservations);
    }


    public  static void addRoom(IRoom room){
        rooms.add(room);

    }
    public static IRoom getARoom(String roomId)
    {
        for (Reservation reserv:reservations)
        {
            if (roomId==reserv.getRoom().getRoomNumber()) {
                return (reserv.getRoom());
            }
            }
        return null;
    }



    public static Reservation reserveARoom(Customer customer, IRoom room, Date CheckInDate, Date CheckOutDate){

        Reservation rs=new Reservation(customer,room,CheckInDate,CheckOutDate);
        reservations.add(rs);
        return rs;

    }
    public static Collection<IRoom>findRooms(Date CheckInDate,Date CheckOutDate){
        List<IRoom> roomstemp = new LinkedList<IRoom>();
        for(Reservation R:reservations) {
            if((R.getCheckInDate()==CheckInDate) && (R.getCheckOutDate()==CheckOutDate)){
                roomstemp.add(R.getRoom());
            }
        }
        return roomstemp;
        }

    public static Collection<Reservation>getCustomersReservation(Customer customer){
        List<Reservation> customerReservations = new LinkedList<Reservation>();
        for ( Reservation cust : reservations){
            if (customer==cust.getCustomer())
            {
                customerReservations.add(cust);
            }

        }
        return customerReservations;

    }
    public static void print_AllReservations()
    {
         for (Reservation resev:reservations) {
             System.out.println(resev);
         }
    }

}
