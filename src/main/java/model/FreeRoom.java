package model;

/*
FreeRoom class extends the Room class, It inherits the Room's roomType and roomNumber attributes,
but sets its own rule for the price, i.e. it's set to 0.0
 */

public class FreeRoom extends Room {
    /*
   Constructor for this class. The 'super' keyword means that the class inherits the super class' attributes
   except the price has been set to 0.0
    */
    public FreeRoom(RoomType roomType, String roomNumber, double price)
    {
        super(roomType, roomNumber, 0.0);
    }

    @Override
    public String toString() {
        return "FreeRoom{}" + super.toString();
    }
}
