package nl.uva.bromance.QL.ast.nodes;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.expressions.Evaluable;

public class Input extends QLNode {
    private Evaluable expr;

    public Input(int ln, Evaluable expr) {
        super(ln);
        this.expr = expr;
    }
}
