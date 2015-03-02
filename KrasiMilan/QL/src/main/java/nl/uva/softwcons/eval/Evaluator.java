package nl.uva.softwcons.eval;

import nl.uva.softwcons.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ast.form.Form;
import nl.uva.softwcons.ast.form.FormVisitor;
import nl.uva.softwcons.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ast.statement.Conditional;
import nl.uva.softwcons.ast.statement.Question;
import nl.uva.softwcons.ast.statement.StatementVisitor;
import nl.uva.softwcons.eval.value.Value;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Evaluator implements FormVisitor<Void>, StatementVisitor<Void> {

    private final FormAnswers answers;
    private Multimap<Identifier, ValueChangeListener<Value>> changeListeners = ArrayListMultimap.create();

    public Evaluator(final FormAnswers answers) {
        this.answers = answers;
    }

    public void addListener(final Identifier questionId, final ValueChangeListener<Value> listener) {
        this.changeListeners.put(questionId, listener);
    }

    public void setQuestionValue(Identifier id, Value value) {
        this.answers.setValue(id, value);
    }

    @Override
    public Void visit(final Form form) {
        form.getStatements().forEach(st -> st.accept(this));
        return null;
    }

    @Override
    public Void visit(final ComputedQuestion question) {
        final Value resultValue = ExpressionEvaluator.evaluate(question.getExpression(), answers);
        this.answers.setValue(question.getId(), resultValue);
        return null;
    }

    @Override
    public Void visit(final Question question) {
        return null;
    }

    @Override
    public Void visit(final Conditional conditional) {
        final Value resultValue = ExpressionEvaluator.evaluate(conditional.getCondition(), answers);
        this.answers.setValue(conditional.getId(), resultValue);
        return null;
    }

}
