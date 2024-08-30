package org.example.Exceptions;

public class StaffAlreadyExistsException extends Exception{
    public StaffAlreadyExistsException(String message) {
        super(message);
    }
}