package nl.uva.softwcons.ast.statement;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.type.Type;

public class ComputedQuestion extends Question {

    private Expression expression;

    public ComputedQuestion(final String id, final String label, final Type type, final Expression value) {
        super(id, label, type);

        this.expression = value;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getExpression() {
        return expression;
    }

}
