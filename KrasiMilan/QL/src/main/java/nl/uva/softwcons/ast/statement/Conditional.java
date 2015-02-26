package nl.uva.softwcons.ast.statement;

import java.util.List;

import nl.uva.softwcons.ast.expression.Expression;

public class Conditional extends Statement {

    private Expression condition;
    private List<Question> questions;
    private String id;

    public Conditional(final Expression condition, final List<Question> questions) {
        this.condition = condition;
        this.questions = questions;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getId() {
        return this.id;
    }
}
