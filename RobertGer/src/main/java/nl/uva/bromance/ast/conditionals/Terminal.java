package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.visitors.QLNodeVisitor;

/**
 * Created by Robert on 9-3-2015.
 */
public class Terminal extends QLNode {

    private String value;

    public Terminal(int ln, String value) {
        super(ln);
        this.value = value;
    }

    public boolean isInteger() {
        return value.matches("[0-9]*");
    }

    public boolean isBoolean() {
        if (value.toLowerCase().equals("true") || value.toLowerCase().equals(("false"))){
            return true;
        }
        return false;
    }

    public boolean isString() {
        return value.matches("\".+\"");
    }

    public boolean isIdentifier() {
        return !isInteger() && !isString();
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(QLNodeVisitor visitor) {
        visitor.visit(this);
    }
}
