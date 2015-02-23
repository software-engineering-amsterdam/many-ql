package cons.ql.ast.visitor.typechecker;

import java.util.ArrayList;
import java.util.stream.Collectors;

import cons.TypeRegister;
import cons.ql.ast.ASTNode;
import cons.ql.ast.Expression;
import cons.ql.ast.expression.Identifier;
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
	
	public QLType getType(Identifier identifier) {
		System.out.println("identifier one");
		return this.register.resolve(identifier);
	}
	
	public QLType getType(Expression expr) {
		System.out.println("expr one");
		return expr.getType();
	}
	
	
	/**
	 * Checks whether the given expression passes the type checker. 
	 * If the types are not compatible with the given compatibleWith type
	 * then an error is added to the errors list.
	 * @param expr
	 * @param compatibleWith The QLType the operands should be compatible with
	 */
	private Void checkExpression(Expression expr, QLType compatibleWith) {
		
		expr.getOperands().stream().forEach(operand -> operand.accept(this));
				
		// Both operands should be compatible with compatibleWith
		if (!isCompatibleWith(expr, compatibleWith)) {
			errors.add(createIncompatibleError(expr, compatibleWith));
		}
		
		return null;
	}
	
	/**
	 * Checks whether the operands of an expression are compatible with the
	 * expected QLType.
	 * @param expr
	 * @param compatibleWith
	 */
	public boolean isCompatibleWith(Expression expr, QLType compatibleWith) {
		
		return expr.getOperands()
				.stream()
				.map(n -> getType(n).compatibleWith(compatibleWith))
				.allMatch(a -> a);
	}
	
	private String createIncompatibleError(Expression expr, QLType compatibleTo) {
		
		// create string of actual types
		String actualTypes = expr.getOperands()
				.stream()
				.map(x -> getType(x).toString())
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
	public Void visit(Add addNode) {
		return checkExpression(addNode, new QLNumeric());
	}

	@Override
	public Void visit(Div divNode) {
		return checkExpression(divNode, new QLNumeric());
	}

	@Override
	public Void visit(Mul mulNode) {
		return checkExpression(mulNode, new QLNumeric());
	}

	@Override
	public Void visit(Sub subNode) {
		return checkExpression(subNode, new QLNumeric());
	}
	
	@Override
	public Void visit(Neg negNode) {
		return checkExpression(negNode, new QLNumeric());
	}
	
	@Override
	public Void visit(Pos posNode) {
		return checkExpression(posNode, new QLNumeric());
	}
	
	/**
	 * EQUALITY OPERATORS
	 * 
	 * The left operand should be compatible with the right one.
	 * So the compatibleWith value is one of the operands' type
	 */
	
	@Override
	public Void visit(Eq eqNode) {
		return checkExpression(eqNode, eqNode.getLeft().getType());
	}
	
	@Override
	public Void visit(NEq neqNode) {
		return checkExpression(neqNode, neqNode.getLeft().getType());
	}
	
	/**
	 * Relational operators
	 */

	@Override
	public Void visit(GEq geqNode) {
		return checkExpression(geqNode, new QLNumeric());
	}

	@Override
	public Void visit(GT gtNode) {
		return checkExpression(gtNode, new QLNumeric());
	}

	@Override
	public Void visit(LEq leqNode) {
		return checkExpression(leqNode, new QLNumeric());
	}

	@Override
	public Void visit(LT ltNode) {
		return checkExpression(ltNode, new QLNumeric());
	}

	
	@Override
	public Void visit(And andNode) {
		return checkExpression(andNode, new QLBoolean());	
	}
	
	@Override
	public Void visit(Or orNode) {
		return checkExpression(orNode, new QLBoolean());
	}

	@Override
	public Void visit(Not notNode) {
		return checkExpression(notNode, new QLBoolean());
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
		// The expression must have a boolean type		
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
		
		System.out.println("Storing questionNode in register");
		register.store(questionNode.getIdentifier(), questionNode.getType());
		System.out.println(register.getBindings());
		
		return null;
	}
}
