package nl.uva.softwcons.ql.eval;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
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
    private Multimap<Identifier, ValueChangeListener<Value>> changeListeners = ArrayListMultimap.create();

    public Evaluator(final Form form) {
        this.answers = new FormAnswers();
        this.referencesResolver = new ReferencesResolver(form);

        form.accept(this);
    }

    public void addListener(final Identifier questionId, final ValueChangeListener<Value> listener) {
        this.changeListeners.put(questionId, listener);
    }

    public void updateQuestionValue(final Identifier variable, Value value) {
        this.answers.setValue(variable, value);
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
        return null;
    }

    @Override
    public Void visit(final Conditional conditional) {
        final Value resultValue = ExpressionEvaluator.evaluate(conditional.getExpression(), answers);

        return null;
    }

}
