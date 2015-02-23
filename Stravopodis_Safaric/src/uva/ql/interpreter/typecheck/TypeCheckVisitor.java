package uva.ql.interpreter.typecheck;


import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
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
import uva.ql.ast.visitor.VisitorInterface;
import uva.ql.interpreter.typecheck.exception.IllegalTypeException;

public class TypeCheckVisitor implements VisitorInterface<Void>{

	public SymbolMap symbols = new SymbolMap();
	
	
	@Override
	public Void visitProg(Prog prog) {
		this.visitForm(prog.getForm());
		return null;
	}

	@Override
	public Void visitForm(Form form) {
		
		CodeLines codeLines = form.getCodeLines();
		Symbol symbol = new Symbol(new Type("form", codeLines), form.getClass().getName());
		
		symbols.putValue(form.getIdentifier().evaluate().getValue(), symbol);
		
		for (Statement statement : form.getStatement()){
			this.visitStatement(statement);
		}
		return null;
	}

	@Override
	public Void visitASTNode(ASTNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitStatement(Statement statement) {
		statement.accept(this);
		return null;
	}

	@Override
	public Void visitQuestion(Question question) {
		
		Identifier identifier = question.getIdentifier();
		String identifierValue = identifier.evaluate().getValue();
		CodeLines codeLines = question.getCodeLines();
		
		if (symbols.exists(identifierValue)){
			Symbol _symbol = symbols.retrieve(identifierValue);
			String message;
			System.out.println(symbols.toString());
			
			for (String s : symbols.getAllKeys()){
				System.out.println(symbols.retrieve(s) + " " + s);
			}
			
			System.out.println(symbols.retrieve(identifierValue));
			
			if (_symbol.getClassName().equals(question.getClass().getName())){
				if (_symbol.getSymbolType().getTypeName().equals(question.getType().getTypeName()))
					message = "IllegalTypeException - duplicate questions, same type:";
				else 
					message = "IllegalTypeException - duplicate questions, different type:";
				
				throw new IllegalTypeException(message + identifierValue + " " + question.getType() + " - " + identifierValue + "," + _symbol.getSymbolType());
			}
		}
		
		Symbol symbol = new Symbol(question.getType(), question.getClass().getName(), codeLines);
		symbols.putValue(identifierValue, symbol);
		
		for (Statement statement : question.getStatement()){
			statement.accept(this);
		}
		
		identifier.accept(this);
		question.getType().accept(this);
		
		return null;
	}

	@Override
	public Void visitDeclaration(Declaration declaration) {
		// public Declaration(Identifier _identifier, Type _type, Expression _expressions, CodeLines _codeLines){
		
		Identifier identifier = declaration.getIdentifier();
		Type type = declaration.getType();
		Expression expression;
		
		if (declaration.getExpression() != null){
			expression = declaration.getExpression();
			expression.accept(this);
		}
		
		Symbol symbol = new Symbol(declaration.getType(), declaration.getClass().getName(), declaration.getCodeLines());
		symbols.putValue(identifier.evaluate().getValue(), symbol);
		
		identifier.accept(this);
		type.accept(this);
		
		return null;
	}

	@Override
	public Void visitIfStatement(IfStatement ifStatement) {
		
		Expression expression = ifStatement.getExpression();
		
		if (expression.evaluate().getValue().getClass() != Boolean.class)
			throw new IllegalTypeException("IllegalTypeException: conditions must be of type boolean - " 
											+ expression.getCodeLines().toString());
		
		for (Statement statement : ifStatement.getStatement()){
			statement.accept(this);
		}
		
		expression.accept(this);
		
		return null;
	}

	@Override
	public Void visitAssign(Assign assign) {
		// public Assign(Identifier _identifier, String ? Expression _expression, CodeLines _codeLines){
		// public Symbol (Type _type, String _className, CodeLines _address){
		Type type = new Type(assign.getExpression().evaluate().getValue().getClass().getSimpleName(), assign.getCodeLines());
		String identifier = assign.getIdentifier().evaluate().getValue();
		
		symbols.putValue(identifier, new Symbol(type, assign.getClass().getName(), assign.getCodeLines()));
		
		assign.getExpression().accept(this);
		assign.getIdentifier().accept(this);
		
		return null;
	}

	@Override
	public Void visitBinaryExpression(BinaryExpressions expression) {
		
		Expression left = expression.getLeftExpr();
		Expression right = expression.getRightExpr();
		
		left.accept(this);
		right.accept(this);
		
		return null;
	}

	@Override
	public Void visitExpression(Expression expression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitExponentiation(Exponentiation exponentiation) {
		// Should be NumberValue
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitAddition(Addition addition) {
		// Should be NumberValue
		//System.out.println(this.visitExpression(addition.getLeftExpr()).getClass().getName());
		
		this.visitBinaryExpression(addition);
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitSubstraction(Substraction substraction) {
		// Should be NumberValue
		this.visitBinaryExpression(substraction);
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitMultiplication(Multiplication multipllication) {
		// Should be NumberValue
		this.visitBinaryExpression(multipllication);
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitDivision(Division division) {
		// Should be NumberValue
		this.visitBinaryExpression(division);
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitAnd(And and) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitOr(Or or) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitEqual(Equal equal) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitNotEqual(NotEqual notEqual) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitGreaterEqual(Greater_Eq greaterEqual) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitGreater(Greater greater) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitLessEqual(Less_Eq lessEqual) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitLess(Less less) {
		// Should be of equal class
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitType(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitIdentifier(Identifier identifier) {
		
		return null;
	}

	@Override
	public Void visitBooleanLiteral(BooleanLiteral booleanLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visitDecimalLiteral(DecimalLiteral decimalLiteral) {
		System.out.println(decimalLiteral);
		
		return null;
	}

	@Override
	public Void visitIntLiteral(IntLiteral intLiteral) {
		System.out.println(intLiteral);
		
		return null;
	}

	@Override
	public Void visitStringLiteral(StringLiteral stringLiteral) {
		// TODO Auto-generated method stub
		return null;
	}
}
