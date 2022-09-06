package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ReservationService {
     static  List<Reservation> reservations = new LinkedList<Reservation>();
      static List<IRoom> rooms = new LinkedList<IRoom>();

    private static ReservationService reservationService=null ;
    public static Collection<IRoom>getALLRooms()
    {
        return rooms;
    }
    public  Collection<Reservation>getALLResevations() {
        return(getReservations());
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



    public  Reservation reserveARoom(Customer customer, IRoom room, Date CheckInDate, Date CheckOutDate){

            if (isRoomAvailable(CheckInDate, CheckOutDate, room)) {
                Reservation rs=new Reservation(customer,room,CheckInDate,CheckOutDate);
                getReservations().add(rs);
                return rs;
            }

        System.out.println("this room not availbale");
        return null;




    }
    public  Collection<IRoom>findRooms(Date CheckInDate,Date CheckOutDate){
        Collection<IRoom> openRooms = new LinkedList<>();
        if (getReservations().isEmpty()) {
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
    public  boolean isRoomAvailable(Date start, Date end, IRoom room) {
        for (Reservation reservation : getReservations()) {
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
     boolean isDateConflictingWithReservation(Date start, Date end, Reservation reservation) {
        return !(end.before(reservation.getCheckInDate()) || start.after(reservation.getCheckOutDate()));
    }



        public  Collection<Reservation>getCustomersReservation(Customer customer){
        List<Reservation> customerReservations = new LinkedList<Reservation>();
        for ( Reservation cust : getReservations()){
            if (customer==cust.getCustomer())
            {
                customerReservations.add(cust);
            }

        }
        return customerReservations;

    }
    public  void print_AllReservations()
    {
         for (Reservation resev: getReservations()) {
             System.out.println(resev);
         }
    }

    public   List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
