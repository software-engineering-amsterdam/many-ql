package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.visitors.QlNodeVisitor;

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
    public void accept(QlNodeVisitor visitor) {
        visitor.visit(this);
    }
}
