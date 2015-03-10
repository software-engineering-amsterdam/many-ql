package uva.ql.interpreter.typecheck;


import java.util.List;

import uva.ql.ast.ASTNode;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Type;
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
import uva.ql.ast.question.Question;
import uva.ql.ast.statements.Assign;
import uva.ql.ast.statements.IfStatement;
import uva.ql.ast.statements.Statement;
import uva.ql.ast.visitor.ExpressionVisitorInterface;
import uva.ql.ast.visitor.StatementVisitorInterface;
import uva.ql.interpreter.typecheck.exception.IllegalTypeException;
import uva.ql.interpreter.typecheck.table.ExpressionTable;
import uva.ql.interpreter.typecheck.table.SymbolTable;
import uva.ql.interpreter.typecheck.table.SymbolTableValue;
import uva.ql.supporting.ExpressionSupporting;

public class TypeCheckVisitor implements ExpressionVisitorInterface<Object>, StatementVisitorInterface<Object>{

	private TypeCheck typeCheck;
	protected SymbolTable symbolTable;
	protected ExpressionTable expressionTable;
	
	public TypeCheckVisitor(TypeCheck _typeCheck, SymbolTable _symbolTable, ExpressionTable _expressionTable){
		this.typeCheck = _typeCheck;
		this.symbolTable = _symbolTable;
		this.expressionTable = _expressionTable;
	}
	
	@Override
	public Object visitProg(Prog prog) {
		this.visitForm(prog.getForm());
		return null;
	}

	@Override
	public Form visitForm(Form form) {
		this.symbolTable.putValue(form.getIdentifier().evaluatedValue(), new SymbolTableValue(null, form.getCodeLines()));
		this.visitStatements(form.getStatement());
		return null;
	}

	@Override
	public Object visitASTNode(ASTNode node) {
		return null;
	}

	@Override
	public Object visitStatement(Statement statement) {
		statement.accept(this);
		return null;
	}

	private Object visitStatements(List<Statement> statements){
		for (Statement s : statements)
			s.accept(this);
		return null;
	}
	
	@Override
	public Object visitQuestion(Question question) {
		SymbolTableValue value = new SymbolTableValue(question.getType(), question.getCodeLines());
		
		this.typeCheck.isDuplicate(question.getIdentifier(), value);
		this.symbolTable.putValue(question.getIdentifier().evaluatedValue(), value);
		
		question.getIdentifier().accept(this);
		question.getType().accept(this);
		this.visitStatements(question.getStatement());
		
		return null;
	}

	@Override
	public Object visitIfStatement(IfStatement ifStatement) {
		Expression expression = ifStatement.getExpression();
		
		BinaryExpressions binary = (BinaryExpressions)expression.accept(this);
		
		if (!(binary.evaluate().getValue() instanceof Boolean))
			throw new IllegalTypeException("IllegalTypeException: conditions must be of type boolean - " 
											+ expression.getCodeLines().toString());
		
		this.visitStatements(ifStatement.getStatement());
		
		return null;
	}

	@Override
	public Object visitAssign(Assign assign) {
		
		this.typeCheck.assignmentWithinScope(assign.getIdentifier());
		this.typeCheck.referenceUndefinedQuestion(assign.getIdentifier());
		this.typeCheck.hasDuplicateLabels(assign.getIdentifier(), assign.getExpression());
		this.expressionTable.putValue(assign.getIdentifier(), assign.getExpression());
		
		assign.getExpression().accept(this);
		assign.getIdentifier().accept(this);
		
		return null;
	}

	@Override
	public Expression visitBinaryExpression(BinaryExpressions expression) {
		
		Expression left = (Expression)expression.getLeftExpr().accept(this);
		Expression right = (Expression)expression.getRightExpr().accept(this);
		
		ExpressionSupporting validateExpression = new ExpressionSupporting(this.expressionTable, this.symbolTable, left, right, expression.getOperator() );
		return validateExpression.expressionValidator();
	}

	@Override
	public Object visitExpression(Expression expression) {
		return expression.accept(this);
	}

	@Override
	public Object visitExponentiation(Exponentiation exponentiation) {
		return this.visitBinaryExpression(exponentiation);
	}

	@Override
	public Object visitAddition(Addition addition) {
		return this.visitBinaryExpression(addition);
	}

	@Override
	public Object visitSubstraction(Substraction substraction) {
		return this.visitBinaryExpression(substraction);
	}

	@Override
	public Object visitMultiplication(Multiplication multipllication) {
		return this.visitBinaryExpression(multipllication);
	}

	@Override
	public Object visitDivision(Division division) {
		return this.visitBinaryExpression(division);
	}

	@Override
	public Object visitAnd(And and) {
		return this.visitBinaryExpression(and);
	}

	@Override
	public Object visitOr(Or or) {
		return this.visitBinaryExpression(or);
	}

	@Override
	public Object visitEqual(Equal equal) {
		return this.visitBinaryExpression(equal);
	}

	@Override
	public Object visitNotEqual(NotEqual notEqual) {
		return this.visitBinaryExpression(notEqual);
	}

	@Override
	public Object visitGreaterEqual(Greater_Eq greaterEqual) {
		return this.visitBinaryExpression(greaterEqual);
	}

	@Override
	public Object visitGreater(Greater greater) {
		return this.visitBinaryExpression(greater);
	}

	@Override
	public Object visitLessEqual(Less_Eq lessEqual) {
		return this.visitBinaryExpression(lessEqual);
	}

	@Override
	public Object visitLess(Less less) {
		return this.visitBinaryExpression(less);
	}

	@Override
	public Object visitType(Type type) {
		return null;
	}

	@Override
	public Object visitIdentifier(Identifier identifier) {
		this.typeCheck.referenceUndefinedQuestion(identifier);
		return identifier;
	}

	@Override
	public Object visitBooleanLiteral(BooleanLiteral booleanLiteral) {
		return booleanLiteral;
	}

	@Override
	public Object visitMoneyLiteral(MoneyLiteral moneyLiteral) {
		return moneyLiteral;
	}

	@Override
	public Object visitIntLiteral(IntLiteral intLiteral) {
		return intLiteral;
	}

	@Override
	public Object visitStringLiteral(StringLiteral stringLiteral) {
		return stringLiteral;
	}
}
