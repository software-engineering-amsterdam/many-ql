package edu.parser.QL.nodes.expression;

import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.type.Number;

/**
 * Created by Steven Kok on 12/03/2015.
 */
public interface ExpressionVisitor<T extends AbstractNode> {

    T visit(edu.parser.QL.nodes.expression.Addition addition);

    T visit(edu.parser.QL.nodes.expression.And and);

    T visit(edu.parser.QL.nodes.expression.Equal equal);

    T visit(edu.parser.QL.nodes.expression.GreaterOrEqual greaterOrEqual);

    T visit(edu.parser.QL.nodes.expression.GreaterThan greaterThan);

    T visit(QLIdentifier qlIdentifier);

    T visit(edu.parser.QL.nodes.expression.LessOrEqual lessOrEqual);

    T visit(edu.parser.QL.nodes.expression.LessThan lessThan);

    T visit(edu.parser.QL.nodes.expression.Multiplication multiplication);

    T visit(edu.parser.QL.nodes.expression.Not not);

    T visit(edu.parser.QL.nodes.expression.NotEqual notEqual);

    T visit(edu.parser.QL.nodes.expression.Or or);

    T visit(edu.parser.QL.nodes.expression.Division division);

    T visit(edu.parser.QL.nodes.type.Boolean aBoolean);

    T visit(Number number);

    T visit(Expression expression);
}
