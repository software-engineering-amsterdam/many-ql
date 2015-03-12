package edu.parser.QL;

import edu.exceptions.TypeCheckException;
import edu.parser.QL.nodes.expression.*;
import edu.parser.QL.nodes.question.Question;
import edu.parser.QL.nodes.type.Number;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Steven Kok on 12/03/2015.
 */
public class TypeCheckerExpressionValidator implements ExpressionVisitor {

    private final Set<QLIdentifier> identifiers;
    private Map<QLIdentifier, Question> questions;

    public TypeCheckerExpressionValidator(Map<QLIdentifier, Question> questions) {
        this.questions = questions;
        this.identifiers = new HashSet<>();
    }

    @Override
    public Expression visit(Addition addition) {
        return visitArithmeticExpression(addition);
    }

    @Override
    public Expression visit(And and) {
        return visitLogicalExpression(and);
    }

    @Override
    public Expression visit(Or or) {
        return visitLogicalExpression(or);
    }


    private Expression visitLogicalExpression(BinaryExpression expression) {
        if (expression.getLeft().hasBooleanOperands() && expression.getRight().hasBooleanOperands()) {
            visit(expression.getLeft());
            visit(expression.getRight());
            return expression;
        } else {
            throw new TypeCheckException(String.format(TypeChecker.EXPRESSION_EXPECTS_BOOLEAN, expression.getClass().getSimpleName(), expression.toString()));
        }
    }

    @Override
    public Expression visit(Equal equal) {
        visit(equal.getLeft());
        visit(equal.getRight());
        return equal;
    }

    @Override
    public Expression visit(GreaterOrEqual greaterOrEqual) {
        return visitArithmeticExpression(greaterOrEqual);
    }

    @Override
    public Expression visit(GreaterThan greaterThan) {
        return visitArithmeticExpression(greaterThan);
    }

    @Override
    public Expression visit(LessOrEqual lessOrEqual) {
        return visitArithmeticExpression(lessOrEqual);
    }

    @Override
    public Expression visit(LessThan lessThan) {
        return visitArithmeticExpression(lessThan);
    }

    @Override
    public Expression visit(Multiplication multiplication) {
        return visitArithmeticExpression(multiplication);
    }

    @Override
    public Expression visit(Division division) {
        return visitArithmeticExpression(division);
    }

    @Override
    public Expression visit(edu.parser.QL.nodes.type.Boolean aBoolean) {
        return aBoolean;
    }

    @Override
    public Expression visit(Number number) {
        return number;
    }

    @Override
    public Expression visit(Expression expression) {
        return expression.accept(this);
    }

    @Override
    public Expression visit(Not not) {
        if (!not.getOperand().hasBooleanOperands()) {
            throw new TypeCheckException(String.format(TypeChecker.EXPRESSION_EXPECTS_BOOLEAN, not.getClass().getSimpleName(), not.toString()));
        }
        return visit(not.getOperand());
    }

    @Override
    public Expression visit(NotEqual notEqual) {
        return notEqual;
    }

    private Expression visitArithmeticExpression(BinaryExpression expression) {
        if (expression.getLeft().hasBooleanOperands() || expression.getRight().hasBooleanOperands()) {
            throw new TypeCheckException(String.format(TypeChecker.EXPRESSION_EXPECTS_NON_BOOLEAN, expression.getClass().getSimpleName(), expression.toString()));
        }
        visit(expression.getLeft());
        visit(expression.getRight());
        return expression;
    }


    @Override
    public Expression visit(QLIdentifier QLIdentifier) {
        identifiers.add(QLIdentifier); // may overwrite existing items
        checkReferenceToUndefinedQuestions();
        return QLIdentifier;
    }


    // implicitly checks for cyclic dependencies of questions
    private void checkReferenceToUndefinedQuestions() {
        String undefinedReferences = identifiers
                .stream()
                .filter(identifier -> !questions.containsKey(identifier))
                .map(QLIdentifier::toString)
                .collect(Collectors.joining(", "));
        if (!undefinedReferences.isEmpty()) {
            throw new TypeCheckException("Invalid reference to undefined question: " + undefinedReferences);
        }
    }
}
