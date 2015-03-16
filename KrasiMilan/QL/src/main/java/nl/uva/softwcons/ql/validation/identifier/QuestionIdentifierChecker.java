package nl.uva.softwcons.ql.validation.identifier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;
import nl.uva.softwcons.ql.validation.Error;
import nl.uva.softwcons.ql.validation.identifier.error.DuplicateQuestionIdentifier;

public class QuestionIdentifierChecker implements FormVisitor<Void>, StatementVisitor<Void> {
    private final Set<Identifier> identifiers;
    private final List<Error> errorsFound;

    public QuestionIdentifierChecker() {
        this.identifiers = new HashSet<>();
        this.errorsFound = new ArrayList<>();
    }

    @Override
    public Void visit(final Form form) {
        form.getStatements().forEach(st -> st.accept(this));
        return null;
    }

    @Override
    public Void visit(final ComputedQuestion question) {
        validateQuestionIdentifier(question);
        return null;
    }

    @Override
    public Void visit(final Question question) {
        validateQuestionIdentifier(question);
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
     * Registers the given question's identifier for the current environment or
     * adds a {@link DuplicateQuestionIdentifier} error to the current errors
     * list in case the variable has already been defined.
     * 
     * @param question
     *            The question whose identifier should be defined in the current
     *            environment
     */
    private void validateQuestionIdentifier(final Question question) {
        final Identifier questionIdentifier = question.getId();
        if (this.identifiers.contains(questionIdentifier)) {
            this.errorsFound.add(new DuplicateQuestionIdentifier(question.getLineInfo()));
        } else {
            this.identifiers.add(questionIdentifier);
        }
    }

}
