package nl.uva.softwcons.eval;

import nl.uva.softwcons.ast.expression.ExpressionVisitor;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Addition;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Division;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Multiplication;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Subtraction;
import nl.uva.softwcons.ast.expression.binary.comparison.Equal;
import nl.uva.softwcons.ast.expression.binary.comparison.GreaterOrEqual;
import nl.uva.softwcons.ast.expression.binary.comparison.GreaterThan;
import nl.uva.softwcons.ast.expression.binary.comparison.LowerOrEqual;
import nl.uva.softwcons.ast.expression.binary.comparison.LowerThan;
import nl.uva.softwcons.ast.expression.binary.comparison.NotEqual;
import nl.uva.softwcons.ast.expression.binary.logical.And;
import nl.uva.softwcons.ast.expression.binary.logical.Or;
import nl.uva.softwcons.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ast.expression.literal.BooleanLiteral;
import nl.uva.softwcons.ast.expression.literal.DecimalLiteral;
import nl.uva.softwcons.ast.expression.literal.IntegerLiteral;
import nl.uva.softwcons.ast.expression.literal.StringLiteral;
import nl.uva.softwcons.ast.expression.unary.logical.Not;
import nl.uva.softwcons.ast.form.Form;
import nl.uva.softwcons.ast.form.FormVisitor;
import nl.uva.softwcons.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ast.statement.Conditional;
import nl.uva.softwcons.ast.statement.Question;
import nl.uva.softwcons.ast.statement.StatementVisitor;
import nl.uva.softwcons.eval.value.BooleanValue;
import nl.uva.softwcons.eval.value.DecimalValue;
import nl.uva.softwcons.eval.value.IntegerValue;
import nl.uva.softwcons.eval.value.StringValue;
import nl.uva.softwcons.eval.value.Value;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Evaluator implements FormVisitor<Void>, StatementVisitor<Void>, ExpressionVisitor<Value> {

    private final FormAnswers answers;
    private Multimap<Identifier, ValueChangeListener<Value>> changeListeners = ArrayListMultimap.create();

    public Evaluator(final FormAnswers answers) {
        this.answers = answers;
    }

    public void addListener(final Identifier questionId, final ValueChangeListener<Value> listener) {
        this.changeListeners.put(questionId, listener);
    }

    @Override
    public Void visit(final Form form) {
        form.getStatements().forEach(st -> st.accept(this));
        return null;
    }

    @Override
    public Void visit(final ComputedQuestion question) {
        Value resultValue = question.getExpression().accept(this);
        this.answers.setValue(question.getId(), resultValue);
        return null;
    }

    @Override
    public Void visit(final Question question) {
        return null;
    }

    @Override
    public Void visit(final Conditional question) {
        Value resultValue = question.getCondition().accept(this);
        this.answers.setValue(question.getId(), resultValue);
        return null;
    }

    @Override
    public Value visit(final Addition expr) {
        return leftOperand(expr).add(rightOperand(expr));
    }

    @Override
    public Value visit(final Division expr) {
        return leftOperand(expr).divide(rightOperand(expr));
    }

    @Override
    public Value visit(final Multiplication expr) {
        return leftOperand(expr).multiply(rightOperand(expr));
    }

    @Override
    public Value visit(final Subtraction expr) {
        return leftOperand(expr).subtract(rightOperand(expr));
    }

    @Override
    public Value visit(final Equal expr) {
        return leftOperand(expr).isEqual(rightOperand(expr));
    }

    @Override
    public Value visit(final GreaterOrEqual expr) {
        return leftOperand(expr).isGreaterOrEqual(rightOperand(expr));
    }

    @Override
    public Value visit(final GreaterThan expr) {
        return leftOperand(expr).isGreater(rightOperand(expr));
    }

    @Override
    public Value visit(final LowerOrEqual expr) {
        return leftOperand(expr).isLowerOrEqual(rightOperand(expr));
    }

    @Override
    public Value visit(final LowerThan expr) {
        return leftOperand(expr).isLower(rightOperand(expr));
    }

    @Override
    public Value visit(final NotEqual expr) {
        return leftOperand(expr).isEqual(rightOperand(expr)).not();
    }

    @Override
    public Value visit(final And expr) {
        return leftOperand(expr).and(rightOperand(expr));
    }

    @Override
    public Value visit(final Or expr) {
        return leftOperand(expr).or(rightOperand(expr));
    }

    @Override
    public Value visit(final Not expr) {
        return unaryOperand(expr).not();
    }

    @Override
    public Value visit(final Identifier questionId) {
        return answers.getValue(questionId);
    }

    @Override
    public BooleanValue visit(final BooleanLiteral expr) {
        return new BooleanValue(expr.getValue());
    }

    @Override
    public IntegerValue visit(final IntegerLiteral expr) {
        return new IntegerValue(expr.getValue());
    }

    @Override
    public StringValue visit(final StringLiteral expr) {
        return new StringValue(expr.getValue());
    }

    @Override
    public DecimalValue visit(final DecimalLiteral expr) {
        return new DecimalValue(expr.getValue());
    }
}
