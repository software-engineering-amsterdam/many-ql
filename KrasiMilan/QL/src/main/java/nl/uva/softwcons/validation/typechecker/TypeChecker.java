package nl.uva.softwcons.validation.typechecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nl.uva.softwcons.ast.FormVisitor;
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
import nl.uva.softwcons.ast.form.Form;
import nl.uva.softwcons.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ast.statement.Conditional;
import nl.uva.softwcons.ast.statement.Question;
import nl.uva.softwcons.ast.statement.StatementVisitor;
import nl.uva.softwcons.ast.type.Type;
import nl.uva.softwcons.validation.Error;
import nl.uva.softwcons.validation.typechecker.error.DuplicateQuestionIdentifier;
import nl.uva.softwcons.validation.typechecker.error.InvalidConditionType;
import nl.uva.softwcons.validation.typechecker.error.InvalidOperatorTypes;
import nl.uva.softwcons.validation.typechecker.error.InvalidQuestionExpressionType;
import nl.uva.softwcons.validation.typechecker.error.UndefinedReference;

public class TypeChecker implements FormVisitor<Void>, StatementVisitor<Void>, ExpressionVisitor<Type> {
    private final Environment env;
    private final List<Error> errorsFound;

    public TypeChecker() {
        this.env = new Environment();
        this.errorsFound = new ArrayList<>();
    }

    @Override
    public Void visitForm(final Form form) {
        form.getStatements().forEach(st -> st.accept(this));
        return null;
    }

    @Override
    public Void visit(final ComputedQuestion computedQuestion) {
        defineQuestionInEnvironment(computedQuestion);

        final Type questionExpressionType = computedQuestion.getExpression().accept(this);
        if (questionExpressionType != computedQuestion.getType()) {
            this.errorsFound.add(new InvalidQuestionExpressionType(computedQuestion.getLineInfo()));
        }

        return null;
    }

    @Override
    public Void visit(final Question question) {
        defineQuestionInEnvironment(question);

        return null;
    }

    @Override
    public Void visit(final Conditional conditional) {
        final Type conditionExprType = conditional.getCondition().accept(this);
        if (conditionExprType != Type.BOOLEAN) {
            this.errorsFound.add(new InvalidConditionType(conditional.getLineInfo()));
        }

        conditional.getQuestions().forEach(q -> q.accept(this));

        return null;
    }

    @Override
    public Type visit(final Addition expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = Addition.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.DECIMAL, Type.INTEGER);

        return combinedExpressionType;
    }

    @Override
    public Type visit(Division expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = Division.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.DECIMAL, Type.INTEGER);

        return combinedExpressionType;
    }

    @Override
    public Type visit(Multiplication expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExprType = Multiplication.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExprType, Type.DECIMAL, Type.INTEGER);

        return combinedExprType;
    }

    @Override
    public Type visit(Subtraction expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = Subtraction.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.DECIMAL, Type.INTEGER);

        return combinedExpressionType;
    }

    @Override
    public Type visit(Equal expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = Equal.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(NotEqual expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = NotEqual.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(GreaterOrEqual expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = GreaterOrEqual.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(GreaterThan expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = GreaterThan.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(LowerOrEqual expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = LowerOrEqual.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(LowerThan expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = LowerThan.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(And expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = And.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(Or expr) {
        final Type leftExprType = expr.getLeftExpression().accept(this);
        final Type rightExprType = expr.getRightExpression().accept(this);
        final Type combinedExpressionType = And.resolveType(leftExprType, rightExprType);

        validateExpressionType(expr, combinedExpressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(Not expr) {
        final Type expressionType = expr.getExpression().accept(this);

        validateExpressionType(expr, expressionType, Type.BOOLEAN);

        return Type.BOOLEAN;
    }

    @Override
    public Type visit(Identifier questionId) {
        final Type variableType = this.env.resolveVariable(questionId);

        if (variableType == Type.UNDEFINED) {
            this.errorsFound.add(new UndefinedReference(questionId.getLineInfo()));
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

    /**
     * Registers the given question in the current environment or adds a
     * {@link DuplicateQuestionIdentifier} error to the current errors list in
     * case the variable has already been defined.
     * 
     * @param question
     *            The question which should be defined in the current
     *            environment
     */
    private void defineQuestionInEnvironment(final Question question) {
        if (this.env.resolveVariable(question.getId()) == Type.UNDEFINED) {
            this.env.defineVariable(question.getId(), question.getType());
        } else {
            this.errorsFound.add(new DuplicateQuestionIdentifier(question.getLineInfo()));
        }
    }

    private void validateExpressionType(final Expression expr, final Type nodeType, final Type... allowedTypes) {
        if (!Arrays.asList(allowedTypes).contains(nodeType)) {
            this.errorsFound.add(new InvalidOperatorTypes(expr.getLineInfo()));
        }
    }

    // TODO this should be part of some interface
    public List<Error> getErrors() {
        return this.errorsFound;
    }

}
