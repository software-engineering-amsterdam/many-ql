package com.klq.ast;

import java.util.ArrayList;

/**
 * Created by juriaan on 9-2-15.
 */
public abstract class ANode {
    private String loc;

    public ANode(String loc) {
        this.loc = loc;
    }

    public abstract <T> T  accept(IVisitor<T> visitor);

    public void printSelf() {
    }

    public String getLoc() {
        return loc;
    }
}
