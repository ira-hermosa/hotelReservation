package model;

/*
We need an interface that 'connects' the different classes pertaining to the Room object.
As this is an interface, the methods are declared but not defined. Actual implementation of these methods
is provided by the Room class which implements this interface
 */

/*
An interface can't have a constructor as it can't be instantiated on its own.
 */

public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomType getRoomType();
    public boolean isFree();
}
