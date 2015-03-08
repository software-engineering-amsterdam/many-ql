package nl.uva.softwcons.ql.eval;

import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.ExpressionVisitor;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Addition;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Division;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Multiplication;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Subtraction;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.Equal;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.GreaterOrEqual;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.GreaterThan;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.LowerOrEqual;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.LowerThan;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.NotEqual;
import nl.uva.softwcons.ql.ast.expression.binary.logical.And;
import nl.uva.softwcons.ql.ast.expression.binary.logical.Or;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.expression.literal.BooleanLiteral;
import nl.uva.softwcons.ql.ast.expression.literal.NumberLiteral;
import nl.uva.softwcons.ql.ast.expression.literal.StringLiteral;
import nl.uva.softwcons.ql.ast.expression.unary.logical.Not;
import nl.uva.softwcons.ql.eval.value.BooleanValue;
import nl.uva.softwcons.ql.eval.value.NumberValue;
import nl.uva.softwcons.ql.eval.value.StringValue;
import nl.uva.softwcons.ql.eval.value.Value;

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
        return leftOperandVisit(expr).add(rightOperandVisit(expr));
    }

    @Override
    public Value visit(final Division expr) {
        return leftOperandVisit(expr).divide(rightOperandVisit(expr));
    }

    @Override
    public Value visit(final Multiplication expr) {
        return leftOperandVisit(expr).multiply(rightOperandVisit(expr));
    }

    @Override
    public Value visit(final Subtraction expr) {
        return leftOperandVisit(expr).subtract(rightOperandVisit(expr));
    }

    @Override
    public Value visit(final Equal expr) {
        return leftOperandVisit(expr).isEqual(rightOperandVisit(expr));
    }

    @Override
    public Value visit(final GreaterOrEqual expr) {
        return leftOperandVisit(expr).isGreaterOrEqual(rightOperandVisit(expr));
    }

    @Override
    public Value visit(final GreaterThan expr) {
        return leftOperandVisit(expr).isGreater(rightOperandVisit(expr));
    }

    @Override
    public Value visit(final LowerOrEqual expr) {
        return leftOperandVisit(expr).isLowerOrEqual(rightOperandVisit(expr));
    }

    @Override
    public Value visit(final LowerThan expr) {
        return leftOperandVisit(expr).isLower(rightOperandVisit(expr));
    }

    @Override
    public Value visit(final NotEqual expr) {
        return leftOperandVisit(expr).isEqual(rightOperandVisit(expr)).not();
    }

    @Override
    public Value visit(final And expr) {
        return leftOperandVisit(expr).and(rightOperandVisit(expr));
    }

    @Override
    public Value visit(final Or expr) {
        return leftOperandVisit(expr).or(rightOperandVisit(expr));
    }

    @Override
    public Value visit(final Not expr) {
        return unaryOperandVisit(expr).not();
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
    public StringValue visit(final StringLiteral expr) {
        return new StringValue(expr.getValue());
    }

    @Override
    public NumberValue visit(final NumberLiteral expr) {
        return new NumberValue(expr.getValue());
    }
}
