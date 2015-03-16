package com.klq.ast.impl;

/**
 * Created by juriaan on 9-2-15.
 */
public abstract class ANode {
    private Location location;

    public ANode(){
        this(null);
    }

    public ANode(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
