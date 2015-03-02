package nl.uva.softwcons.validation.labels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.uva.softwcons.ast.form.Form;
import nl.uva.softwcons.ast.form.FormVisitor;
import nl.uva.softwcons.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ast.statement.Conditional;
import nl.uva.softwcons.ast.statement.Question;
import nl.uva.softwcons.ast.statement.StatementVisitor;
import nl.uva.softwcons.validation.Error;
import nl.uva.softwcons.validation.labels.error.DuplicateLabel;

public class LabelChecker implements FormVisitor<Void>, StatementVisitor<Void> {
    private final Set<String> labels;
    private final List<Error> errorsFound;

    public LabelChecker() {
        this.labels = new HashSet<>();
        this.errorsFound = new ArrayList<>();
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

    // TODO this should be part of some interface
    public List<Error> getErrors() {
        return this.errorsFound;
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
            this.errorsFound.add(new DuplicateLabel(question.getLineInfo()));
        } else {
            this.labels.add(questionLabel);
        }
    }

}
