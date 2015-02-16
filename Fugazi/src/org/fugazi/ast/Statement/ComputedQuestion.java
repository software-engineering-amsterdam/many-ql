package org.fugazi.ast.statement;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.literal.ID;
import org.fugazi.ast.type.Type;

public class ComputedQuestion extends Question {

    private final Expression computed;

    public ComputedQuestion(Type _type, String _label, ID _identifier, Expression _computed) {
        super(_type, _label, _identifier);
        this.computed = _computed;
    }

    public Expression getComputedExpression() {
        return this.computed;
    }

    @Override
    public String toString() {
        return this.type.toString() + this.identifier.toString() + " " + "('" + this.label + "') = " + this.computed.toString();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitComputedQuestion(this);
    }
}
