package nl.uva.softwcons.validation.dependency;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import nl.uva.softwcons.ast.statement.Block;
import nl.uva.softwcons.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ast.statement.Conditional;
import nl.uva.softwcons.ast.statement.Question;
import nl.uva.softwcons.ast.statement.StatementVisitor;
import nl.uva.softwcons.validation.Error;
import nl.uva.softwcons.validation.VariableExctractor;
import nl.uva.softwcons.validation.dependency.error.CyclicQuestionsDependency;

public class CyclicDependencyChecker implements StatementVisitor<Void> {

    private final List<Error> errorsFound;

    public CyclicDependencyChecker() {
        this.errorsFound = new ArrayList<>();
    }

    @Override
    public Void visit(final Block body) {
        body.getStatements().forEach(st -> st.accept(this));
        return null;
    }

    @Override
    public Void visit(final ComputedQuestion question) {
        final String questionIdentifier = question.getId();
        final Set<String> expressionVariables = VariableExctractor.extractFrom(question.getExpression());

        if (expressionVariables.contains(questionIdentifier)) {
            this.errorsFound.add(new CyclicQuestionsDependency());
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
