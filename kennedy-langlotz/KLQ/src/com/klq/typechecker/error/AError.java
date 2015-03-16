package com.klq.typechecker.error;

import com.klq.ast.Location;

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
        String beginLine;
        if(location == null){
            beginLine = "line unknown";
        }
        else{
            beginLine = String.valueOf(location.getBeginLine());
        }
        return String.format("Error code %d --- %s --- at %s", code, errorMessage, beginLine);
    }

    public Boolean getStopRunning() {
        return stopRunning;
    }
}
