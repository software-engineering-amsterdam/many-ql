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

	T visit(Pos pos);
	T visit(Not not);
	T visit(Neg neg);
	
	T visit(Identifier identifier);

	T visit(QLString qlString);
	T visit(QLNumeric qlNumeric);
	T visit(QLFloat qlFloat);
	T visit(QLInteger qlInteger);
	T visit(QLBoolean qlBoolean);

	T visit(Or or);
	T visit(NEq nEq);
	T visit(LT lt);
	T visit(LEq lEq);
	T visit(GT gt);
	T visit(GEq gEq);
	T visit(Eq eq);
	T visit(And and);

	T visit(StringLiteral stringLiteral);
	T visit(IntegerLiteral integerLiteral);
	T visit(FloatLiteral floatLiteral);
	T visit(BooleanLiteral booleanLiteral);

	T visit(Add add);
	T visit(Div div);
	T visit(Mul mul);
	T visit(Sub sub);

	T visit(Block block);
	T visit(ComputedQuestion computedQuestion);
	T visit(Question question);
	T visit(If if1);
	T visit(Form form);
}