package nl.uva.bromance.ast.conditionals;

/**
 * Created by Robert on 9-3-2015.
 */
public class Terminal {

    private String value;

    public Terminal(String value) {
        this.value = value;
    }

    public boolean isInteger() {
        return value.matches("[0-9]*");
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
}
