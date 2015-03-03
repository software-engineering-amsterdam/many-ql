package ql.ast.visitor;

import ql.ast.expression.Identifier;
import ql.ast.expression.arithmetic.Add;
import ql.ast.expression.arithmetic.Div;
import ql.ast.expression.arithmetic.Mul;
import ql.ast.expression.arithmetic.Neg;
import ql.ast.expression.arithmetic.Pos;
import ql.ast.expression.arithmetic.Sub;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.relational.And;
import ql.ast.expression.relational.Eq;
import ql.ast.expression.relational.GEq;
import ql.ast.expression.relational.GT;
import ql.ast.expression.relational.LEq;
import ql.ast.expression.relational.LT;
import ql.ast.expression.relational.NEq;
import ql.ast.expression.relational.Not;
import ql.ast.expression.relational.Or;
import ql.ast.expression.type.QLBoolean;
import ql.ast.expression.type.QLError;
import ql.ast.expression.type.QLFloat;
import ql.ast.expression.type.QLForm;
import ql.ast.expression.type.QLInteger;
import ql.ast.expression.type.QLNumeric;
import ql.ast.expression.type.QLString;
import ql.ast.statement.Block;
import ql.ast.statement.ComputedQuestion;
import ql.ast.statement.Form;
import ql.ast.statement.If;
import ql.ast.statement.IfElse;
import ql.ast.statement.Question;

public interface Visitor<T> {
	public T visit(Pos pos);
	public T visit(Not not);
	public T visit(Neg neg);
	
	public T visit(Identifier identifier);

	public T visit(QLString qlString);
	public T visit(QLNumeric qlNumeric);
	public T visit(QLFloat qlFloat);
	public T visit(QLForm qlForm);
	public T visit(QLInteger qlInteger);
	public T visit(QLBoolean qlBoolean);
	public T visit(QLError qlError);

	public T visit(Or or);
	public T visit(NEq nEq);
	public T visit(LT lt);
	public T visit(LEq lEq);
	public T visit(GT gt);
	public T visit(GEq gEq);
	public T visit(Eq eq);
	public T visit(And and);

	public T visit(StringLiteral stringLiteral);
	public T visit(IntegerLiteral integerLiteral);
	public T visit(FloatLiteral floatLiteral);
	public T visit(BooleanLiteral booleanLiteral);

	public T visit(Add add);
	public T visit(Div div);
	public T visit(Mul mul);
	public T visit(Sub sub);

	public T visit(Block block);
	public T visit(ComputedQuestion computedQuestion);
	public T visit(Question question);
	public T visit(If ifThen);
	public T visit(IfElse ifElse);
	public T visit(Form form);
}