package cons.ql.ast.visitor.typechecker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cons.TypeRegister;
import cons.ql.ast.ASTNode;
import cons.ql.ast.Expression;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.arithmetic.Add;
import cons.ql.ast.expression.arithmetic.Div;
import cons.ql.ast.expression.arithmetic.Mul;
import cons.ql.ast.expression.arithmetic.Neg;
import cons.ql.ast.expression.arithmetic.Pos;
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
import cons.ql.ast.expression.relational.Not;
import cons.ql.ast.expression.relational.Or;
import cons.ql.ast.expression.type.QLBoolean;
import cons.ql.ast.expression.type.QLError;
import cons.ql.ast.expression.type.QLFloat;
import cons.ql.ast.expression.type.QLInteger;
import cons.ql.ast.expression.type.QLNumeric;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.statement.If;
import cons.ql.ast.statement.Question;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class TypeChecker implements ExpressionVisitor<QLType>, StatementVisitor<QLType> {
	private ArrayList<String> errors = new ArrayList<String>();
	private TypeRegister register;
	
	public TypeChecker(TypeRegister register) {
		this.register = register;
	}
	
	/**
	 * Entry point, static type checks the supplied tree
	 * @return a boolean indicating pass or fail
	 */
	public boolean check(ASTNode tree) {
		tree.accept(this);
		
		if (!errors.isEmpty()) {
			for (String error : errors) {
				System.out.println("[Error]: " + error);
			}
			
			errors.clear();
			return false;
		}
		
		return true;
	}	
	
	/**
	 * Checks whether the given expression passes the type checker. 
	 * If the types are not compatible with the given compatibleWith type
	 * then an error is added to the errors list.
	 * @param expr
	 * @param compatibleWith The QLType the operands should be compatible with
	 */
	private QLType checkExpression(Expression expr, QLType compatibleWith) {
		
		List<QLType> operandTypes = expr.getOperands()
				.stream()
				.map(operand -> operand.accept(this))
				.collect(Collectors.toList());
				
		// Both operands should be compatible with compatibleWith
		if (!isCompatibleWith(operandTypes, compatibleWith)) {
			errors.add(createIncompatibleError(expr, operandTypes, compatibleWith));
		}
		
		return expr.getType();
	}
	
	/**
	 * Checks whether the operands of an expression are compatible with the
	 * expected QLType.
	 * @param expr
	 * @param compatibleWith
	 */
	public boolean isCompatibleWith(List<QLType> operandTypes, QLType compatibleWith) {
		
		return operandTypes
				.stream()
				.map(n -> n.compatibleWith(compatibleWith))
				.allMatch(a -> a);
	}
	
	private String createIncompatibleError(
			Expression expr, List<QLType> operandTypes, QLType compatibleTo) {
		
		// create string of actual types
		String actualTypes = operandTypes
				.stream()
				.map(x -> x.toString())
				.collect(Collectors.joining(" & "));
		
		return "<" + expr.getClass().getSimpleName() + "> Expected type: " 
				+ compatibleTo.compatibilities() + ", actual types: "	
				+ actualTypes
				+ ".";
	}
	
	/**
	 * OPERATORS 
	 */
	@Override
	public QLType visit(Add addNode) {
		return checkExpression(addNode, new QLNumeric());
	}

	@Override
	public QLType visit(Div divNode) {
		return checkExpression(divNode, new QLNumeric());
	}

	@Override
	public QLType visit(Mul mulNode) {
		return checkExpression(mulNode, new QLNumeric());
	}

	@Override
	public QLType visit(Sub subNode) {
		return checkExpression(subNode, new QLNumeric());
	}
	
	@Override
	public QLType visit(Neg negNode) {
		return checkExpression(negNode, new QLNumeric());
	}
	
	@Override
	public QLType visit(Pos posNode) {
		return checkExpression(posNode, new QLNumeric());
	}
	
	/**
	 * EQUALITY OPERATORS
	 * 
	 * The left operand should be compatible with the right one.
	 * So the compatibleWith value is one of the operands' type
	 */
	
	@Override
	public QLType visit(Eq eqNode) {
		return checkExpression(eqNode, eqNode.getLeft().getType());
	}
	
	@Override
	public QLType visit(NEq neqNode) {
		return checkExpression(neqNode, neqNode.getLeft().getType());
	}
	
	/**
	 * Relational operators
	 */

	@Override
	public QLType visit(GEq geqNode) {
		return checkExpression(geqNode, new QLNumeric());
	}

	@Override
	public QLType visit(GT gtNode) {
		return checkExpression(gtNode, new QLNumeric());
	}

	@Override
	public QLType visit(LEq leqNode) {
		return checkExpression(leqNode, new QLNumeric());
	}

	@Override
	public QLType visit(LT ltNode) {
		return checkExpression(ltNode, new QLNumeric());
	}

	
	@Override
	public QLType visit(And andNode) {
		return checkExpression(andNode, new QLBoolean());	
	}
	
	@Override
	public QLType visit(Or orNode) {
		return checkExpression(orNode, new QLBoolean());
	}

	@Override
	public QLType visit(Not notNode) {
		return checkExpression(notNode, new QLBoolean());
	}
	
	/**
	 * Types
	 */
	
	public QLType visit(QLBoolean booleanNode) { return booleanNode.getType(); }
	public QLType visit(QLFloat floatNode) 		{ return floatNode.getType(); }    
	public QLType visit(QLNumeric numericNode) 	{ return numericNode.getType(); }
	public QLType visit(QLInteger intNode) 		{ return intNode.getType(); }
	public QLType visit(QLString stringNode) 	{ return stringNode.getType(); }
	public QLType visit(QLError errNode)		{ return errNode.getType(); }
	
	public QLType visit(BooleanLiteral booleanNode) {	return booleanNode.getType();}	
	public QLType visit(FloatLiteral floatNode) {		return floatNode.getType();}
	public QLType visit(IntegerLiteral intNode) {		return intNode.getType();}
	public QLType visit(StringLiteral stringNode) {		return stringNode.getType();}
	
	public QLType visit(Identifier identifier) {
		return this.register.resolve(identifier);
	}

	/**
	 * Statements
	 */	
	@Override
	public QLType visit(ComputedQuestion compQuestionNode) {
		StatementVisitor.super.visit(compQuestionNode);
		
		if(!compQuestionNode.getType().compatibleWith(
				compQuestionNode.getExpression().getType())) {

			errors.add("<" + compQuestionNode.getIdentifier() + ">:" 
					+ compQuestionNode.getType() + " was assigned a "
					+ compQuestionNode.getExpression().getType() + ".");
		}
		return new QLError();
	}
	
	@Override
	public QLType visit(If ifNode) {
		// The expression must have a boolean type		
		ifNode.getExpression().accept(this);
		
		if (ifNode.getExpression().getType().getClass() != QLBoolean.class) {
			errors.add("Expected QLBoolean, got " + ifNode.getExpression().getType());
		}
		return new QLError();
	}

	@Override
	public QLType visit(Question questionNode) {
		// Do we allow redeclaration?
		// If not, do a check here
		
		register.store(questionNode.getIdentifier(), questionNode.getType());
		
		return new QLError();
	}
}
