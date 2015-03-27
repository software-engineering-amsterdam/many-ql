package nl.uva.softwcons.qls.validation.questionidentifier;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.Statement;
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;

public final class FormQuestionCollector implements FormVisitor<Set<Identifier>>, StatementVisitor<Set<Identifier>> {

    public static Set<Identifier> collectFrom(final Form form) {
        return form.accept(new FormQuestionCollector());
    }

    private FormQuestionCollector() {
    }

    @Override
    public Set<Identifier> visit(final ComputedQuestion question) {
        return new HashSet<>(Arrays.asList(question.getId()));
    }

    @Override
    public Set<Identifier> visit(final Question question) {
        return new HashSet<>(Arrays.asList(question.getId()));
    }

    @Override
    public Set<Identifier> visit(final Conditional statement) {
        return visitAndFlatten(statement.getQuestions());
    }

    @Override
    public Set<Identifier> visit(final Form form) {
        return visitAndFlatten(form.getStatements());
    }

    /**
     * Visits the given statements, collects found identifiers and merges them
     * into a flat resulting set.
     */
    private Set<Identifier> visitAndFlatten(final List<? extends Statement> statements) {
        return statements.stream().flatMap(s -> s.accept(this).stream()).collect(Collectors.toSet());
    }
}
