package nl.uva.sc.encoders.ql.visitor;

import nl.uva.sc.encoders.ql.ast.operator.AddOperator;
import nl.uva.sc.encoders.ql.ast.operator.AndOperator;
import nl.uva.sc.encoders.ql.ast.operator.DivideOperator;
import nl.uva.sc.encoders.ql.ast.operator.GreaterOrEqualOperator;
import nl.uva.sc.encoders.ql.ast.operator.GreaterThanOperator;
import nl.uva.sc.encoders.ql.ast.operator.LessOrEqualOperator;
import nl.uva.sc.encoders.ql.ast.operator.LessThanOperator;
import nl.uva.sc.encoders.ql.ast.operator.MultiplyOperator;
import nl.uva.sc.encoders.ql.ast.operator.OrOperator;
import nl.uva.sc.encoders.ql.ast.operator.SubstractOperator;

public interface BinaryOperatorVisitor<T> {

	T visit(AddOperator operator);

	T visit(AndOperator operator);

	T visit(DivideOperator operator);

	T visit(GreaterOrEqualOperator operator);

	T visit(GreaterThanOperator operator);

	T visit(LessOrEqualOperator operator);

	T visit(MultiplyOperator operator);

	T visit(OrOperator operator);

	T visit(SubstractOperator operator);

	T visit(LessThanOperator lessThanOperator);
}
