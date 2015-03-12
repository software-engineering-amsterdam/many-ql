package edu.parser.QL.evaluator;

import edu.parser.QL.nodes.expression.*;
import edu.parser.QL.nodes.type.Number;

/**
 * Created by Steven Kok on 12/03/2015.
 */
public class ComputedQuestionsRetriever implements ExpressionVisitor {
    @Override
    public Expression visit(Addition addition) {
        return null;
    }

    @Override
    public Expression visit(And and) {
        return null;
    }

    @Override
    public Expression visit(Equal equal) {
        return null;
    }

    @Override
    public Expression visit(GreaterOrEqual greaterOrEqual) {
        return null;
    }

    @Override
    public Expression visit(GreaterThan greaterThan) {
        return null;
    }

    @Override
    public Expression visit(QLIdentifier QLIdentifier) {
        return null;
    }

    @Override
    public Expression visit(LessOrEqual lessOrEqual) {
        return null;
    }

    @Override
    public Expression visit(LessThan lessThan) {
        return null;
    }

    @Override
    public Expression visit(Multiplication multiplication) {
        return null;
    }

    @Override
    public Expression visit(Not not) {
        return null;
    }

    @Override
    public Expression visit(NotEqual notEqual) {
        return null;
    }

    @Override
    public Expression visit(Or or) {
        return null;
    }

    @Override
    public Expression visit(Division division) {
        return null;
    }

    @Override
    public Expression visit(edu.parser.QL.nodes.type.Boolean aBoolean) {
        return null;
    }

    @Override
    public Expression visit(Number number) {
        return null;
    }

    @Override
    public Expression visit(Expression expression) {
        return null;
    }
}
