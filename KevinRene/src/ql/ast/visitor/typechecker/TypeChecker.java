package ql.ast.visitor.typechecker;

import java.util.List;
import java.util.stream.Collectors;

import ql.TypeEnvironment;
import ql.ast.Expression;
import ql.ast.QLType;
import ql.ast.Statement;
import ql.ast.expression.Identifier;
import ql.ast.expression.arithmetic.Add;
import ql.ast.expression.arithmetic.Divide;
import ql.ast.expression.arithmetic.Multiply;
import ql.ast.expression.arithmetic.Negation;
import ql.ast.expression.arithmetic.Positive;
import ql.ast.expression.arithmetic.Subtract;
import ql.ast.expression.booleanalgebra.And;
import ql.ast.expression.booleanalgebra.Not;
import ql.ast.expression.booleanalgebra.Or;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.relational.Equal;
import ql.ast.expression.relational.Greater;
import ql.ast.expression.relational.GreaterOrEqual;
import ql.ast.expression.relational.Lower;
import ql.ast.expression.relational.LowerOrEqual;
import ql.ast.expression.relational.NotEqual;
import ql.ast.statement.Block;
import ql.ast.statement.ComputedQuestion;
import ql.ast.statement.Form;
import ql.ast.statement.If;
import ql.ast.statement.IfElse;
import ql.ast.statement.Question;
import ql.ast.type.QLBoolean;
import ql.ast.type.QLError;
import ql.ast.type.QLFloat;
import ql.ast.type.QLForm;
import ql.ast.type.QLInteger;
import ql.ast.type.QLNumeric;
import ql.ast.type.QLString;
import ql.ast.visitor.ExpressionVisitor;
import ql.ast.visitor.StatementVisitor;
import ql.ast.visitor.TypeVisitor;
import ql.errorhandling.ErrorEnvironment;
import ql.errorhandling.error.IllegalAssignmentError;
import ql.errorhandling.error.RedefinedVariableError;
import ql.errorhandling.error.TypeError;
import ql.errorhandling.error.UndefinedVariableError;

public class TypeChecker extends StatementVisitor<Void> implements ExpressionVisitor<QLType>, TypeVisitor<QLType> {
	private ErrorEnvironment errorEnvironment;
	private TypeEnvironment typeEnvironment;	
	
	private TypeChecker(TypeEnvironment typeEnvironment) {
		super.setExpressionVisitor(this);
		super.setTypeVisitor(this);
		
		this.typeEnvironment = typeEnvironment;
		errorEnvironment = new ErrorEnvironment();
	}
	
	public ErrorEnvironment getErrorEnvironment() {
		return errorEnvironment;
	}
	
	public static ErrorEnvironment check(Statement tree, TypeEnvironment typeEnvironment) {
		TypeChecker typeChecker = new TypeChecker(typeEnvironment);
				
		tree.accept(typeChecker);

		return typeChecker.getErrorEnvironment();
	}	
	
	public static ErrorEnvironment check(Expression tree, TypeEnvironment typeEnvironment) {
		TypeChecker typeChecker = new TypeChecker(typeEnvironment);
		
		tree.accept(typeChecker);

		return typeChecker.getErrorEnvironment();
	}
	
	public static ErrorEnvironment check(QLType tree, TypeEnvironment typeEnvironment) {
		TypeChecker typeChecker = new TypeChecker(typeEnvironment);
		
		tree.accept(typeChecker);

		return typeChecker.getErrorEnvironment();
	}	
	
	/**
	 * Checks whether the given expression passes the type checker. 
	 * If the types are not compatible with the given compatibleWith type
	 * then an error is added to the errors list.
	 * @param expression
	 * @param expectedTypes The QLType the operands should be compatible with
	 */
	private QLType checkExpression(Expression expression, QLType expectedTypes) {		
		List<QLType> actualTypes = expression.getOperands()
				.stream()
				.map(operand -> operand.accept(this))
				.collect(Collectors.toList());
				
		// Both operands should be compatible with compatibleWith
		if (!isCompatibleWith(actualTypes, expectedTypes)) {
			errorEnvironment.addError(new TypeError(expression, expectedTypes, actualTypes));
		}
		
		return expression.getType();
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
				.map(type -> type.compatibleWith(compatibleWith))
				.allMatch(a -> a);
	}	
	
	/**
	 * OPERATORS 
	 */
	@Override
	public QLType visit(Add addNode) {
		return checkExpression(addNode, new QLNumeric());
	}

	@Override
	public QLType visit(Divide divNode) {
		return checkExpression(divNode, new QLNumeric());
	}

	@Override
	public QLType visit(Multiply mulNode) {
		return checkExpression(mulNode, new QLNumeric());
	}

	@Override
	public QLType visit(Subtract subNode) {
		return checkExpression(subNode, new QLNumeric());
	}
	
	@Override
	public QLType visit(Negation negNode) {
		return checkExpression(negNode, new QLNumeric());
	}
	
	@Override
	public QLType visit(Positive posNode) {
		return checkExpression(posNode, new QLNumeric());
	}
	
	/**
	 * EQUALITY OPERATORS
	 * 
	 * The left operand should be compatible with the right one.
	 * So the compatibleWith value is one of the operands' type
	 */
	
	@Override
	public QLType visit(Equal eqNode) {
		return checkExpression(eqNode, eqNode.getLeft().accept(this));
	}
	
	@Override
	public QLType visit(NotEqual neqNode) {
		return checkExpression(neqNode, neqNode.getLeft().accept(this));
	}
	
	/**
	 * Relational operators
	 */

	@Override
	public QLType visit(GreaterOrEqual geqNode) {
		return checkExpression(geqNode, new QLNumeric());
	}

	@Override
	public QLType visit(Greater gtNode) {
		return checkExpression(gtNode, new QLNumeric());
	}

	@Override
	public QLType visit(LowerOrEqual leqNode) {
		return checkExpression(leqNode, new QLNumeric());
	}

	@Override
	public QLType visit(Lower ltNode) {
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
	@Override
	public QLType visit(QLBoolean booleanNode) { return booleanNode; }
	@Override
	public QLType visit(QLFloat floatNode) { return floatNode; }
	@Override
	public QLType visit(QLForm formNode) { return formNode; }   
	@Override
	public QLType visit(QLNumeric numericNode) { return numericNode; }
	@Override
	public QLType visit(QLInteger intNode) { return intNode; }
	@Override
	public QLType visit(QLString stringNode) { return stringNode; }
	@Override
	public QLType visit(QLError errNode) { return errNode; }
	
	@Override
	public QLType visit(BooleanLiteral booleanNode) { return booleanNode.getType(); }	
	@Override
	public QLType visit(FloatLiteral floatNode) { return floatNode.getType(); }
	@Override
	public QLType visit(IntegerLiteral intNode) { return intNode.getType(); }
	@Override
	public QLType visit(StringLiteral stringNode) {	return stringNode.getType(); }
	
	public QLType visit(Identifier identifier) {
		QLType identifierType = typeEnvironment.resolve(identifier);
		
		if(identifierType == null) {
			errorEnvironment.addError(new UndefinedVariableError(identifier));
			return new QLError();
		}
		
		return identifierType;
	}

	/**
	 * Statements
	 */	
	@Override
	public Void visit(ComputedQuestion compQuestionNode) {		
		QLType questionType = compQuestionNode.getType();
		QLType expressionType = compQuestionNode.getExpression().accept(this);
		
		if(!questionType.compatibleWith(expressionType)) {
			errorEnvironment.addError(new IllegalAssignmentError(compQuestionNode, questionType, expressionType));
		}
		
		Identifier questionIdentifier = compQuestionNode.getIdentifier();
		
		if(typeEnvironment.resolve(questionIdentifier) == null) {
			typeEnvironment.store(questionIdentifier, questionType);
		} else {
			errorEnvironment.addError(new RedefinedVariableError(questionIdentifier));
		}
		
		return null;
	}
	
	@Override
	public Void visit(Form formNode) {
		Identifier formIdentifier = formNode.getIdentifier();
		
		if(typeEnvironment.resolve(formIdentifier) == null) {
			typeEnvironment.store(formNode.getIdentifier(), formNode.getType());
		} else {
			errorEnvironment.addError(new RedefinedVariableError(formIdentifier));
		}
		
		return super.visit(formNode);
	}
	
	@Override
	public Void visit(If ifNode) {		
		// The expression must have a boolean type
		QLType ifType = ifNode.getExpression().accept(this);
		
		if (!ifType.compatibleWith(new QLBoolean())) {
			errorEnvironment.addError(new TypeError(ifNode, new QLBoolean(), ifType));
		}		
			
		return ifNode.getBlock().accept(this);
	}
	
	@Override
	public Void visit(IfElse ifElseNode) {
		// The expression must have a boolean type
		QLType ifType = ifElseNode.getExpression().accept(this);
		
		if (!ifType.compatibleWith(new QLBoolean())) {
			errorEnvironment.addError(new TypeError(ifElseNode, new QLBoolean(), ifType));
		}		

		
		ifElseNode.getIfBranch().accept(this);
		return ifElseNode.getElseBranch().accept(this);
	}

	@Override
	public Void visit(Question questionNode) {
		Identifier questionIdentifier = questionNode.getIdentifier();
		
		if(typeEnvironment.resolve(questionIdentifier) == null) {
			typeEnvironment.store(questionIdentifier, questionNode.getType());
		} else {
			errorEnvironment.addError(new RedefinedVariableError(questionIdentifier));
		}
		
		return null;
	}
	
	@Override
	public Void visit(Block blockNode) {
		increaseScope();
		super.visit(blockNode);
		decreaseScope();
		return null;
	}
	
	private void increaseScope() {
		typeEnvironment = new TypeEnvironment(typeEnvironment);
	}
	
	private void decreaseScope() {
		typeEnvironment = typeEnvironment.getParent();
	}
}
