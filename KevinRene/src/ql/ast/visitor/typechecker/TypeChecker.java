package ql.ast.visitor.typechecker;

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
import ql.ast.expression.literal.MoneyLiteral;
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
import ql.ast.type.QLForm;
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
	private TypeEnvironment typeEnvironment, scopedEnvironment;	
	
	private TypeChecker(TypeEnvironment typeEnvironment) {
		super.setExpressionVisitor(this);
		super.setTypeVisitor(this);
		
		// Type environment that is given. Will include ALL identifiers with their types.
		this.typeEnvironment = typeEnvironment;
		// Type environment for internal scope that abides scoping rules.
		scopedEnvironment = new TypeEnvironment();
		
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
	 * OPERATORS 
	 */
	@Override
	public QLType visit(Add add) {
		QLType lhs = add.getLeft().accept(this);
		QLType rhs = add.getRight().accept(this);
		
		if (!lhs.add(rhs)) {
			errorEnvironment.addError(new TypeError(add, lhs, rhs));
		}
		
		return add.getType();
	}

	@Override
	public QLType visit(Divide div) {
		QLType lhs = div.getLeft().accept(this);
		QLType rhs = div.getRight().accept(this);
		
		if (!lhs.divide(rhs)) {
			errorEnvironment.addError(new TypeError(div, lhs, rhs));
		}
		
		return div.getType();
	}

	@Override
	public QLType visit(Multiply mul) {
		QLType lhs = mul.getLeft().accept(this);
		QLType rhs = mul.getRight().accept(this);
		
		if (!lhs.multiply(rhs)) {
			errorEnvironment.addError(new TypeError(mul, lhs, rhs));
		}
		
		return mul.getType();
	}

	@Override
	public QLType visit(Subtract sub) {
		QLType lhs = sub.getLeft().accept(this);
		QLType rhs = sub.getRight().accept(this);
		
		if (!lhs.subtract(rhs)) {
			errorEnvironment.addError(new TypeError(sub, lhs, rhs));
		}
		
		return sub.getType();
	}
	
	@Override
	public QLType visit(Negation neg) {
		QLType lhs = neg.getExpression().accept(this);
		
		if (!lhs.negative()) {
			errorEnvironment.addError(new TypeError(neg, lhs));
		}
		
		return neg.getType();
	}
	
	@Override
	public QLType visit(Positive pos) {
		QLType lhs = pos.getExpression().accept(this);
		
		if (!lhs.positive()) {
			errorEnvironment.addError(new TypeError(pos, lhs));
		}
		
		return pos.getType();
	}
	
	/**
	 * EQUALITY OPERATORS
	 * 
	 * The left operand should be compatible with the right one.
	 * So the compatibleWith value is one of the operands' type
	 */
	
	@Override
	public QLType visit(Equal eq) {
		QLType lhs = eq.getLeft().accept(this);
		QLType rhs = eq.getRight().accept(this);
		
		if (!lhs.equalTo(rhs)) {
			errorEnvironment.addError(new TypeError(eq, lhs, rhs));
		}
		
		return eq.getType();
	}
	
	@Override
	public QLType visit(NotEqual neq) {
		QLType lhs = neq.getLeft().accept(this);
		QLType rhs = neq.getRight().accept(this);
		
		if (!lhs.notEqualTo(rhs)) {
			errorEnvironment.addError(new TypeError(neq, lhs, rhs));
		}
		
		return neq.getType();
	}
	
	/**
	 * Relational operators
	 */

	@Override
	public QLType visit(GreaterOrEqual geq) {
		QLType lhs = geq.getLeft().accept(this);
		QLType rhs = geq.getRight().accept(this);
		
		if (!lhs.greaterOrEqual(rhs)) {
			errorEnvironment.addError(new TypeError(geq, lhs, rhs));
		}
		
		return geq.getType();
	}

	@Override
	public QLType visit(Greater gt) {
		QLType lhs = gt.getLeft().accept(this);
		QLType rhs = gt.getRight().accept(this);
		
		if (!lhs.greaterThan(rhs)) {
			errorEnvironment.addError(new TypeError(gt, lhs, rhs));
		}
		
		return gt.getType();
	}

	@Override
	public QLType visit(LowerOrEqual leq) {
		QLType lhs = leq.getLeft().accept(this);
		QLType rhs = leq.getRight().accept(this);
		
		if (!lhs.lowerOrEqual(rhs)) {
			errorEnvironment.addError(new TypeError(leq, lhs, rhs));
		}
		
		return leq.getType();
	}

	@Override
	public QLType visit(Lower lt) {
		QLType lhs = lt.getLeft().accept(this);
		QLType rhs = lt.getRight().accept(this);
		
		if (!lhs.lowerThan(rhs)) {
			errorEnvironment.addError(new TypeError(lt, lhs, rhs));
		}
		
		return lt.getType();
	}

	
	@Override
	public QLType visit(And and) {
		QLType lhs = and.getLeft().accept(this);
		QLType rhs = and.getRight().accept(this);
		
		if (!lhs.and(rhs)) {
			errorEnvironment.addError(new TypeError(and, lhs, rhs));
		}
		
		return and.getType();
	}
	
	@Override
	public QLType visit(Or or) {
		QLType lhs = or.getLeft().accept(this);
		QLType rhs = or.getRight().accept(this);
		
		if (!lhs.or(rhs)) {
			errorEnvironment.addError(new TypeError(or, lhs, rhs));
		}
		
		return or.getType();
	}

	@Override
	public QLType visit(Not not) {
		QLType lhs = not.getExpression().accept(this);
		
		if (!lhs.not()) {
			errorEnvironment.addError(new TypeError(not, lhs));
		}
		
		return not.getType();
	}
		
	@Override
	public QLType visit(BooleanLiteral booleanNode) { 
		return booleanNode.getType(); 
	}	
	
	@Override
	public QLType visit(FloatLiteral floatNode) { 
		return floatNode.getType(); 
	}
	
	@Override
	public QLType visit(MoneyLiteral moneyNode) {
		return moneyNode.getType();
	}
	
	@Override
	public QLType visit(IntegerLiteral integerNode) { 
		return integerNode.getType(); 
	}
	
	@Override
	public QLType visit(StringLiteral stringNode) {	
		return stringNode.getType();
	}
	
	public QLType visit(Identifier identifier) {
		QLType identifierType = scopedEnvironment.resolve(identifier);
		
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
		
		if(!questionType.assign(expressionType)) {
			errorEnvironment.addError(new IllegalAssignmentError(compQuestionNode, questionType, expressionType));
		}
		
		Identifier questionIdentifier = compQuestionNode.getIdentifier();
		
		if(scopedEnvironment.resolve(questionIdentifier) == null) {
			scopedEnvironment.store(questionIdentifier, questionType);
			typeEnvironment.store(questionIdentifier, questionType);
		} else {
			errorEnvironment.addError(new RedefinedVariableError(questionIdentifier));
		}
		
		return null;
	}
	
	@Override
	public Void visit(Form formNode) {
		Identifier formIdentifier = formNode.getIdentifier();
		
		if(scopedEnvironment.resolve(formIdentifier) == null) {
			scopedEnvironment.store(formNode.getIdentifier(), new QLForm());
			typeEnvironment.store(formNode.getIdentifier(), new QLForm());
		} else {
			errorEnvironment.addError(new RedefinedVariableError(formIdentifier));
		}
		
		return super.visit(formNode);
	}
	
	@Override
	public Void visit(If ifNode) {		
		// The expression must have a boolean type
		QLType ifType = ifNode.getExpression().accept(this);
		
		if (!ifType.equals(new QLBoolean())) {
			errorEnvironment.addError(new TypeError(ifNode, new QLBoolean(), ifType));
		}		
			
		return ifNode.getBlock().accept(this);
	}
	
	@Override
	public Void visit(IfElse ifElseNode) {
		// The expression must have a boolean type
		QLType ifType = ifElseNode.getExpression().accept(this);
		
		if (!ifType.equals(new QLBoolean())) {
			errorEnvironment.addError(new TypeError(ifElseNode, new QLBoolean(), ifType));
		}		

		
		ifElseNode.getIfBranch().accept(this);
		return ifElseNode.getElseBranch().accept(this);
	}

	@Override
	public Void visit(Question questionNode) {
		Identifier questionIdentifier = questionNode.getIdentifier();
		
		if(scopedEnvironment.resolve(questionIdentifier) == null) {
			scopedEnvironment.store(questionIdentifier, questionNode.getType());
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
		scopedEnvironment = new TypeEnvironment(scopedEnvironment);
	}
	
	private void decreaseScope() {
		scopedEnvironment = scopedEnvironment.getParent();
	}
}
