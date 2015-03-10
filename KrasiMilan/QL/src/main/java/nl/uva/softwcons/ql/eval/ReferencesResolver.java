package nl.uva.softwcons.ql.eval;

import java.util.Collection;
import java.util.Set;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;
import nl.uva.softwcons.ql.validation.VariableExctractor;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ReferencesResolver implements FormVisitor<Void>, StatementVisitor<Void> {
    private final Multimap<Identifier, ComputedQuestion> questionReferences;
    private final Multimap<Identifier, Conditional> conditionalReferences;

    public ReferencesResolver(final Form form) {
        this.questionReferences = ArrayListMultimap.create();
        this.conditionalReferences = ArrayListMultimap.create();

        form.accept(this);
    }

    public Collection<ComputedQuestion> getReferencedQuestions(final Identifier variableName) {
        return questionReferences.get(variableName);
    }

    public Collection<Conditional> getReferencedConditionals(final Identifier variableName) {
        return conditionalReferences.get(variableName);
    }

    @Override
    public Void visit(final Form form) {
        form.getStatements().forEach(st -> st.accept(this));
        return null;
    }

    @Override
    public Void visit(final ComputedQuestion question) {
        final Set<Identifier> expressionVariables = VariableExctractor.extractFrom(question.getExpression());
        expressionVariables.forEach(v -> this.questionReferences.put(v, question));
        return null;
    }

    @Override
    public Void visit(final Question statement) {
        return null;
    }

    @Override
    public Void visit(final Conditional conditional) {
        final Set<Identifier> expressionVariables = VariableExctractor.extractFrom(conditional.getExpression());
        expressionVariables.forEach(v -> this.conditionalReferences.put(v, conditional));

        conditional.getQuestions().forEach(q -> q.accept(this));
        return null;
    }

}
