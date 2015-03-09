package nl.uva.softwcons.ql.eval;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
import nl.uva.softwcons.ql.ast.statement.Computable;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;
import nl.uva.softwcons.ql.eval.value.Value;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Evaluator implements FormVisitor<Void>, StatementVisitor<Void> {
    private final FormAnswers answers;
    private final ReferencesResolver referencesResolver;

    private final Multimap<Computable, ValueChangeListener<Value>> changeListeners = ArrayListMultimap.create();

    public Evaluator(final Form form) {
        this.answers = new FormAnswers();
        this.referencesResolver = new ReferencesResolver(form);

        form.accept(this);
    }

    public Value getValue(final Identifier variable) {
        return this.answers.getValue(variable);
    }

    public void updateValue(final Identifier variable, final Value value) {
        this.answers.setValue(variable, value);

        reevaluateIdentifierReferences(variable);
    }

    public void addListener(final Computable computable, final ValueChangeListener<Value> listener) {
        this.changeListeners.put(computable, listener);
    }

    @Override
    public Void visit(final Form form) {
        form.getStatements().forEach(st -> st.accept(this));
        return null;
    }

    @Override
    public Void visit(final Question question) {
        return null;
    }

    @Override
    public Void visit(final ComputedQuestion question) {
        final Value resultValue = ExpressionEvaluator.evaluate(question.getExpression(), answers);
        this.answers.setValue(question.getId(), resultValue);
        notifyListeners(question, resultValue);

        return null;
    }

    @Override
    public Void visit(final Conditional conditional) {
        final Value resultValue = ExpressionEvaluator.evaluate(conditional.getExpression(), answers);
        notifyListeners(conditional, resultValue);

        return null;
    }

    private void reevaluateIdentifierReferences(final Identifier variableName) {
        // TODO discuss sequence of calls here
        this.referencesResolver.getReferencedConditionals(variableName).forEach(c -> c.accept(this));

        this.referencesResolver.getReferencedQuestions(variableName).forEach(q -> {
            q.accept(this);
            this.reevaluateIdentifierReferences(q.getId());
        });
    }

    private void notifyListeners(final Computable computable, final Value newValue) {
        this.changeListeners.get(computable).forEach(l -> l.processValueChange(newValue));
    }
}
