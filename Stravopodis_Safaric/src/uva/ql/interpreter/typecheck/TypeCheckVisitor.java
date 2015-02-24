package uva.ql.interpreter.typecheck;


import java.util.List;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
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
import uva.ql.ast.visitor.VisitorInterface;
import uva.ql.interpreter.typecheck.exception.IllegalTypeException;

public class TypeCheckVisitor implements VisitorInterface<Object>{

	public SymbolMap symbols = new SymbolMap();
	
	// Check whether an e.g. assignment is within the scope a question declaration
	private boolean withinScope(CodeLines x, CodeLines y){
		if (x == null || y == null) return false;
		return 		x.getSourceCodeLocation().x > y.getSourceCodeLocation().x 
				&& 	x.getSourceCodeLocation().y <= y.getSourceCodeLocation().y;
	}
	
	private boolean questionReferenceUndefined(Identifier identifier){
		return this.symbols.existsWithClassType(identifier.evaluate().getValue(), Question.class.getName());
	}
	
	@Override
	public Object visitProg(Prog prog) {
		this.visitForm(prog.getForm());
		return null;
	}

	@Override
	public Object visitForm(Form form) {
		
		Symbol symbol = new Symbol("form", form.getClass().getName(), form.getCodeLines());
		symbols.putValue(form.getIdentifier().evaluate().getValue(), symbol);
		
		this.visitStatements(form.getStatement());
		return null;
	}

	@Override
	public Object visitASTNode(ASTNode node) {
		// TODO Auto-generated method stub
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
		
		Symbol symbol = new Symbol(question.getType().getTypeName(), question.getClass().getName(), question.getCodeLines());
		
		Identifier identifier = question.getIdentifier();
		String identifierValue = identifier.evaluate().getValue();
		
		if (symbols.existsWithClassType(identifierValue, question.getClass().getName())){
			
			if (symbols.keyWithSymbolExists(identifierValue, symbol))
				throw new IllegalTypeException("IllegalTypeException: duplicate question with same type" + identifierValue);
			else 
				throw new IllegalTypeException("IllegalTypeException: duplicate question with different type" + identifierValue);	
		}
		
		symbols.putValue(identifierValue, symbol);
		
		identifier.accept(this);
		question.getType().accept(this);
		
		this.visitStatements(question.getStatement());
		return null;
	}

	@Override
	public Object visitIfStatement(IfStatement ifStatement) {
		
		Expression expression = ifStatement.getExpression();
		
		if (expression.evaluate().getValue().getClass() != Boolean.class)
			throw new IllegalTypeException("IllegalTypeException: conditions must be of type boolean - " 
											+ expression.getCodeLines().toString());
		

		expression.accept(this);
		this.visitStatements(ifStatement.getStatement());
		
		return null;
	}

	@Override
	public Object visitAssign(Assign assign) {
		
		Type type = new Type(assign.getExpression().evaluate().getValue().getClass().getSimpleName().toLowerCase(), assign.getCodeLines());
		String identifier = assign.getIdentifier().evaluate().getValue();
		Expression expression = assign.getExpression();
		
		// Check whether this identifier is defined as an question, but it has to be within scope of the question
		if (this.symbols.exists(identifier)){			
			Symbol symbol = symbols.getSymbolForAttributes(identifier, null , Question.class.getName());
			
			if (!this.withinScope(assign.getCodeLines(), symbol.getCodeLines()))
				throw new IllegalArgumentException("IllegalArgumentException: question assignment not in scope of question -> " 
													+ assign.getCodeLines().toString());
			
		}
		
		// Check for duplicate labels
		if (expression.getClass().equals(StringLiteral.class) && symbols.contentExists(expression))
			throw new IllegalArgumentException("IllegalArgumentException: multiple question instances have same question: " 
											+ expression.evaluate().getValue().toString());
		
		symbols.putValue(identifier, 
				new Symbol(type.getTypeName(), assign.getClass().getName(), assign.getCodeLines(), expression));
		
		this.visitExpression(expression);
		assign.getExpression().accept(this);
		assign.getIdentifier().accept(this);
		
		return null;
	}

	@Override
	public Object visitBinaryExpression(BinaryExpressions expression) {
		
		Expression left = expression.getLeftExpr();
		Expression right = expression.getRightExpr();
		
		left.accept(this);
		right.accept(this);
		
		return null;
	}

	@Override
	public Object visitExpression(Expression expression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitExponentiation(Exponentiation exponentiation) {
		// Should be NumberValue
		
		this.visitBinaryExpression(exponentiation);
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitAddition(Addition addition) {
		// Should be NumberValue
		
		this.visitBinaryExpression(addition);
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitSubstraction(Substraction substraction) {
		// Should be NumberValue
		
		this.visitBinaryExpression(substraction);
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitMultiplication(Multiplication multipllication) {
		// Should be NumberValue
		this.visitBinaryExpression(multipllication);
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDivision(Division division) {
		// Should be NumberValue
		this.visitBinaryExpression(division);
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitAnd(And and) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitOr(Or or) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitEqual(Equal equal) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public Object visitNotEqual(NotEqual notEqual) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitGreaterEqual(Greater_Eq greaterEqual) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitGreater(Greater greater) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitLessEqual(Less_Eq lessEqual) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitLess(Less less) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitType(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitIdentifier(Identifier identifier) {
		
		if (!questionReferenceUndefined(identifier))
			throw new IllegalArgumentException("IllegalArgumentException: reference to an undefined question -> " 
												+ identifier.toString());
		
		return null;
	}

	@Override
	public Object visitBooleanLiteral(BooleanLiteral booleanLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDecimalLiteral(DecimalLiteral decimalLiteral) {
		System.out.println(decimalLiteral);
		
		return null;
	}

	@Override
	public Object visitIntLiteral(IntLiteral intLiteral) {
		System.out.println(intLiteral);
		
		return null;
	}

	@Override
	public Object visitStringLiteral(StringLiteral stringLiteral) {
		// TODO Auto-generated method stub
		return null;
	}
}
