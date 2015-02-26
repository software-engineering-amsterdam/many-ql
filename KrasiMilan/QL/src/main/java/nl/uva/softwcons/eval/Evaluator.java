package nl.uva.softwcons.eval;

import nl.uva.softwcons.ast.expression.ExpressionVisitor;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;
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
import nl.uva.softwcons.ast.expression.unary.UnaryExpression;
import nl.uva.softwcons.ast.expression.unary.logical.Not;
import nl.uva.softwcons.ast.statement.Block;
import nl.uva.softwcons.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ast.statement.Conditional;
import nl.uva.softwcons.ast.statement.Question;
import nl.uva.softwcons.ast.statement.Statement;
import nl.uva.softwcons.ast.statement.StatementVisitor;
import nl.uva.softwcons.eval.value.BooleanValue;
import nl.uva.softwcons.eval.value.DecimalValue;
import nl.uva.softwcons.eval.value.IntegerValue;
import nl.uva.softwcons.eval.value.StringValue;
import nl.uva.softwcons.eval.value.Value;

public class Evaluator implements ExpressionVisitor<Value>, StatementVisitor<Void> {

    private FormAnswers answers;

    public Evaluator(FormAnswers answers) {
        this.answers = answers;
    }

    @Override
    public Void visit(Block block) {
        for (Statement stat : block.getStatements()) {
            stat.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ComputedQuestion question) {
        Value resultValue = question.getExpression().accept(this);
        this.answers.setValue(question.getId(), resultValue);
        return null;
    }

    @Override
    public Void visit(Question question) {
        return null;
    }

    @Override
    public Void visit(Conditional question) {
        Value resultValue = question.getCondition().accept(this);
        this.answers.setValue(question.getId(), resultValue);
        return null;
    }

    private Value leftValue(BinaryExpression expr) {
        return expr.getLeftExpression().accept(this);
    }

    private Value rightValue(BinaryExpression expr) {
        return expr.getRightExpression().accept(this);
    }

    private Value unaryValue(UnaryExpression expr) {
        return expr.getExpression().accept(this);
    }

    @Override
    public Value visit(Addition expr) {
        return (Value) leftValue(expr).add(rightValue(expr));
    }

    @Override
    public Value visit(Division expr) {
        return (Value) leftValue(expr).divide(rightValue(expr));
    }

    @Override
    public Value visit(Multiplication expr) {
        return (Value) leftValue(expr).multiply(rightValue(expr));
    }

    @Override
    public Value visit(Subtraction expr) {
        return (Value) leftValue(expr).subtract(rightValue(expr));
    }

    @Override
    public Value visit(Equal expr) {
        return leftValue(expr).isEqual(rightValue(expr));
    }

    @Override
    public Value visit(GreaterOrEqual expr) {
        return leftValue(expr).isGreaterOrEqual(rightValue(expr));
    }

    @Override
    public Value visit(GreaterThan expr) {
        return leftValue(expr).isGreater(rightValue(expr));
    }

    @Override
    public Value visit(LowerOrEqual expr) {
        return leftValue(expr).isLowerOrEqual(rightValue(expr));
    }

    @Override
    public Value visit(LowerThan expr) {
        return leftValue(expr).isLower(rightValue(expr));
    }

    @Override
    public Value visit(NotEqual expr) {
        return leftValue(expr).isEqual(rightValue(expr)).not();
    }

    @Override
    public Value visit(And expr) {
        return leftValue(expr).and(rightValue(expr));
    }

    @Override
    public Value visit(Or expr) {
        return leftValue(expr).or(rightValue(expr));
    }

    @Override
    public Value visit(Not expr) {
        return unaryValue(expr).not();
    }

    @Override
    public Value visit(Identifier expr) {
        return answers.getValue(expr.getName());
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
