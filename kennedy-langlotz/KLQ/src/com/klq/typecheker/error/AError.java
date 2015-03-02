package com.klq.typecheker.error;

/**
 * Created by Juriaan on 1-3-2015.
 */
public abstract class AError {
    private int code;
    private Boolean stopRunning;
    private String location;
    private String errorMessage;

    public AError(int code, Boolean stopRunning, String errorMessage, String location) {
        this.code = code;
        this.stopRunning = stopRunning;
        this.location = location;
        this.errorMessage = errorMessage;
    }

    public String toString() {
        return String.format("Error code %d --- %s --- at %s", code, errorMessage, location);
    }

    public Boolean getStopRunning() {
        return stopRunning;
    }
}
