package nl.uva.softwcons.ql.validation.dependency;

import java.util.ArrayList;
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
import nl.uva.softwcons.ql.validation.VariableExctractor;
import nl.uva.softwcons.ql.validation.dependency.error.CyclicQuestionsDependency;

public class CyclicDependencyChecker implements FormVisitor<Void>, StatementVisitor<Void> {

    private final List<Error> errorsFound;

    public CyclicDependencyChecker() {
        this.errorsFound = new ArrayList<>();
    }

    @Override
    public Void visit(final Form form) {
        form.getStatements().forEach(st -> st.accept(this));
        return null;
    }

    @Override
    public Void visit(final ComputedQuestion question) {
        final Identifier questionIdentifier = question.getId();
        final Set<Identifier> expressionVariables = VariableExctractor.extractFrom(question.getExpression());

        if (expressionVariables.contains(questionIdentifier)) {
            this.errorsFound.add(new CyclicQuestionsDependency(question.getLineInfo()));
        }

        return null;
    }

    @Override
    public Void visit(final Question question) {
        return null;
    }

    @Override
    public Void visit(Conditional conditional) {
        conditional.getQuestions().forEach(q -> q.accept(this));
        return null;
    }

    // TODO this should be part of some interface
    public List<Error> getErrors() {
        return this.errorsFound;
    }

}
