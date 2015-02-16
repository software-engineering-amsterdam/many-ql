package org.fugazi.ast.statement;

import org.fugazi.ast.expression.Expression;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.literal.ID;
import org.fugazi.ast.type.Type;

public class ComputedQuestionStatement extends QuestionStatement {

    private Expression computedExpression;

    public ComputedQuestionStatement(Type _type, String _label, ID _identifier, Expression _computedExpression) {
        super(_type, _label, _identifier);
        this.computedExpression = _computedExpression;
    }

    public Expression getComputedExpression() {
        return this.computedExpression;
    }

    @Override
    public String toString() {
        return this.type.toString() + this.identifier.toString() + " " + "('" + this.label + "') = " + this.computedExpression.toString();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitComputedQuestionStatement(this);
    }
}
