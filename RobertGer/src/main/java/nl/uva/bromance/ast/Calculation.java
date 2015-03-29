package nl.uva.bromance.ast;

import nl.uva.bromance.ast.conditionals.*;
import nl.uva.bromance.ast.visitors.QLNodeVisitor;


public class Calculation extends QLNode implements ContainsExpression, HasIdentifier {
    private Identifier identifier;
    private IntResult result;
    private Expression expression;

    public Calculation(int lineNumber, Identifier id) {
        super(lineNumber);
        this.identifier = id;
        this.identifier.setResult(new IntResult(0));
    }

    public IntResult getResult(){
        return result;
    }

    //TODO: Find fix for childType
    @Override
    public void accept(QLNodeVisitor visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

    @Override
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void handleExpressionResult() {
        result = (IntResult) expression.getResult();
        identifier.setResult(result);
    }

    @Override
    public Identifier getIdentifier() {
        return identifier;
    }
}