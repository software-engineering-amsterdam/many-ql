package org.uva.ql.visitor;

import org.uva.ql.ast.expression.association.Parenthesis;
import org.uva.ql.ast.expression.binary.Addition;
import org.uva.ql.ast.expression.binary.And;
import org.uva.ql.ast.expression.binary.Divide;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.binary.Greater;
import org.uva.ql.ast.expression.binary.GreaterEqual;
import org.uva.ql.ast.expression.binary.Less;
import org.uva.ql.ast.expression.binary.LessEqual;
import org.uva.ql.ast.expression.binary.Multiply;
import org.uva.ql.ast.expression.binary.NotEqual;
import org.uva.ql.ast.expression.binary.Or;
import org.uva.ql.ast.expression.binary.Substraction;
import org.uva.ql.ast.expression.literal.BoolLiteral;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.ast.expression.unary.Negative;
import org.uva.ql.ast.expression.unary.Not;
import org.uva.ql.ast.expression.unary.Positive;

public interface ExpressionVisitor<T> {

	public T visit(Not node);

	public T visit(Positive node);

	public T visit(Negative node);

	public T visit(Addition node);

	public T visit(Substraction node);

	public T visit(Multiply node);

	public T visit(Divide node);

	public T visit(And node);

	public T visit(Or node);

	public T visit(Equal node);

	public T visit(NotEqual node);

	public T visit(Greater node);

	public T visit(GreaterEqual node);

	public T visit(Less node);

	public T visit(LessEqual node);

	public T visit(Identifier node);

	public T visit(IntLiteral node);

	public T visit(BoolLiteral node);

	public T visit(StrLiteral node);

	public T visit(Parenthesis node);

}
