package nl.uva.softwcons.ql.ast.statement;

import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.type.Type;

public class ComputedQuestion extends Question implements Computable {
    private final Expression expression;

    public ComputedQuestion(final Identifier id, final String label, final Type type, final Expression value) {
        super(id, label, type);

        this.expression = value;
    }

    @Override
    public Expression getExpression() {
        return expression;
    }

    @Override
    public <T> T accept(final StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
