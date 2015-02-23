package cons.ql.ast.visitor.evaluator;

import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.Literal;
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
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

@SuppressWarnings("rawtypes")
public class Evaluator implements ExpressionVisitor<Literal>, StatementVisitor<Literal> {

	@Override
	public Literal visit(Block block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(ComputedQuestion computedQuestion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(If if1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(Form form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(Pos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(Not not) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(Neg neg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(Identifier identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(QLString qlString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(QLNumeric qlNumeric) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(QLFloat qlFloat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(QLInteger qlInteger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(QLBoolean qlBoolean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(QLError qlError) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(Or or) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(NEq nEq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(LT lt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(LEq lEq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(GT gt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(GEq gEq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(Eq eq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(And and) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(StringLiteral stringLiteral) {
		return stringLiteral;
	}

	@Override
	public Literal visit(IntegerLiteral integerLiteral) {
		return integerLiteral;
	}

	@Override
	public Literal visit(FloatLiteral floatLiteral) {
		return floatLiteral;
	}

	@Override
	public Literal visit(BooleanLiteral booleanLiteral) {
		return booleanLiteral;
	}

	@Override
	public Literal visit(Add add) {
		Literal leftValue = add.getLeft().accept(this);
		Literal rightValue = add.getRight().accept(this);
		
		return leftValue.add(rightValue);
	}

	@Override
	public Literal visit(Div div) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(Mul mul) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Literal visit(Sub sub) {
		// TODO Auto-generated method stub
		return null;
	}	
}
