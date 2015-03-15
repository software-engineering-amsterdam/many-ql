package org.fugazi.ql.ast.statement;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.type.Type;

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
        return this.getType().toString() + this.getIdName() + " " + "('" + this.getLabel() + "') = " + this.computed.toString();
    }

    public <T> T accept(IStatementVisitor<T> visitor) {
        return visitor.visitComputedQuestion(this);
    }
}
