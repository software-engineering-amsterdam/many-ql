package nl.uva.softwcons.ql.validation.label;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;
import nl.uva.softwcons.ql.validation.Checker;
import nl.uva.softwcons.ql.validation.Error;
import nl.uva.softwcons.ql.validation.label.error.DuplicateLabel;

public final class LabelChecker extends Checker implements FormVisitor<List<Error>>, StatementVisitor<Void> {
    private final Set<String> labels;

    public static List<Error> check(final Form form) {
        return form.accept(new LabelChecker());
    }

    private LabelChecker() {
        this.labels = new HashSet<>();
    }

    @Override
    public List<Error> visit(final Form form) {
        form.getStatements().forEach(st -> st.accept(this));

        return this.getErrors();
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
