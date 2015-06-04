package nl.uva.bromance.QL.expressions.unary;

import nl.uva.bromance.QL.ast.QLNode;

public class Variable extends QLNode implements UnaryExpression {

    public String identifier;

    public Variable(String identifier, int ln) {
        super(ln);
        this.identifier = identifier;
    }

    @Override
    public Primitive evaluate() {
        return null; //TODO: Look up the identifier of this variabel in the identifier map.
    }
}
