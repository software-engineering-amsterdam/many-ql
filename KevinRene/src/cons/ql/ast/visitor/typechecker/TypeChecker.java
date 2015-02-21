package cons.ql.ast.visitor.typechecker;

import java.util.ArrayList;

import cons.ql.ast.ASTNode;
import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.Identifier;
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

public class TypeChecker implements ExpressionVisitor<Boolean>, StatementVisitor<Boolean> {
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
		
		// Both types must be numeric
		if (left.getType().compatibleWith(new QLNumeric()) &&
			right.getType().compatibleWith(new QLNumeric())) {
			
			return true;
		}
		else {
			errors.add("<" + op + "> Expected type: " 
					+ op.getType().compatibilities() + ", actual types: "	
					+ left.getType() + " & " + right.getType() + ".");
			
			return false;
		}
	}
	
	private boolean checkBinaryNumericRelationalOperator(Binary op) {
		Expression left = op.getLeft();
		Expression right = op.getRight();
		
		left.accept(this);
		right.accept(this);
		
		// Types of operands must be compatible
		// And they must be compatible to the operator's type
		
		if (left.getType().compatibleWith(right.getType()) &&
				left.getType().compatibleWith(new QLNumeric()) &&
				right.getType().compatibleWith(new QLNumeric())) {
			return true;
		}
		else {
			errors.add("<" + op + "> Expected type: QLNumeric, actual types: "	
					+ left.getType() + " & " + right.getType() + ".");
			
			return false;
		}
	}
	
	private boolean checkBinaryRelationalOperator(Binary op) {
		Expression left = op.getLeft();
		Expression right = op.getRight();
		
		left.accept(this);
		right.accept(this);
		
		// Both operands should be booleans
		if (left.getType().compatibleWith(new QLBoolean()) &&
			right.getType().compatibleWith(new QLBoolean())) {
			return true;
		
		} else {
			errors.add("<" + op.getClass().getSimpleName() + "> Expected type: " 
					+ op.getType().compatibilities() + ", actual types: "	
					+ left.getType() + " & " + right.getType()
					+ ".");
			
			return false;
		}
	}	
	
	/**
	 * OPERATORS 
	 */
	@Override
	public Boolean visit(Add addNode) {
		return checkBinaryNumericOperator(addNode);
	}

	@Override
	public Boolean visit(Div divNode) {
		return checkBinaryNumericOperator(divNode);
	}

	@Override
	public Boolean visit(Mul mulNode) {
		return checkBinaryNumericOperator(mulNode);
	}

	@Override
	public Boolean visit(Sub subNode) {
		return checkBinaryNumericOperator(subNode);
	}
	
	@Override
	public Boolean visit(Neg negNode) {
		negNode.getExpression().accept(this);
		
		// Expression must be a numeric
		if (negNode.getType().compatibleWith(negNode.getExpression().getType())) {
			errors.add("<Not> Expected type: QLNumeric, actual type: " + negNode.getExpression().getType());
		}
		return false;
	}
	
	@Override
	public Boolean visit(Pos posNode) {
		posNode.getExpression().accept(this);
		
		// Expression must be a numeric
		if (posNode.getType().compatibleWith(posNode.getExpression().getType())) {
			errors.add("<Not> Expected type: QLNumeric, actual type: " + posNode.getExpression().getType());
		}
		return false;
		
	}
	
	/**
	 * EQUALITY OPERATORS
	 */
	
	@Override
	public Boolean visit(Eq eqNode) {
		return equalityOperator(eqNode);
	}
	
	@Override
	public Boolean visit(NEq neqNode) {
		return equalityOperator(neqNode);
	}
	
	private boolean equalityOperator(Binary op) {
		Expression left = op.getLeft();
		Expression right = op.getRight();
		
		left.accept(this);
		right.accept(this);
		
		// Both operands should be compatible with eachother	
		if (!left.getType().compatibleWith(right.getType())) {
			
			errors.add("<" + op.getClass().getSimpleName() + "> "
					+ "Expected types to be of " 
					+ op.getLeft().getType().compatibilities() + ", "
					+ "but got: "
					+ op.getLeft().getType() + " & " + op.getRight().getType()
					+ ".");
			return false;
		}
		return true;
	}
	
	/**
	 * Relational operators
	 */

	@Override
	public Boolean visit(GEq geqNode) {
		return checkBinaryNumericRelationalOperator(geqNode);
	}

	@Override
	public Boolean visit(GT gtNode) {
		return checkBinaryNumericRelationalOperator(gtNode);
	}

	@Override
	public Boolean visit(LEq leqNode) {
		return checkBinaryNumericRelationalOperator(leqNode);
	}

	@Override
	public Boolean visit(LT ltNode) {
		return checkBinaryNumericRelationalOperator(ltNode);
	}

	
	@Override
	public Boolean visit(And andNode) {
		return checkBinaryRelationalOperator(andNode);	
	}
	
	@Override
	public Boolean visit(Or orNode) {
		return checkBinaryRelationalOperator(orNode);
	}

	@Override
	public Boolean visit(Not notNode) {
		notNode.getExpression().accept(this);
		
		// Expression must be a Boolean
		if (notNode.getExpression().getType().compatibleWith(new QLBoolean())) {
			errors.add("<Not> Expected type: QLBoolean, actual type: " + notNode.getExpression().getType());
		}
		
		return false;
	}

	/**
	 * Statements
	 */	
	@Override
	public Boolean visit(ComputedQuestion compQuestionNode) {
		StatementVisitor.super.visit(compQuestionNode);
		
		if(!compQuestionNode.getType().compatibleWith(
				compQuestionNode.getExpression().getType())) {

			errors.add("<" + compQuestionNode.getIdentifier() + ">:" 
					+ compQuestionNode.getType() + " was assigned a "
					+ compQuestionNode.getExpression().getType() + ".");
		}
		return false;
	}
	
	@Override
	public Boolean visit(If ifNode) {
		// The expression must have a Boolean type		
		ifNode.getExpression().accept(this);
		
		if (ifNode.getExpression().getType().getClass() != QLBoolean.class) {
			errors.add("Expected QLBoolean, got " + ifNode.getExpression().getType());
		}
		return false;
	}

	@Override
	public Boolean visit(Question questionNode) {
		// Do we allow redeclaration?
		// If not, do a check here
		return false;
	}

}
