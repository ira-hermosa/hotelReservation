package model;

public class Room implements IRoom{

    //RoomType comes from the RoomType enumeration
    private RoomType RoomType;

    private ChargingType chargingType;
    private String roomNumber;
    private double price;

    //Constructor of this class
    public Room(model.RoomType roomType, String roomNumber, double price, ChargingType chargingType) {
        this.RoomType = roomType;
        this.roomNumber = roomNumber;
        this.chargingType = chargingType;
        if (chargingType == ChargingType.FREE) {
            this.price = 0;
        }
        else {
            this.price = price;
        }
    }

    public ChargingType getChargingType() {
        return chargingType;
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
        return chargingType == ChargingType.FREE;
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
