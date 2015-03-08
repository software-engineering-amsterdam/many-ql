package nl.uva.softwcons.ql.ast.statement;

import java.util.List;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;

public class Conditional extends Statement {

    private Expression condition;
    private List<Question> questions;
    private Identifier id; // TODO remove me once we decide how to store
                           // conditions

    public Conditional(final Expression condition, final List<Question> questions) {
        this.condition = condition;
        this.questions = questions;
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Identifier getId() {
        return this.id;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public LineInfo getLineInfo() {
        return condition.getLineInfo();
    }
}
