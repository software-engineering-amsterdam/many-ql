package nl.uva.softwcons.ql.validation.dependency;

import java.util.List;
import java.util.Set;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;
import nl.uva.softwcons.ql.validation.Checker;
import nl.uva.softwcons.ql.validation.Error;
import nl.uva.softwcons.ql.validation.VariableExctractor;
import nl.uva.softwcons.ql.validation.dependency.error.CyclicQuestionsDependency;

public final class CyclicDependencyChecker extends Checker implements FormVisitor<List<Error>>, StatementVisitor<Void> {

    public static List<Error> check(final Form form) {
        return form.accept(new CyclicDependencyChecker());
    }

    private CyclicDependencyChecker() {
    }

    @Override
    public List<Error> visit(final Form form) {
        form.getStatements().forEach(st -> st.accept(this));

        return this.getErrors();
    }

    @Override
    public Void visit(final ComputedQuestion question) {
        final Identifier questionIdentifier = question.getId();
        final Set<Identifier> expressionVariables = VariableExctractor.extractFrom(question.getExpression());

        if (expressionVariables.contains(questionIdentifier)) {
            this.addError(new CyclicQuestionsDependency(question.getLineInfo()));
        }

        return null;
    }

    @Override
    public Void visit(final Question question) {
        return null;
    }

    @Override
    public Void visit(final Conditional conditional) {
        conditional.getQuestions().forEach(q -> q.accept(this));
        return null;
    }

}
