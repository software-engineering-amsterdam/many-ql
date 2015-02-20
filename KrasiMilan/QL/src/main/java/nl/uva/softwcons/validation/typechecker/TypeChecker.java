package nl.uva.softwcons.validation.typechecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;
import nl.uva.softwcons.ast.expression.binary.arithmetic.AdditionExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.DivisionExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.MultiplicationExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.SubstractionExpression;
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
import nl.uva.softwcons.ast.statement.Block;
import nl.uva.softwcons.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ast.statement.Conditional;
import nl.uva.softwcons.ast.statement.Question;
import nl.uva.softwcons.ast.statement.StatementVisitor;
import nl.uva.softwcons.ast.type.Type;
import nl.uva.softwcons.validation.Error;
import nl.uva.softwcons.validation.typechecker.error.DuplicateQuestion;
import nl.uva.softwcons.validation.typechecker.error.InvalidConditionType;
import nl.uva.softwcons.validation.typechecker.error.InvalidOperatorTypes;
import nl.uva.softwcons.validation.typechecker.error.InvalidQuestionExpressionType;
import nl.uva.softwcons.validation.typechecker.error.UndefinedReference;

public class TypeChecker implements ExpressionVisitor<Type>, StatementVisitor<Type> {

    private final Environment env;
    private final List<Error> errorsFound;

    public TypeChecker() {
        this.env = new Environment();
        this.errorsFound = new ArrayList<>();
    }

    @Override
    public Type visit(final Block block) {
        block.getStatements().forEach(st -> st.accept(this));
        return Type.UNDEFINED;
    }

    @Override
    public Type visit(final ComputedQuestion computedQuestion) {
        defineQuestionInEnvironment(computedQuestion);

        final Type questionExpressionType = computedQuestion.getExpression().accept(this);
        if (questionExpressionType != computedQuestion.getType()) {
            this.errorsFound.add(new InvalidQuestionExpressionType());
        }

        return Type.UNDEFINED;
    }

    @Override
    public Type visit(final Question question) {
        defineQuestionInEnvironment(question);

        return Type.UNDEFINED;
    }

    /**
     * Registers the given question in the current environment or adds a
     * {@link DuplicateQuestion} error to the current errors list in case the
     * variable has already been defined.
     * 
     * @param question
     *            The question which should be defined in the current
     *            environment
     */
    private void defineQuestionInEnvironment(final Question question) {
        if (this.env.resolveVariable(question.getId()) == Type.UNDEFINED) {
            this.env.defineVariable(question.getId(), question.getType());
        } else {
            this.errorsFound.add(new DuplicateQuestion());
        }
    }

    @Override
    public Type visit(final Conditional conditional) {
        final Type conditionExprType = conditional.getCondition().accept(this);
        if (conditionExprType != Type.BOOLEAN) {
            this.errorsFound.add(new InvalidConditionType());
        }

        conditional.getQuestions().forEach(q -> q.accept(this));

        return Type.UNDEFINED;
    }

    @Override
    public Type visit(final AdditionExpression expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = AdditionExpression.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.DECIMAL, Type.INTEGER);

        return combinedExpressionType;
    }

    @Override
    public Type visit(DivisionExpression expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = DivisionExpression.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.DECIMAL, Type.INTEGER);

        return combinedExpressionType;
    }

    @Override
    public Type visit(MultiplicationExpression expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExprType = MultiplicationExpression.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExprType, Type.DECIMAL, Type.INTEGER);

        return combinedExprType;
    }

    @Override
    public Type visit(SubstractionExpression expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = SubstractionExpression.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.DECIMAL, Type.INTEGER);

        return combinedExpressionType;
    }

    @Override
    public Type visit(EqualExpression expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = EqualExpression.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(NotEqualExpression expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = NotEqualExpression.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(GreaterOrEqualExpression expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = GreaterOrEqualExpression.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(GreaterThanExpression expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = GreaterThanExpression.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(LowerOrEqualExpression expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = LowerOrEqualExpression.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(LowerThanExpression expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = LowerThanExpression.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(AndExpression expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = AndExpression.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(OrExpression expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = AndExpression.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(NotExpression expr) {
        final Type expressionType = expr.getExpression().accept(this);

        validateExpressionType(expr, expressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(IdentifierExpression expr) {
        final String variableName = expr.getName();
        final Type variableType = this.env.resolveVariable(variableName);

        if (variableType == Type.UNDEFINED) {
            this.errorsFound.add(new UndefinedReference());
        }

        return variableType;
    }

    @Override
    public Type visit(BooleanLiteral expr) {
        return Type.BOOLEAN;
    }

    @Override
    public Type visit(IntegerLiteral expr) {
        return Type.INTEGER;
    }

    @Override
    public Type visit(StringLiteral expr) {
        return Type.STRING;
    }

    @Override
    public Type visit(DecimalLiteral expr) {
        return Type.DECIMAL;
    }

    private void validateExpressionType(final Expression node, final Type nodeType, final Type... allowedTypes) {
        if (!Arrays.asList(allowedTypes).contains(nodeType)) {
            this.errorsFound.add(new InvalidOperatorTypes());
        }
    }

    // TODO this should be part of some interface
    public List<Error> getErrors() {
        return this.errorsFound;
    }

}
