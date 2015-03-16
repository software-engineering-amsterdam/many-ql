package org.uva.sea.ql.encoders.visitor;

import org.uva.sea.ql.encoders.ast.operator.AddOperator;
import org.uva.sea.ql.encoders.ast.operator.AndOperator;
import org.uva.sea.ql.encoders.ast.operator.DivideOperator;
import org.uva.sea.ql.encoders.ast.operator.GreaterOrEqualOperator;
import org.uva.sea.ql.encoders.ast.operator.GreaterThanOperator;
import org.uva.sea.ql.encoders.ast.operator.LessOrEqualOperator;
import org.uva.sea.ql.encoders.ast.operator.LessThanOperator;
import org.uva.sea.ql.encoders.ast.operator.MultiplyOperator;
import org.uva.sea.ql.encoders.ast.operator.OrOperator;
import org.uva.sea.ql.encoders.ast.operator.SubstractOperator;

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
