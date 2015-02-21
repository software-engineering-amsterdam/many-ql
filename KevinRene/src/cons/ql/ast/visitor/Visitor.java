package cons.ql.ast.visitor;

import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.arithmetic.Add;
import cons.ql.ast.expression.arithmetic.Div;
import cons.ql.ast.expression.arithmetic.Mul;
import cons.ql.ast.expression.arithmetic.Sub;
import cons.ql.ast.expression.literal.BooleanLiteral;
import cons.ql.ast.expression.literal.FloatLiteral;
import cons.ql.ast.expression.literal.IntegerLiteral;
import cons.ql.ast.expression.literal.StringLiteral;
import cons.ql.ast.expression.relational.And;
import cons.ql.ast.expression.relational.Eq;
import cons.ql.ast.expression.relational.GEq;
import cons.ql.ast.expression.relational.GT;
import cons.ql.ast.expression.relational.LEq;
import cons.ql.ast.expression.relational.LT;
import cons.ql.ast.expression.relational.NEq;
import cons.ql.ast.expression.relational.Or;
import cons.ql.ast.expression.type.QLBoolean;
import cons.ql.ast.expression.type.QLError;
import cons.ql.ast.expression.type.QLFloat;
import cons.ql.ast.expression.type.QLInteger;
import cons.ql.ast.expression.type.QLNumeric;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.expression.unary.Neg;
import cons.ql.ast.expression.unary.Not;
import cons.ql.ast.expression.unary.Pos;
import cons.ql.ast.statement.Block;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.statement.Form;
import cons.ql.ast.statement.If;
import cons.ql.ast.statement.Question;

public interface Visitor<T> {

	public T visit(Pos pos);
	public T visit(Not not);
	public T visit(Neg neg);
	
	public T visit(Identifier identifier);

	public T visit(QLString qlString);
	public T visit(QLNumeric qlNumeric);
	public T visit(QLFloat qlFloat);
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
	public T visit(If if1);
	public T visit(Form form);
}