package model;

import java.util.Date;

public class Reservation {
    private static  Customer customer;
    private static IRoom room;
    private static Date checkInDate;
    private static Date checkOutDate;
    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        this.setCustomer(customer);
        this.setRoom(room);
        this.setCheckOutDate(checkOutDate);
        this.setCheckInDate(checkInDate);
    }
    @Override
    public String toString()
    {
        return ("name:"+ getCustomer().getFirstName() +" "+ getCustomer().getLastName() +" "+"room"+ getRoom() +"check IN"+ getCheckInDate().toString()+" "+"check out"+" "+ getCheckOutDate().toString());
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public  static IRoom getRoom() {
        return room;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public static Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public static Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
