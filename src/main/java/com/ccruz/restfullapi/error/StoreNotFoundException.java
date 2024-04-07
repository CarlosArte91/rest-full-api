package com.ccruz.restfullapi.error;

public class StoreNotFoundException extends Exception {
    public StoreNotFoundException(String message) {
        super(message);
    }
}
