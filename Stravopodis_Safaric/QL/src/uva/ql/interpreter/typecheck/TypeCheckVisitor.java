package uva.ql.interpreter.typecheck;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.type.TypeInteger;
import uva.ql.ast.type.TypeMoney;
import uva.ql.ast.type.TypeString;
import uva.ql.ast.visitor.ExpressionVisitor;
import uva.ql.ast.visitor.StatementVisitor;
import uva.ql.ast.visitor.TypeVisitor;
import uva.ql.interpreter.typecheck.depedency.DependencyExpressionVisitor;
import uva.ql.interpreter.typecheck.depedency.DependencyHelper;
import uva.ql.interpreter.typecheck.depedency.DependencySet;
import uva.ql.interpreter.typecheck.depedency.DependencyTable;
import uva.ql.interpreter.typecheck.error.IssueList;
import uva.ql.interpreter.typecheck.error.IssueObject;
import uva.ql.interpreter.typecheck.error.IssueType;
import uva.ql.interpreter.typecheck.table.LabelTable;
import uva.ql.interpreter.typecheck.table.SymbolTable;

public class TypeCheckVisitor implements ExpressionVisitor<Expression>, StatementVisitor<Void>, TypeVisitor<Type>{

	private final IssueList issueList = new IssueList();
	private final SymbolTable symbolTable = new SymbolTable();
	private final LabelTable labelTable = new LabelTable();
	
	private final DependencyExpressionVisitor dependencyVisitor = new DependencyExpressionVisitor();
	private DependencyTable dependencyTable = new DependencyTable();
	
	/* Type Check Methods */
	
	public boolean hasErrors(){
		return this.issueList.hasErrors();
	}
	
	public void printIssues(){
		this.issueList.printIssues();
	}
	
	private boolean isDuplicateQuestionSameType(Question question){
		
		String questionIdentifier = question.getQuestionIdentifier().evaluate().getValue();
		Type questionType = question.getQuestionType();
		
		return this.symbolTable.valueExists(questionIdentifier, questionType);
	}
	
	private boolean isDuplicateQuestionDifferentType(Question question){
		
		String questionIdentifier = question.getQuestionIdentifier().evaluate().getValue();
		Type questionType = question.getQuestionType();
		
		if (this.symbolTable.keyExists(questionIdentifier)){
			return !this.symbolTable.retrieveValue(questionIdentifier).equals(questionType);
		}
		
		return false;
	}
	
	private boolean referenceToUndefinedQuestion(Identifier identifier){
		return !symbolTable.keyExists(identifier.evaluate().getValue());
	}
	
	private boolean duplicateLabelCheck(Question question){
		return this.labelTable.keyExists(question.getQuestionLabel().evaluate().getValue().replaceAll("\\s+",""));
	}
	
	private boolean expressionOfType(List<Type> possibleTypes, List<Type> supportedTypes){
		
		for (Type type : supportedTypes){
			if (possibleTypes.contains(type)){
				return true;
			}
		}
		
		return false;
	}
	
	private void cyclicDependencies(){
		
		dependencyTable = DependencyHelper.populateFullDependencies(dependencyTable);
		
		Set<String> cycles = DependencyHelper.findCycles(dependencyTable);
		
		if (!cycles.isEmpty()){
			for (String _identifier: cycles){
				IssueObject issue = new IssueObject(IssueType.ERROR.CYCLIC_DEPENDANCIES, _identifier, null);
				this.issueList.putIssueObject(issue);
			}
		}
	}
	
	/* Type Check Visitor */
	
	@Override
	public Void visitProg(Prog prog) {
		prog.getForm().accept(this);
		this.cyclicDependencies();
		
		return null;
	}

	@Override
	public Void visitForm(Form form) {
		this.visitStatements(form.getStatement());
		
		return null;
	}
	
	private Object visitStatements(List<Statement> statements){
		for (Statement statement : statements){
			statement.accept(this);
		}
		
		return null;
	}

	@Override
	public Void visitASTNode(ASTNode node) {
		return null;
	}

	@Override
	public Void visitStatement(Statement statement) {
		statement.accept(this);
		
		return null;
	}


	@Override
	public Void visitIfStatement(IfStatement ifStatement) {
		
		if (ifStatement.hasBooleanCondition()){			
			this.visitBinaryLogical((BinaryExpressions)ifStatement.getExpression());
		}
		else {
			IssueObject issue = new IssueObject(IssueType.ERROR.CONDITION_NOT_BOOLEAN, ifStatement.getExpression(),ifStatement.getCodeLine());
			this.issueList.putIssueObject(issue);
		}
		
		this.visitStatements(ifStatement.getStatement());
		
		return null;
	}
	
	@Override
	public Void visitSimpleQuestion(Question question) {
		this.visitQuestion(question);
		
		return null;
	}

	@Override
	public Void visitComputedQuestion(Question question) {
		
		// CAUTION
		dependencyVisitor.visitExpression(question.getQuestionExpression());
		
		DependencySet dependencies = new DependencySet(dependencyVisitor.getIdentifierList().toString());
		dependencyTable.putValue(question.getQuestionIdentifierValue(), dependencies);
			
		this.visitQuestion(question);
		question.getQuestionExpression().accept(this);

		return null;
	}
	
	private Object visitQuestion(Question question){
		String questionIdentifier = question.getQuestionIdentifierValue();
		String questionLabel = question.getQuestionLabelText();
		
		if (this.isDuplicateQuestionDifferentType(question)){
			IssueObject issue = new IssueObject(IssueType.ERROR.DUPLICATE_DIFFERENT_TYPE, question, question.getCodeLine());
			this.issueList.putIssueObject(issue);
		}
		
		if (isDuplicateQuestionSameType(question)){
			IssueObject issue = new IssueObject(IssueType.ERROR.DUPLICATE_SAME_TYPE, question, question.getCodeLine());
			this.issueList.putIssueObject(issue);
		}
		
		if (duplicateLabelCheck(question)){
			IssueObject issue = new IssueObject(IssueType.WARNING.DUPLICATE_QUESTION_LABEL, question, question.getCodeLine());
			this.issueList.putIssueObject(issue);
		}
		
		this.labelTable.putValue(questionLabel.replaceAll("\\s+",""), question.getCodeLine());
		this.symbolTable.putValue(questionIdentifier, question.getQuestionType());
		
		return null;
	}

	@Override
	public Void visitAssign(Assign assign) {
		assign.getIdentifier().accept(this);
		assign.getExpression().accept(this);
		
		return null;
	}

	@Override
	public Expression visitBinaryExpression(BinaryExpressions expression) {	
		expression.accept(this);
		
		return null;
	}
	
	private Expression visitBinaryNumerical(BinaryExpressions binaryExpression){
		
		Expression left = binaryExpression.getLeftExpr();
		Expression right = binaryExpression.getRightExpr();
		
		List<Type> supportedTypes = Arrays.asList(new TypeMoney(), new TypeInteger());
		
		boolean leftIsNumerical = this.expressionOfType(left.possibleReturnTypes(), supportedTypes);
		boolean rightIsNumerical = this.expressionOfType(right.possibleReturnTypes(), supportedTypes);
		
		// If the leftIsNumerical | rightIsNumerical are false - check if they are Identifiers
		
		this.checkIdentifierTypeCompliance(leftIsNumerical, left, supportedTypes);
		this.checkIdentifierTypeCompliance(rightIsNumerical,right , supportedTypes);
		
		left.accept(this);
		right.accept(this);
		
		return null;
	}
	
	
	
	private Expression visitBinaryLogical(BinaryExpressions binaryExpression){

		Expression left = binaryExpression.getLeftExpr();
		Expression right = binaryExpression.getRightExpr();
		
		List<Type> leftType = this.getExpressionType(left);
		List<Type> rightType = this.getExpressionType(right);
		
		// Checking operator - operand support
		if (Collections.disjoint(leftType, rightType)){
			IssueObject issue = new IssueObject(IssueType.ERROR.INVALID_OPERANDS_LOGICAL, binaryExpression, binaryExpression.getCodeLine());
			this.issueList.putIssueObject(issue);
		}
		
		// Operands must be of the same type
		if (Collections.disjoint(leftType, rightType)){
			IssueObject issue = new IssueObject(IssueType.ERROR.INVALID_OPERANDS_LOGICAL, binaryExpression, binaryExpression.getCodeLine());
			this.issueList.putIssueObject(issue);
		}
		
		left.accept(this);
		right.accept(this);
		
		return null;
	}
	
	private void checkIdentifierTypeCompliance(boolean isOfType, Expression expression, List<Type> supportedTypes){
		
		if (!isOfType && !expression.possibleReturnTypes().containsAll(supportedTypes)){
				
			// Check is an expression is of type Identifier() of type TypeString() - sellingPrice integer e.g.
			// Prepare an issue
			IssueObject issue = new IssueObject(IssueType.ERROR.INVALID_OPERANDS_MATH, expression, expression.getCodeLine());
			
			if (expression.possibleReturnTypes().contains(new TypeString())){
				
				// Get question type of an Identifier (expression)
				
				Type type = this.symbolTable.retrieveValue(expression.getEvaluatedValue().toString());
				
				if (!type.checkTypeConformance(supportedTypes)){
					this.issueList.putIssueObject(issue);
				}
			}
			else {
				this.issueList.putIssueObject(issue);
			}
		}
	}
	
	private List<Type> getExpressionType(Expression expression){
		
		// Check is an expression is an Identifier() of TypeString()
		
		if (expression.possibleReturnTypes().contains(new TypeString())){
			Type type = this.symbolTable.retrieveValue(expression.getEvaluatedValue().toString());
			return Arrays.asList(type);
		}
		
		return expression.possibleReturnTypes();
	}

	@Override
	public Expression visitExpression(Expression expression) {		
		return expression.accept(this);
	}

	@Override
	public Expression visitExponentiation(Exponentiation exponentiation) {
		return this.visitBinaryNumerical(exponentiation);
	}

	@Override
	public Expression visitAddition(Addition addition) {
		return this.visitBinaryNumerical(addition);
	}

	@Override
	public Expression visitSubstraction(Substraction substraction) {
		return this.visitBinaryNumerical(substraction);
	}

	@Override
	public Expression visitMultiplication(Multiplication multipllication) {
		return this.visitBinaryNumerical(multipllication);
	}

	@Override
	public Expression visitDivision(Division division) {
		return this.visitBinaryNumerical(division);
	}

	@Override
	public Expression visitAnd(And and) {
		return this.visitBinaryLogical(and);
	}

	@Override
	public Expression visitOr(Or or) {
		return this.visitBinaryLogical(or);
	}

	@Override
	public Expression visitEqual(Equal equal) {
		return this.visitBinaryLogical(equal);
	}

	@Override
	public Expression visitNotEqual(NotEqual notEqual) {
		return this.visitBinaryLogical(notEqual);
	}

	@Override
	public Expression visitGreaterEqual(Greater_Eq greaterEqual) {
		return this.visitBinaryLogical(greaterEqual);
	}

	@Override
	public Expression visitGreater(Greater greater) {
		return this.visitBinaryLogical(greater);
	}

	@Override
	public Expression visitLessEqual(Less_Eq lessEqual) {
		return this.visitBinaryLogical(lessEqual);
	}

	@Override
	public Expression visitLess(Less less) {
		return this.visitBinaryLogical(less);
	}

	@Override
	public Identifier visitIdentifier(Identifier identifier) {
		
		if (this.referenceToUndefinedQuestion(identifier)){
			IssueObject issue = new IssueObject(IssueType.ERROR.REFERENCE_UNDEFINED, identifier, identifier.getCodeLine());
			this.issueList.putIssueObject(issue);
		}
		
		return identifier;
	}

	@Override
	public BooleanLiteral visitBooleanLiteral(BooleanLiteral booleanLiteral) {
		return booleanLiteral;
	}

	@Override
	public MoneyLiteral visitMoneyLiteral(MoneyLiteral moneyLiteral) {
		return moneyLiteral;
	}

	@Override
	public IntLiteral visitIntLiteral(IntLiteral intLiteral) {
		return intLiteral;
	}

	@Override
	public StringLiteral visitStringLiteral(StringLiteral stringLiteral) {
		return stringLiteral;
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
