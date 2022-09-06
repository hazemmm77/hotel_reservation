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
        for (IRoom room:rooms)
        {
            if (room.getRoomNumber().equals(roomId)) {
                return (room);
            }
            }
        return null;
    }



    public static Reservation reserveARoom(Customer customer, IRoom room, Date CheckInDate, Date CheckOutDate){

            if (isRoomAvailable(CheckInDate, CheckOutDate, room)) {
                Reservation rs=new Reservation(customer,room,CheckInDate,CheckOutDate);
                reservations.add(rs);
                return rs;
            }

        System.out.println("this room not availbale");
        return null;




    }
    public static Collection<IRoom>findRooms(Date CheckInDate,Date CheckOutDate){
        Collection<IRoom> openRooms = new LinkedList<>();
        if (reservations.isEmpty()) {
            return rooms; //no reservation has been made. all rooms are
            //free
        }
        for (IRoom room : rooms) {
            if (isRoomAvailable(CheckInDate, CheckOutDate, room)) {
                openRooms.add(room);
            }
        }
        return openRooms;
    }
    public static boolean isRoomAvailable(Date start, Date end, IRoom room) {
        for (Reservation reservation : reservations) {
            IRoom currentRoom = reservation.getRoom();
            //if room has been reserved, check if room will be free by
            //start and end date
            if (room.getRoomNumber().equals(currentRoom.getRoomNumber())) {
                if (isDateConflictingWithReservation(start, end, reservation)) {
                    return false;
                }
            }

        }
        return true;
    }
    static boolean isDateConflictingWithReservation(Date start, Date end, Reservation reservation) {
        return !(end.before(reservation.getCheckInDate()) || start.after(reservation.getCheckOutDate()));
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
