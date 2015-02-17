package cons.ql.ast.visitor.typechecker;

import java.util.ArrayList;

import cons.ql.ast.ASTNode;
import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.arithmetic.*;
import cons.ql.ast.expression.relational.*;
import cons.ql.ast.expression.type.*;
import cons.ql.ast.expression.unary.*;
import cons.ql.ast.statement.*;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class TypeChecker implements ExpressionVisitor, StatementVisitor {
	private ArrayList<String> errors = new ArrayList<String>();
	
	// TODO, should take a statement?
	public boolean checkStaticTypes(ASTNode tree) {
		tree.accept(this);
		
		if (!errors.isEmpty()) {
			
			for (String error : errors) {
				System.out.println("[Error]: " + error);
			}
			
			return false;
		}
		
		return true;
	}
		
	private boolean checkBinaryNumericOperator(Binary op) {
		Expression left = op.getLeft();
		Expression right = op.getRight();
		
		left.accept(this);
		right.accept(this);
		
		// Types of operands must be compatible
		// And they must be compatible to the operator's type
		
		if (left.getType().compatibleWith(right.getType()) &&
				op.getType().compatibleWith(left.getType()) &&
				op.getType().compatibleWith(right.getType())) {
			return true;
		}
		else {
			errors.add("<" + op.getClass().getSimpleName() + "> Expected type: " 
					+ op.getType().compatibilities()
					+ ", actual types: "	
					+ left.getType().getName() + " & " + right.getType().getName()
					+ ".");
			
			return false;
		}
	}
	
	private boolean checkBinaryRelationalOperator(Binary op) {
		Expression left = op.getLeft();
		Expression right = op.getRight();
		
		left.accept(this);
		right.accept(this);
		
		// Both operands should be booleans
		
		if (op.getType().compatibleWith(left.getType()) &&
			op.getType().compatibleWith(right.getType())) {
			return true;
		}
		else {
			errors.add("<" + op.getClass().getSimpleName() + "> Expected type: " 
					+ op.getType().compatibilities()
					+ ", actual types: "	
					+ left.getType().getName() + " & " + right.getType().getName()
					+ ".");
			
			return false;
		}
	}
	
	/**
	 * OPERATORS 
	 */
	
	@Override
	public void visit(Add addNode) {
		checkBinaryNumericOperator(addNode);
	}

	@Override
	public void visit(Div divNode) {
		checkBinaryNumericOperator(divNode);
	}

	@Override
	public void visit(Mul mulNode) {
		checkBinaryNumericOperator(mulNode);
	}

	@Override
	public void visit(Sub subNode) {
		checkBinaryNumericOperator(subNode);
	}
	
	@Override
	public void visit(Neg negNode) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void visit(Pos posNode) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Relational operators
	 */
	@Override
	public void visit(And andNode) {
		checkBinaryRelationalOperator(andNode);
		
	}

	@Override
	public void visit(Eq eqNode) {
		
	}

	@Override
	public void visit(GEq geqNode) {
		// Both must be numeric
		
	}

	@Override
	public void visit(GT gtNode) {
		// Both must be numeric
		
	}

	@Override
	public void visit(LEq leqNode) {
		// Both must be numeric
		
	}

	@Override
	public void visit(LT ltNode) {
		// Both must be numeric
		
	}

	@Override
	public void visit(NEq neqNode) {
		
	}

	@Override
	public void visit(Or orNode) {
		checkBinaryRelationalOperator(orNode);		
	}

	@Override
	public void visit(Not notNode) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Statements
	 */
	
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
		// The expression must have a boolean type
		
		ifNode.getExpression().accept(this);
		
		if (ifNode.getExpression().getType().getClass() != QLBoolean.class) {
			errors.add("Expected QLBoolean, got " + ifNode.getExpression().getType().getClass().getSimpleName());
		}
	}

	@Override
	public void visit(Question questionNode) {

		QLIdentifier ident = questionNode.getIdent();
		
		// Do we allow redeclaration?
		// If not, do a check here
		
		
		
	}
	
	/**
	 * Types
	 */

	@Override
	public void visit(QLBoolean booleanNode) {}

	@Override
	public void visit(QLFloat floatNode) {}

	@Override
	public void visit(QLIdentifier identNode) {}

	@Override
	public void visit(QLInteger intNode) {}

	@Override
	public void visit(QLString stringNode) {}

	@Override
	public void visit(QLNumeric numericNode) {}
}
