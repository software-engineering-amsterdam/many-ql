package cons.ql.ast.visitor.typechecker;

import java.util.ArrayList;

import cons.ql.ast.ASTNode;
import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.QLType;
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
import cons.ql.ast.expression.type.QLNumeric;
import cons.ql.ast.expression.unary.Neg;
import cons.ql.ast.expression.unary.Not;
import cons.ql.ast.expression.unary.Pos;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.statement.If;
import cons.ql.ast.statement.Question;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class TypeChecker implements ExpressionVisitor<Void>, StatementVisitor<Void> {
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
	
	private boolean isCompatible(Binary op, QLType compatibleTo) {
		return op.getLeft().getType().compatibleWith(compatibleTo) &&
		op.getRight().getType().compatibleWith(compatibleTo);
	}
	
	private Void checkBinary(Binary op, QLType compatibleTo) {
		Expression left = op.getLeft();
		Expression right = op.getRight();
		
		left.accept(this);
		right.accept(this);
		
		// Both operands should be compatible with compatibleTo
		if (!isCompatible(op, compatibleTo)) {
		
			errors.add("<" + op.getClass().getSimpleName() + "> Expected type: " 
					+ op.getType().compatibilities() + ", actual types: "	
					+ left.getType() + " & " + right.getType()
					+ ".");
		}
		
		return null;
	}
	
	/**
	 * OPERATORS 
	 */
	@Override
	public Void visit(Add addNode) {
		return checkBinary(addNode, new QLNumeric());
	}

	@Override
	public Void visit(Div divNode) {
		return checkBinary(divNode, new QLNumeric());
	}

	@Override
	public Void visit(Mul mulNode) {
		return checkBinary(mulNode, new QLNumeric());
	}

	@Override
	public Void visit(Sub subNode) {
		return checkBinary(subNode, new QLNumeric());
	}
	
	@Override
	public Void visit(Neg negNode) {
		negNode.getExpression().accept(this);
		
		// Expression must be a numeric
		if (negNode.getType().compatibleWith(negNode.getExpression().getType())) {
			errors.add("<Not> Expected type: QLNumeric, actual type: " + negNode.getExpression().getType());
		}
		return null;
	}
	
	@Override
	public Void visit(Pos posNode) {
		posNode.getExpression().accept(this);
		
		// Expression must be a numeric
		if (posNode.getType().compatibleWith(posNode.getExpression().getType())) {
			errors.add("<Not> Expected type: QLNumeric, actual type: " + posNode.getExpression().getType());
		}
		return null;
	}
	
	/**
	 * EQUALITY OPERATORS
	 */
	
	@Override
	public Void visit(Eq eqNode) {
		return equalityOperator(eqNode);
	}
	
	@Override
	public Void visit(NEq neqNode) {
		return equalityOperator(neqNode);
	}
	
	private Void equalityOperator(Binary op) {
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
		}
		return null;
	}
	
	/**
	 * Relational operators
	 */

	@Override
	public Void visit(GEq geqNode) {
		return checkBinary(geqNode, new QLNumeric());
	}

	@Override
	public Void visit(GT gtNode) {
		return checkBinary(gtNode, new QLNumeric());
	}

	@Override
	public Void visit(LEq leqNode) {
		return checkBinary(leqNode, new QLNumeric());
	}

	@Override
	public Void visit(LT ltNode) {
		return checkBinary(ltNode, new QLNumeric());
	}

	
	@Override
	public Void visit(And andNode) {
		return checkBinary(andNode, new QLBoolean());	
	}
	
	@Override
	public Void visit(Or orNode) {
		return checkBinary(orNode, new QLBoolean());
	}

	@Override
	public Void visit(Not notNode) {
		notNode.getExpression().accept(this);
		
		// Expression must be a boolean
		if (notNode.getExpression().getType().compatibleWith(new QLBoolean())) {
			errors.add("<Not> Expected type: QLBoolean, actual type: " + notNode.getExpression().getType());
		}
		
		return null;
	}

	/**
	 * Statements
	 */	
	@Override
	public Void visit(ComputedQuestion compQuestionNode) {
		StatementVisitor.super.visit(compQuestionNode);
		
		if(!compQuestionNode.getType().compatibleWith(
				compQuestionNode.getExpression().getType())) {

			errors.add("<" + compQuestionNode.getIdentifier() + ">:" 
					+ compQuestionNode.getType() + " was assigned a "
					+ compQuestionNode.getExpression().getType() + ".");
		}
		return null;
	}
	
	@Override
	public Void visit(If ifNode) {
		// The expression must have a Void type		
		ifNode.getExpression().accept(this);
		
		if (ifNode.getExpression().getType().getClass() != QLBoolean.class) {
			errors.add("Expected QLBoolean, got " + ifNode.getExpression().getType());
		}
		return null;
	}

	@Override
	public Void visit(Question questionNode) {
		// Do we allow redeclaration?
		// If not, do a check here
		return null;
	}

}
