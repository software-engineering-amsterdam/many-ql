package nl.uva.softwcons.eval;

import nl.uva.softwcons.ast.expression.ExpressionVisitor;
import nl.uva.softwcons.ast.expression.binary.arithmetic.AdditionExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.DivisionExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.MultiplicationExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.SubtractionExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.EqualExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.GreaterOrEqualExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.GreaterThanExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.LowerOrEqualExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.LowerThanExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.NotEqualExpression;
import nl.uva.softwcons.ast.expression.binary.logical.AndExpression;
import nl.uva.softwcons.ast.expression.binary.logical.OrExpression;
import nl.uva.softwcons.ast.expression.identifier.IdentifierExpression;
import nl.uva.softwcons.ast.expression.literal.BooleanLiteral;
import nl.uva.softwcons.ast.expression.literal.DecimalLiteral;
import nl.uva.softwcons.ast.expression.literal.IntegerLiteral;
import nl.uva.softwcons.ast.expression.literal.StringLiteral;
import nl.uva.softwcons.ast.expression.unary.logical.NotExpression;
import nl.uva.softwcons.eval.value.BooleanValue;
import nl.uva.softwcons.eval.value.DecimalValue;
import nl.uva.softwcons.eval.value.IntegerValue;
import nl.uva.softwcons.eval.value.StringValue;
import nl.uva.softwcons.eval.value.Value;

public class Evaluator implements ExpressionVisitor<Value> {

    @Override
    public DecimalValue visit(AdditionExpression expr) {
        DecimalValue leftValue = (DecimalValue) expr.getLeftExpression().accept(this);
        DecimalValue rightValue = (DecimalValue) expr.getRightExpression().accept(this);

        return leftValue.add(rightValue);
    }

    @Override
    public DecimalValue visit(DivisionExpression expr) {
        DecimalValue leftValue = (DecimalValue) expr.getLeftExpression().accept(this);
        DecimalValue rightValue = (DecimalValue) expr.getRightExpression().accept(this);

        return leftValue.divide(rightValue);
    }

    @Override
    public DecimalValue visit(MultiplicationExpression expr) {
        DecimalValue leftValue = (DecimalValue) expr.getLeftExpression().accept(this);
        DecimalValue rightValue = (DecimalValue) expr.getRightExpression().accept(this);

        return leftValue.multiply(rightValue);
    }

    @Override
    public DecimalValue visit(SubtractionExpression expr) {
        DecimalValue leftValue = (DecimalValue) expr.getLeftExpression().accept(this);
        DecimalValue rightValue = (DecimalValue) expr.getRightExpression().accept(this);

        return leftValue.subtract(rightValue);
    }

    @Override
    public BooleanValue visit(EqualExpression expr) {
        Value leftValue = expr.getLeftExpression().accept(this);
        Value rightValue = expr.getRightExpression().accept(this);

        return leftValue.isEqual(rightValue);
    }

    @Override
    public BooleanValue visit(GreaterOrEqualExpression expr) {
        DecimalValue leftValue = (DecimalValue) expr.getLeftExpression().accept(this);
        DecimalValue rightValue = (DecimalValue) expr.getRightExpression().accept(this);

        return leftValue.isGreaterOrEqual(rightValue);
    }

    @Override
    public BooleanValue visit(GreaterThanExpression expr) {
        DecimalValue leftValue = (DecimalValue) expr.getLeftExpression().accept(this);
        DecimalValue rightValue = (DecimalValue) expr.getRightExpression().accept(this);

        return leftValue.isGreater(rightValue);
    }

    @Override
    public BooleanValue visit(LowerOrEqualExpression expr) {
        DecimalValue leftValue = (DecimalValue) expr.getLeftExpression().accept(this);
        DecimalValue rightValue = (DecimalValue) expr.getRightExpression().accept(this);

        return leftValue.isLowerOrEqual(rightValue);
    }

    @Override
    public BooleanValue visit(LowerThanExpression expr) {
        DecimalValue leftValue = (DecimalValue) expr.getLeftExpression().accept(this);
        DecimalValue rightValue = (DecimalValue) expr.getRightExpression().accept(this);

        return leftValue.isLower(rightValue);
    }

    @Override
    public BooleanValue visit(NotEqualExpression expr) {
        Value leftValue = expr.getLeftExpression().accept(this);
        Value rightValue = expr.getRightExpression().accept(this);

        return leftValue.isEqual(rightValue).not();
    }

    @Override
    public BooleanValue visit(AndExpression expr) {
        BooleanValue leftValue = (BooleanValue) expr.getLeftExpression().accept(this);
        BooleanValue rightValue = (BooleanValue) expr.getRightExpression().accept(this);

        return leftValue.and(rightValue);
    }

    @Override
    public BooleanValue visit(OrExpression expr) {
        BooleanValue leftValue = (BooleanValue) expr.getLeftExpression().accept(this);
        BooleanValue rightValue = (BooleanValue) expr.getRightExpression().accept(this);

        return leftValue.or(rightValue);
    }

    @Override
    public BooleanValue visit(NotExpression expr) {
        BooleanValue value = (BooleanValue) expr.getExpression().accept(this);
        return value.not();
    }

    @Override
    public Value visit(IdentifierExpression expr) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BooleanValue visit(BooleanLiteral expr) {
        return new BooleanValue(expr.getValue());
    }

    @Override
    public IntegerValue visit(IntegerLiteral expr) {
        return new IntegerValue(expr.getValue());
    }

    @Override
    public StringValue visit(StringLiteral expr) {
        return new StringValue(expr.getValue());
    }

    @Override
    public DecimalValue visit(DecimalLiteral expr) {
        return new DecimalValue(expr.getValue());
    }

}
