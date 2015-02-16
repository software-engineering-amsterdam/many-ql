package cons.ql.ast.visitor;

import cons.ql.ast.Visitor;
import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.Unary;
import cons.ql.ast.expression.arithmetic.*;
import cons.ql.ast.expression.literal.*;
import cons.ql.ast.expression.relational.*;
import cons.ql.ast.expression.unary.*;
import cons.ql.ast.statement.*;

public class TypeChecker implements Visitor {
	@Override
	public void visit(Binary binaryNode) {
		// TODO Auto-generated method stub
		
	}

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
	@SuppressWarnings("rawtypes")
	public void visit(QLType typeNode) {
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
	public void visit(Unary unaryNode) {
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
	public void visit(IfThen ifThenNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Question questionNode) {
		// TODO Auto-generated method stub
		
	}
}
