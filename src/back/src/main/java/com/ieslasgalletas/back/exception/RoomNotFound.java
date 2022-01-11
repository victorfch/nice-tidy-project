package com.ieslasgalletas.back.exception;

public class RoomNotFound extends RuntimeException{
    public RoomNotFound() {
        super("Room not found");
    }

}