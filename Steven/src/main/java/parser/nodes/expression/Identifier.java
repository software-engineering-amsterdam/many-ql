package parser.nodes.expression;

import typeChecker.Visitor;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Identifier extends Expression {
    private final String identifier;

    public Identifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
