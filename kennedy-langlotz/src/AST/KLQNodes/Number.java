package AST.KLQNodes;

import AST.Node;
import AST.Visitor;

/**
 * Created by juriaan on 17-2-15.
 */
public class Number extends Node {
    private double number;

    public Number(double number) {
        this.number = number;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getNumber() {
        return number;
    }
}
