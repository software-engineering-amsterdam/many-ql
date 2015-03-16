package com.klq.ast;

/**
 * Created by juriaan on 9-2-15.
 */
public abstract class ANode {
    private Location location;

    public ANode(){
        this.location = null;
    }

    public ANode(Location location) {
        this.location = location;
    }

    public void printSelf() {
    }

    public Location getLocation() {
        return location;
    }
}
