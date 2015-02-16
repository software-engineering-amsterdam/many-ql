package nl.uva.softwcons.ast.expression.identifier;

import nl.uva.softwcons.ast.expression.Expression;

public class IdentifierExpression extends Expression {
    private String name;

    public IdentifierExpression(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
