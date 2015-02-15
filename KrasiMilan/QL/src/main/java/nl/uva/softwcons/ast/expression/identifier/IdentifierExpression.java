package nl.uva.softwcons.ast.expression.identifier;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.eval.value.Value;

public class IdentifierExpression extends Expression {
    private String name;

    public IdentifierExpression(String name) {
        this.name = name;
    }

    @Override
    public Value evaluate() {
        // TODO Auto-generated method stub
        return null;
    }

}
