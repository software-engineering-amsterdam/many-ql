package cons.ql.ast.visitor.evaluator;

import cons.ql.ast.expression.arithmetic.Add;
import cons.ql.ast.expression.arithmetic.Div;
import cons.ql.ast.expression.arithmetic.Mul;
import cons.ql.ast.expression.arithmetic.Sub;
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
import cons.ql.ast.expression.type.QLIdent;
import cons.ql.ast.expression.type.QLInt;
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

public class Evaluator implements ExpressionVisitor, StatementVisitor  {

	@Override
	public void visit(Add addNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Div divNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Mul divNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Sub divNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(And andNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Eq eqNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(GEq geqNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(GT gtNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LEq leqNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LT ltNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NEq neqNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Or orNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Block blockNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ComputedQuestion compQuestionNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Form formNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(If ifNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Question questionNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(QLBoolean booleanNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(QLFloat floatNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(QLIdent identNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(QLInt intNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(QLString stringNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Neg negNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Not notNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Pos posNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(QLNumeric numericNode) {
		// TODO Auto-generated method stub
		
	}
}
