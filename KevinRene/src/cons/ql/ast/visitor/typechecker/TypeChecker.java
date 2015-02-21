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
import cons.ql.ast.expression.type.QLFloat;
import cons.ql.ast.expression.type.QLInteger;
import cons.ql.ast.expression.type.QLNumeric;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.expression.unary.Neg;
import cons.ql.ast.expression.unary.Not;
import cons.ql.ast.expression.unary.Pos;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.statement.If;
import cons.ql.ast.statement.Question;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class TypeChecker implements ExpressionVisitor<Object>, StatementVisitor<Object> {
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
			errors.add("<" + op.getType() + "> Expected type: " 
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
			errors.add("<" + op.getType() + "> Expected type: QLNumeric, actual types: "	
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
		if (op.getType().compatibleWith(left.getType()) &&
			op.getType().compatibleWith(right.getType())) {
			return true;
		} else {
			errors.add("<" + op.getClass().getSimpleName() + "> Expected type: " 
					+ op.getType().compatibilities() + ", actual types: "	
					+ left.getType() + " & " + right.getType()
					+ ".");
			
			return false;
		}
	}
	
	@Override
	public Void visit(Identifier identNode) {
		return null; 
	}
	
	/**
	 * Types
	 */

	
	/**
	 * OPERATORS 
	 */
	@Override
	public Void visit(Add addNode) {
		checkBinaryNumericOperator(addNode);
		return null;
	}

	@Override
	public Void visit(Div divNode) {
		checkBinaryNumericOperator(divNode);
		return null;
	}

	@Override
	public Void visit(Mul mulNode) {
		checkBinaryNumericOperator(mulNode);
		return null;
	}

	@Override
	public Void visit(Sub subNode) {
		checkBinaryNumericOperator(subNode);
		return null;
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
	 * Relational operators
	 */
	@Override
	public Void visit(And andNode) {
		checkBinaryRelationalOperator(andNode);
		return null;	
	}

	@Override
	public Void visit(Eq eqNode) {
		Expression left = eqNode.getLeft();
		Expression right = eqNode.getRight();
		
		left.accept(this);
		right.accept(this);
		
		// Both operands should be compatible with eachother	
		if (!(right.getType().compatibleWith(left.getType()) &&
			left.getType().compatibleWith(right.getType()))) {
			
			errors.add("<" + left.getClass().getSimpleName() + "> Expected type: " 
					+ left.getType().compatibilities() + ", actual types: "	
					+ left.getType() + " & " + right.getType()
					+ ".");
		}
		return null;
	}

	@Override
	public Void visit(GEq geqNode) {
		checkBinaryNumericRelationalOperator(geqNode);
		return null;
	}

	@Override
	public Void visit(GT gtNode) {
		checkBinaryNumericRelationalOperator(gtNode);
		return null;
	}

	@Override
	public Void visit(LEq leqNode) {
		checkBinaryNumericRelationalOperator(leqNode);
		return null;
	}

	@Override
	public Void visit(LT ltNode) {
		checkBinaryNumericRelationalOperator(ltNode);
		return null;
	}

	@Override
	public Void visit(NEq neqNode) {
		Expression left = neqNode.getLeft();
		Expression right = neqNode.getRight();
		
		left.accept(this);
		right.accept(this);
		
		// Both operands should be compatible with eachother	
		if (!(right.getType().compatibleWith(left.getType()) &&
			left.getType().compatibleWith(right.getType()))) {
			
			errors.add("<" + left.getClass().getSimpleName() + "> Expected type: " 
					+ left.getType().compatibilities() + ", actual types: "	
					+ left.getType() + " & " + right.getType()
					+ ".");
		}
		return null;
	}

	@Override
	public Void visit(Or orNode) {
		checkBinaryRelationalOperator(orNode);
		return null;
	}

	@Override
	public Void visit(Not notNode) {
		notNode.getExpression().accept(this);
		
		// Expression must be a Void
		if (notNode.getType().compatibleWith(notNode.getExpression().getType())) {
			errors.add("<Not> Expected type: QLBoolean, actual type: " + notNode.getExpression().getType());
		}
		
		return null;
	}

	/**
	 * Statements
	 */	
	// Use default method
	// @Override
	// public void visit(Block blockNode) {}

	@Override
	public Void visit(ComputedQuestion compQuestionNode) {
		StatementVisitor.super.visit(compQuestionNode);
				
		// TODO: make this way easier.
		if(!compQuestionNode.getType().toString().equals(
				compQuestionNode.getExpression().toString())) {

			errors.add("<" + compQuestionNode.getIdentifier() + ">:" 
					+ compQuestionNode.getType() + " was assigned a "
					+ compQuestionNode.getExpression().getType() + ".");
		}
		return null;
	}
	
	// Use the default method
	// @Override
	// public void visit(Form formNode) {}

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
		// Identifier identifier = questionNode.getIdent();
		
		// Do we allow redeclaration?
		// If not, do a check here
		
		return null;
	}

	@Override
	public Void visit(QLString qlString) {
		return null;
	}

	@Override
	public Void visit(QLNumeric qlNumeric) {
		return null;
	}

	@Override
	public Void visit(QLFloat qlFloat) {
		return null;
	}

	@Override
	public Void visit(QLInteger qlInteger) {
		return null;
	}

	@Override
	public Void visit(QLBoolean qlBoolean) {
		return null;
	}

	@Override
	public Void visit(StringLiteral stringLiteral) {
		return null;
	}

	@Override
	public Void visit(IntegerLiteral integerLiteral) {
		return null;
	}

	@Override
	public Void visit(FloatLiteral floatLiteral) {
		return null;
	}

	@Override
	public Void visit(BooleanLiteral booleanLiteral) {
		return null;
	}
}
