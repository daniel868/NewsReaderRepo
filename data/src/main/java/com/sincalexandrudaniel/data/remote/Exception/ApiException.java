package com.sincalexandrudaniel.data.remote.Exception;

public class ApiException extends RuntimeException {
    public final int httpCode;

    public ApiException(int httpCode) {
        super("Server returned http code: " + httpCode);
        this.httpCode = httpCode;
    }
}
