package nl.uva.softwcons.qls.validation.questionidentifier;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;

public final class FormQuestionCollector implements FormVisitor<Set<Identifier>>, StatementVisitor<Set<Identifier>> {

    public static Set<Identifier> collectFrom(final Form form) {
        final FormQuestionCollector collector = new FormQuestionCollector();
        return form.accept(collector);
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
        Set<Identifier> questionsIdentifier = new HashSet<Identifier>();
        // TODO try to fix semi-duplicate code with form
        questionsIdentifier = statement.getQuestions().stream().flatMap(s -> s.accept(this).stream())
                .collect(Collectors.toSet());
        return questionsIdentifier;
    }

    @Override
    public Set<Identifier> visit(final Form form) {
        Set<Identifier> questionsIdentifier = new HashSet<Identifier>();
        questionsIdentifier = form.getStatements().stream().flatMap(s -> s.accept(this).stream())
                .collect(Collectors.toSet());

        return questionsIdentifier;
    }
}
