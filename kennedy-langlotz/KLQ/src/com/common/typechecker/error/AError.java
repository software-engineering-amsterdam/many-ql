package com.common.typechecker.error;

import com.common.ast.Location;

/**
 * Created by Juriaan on 1-3-2015.
 */
public abstract class AError {
    private int code;
    private Boolean stopRunning;
    private Location location;
    private String errorMessage;

    public AError(int code, Boolean stopRunning, String errorMessage, Location location) {
        this.code = code;
        this.stopRunning = stopRunning;
        this.location = location;
        this.errorMessage = errorMessage;
    }

    public String toString() {
        return String.format("Error code %d --- %s --- at %s", code, errorMessage, location.getBeginLine());
    }

    public Boolean getStopRunning() {
        return stopRunning;
    }
}
