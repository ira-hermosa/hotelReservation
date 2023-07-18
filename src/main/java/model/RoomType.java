package model;
/*
We use an enum for the room type because it can only contain a fixed set of constants, i.e.
single & double.
By using an enum, the compiler will catch any errors if a user tries to use other values than
those fixed constants.
 */
public enum RoomType {
    SINGLE,
    DOUBLE
}
