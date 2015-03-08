package nl.uva.softwcons.ql.ast.statement;

import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.type.Type;

public class ComputedQuestion extends Question {
    private Expression expression;

    public ComputedQuestion(final Identifier id, final String label, final Type type, final Expression value) {
        super(id, label, type);

        this.expression = value;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
