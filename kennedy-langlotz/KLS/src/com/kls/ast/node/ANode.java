package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.kls.ast.Location;

/**
 * Created by Timon on 03.03.2015.
 */
public abstract class ANode {
    private final Location location;

    public ANode(Location location){
        this.location = location;
    }

    public abstract <T> T accept(IVisitor<T> visitor);

    public Location getLocation() {
        return location;
    }
}
