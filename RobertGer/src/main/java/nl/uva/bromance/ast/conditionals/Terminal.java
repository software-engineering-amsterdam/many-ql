package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.visitors.QLNodeVisitor;

/**
 * Created by Robert on 9-3-2015.
 */
public class Terminal extends QLNode {

    private String value;
    private Result result;

    public Terminal(int ln, String value) {
        super(ln);
        this.value = value;

        setResult();
    }

    private void setResult() {
        if (isBoolean()) {
            if (value.toLowerCase().equals("false")) {
                result = new BooleanResult(false);
            } else {
                result = new BooleanResult(true);
            }
        } else if (isInteger()) {
            result = new IntResult(Integer.parseInt(value));
        } else if (isString()) {
            result = new StringResult(value);
        } else {
            result = null;
        }

    }

    public Result getResult() {
        return result;
    }

    public boolean isInteger() {
        return value.matches("[0-9]*");
    }

    public boolean isBoolean() {
        if (value.toLowerCase().equals("true") || value.toLowerCase().equals(("false"))) {
            return true;
        }
        return false;
    }

    public boolean isString() {
        return value.matches("\".+\"");
    }

    public boolean isIdentifier() {
        return !isBoolean() && !isInteger() && !isString();
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(QLNodeVisitor visitor) {
        visitor.visit(this);
    }
}
