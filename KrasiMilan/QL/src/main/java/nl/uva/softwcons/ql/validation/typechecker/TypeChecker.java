package nl.uva.softwcons.ql.validation.typechecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;
import nl.uva.softwcons.ql.ast.type.BooleanType;
import nl.uva.softwcons.ql.ast.type.NumberType;
import nl.uva.softwcons.ql.ast.type.StringType;
import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.ql.ast.type.UndefinedType;
import nl.uva.softwcons.ql.validation.Error;
import nl.uva.softwcons.ql.validation.typechecker.error.DuplicateQuestionIdentifier;
import nl.uva.softwcons.ql.validation.typechecker.error.InvalidConditionType;
import nl.uva.softwcons.ql.validation.typechecker.error.InvalidOperatorTypes;
import nl.uva.softwcons.ql.validation.typechecker.error.InvalidQuestionExpressionType;
import nl.uva.softwcons.ql.validation.typechecker.error.UndefinedReference;

public class TypeChecker implements FormVisitor<Void>, StatementVisitor<Void>, ExpressionVisitor<Type> {
    private final Environment env;
    private final List<Error> errorsFound;

    public TypeChecker() {
        this.env = new Environment();
        this.errorsFound = new ArrayList<>();
    }

    @Override
    public Void visit(final Form form) {
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
        if (conditionExprType != BooleanType.instance) {
            this.errorsFound.add(new InvalidConditionType(conditional.getLineInfo()));
        }

        conditional.getQuestions().forEach(q -> q.accept(this));

        return null;
    }

    @Override
    public Type visit(final Addition expr) {
        final Type combinedExpressionType = Addition.resolveType(leftOperandVisit(expr), rightOperandVisit(expr));
        validateExpressionType(expr, combinedExpressionType, NumberType.instance);

        return combinedExpressionType;
    }

    @Override
    public Type visit(final Division expr) {
        final Type combinedExpressionType = Division.resolveType(leftOperandVisit(expr), rightOperandVisit(expr));
        validateExpressionType(expr, combinedExpressionType, NumberType.instance);

        return combinedExpressionType;
    }

    @Override
    public Type visit(final Multiplication expr) {
        final Type combinedExpressionType = Multiplication.resolveType(leftOperandVisit(expr),
                rightOperandVisit(expr));
        validateExpressionType(expr, combinedExpressionType, NumberType.instance);

        return combinedExpressionType;
    }

    @Override
    public Type visit(final Subtraction expr) {
        final Type combinedExpressionType = Subtraction
                .resolveType(leftOperandVisit(expr), rightOperandVisit(expr));
        validateExpressionType(expr, combinedExpressionType, NumberType.instance);

        return combinedExpressionType;
    }

    @Override
    public Type visit(final Equal expr) {
        final Type combinedExpressionType = Equal.resolveType(leftOperandVisit(expr), rightOperandVisit(expr));
        validateExpressionType(expr, combinedExpressionType, BooleanType.instance);

        return BooleanType.instance;
    }

    @Override
    public Type visit(final NotEqual expr) {
        final Type combinedExpressionType = NotEqual.resolveType(leftOperandVisit(expr), rightOperandVisit(expr));
        validateExpressionType(expr, combinedExpressionType, BooleanType.instance);

        return BooleanType.instance;
    }

    @Override
    public Type visit(final GreaterOrEqual expr) {
        final Type combinedExpressionType = GreaterOrEqual.resolveType(leftOperandVisit(expr),
                rightOperandVisit(expr));
        validateExpressionType(expr, combinedExpressionType, BooleanType.instance);

        return BooleanType.instance;
    }

    @Override
    public Type visit(final GreaterThan expr) {
        final Type combinedExpressionType = GreaterThan
                .resolveType(leftOperandVisit(expr), rightOperandVisit(expr));
        validateExpressionType(expr, combinedExpressionType, BooleanType.instance);

        return BooleanType.instance;
    }

    @Override
    public Type visit(final LowerOrEqual expr) {
        final Type combinedExpressionType = LowerOrEqual.resolveType(leftOperandVisit(expr),
                rightOperandVisit(expr));
        validateExpressionType(expr, combinedExpressionType, BooleanType.instance);

        return BooleanType.instance;
    }

    @Override
    public Type visit(final LowerThan expr) {
        final Type combinedExpressionType = LowerThan.resolveType(leftOperandVisit(expr), rightOperandVisit(expr));
        validateExpressionType(expr, combinedExpressionType, BooleanType.instance);

        return BooleanType.instance;
    }

    @Override
    public Type visit(final And expr) {
        final Type combinedExpressionType = And.resolveType(leftOperandVisit(expr), rightOperandVisit(expr));
        validateExpressionType(expr, combinedExpressionType, BooleanType.instance);

        return BooleanType.instance;
    }

    @Override
    public Type visit(final Or expr) {
        final Type combinedExpressionType = Or.resolveType(leftOperandVisit(expr), rightOperandVisit(expr));
        validateExpressionType(expr, combinedExpressionType, BooleanType.instance);

        return BooleanType.instance;
    }

    @Override
    public Type visit(final Not expr) {
        final Type expressionType = unaryOperandVisit(expr);
        validateExpressionType(expr, expressionType, BooleanType.instance);

        return BooleanType.instance;
    }

    @Override
    public Type visit(final Identifier questionId) {
        final Type variableType = this.env.resolveVariable(questionId);

        if (variableType == UndefinedType.instance) {
            this.errorsFound.add(new UndefinedReference(questionId.getLineInfo()));
        }

        return variableType;
    }

    @Override
    public Type visit(final BooleanLiteral expr) {
        return BooleanType.instance;
    }

    @Override
    public Type visit(final StringLiteral expr) {
        return StringType.instance;
    }

    @Override
    public Type visit(final NumberLiteral expr) {
        return NumberType.instance;
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
        if (this.env.resolveVariable(question.getId()) == UndefinedType.instance) {
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
