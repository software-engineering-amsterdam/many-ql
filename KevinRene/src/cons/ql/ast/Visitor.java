package cons.ql.ast;

import cons.ql.ast.expression.*;
import cons.ql.ast.expression.arithmetic.*;
import cons.ql.ast.expression.literal.*;
import cons.ql.ast.expression.relational.*;
import cons.ql.ast.expression.unary.*;
import cons.ql.ast.statement.*;

public interface Visitor {
	public void visit(Binary binaryNode);
	public void visit(Add addNode);	
	public void visit(Div divNode);
	public void visit(Mul divNode);
	public void visit(Sub divNode);
	
	@SuppressWarnings("rawtypes")
	public void visit(QLType typeNode);
	public void visit(QLBoolean booleanNode);	
	public void visit(QLFloat floatNode);
	public void visit(QLIdent identNode);
	public void visit(QLInt intNode);
	public void visit(QLString stringNode);
	
	public void visit(And andNode);	
	public void visit(Eq eqNode);
	public void visit(GEq geqNode);
	public void visit(GT gtNode);
	public void visit(LEq leqNode);
	public void visit(LT ltNode);
	public void visit(NEq neqNode);
	public void visit(Or orNode);
	
	public void visit(Unary unaryNode);
	public void visit(Neg negNode);
	public void visit(Not notNode);
	public void visit(Pos posNode);
	
	public void visit(Block blockNode);
	public void visit(ComputedQuestion compQuestionNode);
	public void visit(Form formNode);
	public void visit(IfThen ifThenNode);
	public void visit(Question questionNode);
}
