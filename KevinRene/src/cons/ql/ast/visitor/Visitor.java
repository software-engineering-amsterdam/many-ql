package cons.ql.ast.visitor;

import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.Unary;
import cons.ql.ast.expression.arithmetic.*;
import cons.ql.ast.expression.literal.*;
import cons.ql.ast.expression.relational.*;
import cons.ql.ast.expression.type.*;
import cons.ql.ast.expression.unary.*;
import cons.ql.ast.statement.*;

public interface Visitor {
	public void visit(Unary unaryNode);
	public void visit(Binary binaryNode);
	
	public void visit(Identifier identNode);	
    
    public void visit(QLBoolean booleanNode);	
	public void visit(QLFloat floatNode);
	public void visit(QLInteger intNode);
	public void visit(QLNumeric numericNode);
	public void visit(QLString stringNode);
	
	public void visit(BooleanLiteral booleanNode);	
	public void visit(FloatLiteral floatNode);
	public void visit(IntegerLiteral intNode);
	public void visit(StringLiteral stringNode);
	
	public void visit(Add addNode);	
	public void visit(Div divNode);
	public void visit(Mul mulNode);
	public void visit(Sub subNode);
	
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
