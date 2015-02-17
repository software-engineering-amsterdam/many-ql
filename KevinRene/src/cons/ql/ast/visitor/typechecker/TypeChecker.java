package cons.ql.ast.visitor.typechecker;

import java.util.ArrayList;
import java.util.List;

import cons.ql.ast.ASTNode;
import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;
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

		QLIdent ident = questionNode.getIdent();
		
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
	public void visit(QLIdent identNode) {}

	@Override
	public void visit(QLInt intNode) {}

	@Override
	public void visit(QLString stringNode) {}

	@Override
	public void visit(QLNumeric numericNode) {}
}
