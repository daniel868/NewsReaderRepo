package com.sincalexandrudaniel.data.remote.Exception;

public class ConnectivityException extends RuntimeException {
    public ConnectivityException(String message) {
        super("Server was not reached: " + message);
    }
}
