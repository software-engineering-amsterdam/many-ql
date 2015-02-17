package cons.ql.ast.visitor.typechecker;

import java.util.ArrayList;

import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.arithmetic.*;
import cons.ql.ast.expression.literal.*;
import cons.ql.ast.expression.relational.*;
import cons.ql.ast.expression.unary.*;
import cons.ql.ast.statement.*;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class TypeChecker implements ExpressionVisitor, StatementVisitor {
	private ArrayList<String> errors = new ArrayList<String>();
	
	public ASTNode checkStaticTypes(ASTNode tree) {
		tree.accept(this);
		
		if(!errors.isEmpty()) {
			for(String error : errors) {
				System.out.println("[Error]: " + error);
			}
			
			return null;
		}
		
		return tree;
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
		StatementVisitor.super.visit(compQuestionNode);
		
		
		// TODO: make this way easier.
		if(!compQuestionNode.getType().getClass().getSimpleName().equals(
				compQuestionNode.getExpression().getClass().getSimpleName())) {
			errors.add("<" + compQuestionNode.getIdent() + ">:" 
					+ compQuestionNode.getType().getClass().getSimpleName()
					+ " was assigned with "	
					+ compQuestionNode.getExpression().getClass().getSimpleName() 
					+ ".");
		}
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
}
