package uva.ql.ast.visitor;

import uva.ql.ast.ASTNode;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.declarations.Declaration;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Type;
import uva.ql.ast.expressions.literals.BooleanLiteral;
import uva.ql.ast.expressions.literals.DecimalLiteral;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.IntLiteral;
import uva.ql.ast.expressions.literals.StringLiteral;
import uva.ql.ast.expressions.logic.And;
import uva.ql.ast.expressions.logic.Equal;
import uva.ql.ast.expressions.logic.Greater;
import uva.ql.ast.expressions.logic.Greater_Eq;
import uva.ql.ast.expressions.logic.Less;
import uva.ql.ast.expressions.logic.Less_Eq;
import uva.ql.ast.expressions.logic.NotEqual;
import uva.ql.ast.expressions.logic.Or;
import uva.ql.ast.expressions.math.Addition;
import uva.ql.ast.expressions.math.Division;
import uva.ql.ast.expressions.math.Exponentiation;
import uva.ql.ast.expressions.math.Multiplication;
import uva.ql.ast.expressions.math.Substraction;
import uva.ql.ast.question.Question;
import uva.ql.ast.statements.Assign;
import uva.ql.ast.statements.IfStatement;
import uva.ql.ast.statements.Statement;

public class Visitor<T> implements VisitorInterface<T>{

	@Override
	public T visitProg(Prog prog) {
		this.visitForm(prog.getForm());
		
		return null;
	}

	@Override
	public T visitForm(Form form) {
		System.out.println(form);
		for(Statement statement : form.getStatement()){
			statement.accept(this);
		}
		return null;
	}

	@Override
	public T visitASTNode(ASTNode node) {
		
		return null;
	}
	@Override
	public T visitStatement(Statement statement) {
		statement.accept(this);
		
		return null;
	}

	@Override
	public T visitQuestion(Question question) {
		System.out.println(question);
		for (Statement statement : question.getStatement()){
			statement.accept(this);
		}
		
		question.getType().accept(this);
		question.getIdentifier().accept(this);
		
		return null;
	}

	@Override
	public T visitDeclaration(Declaration declaration) {
		System.out.println(declaration);
		if (declaration.getExpression() != null)
			declaration.getExpression().accept(this);
		
		declaration.getIdentifier().accept(this);
		declaration.getType().accept(this);
		
		return null;
	}

	@Override
	public T visitIfStatement(IfStatement ifStatement) {
		System.out.println(ifStatement);
		for (Statement statement : ifStatement.getStatement()){
			statement.accept(this);
		}
		
		ifStatement.getExpression().accept(this);
		System.out.println("Evaluate: " + ifStatement.getExpression().evaluate().getValue());
		return null;
	}

	@Override
	public T visitAssign(Assign assign) {
		
		assign.getIdentifier().accept(this);
		assign.getExpression().accept(this);
		System.out.println("Evaluate: " + assign.getExpression().evaluate().getValue());
		return null;
	}

	@Override
	public T visitBinaryExpression(BinaryExpressions expression) {
		System.out.println(expression);
		Expression left = expression.getLeftExpr();
		Expression right = expression.getRightExpr();
		
		left.accept(this);
		right.accept(this);
		
		return null;
	}

	@Override
	public T visitExpression(Expression expression) {
		System.out.println("Evaluated expression: " + expression.evaluate().getValue());
		return null;
	}

	@Override
	public T visitExponentiation(Exponentiation exponentiation) {
		System.out.println(exponentiation);
		this.visitBinaryExpression(exponentiation);
		
		return null;
	}

	@Override
	public T visitAddition(Addition addition) {
		System.out.println(addition);
		this.visitBinaryExpression(addition);
		
		return null;
	}

	@Override
	public T visitSubstraction(Substraction substraction) {
		System.out.println(substraction);
		this.visitBinaryExpression(substraction);
		
		return null;
	}

	@Override
	public T visitMultiplication(Multiplication multipllication) {
		System.out.println(multipllication);
		this.visitBinaryExpression(multipllication);
		
		return null;
	}

	@Override
	public T visitDivision(Division division) {
		System.out.println(division);
		this.visitBinaryExpression(division);
		
		return null;
	}

	@Override
	public T visitAnd(And and) {
		System.out.println(and);
		this.visitBinaryExpression(and);
		
		return null;
	}

	@Override
	public T visitOr(Or or) {
		System.out.println(or);
		this.visitBinaryExpression(or);
		
		return null;
	}

	@Override
	public T visitEqual(Equal equal) {
		System.out.println(equal);
		this.visitBinaryExpression(equal);
		
		return null;
	}

	@Override
	public T visitNotEqual(NotEqual notEqual) {
		System.out.println(notEqual);
		this.visitBinaryExpression(notEqual);
		
		return null;
	}

	@Override
	public T visitGreaterEqual(Greater_Eq greaterEqual) {
		System.out.println(greaterEqual);
		this.visitBinaryExpression(greaterEqual);
		
		return null;
	}

	@Override
	public T visitGreater(Greater greater) {
		System.out.println(greater);
		this.visitBinaryExpression(greater);
		
		return null;
	}

	@Override
	public T visitLessEqual(Less_Eq lessEqual) {
		System.out.println(lessEqual);
		this.visitBinaryExpression(lessEqual);
		
		return null;
	}

	@Override
	public T visitLess(Less less) {
		System.out.println(less);
		this.visitBinaryExpression(less);
		
		return null;
	}

	@Override
	public T visitIdentifier(Identifier identifier) {
		System.out.println(identifier);
		return null;
	}

	@Override
	public T visitBooleanLiteral(BooleanLiteral booleanLiteral) {
		System.out.println(booleanLiteral);
		return null;
	}

	@Override
	public T visitDecimalLiteral(DecimalLiteral decimalLiteral) {
		System.out.println(decimalLiteral);
		return null;
	}

	@Override
	public T visitIntLiteral(IntLiteral intLiteral) {
		System.out.println(intLiteral);
		return null;
	}

	@Override
	public T visitStringLiteral(StringLiteral stringLiteral) {
		System.out.println(stringLiteral);
		return null;
	}

	@Override
	public T visitType(Type type) {
		System.out.println("Primitive type: " + type.getTypeName());
		return null;
	}

	
}
