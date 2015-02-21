package parser.ast.nodes.expression;

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
}
