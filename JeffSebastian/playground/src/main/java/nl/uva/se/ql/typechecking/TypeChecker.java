package nl.uva.se.ql.typechecking;

import nl.uva.se.ql.ast.expression.Expression;
import nl.uva.se.ql.ast.expression.ExpressionVisitor;
import nl.uva.se.ql.ast.expression.arithmetical.Addition;
import nl.uva.se.ql.ast.expression.arithmetical.Divide;
import nl.uva.se.ql.ast.expression.arithmetical.Modulo;
import nl.uva.se.ql.ast.expression.arithmetical.Multiply;
import nl.uva.se.ql.ast.expression.arithmetical.Negative;
import nl.uva.se.ql.ast.expression.arithmetical.Positive;
import nl.uva.se.ql.ast.expression.arithmetical.Power;
import nl.uva.se.ql.ast.expression.arithmetical.Substraction;
import nl.uva.se.ql.ast.expression.literal.BooleanLiteral;
import nl.uva.se.ql.ast.expression.literal.DecimalLiteral;
import nl.uva.se.ql.ast.expression.literal.IntegerLiteral;
import nl.uva.se.ql.ast.expression.literal.StringLiteral;
import nl.uva.se.ql.ast.expression.logical.And;
import nl.uva.se.ql.ast.expression.logical.Equal;
import nl.uva.se.ql.ast.expression.logical.GreaterOrEqual;
import nl.uva.se.ql.ast.expression.logical.GreaterThen;
import nl.uva.se.ql.ast.expression.logical.LessOrEqual;
import nl.uva.se.ql.ast.expression.logical.LessThen;
import nl.uva.se.ql.ast.expression.logical.Not;
import nl.uva.se.ql.ast.expression.logical.NotEqual;
import nl.uva.se.ql.ast.expression.logical.Or;
import nl.uva.se.ql.ast.expression.variable.Reference;
import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.form.FormVisitor;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.statement.StatementVisitor;
import nl.uva.se.ql.ast.type.BooleanType;
import nl.uva.se.ql.ast.type.DecimalType;
import nl.uva.se.ql.ast.type.IntegerType;
import nl.uva.se.ql.ast.type.StringType;
import nl.uva.se.ql.ast.type.Type;
import nl.uva.se.ql.ast.type.TypeVisitor;
import nl.uva.se.ql.ast.type.UndefinedType;
import nl.uva.se.ql.interpretation.Result;
import nl.uva.se.ql.interpretation.error.ErrorList;
import nl.uva.se.ql.interpretation.error.InvalidConditionType;
import nl.uva.se.ql.interpretation.error.InvalidOperandType;
import nl.uva.se.ql.interpretation.error.TypeMismatch;
import nl.uva.se.ql.interpretation.error.TypeNotAllowed;
import nl.uva.se.ql.interpretation.error.UndefinedReference;

public class TypeChecker implements FormVisitor, StatementVisitor,
		ExpressionVisitor<Type>, TypeVisitor<Type> {

	private static final Type BOOLEAN = new BooleanType();
	private static final Type INTEGER = new IntegerType();
	private static final Type DECIMAL = new DecimalType();
	private static final Type STRING = new StringType();

	private SymbolTable symbols;
	private ErrorList errors;

	private TypeChecker(Result<SymbolTable> symbolResult) {
		this.symbols = symbolResult.getResult();
		this.errors = symbolResult.getErrorList();
	}

	public static Result<SymbolTable> check(Form form) {
		Result<SymbolTable> symbolResult = SymbolResolver.resolve(form);

		if (!symbolResult.getErrorList().hasErrors()) {
			TypeChecker typeChecker = new TypeChecker(symbolResult);
			typeChecker.visit(form);
			return new Result<SymbolTable>(typeChecker.errors,
					typeChecker.symbols);
		}

		return symbolResult;
	}

	public void visit(Form form) {
		form.visitChildren(this);
	}

	public void visit(Question question) {
	}

	public void visit(CalculatedQuestion calculatedQuestion) {
		Type type = calculatedQuestion.getExpression().accept(this);
		
		if (!type.equals(calculatedQuestion.getType())) {
			errors.addError(new TypeMismatch(
				calculatedQuestion.getLineNumber(), calculatedQuestion
				.getOffset(), calculatedQuestion.getType(), type));
		}
	}

	public void visit(Condition condition) {
		Type conditionType = condition.getExpression().accept(this);
		if (!conditionType.equals(BOOLEAN)) {
			errors.addError(new InvalidConditionType(condition.getLineNumber(),
				condition.getOffset(), conditionType));
		}

		condition.visitChildren(this);
	}

	public Type visit(Addition plus) {
		Type sharedType = getSharedType(plus.getLeft(), plus.getRight());
		return getTypeForExpression(sharedType, plus, INTEGER, DECIMAL, STRING);
	}

	public Type visit(Divide divide) {
		Type sharedType = getSharedType(divide.getLeft(), divide.getRight());
		return getTypeForExpression(sharedType, divide, INTEGER, DECIMAL);
	}

	public Type visit(Power power) {
		Type sharedType = getSharedType(power.getLeft(), power.getRight());
		return getTypeForExpression(sharedType, power, INTEGER, DECIMAL);
	}

	public Type visit(Multiply multiply) {
		Type sharedType = getSharedType(multiply.getLeft(), multiply.getRight());
		return getTypeForExpression(sharedType, multiply, INTEGER, DECIMAL);
	}

	public Type visit(Modulo modulo) {
		Type sharedType = getSharedType(modulo.getLeft(), modulo.getRight());
		return getTypeForExpression(sharedType, modulo, INTEGER, DECIMAL);
	}

	public Type visit(Negative negative) {
		Type type = negative.getSingleExpression().accept(this);
		return getTypeForExpression(type, negative, INTEGER, DECIMAL);
	}

	public Type visit(Positive positive) {
		Type type = positive.getSingleExpression().accept(this);
		return getTypeForExpression(type, positive, INTEGER, DECIMAL);
	}

	public Type visit(Substraction minus) {
		Type sharedType = getSharedType(minus.getLeft(), minus.getRight());
		return getTypeForExpression(sharedType, minus, INTEGER, DECIMAL);
	}

	public Type visit(Not not) {
		Type type = not.getSingleExpression().accept(this);
		return getTypeForBooleanExpression(type, not, BOOLEAN);
	}

	public Type visit(NotEqual notEqual) {
		Type sharedType = getSharedType(notEqual.getLeft(), notEqual.getRight());
		return getTypeForBooleanExpression(sharedType, notEqual, INTEGER,
				DECIMAL, STRING, BOOLEAN);
	}

	public Type visit(Or or) {
		Type sharedType = getSharedType(or.getLeft(), or.getRight());
		return getTypeForBooleanExpression(sharedType, or, BOOLEAN);
	}

	public Type visit(LessThen lessThen) {
		Type sharedType = getSharedType(lessThen.getLeft(), lessThen.getRight());
		return getTypeForBooleanExpression(sharedType, lessThen, INTEGER,
				DECIMAL, STRING);
	}

	public Type visit(LessOrEqual lessOrEqual) {
		Type sharedType = getSharedType(lessOrEqual.getLeft(),
				lessOrEqual.getRight());
		return getTypeForBooleanExpression(sharedType, lessOrEqual, INTEGER,
				DECIMAL, STRING);
	}

	public Type visit(GreaterThen greaterThen) {
		Type sharedType = getSharedType(greaterThen.getLeft(),
				greaterThen.getRight());
		return getTypeForBooleanExpression(sharedType, greaterThen, INTEGER,
				DECIMAL, STRING);
	}

	public Type visit(GreaterOrEqual greaterOrEqual) {
		Type sharedType = getSharedType(greaterOrEqual.getLeft(),
				greaterOrEqual.getRight());
		return getTypeForBooleanExpression(sharedType, greaterOrEqual, INTEGER,
				DECIMAL, STRING);
	}

	public Type visit(Equal equal) {
		Type sharedType = getSharedType(equal.getLeft(), equal.getRight());
		return getTypeForBooleanExpression(sharedType, equal, INTEGER, DECIMAL,
				STRING, BOOLEAN);
	}

	public Type visit(And and) {
		Type sharedType = getSharedType(and.getLeft(), and.getRight());
		return getTypeForBooleanExpression(sharedType, and, BOOLEAN);
	}

	public Type visit(BooleanLiteral booleanLiteral) {
		return new BooleanType();
	}

	public Type visit(DecimalLiteral decimalLiteral) {
		return new DecimalType();
	}

	public Type visit(IntegerLiteral integerLiteral) {
		return new IntegerType();
	}

	public Type visit(StringLiteral stringLiteral) {
		return new StringType();
	}

	public Type visit(Reference reference) {
		if (symbols.containsSymbol(reference.getName())) {
			return symbols.getTypeForSymbol(reference.getName());
		}

		errors.addError(new UndefinedReference(reference.getLineNumber(),
				reference.getOffset(), reference.getName()));

		return new UndefinedType();
	}

	private Type getSharedType(Expression left, Expression right) {
		Type leftType = left.accept(this);
		Type rightType = right.accept(this);

		if (leftType.isUndefined()) {
			errors.addError(new UndefinedReference(left.getLineNumber(), 
					left.getOffset(), left.toString()));
			return new UndefinedType();
		}

		if (rightType.isUndefined()) {
			errors.addError(new UndefinedReference(right.getLineNumber(), 
					right.getOffset(), right.toString()));
			return new UndefinedType();
		}

		if (leftType.equals(rightType)) {
			return leftType.accept(this);
		}

		errors.addError(new InvalidOperandType(left.getLineNumber(), 
				left.getOffset(), leftType, leftType, rightType));

		return new UndefinedType();
	}

	private Type getTypeForExpression(Type type, Expression expr, Type... types) {
		if (type.isIn(types)) {
			return type.accept(this);
		}

		errors.addError(new TypeNotAllowed(expr.getLineNumber(), 
				expr.getOffset(), type, expr.getClass().getName()));

		return new UndefinedType();
	}

	private Type getTypeForBooleanExpression(Type type, Expression expr, Type... types) {
		if (type.isIn(types)) {
			return new BooleanType();
		}

		errors.addError(new TypeNotAllowed(expr.getLineNumber(), 
				expr.getOffset(), type, expr.getClass().getName()));

		return new UndefinedType();
	}

	@Override
	public Type visit(BooleanType booleanType) {
		return new BooleanType();
	}

	@Override
	public Type visit(DecimalType decimalType) {
		return new DecimalType();
	}

	@Override
	public Type visit(IntegerType integerType) {
		return new IntegerType();
	}

	@Override
	public Type visit(StringType stringType) {
		return new StringType();
	}

	@Override
	public Type visit(UndefinedType undefinedType) {
		return new UndefinedType();
	}
}