package model;

public class Room  implements IRoom{
    private String roomNumber;
    private double price;
    public Room(String roomNumber,double Price){
        this.price=Price;
        this.roomNumber=roomNumber;
    }
    @Override
    public String toString(){
        String temp= this.getRoomNumber().toString()+ this.getPrice();
        return (temp);
    }

    @Override
    public Boolean isFree() {
        return Boolean.TRUE;
    }

    @Override
    public RoomType getRoomType() {
        return null;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return null;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
