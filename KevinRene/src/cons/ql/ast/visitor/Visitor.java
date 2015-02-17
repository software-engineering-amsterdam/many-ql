package cons.ql.ast.visitor;

import cons.ql.ast.expression.arithmetic.Add;
import cons.ql.ast.expression.arithmetic.Div;
import cons.ql.ast.expression.arithmetic.Mul;
import cons.ql.ast.expression.arithmetic.Sub;
import cons.ql.ast.expression.literal.Identifier;
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

public interface Visitor {
	public void visit(Add addNode);	
	public void visit(Div divNode);
	public void visit(Mul mulNode);
	public void visit(Sub subNode);
	
	public void visit(QLBoolean booleanNode);	
	public void visit(QLFloat floatNode);	
	public void visit(QLNumeric numericNode);
	public void visit(Identifier identNode);
	public void visit(QLInteger intNode);
	public void visit(QLString stringNode);
	
	public void visit(And andNode);	
	public void visit(Eq eqNode);
	public void visit(GEq geqNode);
	public void visit(GT gtNode);
	public void visit(LEq leqNode);
	public void visit(LT ltNode);
	public void visit(NEq neqNode);
	public void visit(Or orNode);
	
	public void visit(Neg negNode);
	public void visit(Not notNode);
	public void visit(Pos posNode);
	
	public void visit(Block blockNode);
	public void visit(ComputedQuestion compQuestionNode);
	public void visit(Form formNode);
	public void visit(If ifNode);
	public void visit(Question questionNode);
}
