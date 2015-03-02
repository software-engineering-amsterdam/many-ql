package com.klq.ast.impl.expr;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;

/**
 * Created by juriaan on 17-2-15.
 */
public class NumberNode extends ANode {
    private double number;

    public NumberNode(double number, String location) {
        super(location);
        this.number = number;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public double getNumber() {
        return number;
    }
}
