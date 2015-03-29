package nl.uva.bromance.ast;

import nl.uva.bromance.ast.conditionals.ContainsExpression;
import nl.uva.bromance.ast.conditionals.Expression;
import nl.uva.bromance.ast.conditionals.HasIdentifier;
import nl.uva.bromance.ast.conditionals.IntResult;
import nl.uva.bromance.ast.visitors.QLNodeVisitor;


public class Calculation extends QLNode implements ContainsExpression, HasIdentifier {
    private String identifier;
    private IntResult result;
    private Expression expression;

    public Calculation(int lineNumber, String id) {
        super(lineNumber);
        id = id.substring(1, id.length() - 1);
        this.identifier = id;
    }

    public IntResult getResult() {
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
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }
}