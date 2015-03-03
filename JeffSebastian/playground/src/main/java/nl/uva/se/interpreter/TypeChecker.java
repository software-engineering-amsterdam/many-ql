package nl.uva.se.interpreter;

import java.util.Arrays;

import nl.uva.se.ast.expression.Expression;
import nl.uva.se.ast.expression.arithmetical.Addition;
import nl.uva.se.ast.expression.arithmetical.Divide;
import nl.uva.se.ast.expression.arithmetical.Modulo;
import nl.uva.se.ast.expression.arithmetical.Multiply;
import nl.uva.se.ast.expression.arithmetical.Negative;
import nl.uva.se.ast.expression.arithmetical.Positive;
import nl.uva.se.ast.expression.arithmetical.Power;
import nl.uva.se.ast.expression.arithmetical.Substraction;
import nl.uva.se.ast.expression.literal.BooleanLiteral;
import nl.uva.se.ast.expression.literal.DecimalLiteral;
import nl.uva.se.ast.expression.literal.IntegerLiteral;
import nl.uva.se.ast.expression.literal.StringLiteral;
import nl.uva.se.ast.expression.logical.And;
import nl.uva.se.ast.expression.logical.Equal;
import nl.uva.se.ast.expression.logical.GreaterOrEqual;
import nl.uva.se.ast.expression.logical.GreaterThen;
import nl.uva.se.ast.expression.logical.LessOrEqual;
import nl.uva.se.ast.expression.logical.LessThen;
import nl.uva.se.ast.expression.logical.Not;
import nl.uva.se.ast.expression.logical.NotEqual;
import nl.uva.se.ast.expression.logical.Or;
import nl.uva.se.ast.expression.variable.Reference;
import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.ast.type.BooleanType;
import nl.uva.se.ast.type.DecimalType;
import nl.uva.se.ast.type.IntegerType;
import nl.uva.se.ast.type.StringType;
import nl.uva.se.ast.type.Type;
import nl.uva.se.ast.type.TypeFactory;
import nl.uva.se.ast.type.UndefinedType;
import nl.uva.se.interpreter.error.ErrorList;
import nl.uva.se.visitor.ExpressionVisitor;
import nl.uva.se.visitor.FormVisitor;
import nl.uva.se.visitor.StatementVisitor;

public class TypeChecker implements FormVisitor, StatementVisitor, ExpressionVisitor<Type> {
	
	private static final Type BOOLEAN = new BooleanType();
	private static final Type INTEGER = new IntegerType();
	private static final Type DECIMAL = new DecimalType();
	private static final Type STRING = new StringType();
	
	private SymbolTable symbols;
	
	private ErrorList errors;
	
	private TypeChecker(SymbolTable symbols) {
		this.symbols = symbols;
		this.errors = new ErrorList();
	}
	
	public static SymbolTable run(Form form) {
		SymbolTable symbols = SymbolResolver.resolve(form);
		TypeChecker typeChecker = new TypeChecker(symbols);
		typeChecker.visit(form);
		
		return typeChecker.symbols;
	}
	
	@Override
	public void visit(Form form) {
		form.visitChildren(this);
	}

	@Override
	public void visit(Question question) {
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		calculatedQuestion.getExpression().accept(this);
	}

	@Override
	public void visit(Condition condition) {
		condition.getExpression().accept(this);
	}

	@Override
	public Type visit(Addition plus) {
		return visitNumericalBinaryExpression(plus.getLeft(), plus.getRight());
	}

	@Override
	public Type visit(Divide divide) {
		return visitNumericalBinaryExpression(divide.getLeft(), divide.getRight());
	}

	@Override
	public Type visit(Power power) {
		return visitNumericalBinaryExpression(power.getLeft(), power.getRight());
	}

	@Override
	public Type visit(Multiply multiply) {
		return visitNumericalBinaryExpression(multiply.getLeft(), multiply.getRight());
	}

	@Override
	public Type visit(Modulo modulo) {
		return visitNumericalBinaryExpression(modulo.getLeft(), modulo.getRight());
	}

	@Override
	public Type visit(Negative negative) {
		return visitNumericalUnaryExpression(negative.getSingleExpression());
	}

	@Override
	public Type visit(Positive positive) {
		return visitNumericalUnaryExpression(positive.getSingleExpression());
	}

	@Override
	public Type visit(Substraction minus) {
		return visitNumericalBinaryExpression(minus.getLeft(), minus.getRight());
	}

	@Override
	public Type visit(Not not) {
		return visitBooleanUnaryExpression(not.getSingleExpression());
	}

	@Override
	public Type visit(NotEqual notEqual) {
		return visitBooleanBinaryExpression(notEqual.getLeft(), notEqual.getRight());
	}

	@Override
	public Type visit(Or or) {
		return visitBooleanBinaryExpression(or.getLeft(), or.getRight());
	}

	@Override
	public Type visit(LessThen lessThen) {
		return visitBooleanBinaryExpression(lessThen.getLeft(), lessThen.getRight());
	}

	@Override
	public Type visit(LessOrEqual lessOrEqual) {
		return visitBooleanBinaryExpression(lessOrEqual.getLeft(), lessOrEqual.getRight());
	}

	@Override
	public Type visit(GreaterThen greaterThen) {
		return visitBooleanBinaryExpression(greaterThen.getLeft(), greaterThen.getRight());
	}

	@Override
	public Type visit(GreaterOrEqual greaterOrEqual) {
		return visitBooleanBinaryExpression(greaterOrEqual.getLeft(), greaterOrEqual.getRight());
	}

	@Override
	public Type visit(Equal equal) {
		return visitBooleanBinaryExpression(equal.getLeft(), equal.getRight());
	}

	@Override
	public Type visit(And and) {
		return visitBooleanBinaryExpression(and.getLeft(), and.getRight());
	}

	@Override
	public Type visit(BooleanLiteral booleanLiteral) {
		return new BooleanType();
	}

	@Override
	public Type visit(DecimalLiteral decimalLiteral) {
		return new DecimalType();
	}

	@Override
	public Type visit(IntegerLiteral integerLiteral) {
		return new IntegerType();
	}

	@Override
	public Type visit(StringLiteral stringLiteral) {
		return new StringType();
	}

	@Override
	public Type visit(Reference reference) {
		if (symbols.containsSymbol(reference.getName())) {
			return symbols.getTypeForSymbol(reference.getName());
		}
		
		errors.addUndefinedTypeError(reference.getLineNumber(), 
				reference.getOffset(), reference.getName());
		return new UndefinedType();
	}
	
	private Type getSharedType(Expression left, Expression right) {
		Type leftType = left.accept(this);
		Type rightType = right.accept(this);
		
		if (leftType.isUndefined() || rightType.isUndefined()) {
			return new UndefinedType();
		}
		
		if (leftType.equals(rightType)) {
			return TypeFactory.getTypeForName(leftType.getTypeName());
		}
		
		return new UndefinedType();
	}
	
	private Type visitBooleanBinaryExpression(Expression left, Expression right) {
		Type sharedType = getSharedType(left, right);
		if (sharedType.isIn(BOOLEAN, DECIMAL, INTEGER, STRING)) {
			return new BooleanType();
		}
		
		return new UndefinedType();
	}
	
	private Type visitNumericalBinaryExpression(Expression left, Expression right) {
		Type sharedType = getSharedType(left, right);
		if (sharedType.isIn(INTEGER, DECIMAL)) {
			return TypeFactory.getTypeForName(sharedType.getTypeName());
		}
		
		return new UndefinedType();
	}
	
	private Type visitBooleanUnaryExpression(Expression expr) {
		Type type = expr.accept(this);
		
		if (type.equals(new BooleanType())) {
			return new BooleanType();
		}
		
		errors.addTypeNotAllowedError(expr.getLineNumber(), 
				expr.getOffset(), Arrays.asList(BOOLEAN), type);
		return new UndefinedType();
	}

	private Type visitNumericalUnaryExpression(Expression expr) {
		Type type = expr.accept(this);
		
		if (type.equals(new IntegerType()) || type.equals(new DecimalType())) {
			return TypeFactory.getTypeForName(type.getTypeName());
		}
		
		errors.addTypeNotAllowedError(expr.getLineNumber(), 
				expr.getOffset(), Arrays.asList(INTEGER, DECIMAL), type);
		return new UndefinedType();
	}
}
