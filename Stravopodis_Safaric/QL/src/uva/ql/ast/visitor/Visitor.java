package uva.ql.ast.visitor;

import uva.ql.ast.ASTNode;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.BooleanLiteral;
import uva.ql.ast.expressions.literals.MoneyLiteral;
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
import uva.ql.ast.statements.Assign;
import uva.ql.ast.statements.IfStatement;
import uva.ql.ast.statements.Question;
import uva.ql.ast.statements.Statement;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.type.TypeInteger;
import uva.ql.ast.type.TypeMoney;
import uva.ql.ast.type.TypeString;

public class Visitor<T> implements ExpressionVisitorInterface<T>, StatementVisitorInterface<T>{

	@Override
	public T visitProg(Prog prog) {
		this.visitForm(prog.getForm());
		
		return null;
	}

	@Override
	public T visitForm(Form form) {
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
	public T visitSimpleQuestion(Question question) {
		question.getQuestionType().accept(this);
		
		return null;
	}

	@Override
	public T visitComputedQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public T visitIfStatement(IfStatement ifStatement) {
		
		for (Statement statement : ifStatement.getStatement()){
			statement.accept(this);
		}
		
		ifStatement.getExpression().accept(this);
		
		return null;
	}

	@Override
	public T visitAssign(Assign assign) {
		
		assign.getIdentifier().accept(this);
		assign.getExpression().accept(this);

		return null;
	}

	@Override
	public T visitBinaryExpression(BinaryExpressions expression) {
		
		Expression left = expression.getLeftExpr();
		Expression right = expression.getRightExpr();
		
		left.accept(this);
		right.accept(this);
		
		return null;
	}

	@Override
	public T visitExpression(Expression expression) {
		return null;
	}

	@Override
	public T visitExponentiation(Exponentiation exponentiation) {
		this.visitBinaryExpression(exponentiation);
		
		return null;
	}

	@Override
	public T visitAddition(Addition addition) {
		this.visitBinaryExpression(addition);
		
		return null;
	}

	@Override
	public T visitSubstraction(Substraction substraction) {
		this.visitBinaryExpression(substraction);
		
		return null;
	}

	@Override
	public T visitMultiplication(Multiplication multipllication) {
		this.visitBinaryExpression(multipllication);
		
		return null;
	}

	@Override
	public T visitDivision(Division division) {
		this.visitBinaryExpression(division);
		
		return null;
	}

	@Override
	public T visitAnd(And and) {
		this.visitBinaryExpression(and);
		
		return null;
	}

	@Override
	public T visitOr(Or or) {
		this.visitBinaryExpression(or);
		
		return null;
	}

	@Override
	public T visitEqual(Equal equal) {
		this.visitBinaryExpression(equal);
		
		return null;
	}

	@Override
	public T visitNotEqual(NotEqual notEqual) {
		this.visitBinaryExpression(notEqual);
		
		return null;
	}

	@Override
	public T visitGreaterEqual(Greater_Eq greaterEqual) {
		this.visitBinaryExpression(greaterEqual);
		
		return null;
	}

	@Override
	public T visitGreater(Greater greater) {
		this.visitBinaryExpression(greater);
		
		return null;
	}

	@Override
	public T visitLessEqual(Less_Eq lessEqual) {
		this.visitBinaryExpression(lessEqual);
		
		return null;
	}

	@Override
	public T visitLess(Less less) {
		this.visitBinaryExpression(less);
		
		return null;
	}

	@Override
	public T visitIdentifier(Identifier identifier) {
		return null;
	}

	@Override
	public T visitBooleanLiteral(BooleanLiteral booleanLiteral) {
		return null;
	}

	@Override
	public T visitMoneyLiteral(MoneyLiteral moneyLiteral) {
		return null;
	}

	@Override
	public T visitIntLiteral(IntLiteral intLiteral) {
		return null;
	}

	@Override
	public T visitStringLiteral(StringLiteral stringLiteral) {
		return null;
	}

	@Override
	public T visitTypeBoolean(TypeBoolean booleanType) {
		return null;
	}

	@Override
	public T visitTypeInteger(TypeInteger integerType) {
		return null;
	}

	@Override
	public T visitTypeMoney(TypeMoney moneyType) {
		return null;
	}

	@Override
	public T visitTypeString(TypeString stringType) {
		return null;
	}
}
