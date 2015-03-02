package uva.ql.interpreter.gui;

import java.util.List;
import uva.ql.ast.ASTNode;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
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
import uva.ql.ast.visitor.ExpressionVisitorInterface;
import uva.ql.ast.visitor.StatementVisitorInterface;
import uva.ql.interpreter.gui.elements.UIContainer;
import uva.ql.interpreter.observer.Observer;
import uva.ql.interpreter.observer.Subject;
import uva.ql.interpreter.typecheck.SymbolMap;
import uva.ql.supporting.ExpressionSupporting;
import uva.ql.interpreter.gui.elements.*;

public class GUIVisitor extends Observer implements StatementVisitorInterface<Object>, ExpressionVisitorInterface<Object>{

	
	private SymbolMap symbolTable;
	private Prog prog;
	protected GUI gui;
	
	public GUIVisitor(SymbolMap _symbolTable, Prog _prog, Subject _subject){
		this.symbolTable = _symbolTable;
		this.subject = _subject;
		this.subject.setObserver(this);
		this.prog = _prog;
	}
	
	@Override
	public void update() {
		this.gui.container.removeAll();
		this.gui.container.revalidate();
		
		this.visitProg(this.prog);
	}
	
	private Object visitStatements(List<Statement> statements){
		for(Statement statement : statements)
			statement.accept(this);
		return null;
	}
	
	@Override
	public Object visitProg(Prog prog) {
		this.visitForm(prog.getForm());
		return null;
	}

	@Override
	public Object visitForm(Form form) {
		this.gui.setFrame();
		this.visitStatements(form.getStatement());
		return null;
	}

	@Override
	public Object visitASTNode(ASTNode node) {
		return null;
	}

	@Override
	public Object visitStatement(Statement statement) {
		return statement.accept(this);
	}

	@Override
	public Object visitQuestion(Question question) {		
		
		String identifier = question.getIdentifier().evaluate().getValue();
		Expression expression = this.gui.expressionForQuestion(this.symbolTable, identifier);
		
		UIQuestion uiQuestion = new UIQuestion(question, this.symbolTable, this.subject, expression);
		UIContainer component = uiQuestion.createElement();
		this.gui.container.addComponent(component);
		this.gui.container.getPanel().revalidate();
		this.gui.setFocus(identifier, this.subject, component);
		
		this.visitStatements(question.getStatement());
		return question;
	}

	@Override
	public Object visitIfStatement(IfStatement ifStatement) {
		
		Expression expression = ifStatement.getExpression();
		BinaryExpressions binary = (BinaryExpressions)expression.accept(this);
		
		if ((boolean)binary.evaluate().getValue() == true){
			for (Statement statement : ifStatement.getStatement()){
				statement.accept(this);
			}
		}
		
		return null;
	}

	@Override
	public Object visitAssign(Assign assign) {
		return assign;
	}

	@Override
	public Object visitBinaryExpression(BinaryExpressions expression) {
		Expression left = (Expression)expression.getLeftExpr().accept(this);
		Expression right = (Expression)expression.getRightExpr().accept(this);
		
		ExpressionSupporting validateExpression = new ExpressionSupporting(this.symbolTable, left, right, expression.getOperator());
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
		return type;
	}

	@Override
	public Object visitIdentifier(Identifier identifier) {
		return identifier;
	}

	@Override
	public Object visitBooleanLiteral(BooleanLiteral booleanLiteral) {
		return booleanLiteral;
	}

	@Override
	public Object visitDecimalLiteral(DecimalLiteral decimalLiteral) {
		return decimalLiteral;
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
