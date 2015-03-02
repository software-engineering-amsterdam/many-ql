package nl.uva.softwcons.eval;

import nl.uva.softwcons.ast.expression.Expression;
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
import nl.uva.softwcons.eval.value.BooleanValue;
import nl.uva.softwcons.eval.value.NumberValue;
import nl.uva.softwcons.eval.value.StringValue;
import nl.uva.softwcons.eval.value.Value;

public final class ExpressionEvaluator implements ExpressionVisitor<Value> {
    private FormAnswers variablesTable;

    private ExpressionEvaluator() {
    }

    private ExpressionEvaluator(FormAnswers variablesTable) {
        this.variablesTable = variablesTable;
    }

    public static Value evaluate(final Expression expr, final FormAnswers variables) {
        return expr.accept(new ExpressionEvaluator(variables));
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
        return variablesTable.getValue(questionId);
    }

    @Override
    public BooleanValue visit(final BooleanLiteral expr) {
        return new BooleanValue(expr.getValue());
    }

    @Override
    public NumberValue visit(final IntegerLiteral expr) {
        return new NumberValue(expr.getValue());
    }

    @Override
    public StringValue visit(final StringLiteral expr) {
        return new StringValue(expr.getValue());
    }

    @Override
    public NumberValue visit(final DecimalLiteral expr) {
        return new NumberValue(expr.getValue());
    }
}
