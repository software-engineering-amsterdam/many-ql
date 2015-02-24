package uva.ql.interpreter.typecheck;


import java.util.ArrayList;
import java.util.List;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.PrimitiveType;
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
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;
import uva.ql.ast.visitor.StatementVisitorInterface;
import uva.ql.interpreter.typecheck.exception.IllegalTypeException;

public class TypeCheckVisitor implements ExpressionVisitorInterface<Object>, StatementVisitorInterface<Object>{

	private SymbolMap symbols = new SymbolMap();
	
	public SymbolMap getSymbolTable(){
		return this.symbols;
	}
	
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
		
		
		System.err.println(ifStatement.getExpression().accept(this));
		
		/*Object evaluatedExpression = ifStatement.evaluate().getValue();
		
		if (evaluatedExpression.getClass().equals(Identifier.class)){
			System.out.println("Found some identifier");
		}*/
		
		//if (expression.evaluate().getValue().getClass() != Boolean.class)
			//throw new IllegalTypeException("IllegalTypeException: conditions must be of type boolean - " 
				//							+ expression.getCodeLines().toString());
		

		ifStatement.getExpression().accept(this);
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
	public List<Object> visitBinaryExpression(BinaryExpressions expression) {
		
		Expression left = expression.getLeftExpr();
		Expression right = expression.getRightExpr();
		
		left.accept(this);
		right.accept(this);
		
		// Identifiers evaluated in accordance to their type
		List<Object> objects = new ArrayList<Object>();
		objects.add(left.accept(this));
		objects.add(right.accept(this));
		
		
		System.err.println(findSomeValue(objects, "boolean"));
		
		return objects;
	}
	private List<GenericValue<?>> findSomeValue(List<Object> objects, String type){
		// create a map that stores all of these values!
		
		
		List<GenericValue<?>> genericValue = new ArrayList<GenericValue<?>>();
		
		for (Object _expression : objects){
			if (_expression.getClass().equals(Identifier.class)){
				String identifier = ((Expression)_expression).evaluate().getValue().toString();
				
				for (Symbol symbol : this.symbols.retrieve(identifier)){
					if (symbol.getClassName().equals(Assign.class.getName()) && symbol.getContent() != null){
						if (symbol.getSymbolType().equals(type)){
							Object obj = PrimitiveType.identifierFromPrimitiveType(symbol.getSymbolType(), symbol.getContent());
							
							genericValue.add((GenericValue<?>)obj);
						}
					}
				}
			}
		}
		return genericValue;
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
		
		if (!questionReferenceUndefined(identifier))
			throw new IllegalArgumentException("IllegalArgumentException: reference to an undefined question -> " 
												+ identifier.toString());
		
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
		return null;
	}
}
