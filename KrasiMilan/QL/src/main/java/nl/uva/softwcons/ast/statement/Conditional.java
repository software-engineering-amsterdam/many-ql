package nl.uva.softwcons.ast.statement;

import java.util.List;

import nl.uva.softwcons.ast.expression.Expression;

public class Conditional extends Statement {

    private Expression condition;
    private List<Question> questions;

    public Conditional(final Expression condition, final List<Question> questions) {
        this.condition = condition;
        this.questions = questions;
    }

}
