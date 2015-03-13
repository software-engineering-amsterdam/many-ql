package ql.ast.visitor.typechecker;

import java.util.List;
import java.util.stream.Collectors;

import ql.TypeEnvironment;
import ql.ast.Expression;
import ql.ast.Statement;
import ql.ast.expression.Identifier;
import ql.ast.expression.QLType;
import ql.ast.expression.arithmetic.Add;
import ql.ast.expression.arithmetic.Divide;
import ql.ast.expression.arithmetic.Multiply;
import ql.ast.expression.arithmetic.Negation;
import ql.ast.expression.arithmetic.Positive;
import ql.ast.expression.arithmetic.Subtract;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.relational.And;
import ql.ast.expression.relational.Equal;
import ql.ast.expression.relational.GreaterOrEqual;
import ql.ast.expression.relational.Greater;
import ql.ast.expression.relational.LowerOrEqual;
import ql.ast.expression.relational.Lower;
import ql.ast.expression.relational.NotEqual;
import ql.ast.expression.relational.Not;
import ql.ast.expression.relational.Or;
import ql.ast.expression.type.QLBoolean;
import ql.ast.expression.type.QLError;
import ql.ast.expression.type.QLFloat;
import ql.ast.expression.type.QLForm;
import ql.ast.expression.type.QLInteger;
import ql.ast.expression.type.QLNumeric;
import ql.ast.expression.type.QLString;
import ql.ast.statement.Block;
import ql.ast.statement.ComputedQuestion;
import ql.ast.statement.Form;
import ql.ast.statement.If;
import ql.ast.statement.IfElse;
import ql.ast.statement.Question;
import ql.ast.visitor.ExpressionVisitor;
import ql.ast.visitor.StatementVisitor;
import ql.errorhandling.ErrorEnvironment;
import ql.errorhandling.error.IllegalAssignmentError;
import ql.errorhandling.error.RedefinedVariableError;
import ql.errorhandling.error.TypeError;
import ql.errorhandling.error.UndefinedVariableError;

public class TypeChecker extends StatementVisitor<QLType> implements ExpressionVisitor<QLType> {
	private static ErrorEnvironment typeErrors;
	private TypeEnvironment typeEnvironment;	
	
	private TypeChecker(TypeEnvironment typeEnv) {
		this.typeEnvironment = typeEnv;
		super.setExpressionVisitor(this);
	}
	
	/**
	 * Entry point, static type checks the supplied tree
	 * @return a boolean indicating pass or fail
	 */
	public static boolean check(Statement tree, TypeEnvironment typeEnvironment) {
		TypeChecker typeChecker = new TypeChecker(typeEnvironment);
		typeErrors = new ErrorEnvironment();
		
		tree.accept(typeChecker);
		
		return typeErrors.hasErrors();
	}	
	
	/**
	 * Entry point, static type checks the supplied tree
	 * @return a boolean indicating pass or fail
	 */
	public static boolean check(Expression tree, TypeEnvironment typeEnvironment) {
		TypeChecker typeChecker = new TypeChecker(typeEnvironment);
		typeErrors = new ErrorEnvironment();
		
		tree.accept(typeChecker);
		
		return typeErrors.hasErrors();
	}	
	
	/**
	 * Entry point, static type checks the supplied tree
	 * @return a boolean indicating pass or fail
	 */
	public static boolean check(Statement tree, TypeEnvironment typeEnvironment, ErrorEnvironment errors) {
		TypeChecker typeChecker = new TypeChecker(typeEnvironment);
		
		typeErrors = errors;
		
		tree.accept(typeChecker);
		
		return typeErrors.hasErrors();
	}	
	
	
	/**
	 * Checks whether the given expression passes the type checker. 
	 * If the types are not compatible with the given compatibleWith type
	 * then an error is added to the errors list.
	 * @param expr
	 * @param expectedTypes The QLType the operands should be compatible with
	 */
	private QLType checkExpression(Expression expr, QLType expectedTypes) {		
		List<QLType> actualTypes = expr.getOperands()
				.stream()
				.map(operand -> operand.accept(this))
				.collect(Collectors.toList());
				
		// Both operands should be compatible with compatibleWith
		if (!isCompatibleWith(actualTypes, expectedTypes)) {
			typeErrors.addError(new TypeError(expr, expectedTypes, actualTypes));
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
	
	public QLType visit(QLBoolean booleanNode) { return booleanNode.getType(); }
	public QLType visit(QLFloat floatNode) { return floatNode.getType(); }
	public QLType visit(QLForm formNode) { return formNode.getType(); }   
	public QLType visit(QLNumeric numericNode) { return numericNode.getType(); }
	public QLType visit(QLInteger intNode) { return intNode.getType(); }
	public QLType visit(QLString stringNode) { return stringNode.getType(); }
	public QLType visit(QLError errNode) { return errNode.getType(); }
	
	public QLType visit(BooleanLiteral booleanNode) { return booleanNode.getType(); }	
	public QLType visit(FloatLiteral floatNode) { return floatNode.getType(); }
	public QLType visit(IntegerLiteral intNode) { return intNode.getType(); }
	public QLType visit(StringLiteral stringNode) {	return stringNode.getType(); }
	
	public QLType visit(Identifier identifier) {
		QLType identifierType = typeEnvironment.resolve(identifier);
		
		if(identifierType == null) {
			typeErrors.addError(new UndefinedVariableError(identifier));
			return new QLError();
		}
		
		return identifierType;
	}

	/**
	 * Statements
	 */	
	@Override

	public QLType visit(ComputedQuestion compQuestionNode) {		
		QLType questionType = compQuestionNode.getType();
		QLType expressionType = compQuestionNode.getExpression().accept(this);
		
		if(!questionType.compatibleWith(expressionType)) {
			typeErrors.addError(new IllegalAssignmentError(compQuestionNode, questionType, expressionType));
		}
		
		Identifier questionIdentifier = compQuestionNode.getIdentifier();
		
		if(typeEnvironment.resolve(questionIdentifier) == null) {
			typeEnvironment.store(questionIdentifier, questionType);
		} else {
			typeErrors.addError(new RedefinedVariableError(questionIdentifier));
		}
		
		return questionType;
	}
	
	@Override
	public QLType visit(Form formNode) {
		Identifier formIdentifier = formNode.getIdentifier();
		
		if(typeEnvironment.resolve(formIdentifier) == null) {
			typeEnvironment.store(formNode.getIdentifier(), formNode.getType());
		} else {
			typeErrors.addError(new RedefinedVariableError(formIdentifier));
		}
		
		super.visit(formNode);
		
		return formNode.getType();
	}
	
	@Override
	public QLType visit(If ifNode) {		
		// The expression must have a boolean type
		QLType ifType = ifNode.getExpression().accept(this);
		
		if (!ifType.compatibleWith(new QLBoolean())) {
			typeErrors.addError(new TypeError(ifNode, new QLBoolean(), ifType));
		}		
			
		ifNode.getBlock().accept(this);
		
		return ifType;
	}
	
	@Override
	public QLType visit(IfElse ifElseNode) {
		// The expression must have a boolean type
		QLType ifType = ifElseNode.getExpression().accept(this);
		
		if (!ifType.compatibleWith(new QLBoolean())) {
			typeErrors.addError(new TypeError(ifElseNode, new QLBoolean(), ifType));
		}		

		
		ifElseNode.getIfBranch().accept(this);
		ifElseNode.getElseBranch().accept(this);
		
		return ifType;
	}

	@Override
	public QLType visit(Question questionNode) {
		Identifier questionIdentifier = questionNode.getIdentifier();
		
		if(typeEnvironment.resolve(questionIdentifier) == null) {
			typeEnvironment.store(questionIdentifier, questionNode.getType());
		} else {
			typeErrors.addError(new RedefinedVariableError(questionIdentifier));
		}
		
		return questionNode.getType();
	}
	
	@Override
	public QLType visit(Block blockNode) {
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
