package com.klq.ast.impl.expr;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;

/**
 * Created by juriaan on 17-2-15.
 */
public class NumberNode extends ANode {
    private double number;

    public NumberNode(double number) {
        this.number = number;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public double getNumber() {
        return number;
    }
}
