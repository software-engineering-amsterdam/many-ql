package nl.uva.softwcons.ql.validation.labels;

import java.util.HashSet;
import java.util.Set;

import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;
import nl.uva.softwcons.ql.validation.Checker;
import nl.uva.softwcons.ql.validation.labels.error.DuplicateLabel;

public class LabelChecker extends Checker implements FormVisitor<Void>, StatementVisitor<Void> {
    private final Set<String> labels;

    public LabelChecker() {
        this.labels = new HashSet<>();
    }

    @Override
    public Void visit(final Form form) {
        form.getStatements().forEach(st -> st.accept(this));
        return null;
    }

    @Override
    public Void visit(final ComputedQuestion question) {
        validateQuestionLabel(question);
        return null;
    }

    @Override
    public Void visit(final Question question) {
        validateQuestionLabel(question);
        return null;
    }

    @Override
    public Void visit(final Conditional conditional) {
        conditional.getQuestions().forEach(q -> q.accept(this));
        return null;
    }

    /**
     * Registers the given question's label for the current environment or adds
     * a {@link DuplicateLabel} error to the current errors list in case the
     * variable has already been defined.
     * 
     * @param question
     *            The question whose label should be defined in the current
     *            environment
     */
    private void validateQuestionLabel(final Question question) {
        final String questionLabel = question.getLabel();
        if (this.labels.contains(questionLabel)) {
            this.addError(new DuplicateLabel(question.getLineInfo()));
        } else {
            this.labels.add(questionLabel);
        }
    }

}
