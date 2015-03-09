package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.common.Location;

/**
 * Created by Timon on 03.03.2015.
 */
public abstract class ANodeBase {
    private final Location location;

    public ANodeBase(Location location){
        this.location = location;
        print();
    }

    public abstract <T> T accept(IVisitor<T> visitor);

    public Location getLocation() {
        return location;
    }

    private void print(){
        System.out.println(
                String.format(
                        "%s <%d,%d><%d,%d>: %s",
                        location.getFile(),
                        location.getBeginLine(),
                        location.getBeginColumn(),
                        location.getEndLine(),
                        location.getEndColumn(),
                        this.getClass().getSimpleName()
                )
        );
    }
}
