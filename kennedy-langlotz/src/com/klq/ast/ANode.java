package com.klq.ast;

import java.util.ArrayList;

/**
 * Created by juriaan on 9-2-15.
 */
public abstract class ANode {
    private String loc;

    public abstract void accept(IVisitor visitor);

    public void printSelf() {
    }
}
