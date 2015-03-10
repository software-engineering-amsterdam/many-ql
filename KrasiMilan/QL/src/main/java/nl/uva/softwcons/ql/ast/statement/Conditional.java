package nl.uva.softwcons.ql.ast.statement;

import java.util.List;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;

public class Conditional extends Statement implements Computable {

    private Expression condition;
    private List<Question> questions;

    public Conditional(final Expression condition, final List<Question> questions) {
        this.condition = condition;
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public Expression getExpression() {
        return condition;
    }

    @Override
    public LineInfo getLineInfo() {
        return condition.getLineInfo();
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
