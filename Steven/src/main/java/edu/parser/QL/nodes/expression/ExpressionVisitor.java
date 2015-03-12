package edu.parser.QL.nodes.expression;

import edu.parser.QL.nodes.type.Number;

/**
 * Created by Steven Kok on 12/03/2015.
 */
public interface ExpressionVisitor {

    Expression visit(edu.parser.QL.nodes.expression.Addition addition);

    Expression visit(edu.parser.QL.nodes.expression.And and);

    Expression visit(edu.parser.QL.nodes.expression.Equal equal);

    Expression visit(edu.parser.QL.nodes.expression.GreaterOrEqual greaterOrEqual);

    Expression visit(edu.parser.QL.nodes.expression.GreaterThan greaterThan);

    Expression visit(QLIdentifier QLIdentifier);

    Expression visit(edu.parser.QL.nodes.expression.LessOrEqual lessOrEqual);

    Expression visit(edu.parser.QL.nodes.expression.LessThan lessThan);

    Expression visit(edu.parser.QL.nodes.expression.Multiplication multiplication);

    Expression visit(edu.parser.QL.nodes.expression.Not not);

    Expression visit(edu.parser.QL.nodes.expression.NotEqual notEqual);

    Expression visit(edu.parser.QL.nodes.expression.Or or);

    Expression visit(edu.parser.QL.nodes.expression.Division division);

    Expression visit(edu.parser.QL.nodes.type.Boolean aBoolean);

    Expression visit(Number number);

    Expression visit(Expression expression);
}
