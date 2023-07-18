package model;

public class Room implements IRoom{

    //RoomType comes from the RoomType enumeration
    private RoomType RoomType;
    private String roomNumber;
    private double price;

    //Constructor of this class
    public Room(model.RoomType roomType, String roomNumber, double price) {
        this.RoomType = roomType;
        this.roomNumber = roomNumber;
        this.price = price;
    }

    /*
    As this class implements IRoom interface,the methods should override the methods in the interface.
     */
    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public model.RoomType getRoomType() {
        return RoomType;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    /*
    Override the toString() for better description
     */
    @Override
    public String toString() {
        return "Room{" +
                "RoomType=" + RoomType +
                ", roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                '}';
    }
}
