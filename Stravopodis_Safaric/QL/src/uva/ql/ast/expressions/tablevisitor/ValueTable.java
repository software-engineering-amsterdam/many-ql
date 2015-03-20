package uva.ql.ast.expressions.tablevisitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import uva.ql.ast.ASTNode;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.BooleanLiteral;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.IntLiteral;
import uva.ql.ast.expressions.literals.Literal;
import uva.ql.ast.expressions.literals.MoneyLiteral;
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
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.type.TypeInteger;
import uva.ql.ast.type.TypeMoney;
import uva.ql.ast.type.TypeString;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.value.StringValue;
import uva.ql.ast.visitor.ExpressionVisitor;
import uva.ql.ast.visitor.StatementVisitor;
import uva.ql.ast.visitor.TypeVisitor;

public class ValueTable implements  ExpressionVisitor<Object>, StatementVisitor<Object>, TypeVisitor<Type>{
	
	/*
	 * Visitor creating the following structure: Map<String, Expression>
	 * it resolves the problem of having for instance: sellingPrice = valueResidue * 100
	 * where valueResidue of primitive type int for instance
	 * it replaces in expressions identifiers with literals of a particular type (Money || Integer)
	 */
	
	private final Map<String, GenericValue<?>> valueTable = new HashMap<String, GenericValue<?>>();
	private final Prog prog;
	
	public ValueTable(Prog _prog) {
		this.prog = _prog;
		this.visitProg(this.prog);
	}
	
	public void updateValueTable(){
		this.visitProg(this.prog);
	}
	
	public Map<String, GenericValue<?>> getValueTable(){
		return this.valueTable;
	}
	
	public Set<String> getKeySet(){
		return this.valueTable.keySet();
	}
	
	public GenericValue<?> getValue(String identifier){
		return this.valueTable.get(identifier);
	}
	
	public void updateValueTable(String identifier, GenericValue<?> value){
		this.valueTable.put(identifier, value);
	}
	
	public boolean conditionalExpression(Expression expression){
		return (boolean)this.visitExpression(expression).getValue();
	}
	
	@Override
	public Object visitProg(Prog prog) {
		prog.getForm().accept(this);
		
		return null;
	}

	@Override
	public Object visitForm(Form form) {
		for(Statement statement : form.getStatement()){
			statement.accept(this);
		}
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

	@Override
	public Object visitSimpleQuestion(Question question) {
		GenericValue<?> questionInitialValue = question.getQuestionType().typeInitialValue();
		String questionIdentifier = question.getQuestionIdentifier().evaluate().getValue();
		
		if (!this.valueTable.containsKey(questionIdentifier)){
			this.valueTable.put(questionIdentifier, questionInitialValue);
		}
		
		return null;
	}

	@Override
	public Object visitComputedQuestion(Question question) {
		
		GenericValue<?> expression = this.visitExpression(question.getQuestionExpression());
		String questionIdentifier = question.getQuestionIdentifier().evaluate().getValue();
	
		if (this.valueTable.containsKey(questionIdentifier) && question.getQuestionExpression() instanceof Literal){
			return null;
		}
		
		this.valueTable.put(questionIdentifier, expression);
		
		return null;
	}

	@Override
	public Object visitIfStatement(IfStatement ifStatement) {
		
		for (Statement statement : ifStatement.getStatement()){
			statement.accept(this);
		}
		
		ifStatement.getExpression().accept(this);
		
		return null;
	}

	@Override
	public Object visitAssign(Assign assign) {
		assign.getExpression().accept(this);
		return null;
	}
	
	@Override
	public Expression visitBinaryExpression(BinaryExpressions expression) {
		Expression left = expression.getLeftExpr();
		Expression right = expression.getRightExpr();
		
		left.accept(this);
		right.accept(this);
		
		return null;
	}

	@Override
	public GenericValue<?> visitExpression(Expression expression) {
		return (GenericValue<?>)expression.accept(this);
	}

	@Override
	public NumberValue visitExponentiation(Exponentiation exponentiation) {
		NumberValue leftValue = (NumberValue)exponentiation.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)exponentiation.getRightExpr().accept(this);
		
		return leftValue.exponentiation(rightValue);
	}

	@Override
	public NumberValue visitAddition(Addition addition) {
		NumberValue leftValue = (NumberValue)addition.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)addition.getRightExpr().accept(this);
		
		return leftValue.addition(rightValue);
	}

	@Override
	public NumberValue visitSubstraction(Substraction substraction) {
		NumberValue leftValue = (NumberValue)substraction.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)substraction.getRightExpr().accept(this);
		
		return leftValue.substraction(rightValue);
	}

	@Override
	public NumberValue visitMultiplication(Multiplication multipllication) {
		NumberValue leftValue = (NumberValue)multipllication.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)multipllication.getRightExpr().accept(this);
		
		return leftValue.multiplication(rightValue);	
	}

	@Override
	public NumberValue visitDivision(Division division) {
		NumberValue leftValue = (NumberValue)division.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)division.getRightExpr().accept(this);
		
		return leftValue.division(rightValue);	
	}

	@Override
	public BooleanValue visitAnd(And and) {
		BooleanValue leftValue = (BooleanValue)and.getLeftExpr().accept(this);
		BooleanValue rightValue = (BooleanValue)and.getRightExpr().accept(this);
		
		return leftValue.and(rightValue);
	}

	@Override
	public BooleanValue visitOr(Or or) {
		BooleanValue leftValue = (BooleanValue)or.getLeftExpr().accept(this);
		BooleanValue rightValue = (BooleanValue)or.getRightExpr().accept(this);
		
		return leftValue.or(rightValue);
	}

	@Override
	public BooleanValue visitEqual(Equal equal) {
		GenericValue<?> leftValue = (GenericValue<?>)equal.getLeftExpr().accept(this);
		GenericValue<?> rightValue = (GenericValue<?>)equal.getRightExpr().accept(this);
		
		return new BooleanValue(leftValue.equalsTo(rightValue));
	}

	@Override
	public BooleanValue visitNotEqual(NotEqual notEqual) {
		GenericValue<?> leftValue = (GenericValue<?>)notEqual.getLeftExpr().accept(this);
		GenericValue<?> rightValue = (GenericValue<?>)notEqual.getRightExpr().accept(this);
		
		return new BooleanValue(leftValue.isNotEqual(rightValue));
	}

	@Override
	public BooleanValue visitGreaterEqual(Greater_Eq greaterEqual) {
		NumberValue leftValue = (NumberValue)greaterEqual.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)greaterEqual.getRightExpr().accept(this);
		
		return leftValue.greaterEqual(rightValue);
	}

	@Override
	public BooleanValue visitGreater(Greater greater) {
		NumberValue leftValue = (NumberValue)greater.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)greater.getRightExpr().accept(this);
		
		return leftValue.greater(rightValue);
	}

	@Override
	public BooleanValue visitLessEqual(Less_Eq lessEqual) {
		NumberValue leftValue = (NumberValue)lessEqual.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)lessEqual.getRightExpr().accept(this);
		
		return leftValue.lessEqual(rightValue);
	}

	@Override
	public BooleanValue visitLess(Less less) {
		NumberValue leftValue = (NumberValue)less.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)less.getRightExpr().accept(this);
		
		return leftValue.less(rightValue);
	}

	@Override
	public GenericValue<?> visitIdentifier(Identifier identifier) {
		return identifier.getValue(this);
	}

	@Override
	public BooleanValue visitBooleanLiteral(BooleanLiteral booleanLiteral) {
		return booleanLiteral.evaluate();
	}

	@Override
	public NumberValue visitMoneyLiteral(MoneyLiteral moneyLiteral) {
		return moneyLiteral.evaluate();
	}

	@Override
	public NumberValue visitIntLiteral(IntLiteral intLiteral) {
		return intLiteral.evaluate();
	}

	@Override
	public StringValue visitStringLiteral(StringLiteral stringLiteral) {
		return stringLiteral.evaluate();
	}

	@Override
	public TypeBoolean visitTypeBoolean(TypeBoolean booleanType) {
		return booleanType;
	}

	@Override
	public TypeInteger visitTypeInteger(TypeInteger integerType) {
		return integerType;
	}

	@Override
	public TypeMoney visitTypeMoney(TypeMoney moneyType) {
		return moneyType;
	}

	@Override
	public TypeString visitTypeString(TypeString stringType) {
		return stringType;
	}
	
}
