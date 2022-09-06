package model;

public class Room  implements IRoom{
    private String roomNumber;
    private double price;
    private RoomType r;
    public Room(String roomNumber,double Price,RoomType r){
        this.price=Price;
        this.roomNumber=roomNumber;
        this.r=r;
    }
    @Override
    public String toString(){
        String temp= "roomNumber "+ ""+this.getRoomNumber().toString()+"the price "+" "+this.getPrice()+" "+"Room type "+" "+this.getRoomType().toString();
        return (temp);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
        { return true; }
        if (obj == null || obj.getClass() != this.getClass())
        { return false; }
        if (this.getRoomNumber()==((Room) obj).getRoomNumber())
        { return true;}
        else
        {return false;}





    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getRoomNumber().hashCode();

        return result;
    }


    @Override
    public Boolean isFree() {
        return Boolean.TRUE;
    }

    @Override
    public RoomType getRoomType() {
        return this.r;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String getRoomNumber() {
        return this.roomNumber;
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
