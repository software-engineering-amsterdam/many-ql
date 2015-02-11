package cons.ql.ast;

import cons.ql.ast.expression.arithmetic.*;
import cons.ql.ast.expression.literal.*;
import cons.ql.ast.expression.relational.*;
import cons.ql.ast.expression.unary.*;
import cons.ql.ast.statement.*;

public interface Visitor {
	public void visitAdd(Add addNode);	
	public void visitDiv(Div divNode);
	public void visitMul(Mul divNode);
	public void visitSub(Sub divNode);
	
	public void visitQLBoolean(QLBoolean booleanNode);	
	public void visitQLFloat(QLFloat floatNode);
	public void visitQLIdent(QLIdent identNode);
	public void visitQLInt(QLInt intNode);
	public void visitQLString(QLString stringNode);
	
	public void visitAnd(And andNode);	
	public void visitEq(Eq eqNode);
	public void visitGEq(GEq geqNode);
	public void visitGT(GT gtNode);
	public void visitLEq(LEq leqNode);
	public void visitLT(LT ltNode);
	public void visitNEq(NEq neqNode);
	public void visitOr(Or orNode);
	
	public void visitNeg(Neg negNode);
	public void visitNot(Not notNode);
	public void visitPos(Pos posNode);
	
	public void visitBlock(Block blockNode);
	public void visitComputedQuestion(ComputedQuestion compQuestionNode);
	public void visitForm(Form formNode);
	public void visitIfThen(IfThen ifThenNode);
	public void visitQuestion(Question questionNode);
}
