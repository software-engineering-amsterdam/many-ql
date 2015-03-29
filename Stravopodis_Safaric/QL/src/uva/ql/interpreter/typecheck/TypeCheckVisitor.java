package uva.ql.interpreter.typecheck;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import uva.ql.ast.Node;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.expressions.BinaryExpression;
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
	
	public List<IssueObject> errorList(){
		return issueList.errorList();
	}
	
	public List<IssueObject> getErrorOfType(IssueType.ERROR type){
		return this.issueList.getErrorOfType(type);
	}
	
	public void printIssues(){
		this.issueList.printIssues();
	}
	
	private boolean isDuplicateQuestionSameType(Question question){
		
		String questionIdentifier = question.getQuestionIdentifier().evaluate().getValue();
		Type questionType = question.getQuestionType();
		
		return this.symbolTable.valueEqualsTo(questionIdentifier, questionType);
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
	
	private boolean expressionOfType(List<Type> possibleTypes, List<Type> acceptedTypes){
		
		for (Type type : acceptedTypes){
			if (!possibleTypes.contains(type)){
				return false;
			}
		}
		
		return true;
	}
	
	private void cyclicDependencies(){
		
		DependencyHelper helper = new DependencyHelper();
		dependencyTable = helper.populateDependencyTable(dependencyTable);

		Set<String> cycles = helper.getCycles(dependencyTable);
		
		if (!cycles.isEmpty()){
			this.addCyclicIssues(cycles);
		}
	}
	
	private void addCyclicIssues(Set<String> cycles){
		for (String _identifier: cycles){
			IssueObject issue = new IssueObject(IssueType.ERROR.CYCLIC_DEPENDANCIES, _identifier, null);
			this.issueList.putIssue(issue);
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
		this.visitStatements(form.getFormStatements());
		
		return null;
	}
	
	private Object visitStatements(List<Statement> statements){
		for (Statement statement : statements){
			statement.accept(this);
		}
		
		return null;
	}

	@Override
	public Void visitASTNode(Node node) {
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
			this.visitBinaryLogical((BinaryExpression)ifStatement.getIfStatementExpression());
		}
		else {
			IssueObject issue = new IssueObject(IssueType.ERROR.CONDITION_NOT_BOOLEAN, ifStatement.getIfStatementExpression(),ifStatement.getCodeLine());
			this.issueList.putIssue(issue);
		}
		
		this.visitStatements(ifStatement.getStatements());
		
		return null;
	}
	
	@Override
	public Void visitSimpleQuestion(Question question) {
		this.visitQuestion(question);
		
		return null;
	}

	@Override
	public Void visitComputedQuestion(Question question) {
		
		dependencyVisitor.visitExpression(question.getQuestionExpression());
		dependencyTable.putValue(question.getQuestionIdentifierValue(), dependencyVisitor.getIdentifierSet());
		
		this.visitQuestion(question);
		question.getQuestionExpression().accept(this);

		return null;
	}
	
	private Object visitQuestion(Question question){
		String questionIdentifier = question.getQuestionIdentifierValue();
		String questionLabel = question.getQuestionLabelText();
		
		if (this.isDuplicateQuestionDifferentType(question)){
			IssueObject issue = new IssueObject(IssueType.ERROR.DUPLICATE_DIFFERENT_TYPE, question, question.getCodeLine());
			this.issueList.putIssue(issue);
		}
		
		if (isDuplicateQuestionSameType(question)){
			IssueObject issue = new IssueObject(IssueType.ERROR.DUPLICATE_SAME_TYPE, question, question.getCodeLine());
			this.issueList.putIssue(issue);
		}
		
		if (duplicateLabelCheck(question)){
			IssueObject issue = new IssueObject(IssueType.WARNING.DUPLICATE_QUESTION_LABEL, question, question.getCodeLine());
			this.issueList.putIssue(issue);
		}
		
		this.labelTable.putValue(questionLabel.replaceAll("\\s+",""), question.getCodeLine());
		this.symbolTable.putValue(questionIdentifier, question.getQuestionType());
		
		return null;
	}

	@Override
	public Void visitAssign(Assign assign) {
		assign.getAssignIdentifier().accept(this);
		assign.getAssignExpression().accept(this);
		
		return null;
	}

	@Override
	public Expression visitBinaryExpression(BinaryExpression expression) {	
		expression.accept(this);
		
		return null;
	}
	
	private Expression visitBinaryNumerical(BinaryExpression binaryExpression){
		
		Expression left = binaryExpression.getLeftExpr();
		Expression right = binaryExpression.getRightExpr();
		
		List<Type> acceptedTypes = Arrays.asList(new TypeMoney(), new TypeInteger());
		
		boolean leftIsNumerical = this.expressionOfType(left.possibleReturnTypes(), acceptedTypes);
		boolean rightIsNumerical = this.expressionOfType(right.possibleReturnTypes(), acceptedTypes);
		
		if (!leftIsNumerical){
			this.identifierExpressionValid(left, acceptedTypes);
		}
		
		if (!rightIsNumerical){
			this.identifierExpressionValid(right, acceptedTypes);
		}
			
		left.accept(this);
		right.accept(this);
		
		return null;
	}
	
	
	
	private Expression visitBinaryLogical(BinaryExpression binaryExpression){

		Expression left = binaryExpression.getLeftExpr();
		Expression right = binaryExpression.getRightExpr();
		
		List<Type> leftType = this.getExpressionType(left);
		List<Type> rightType = this.getExpressionType(right);
		
		if (Collections.disjoint(leftType, rightType)){
			IssueObject issue = new IssueObject(IssueType.ERROR.INVALID_OPERANDS_LOGICAL, binaryExpression, binaryExpression.getLinesOfCode());
			this.issueList.putIssue(issue);
		}
		
		left.accept(this);
		right.accept(this);
		
		return null;
	}
	
	private void identifierExpressionValid(Expression expression, List<Type> acceptedTypes){
		
		IssueObject issue = new IssueObject(IssueType.ERROR.INVALID_OPERANDS_MATH, expression, expression.getLinesOfCode());
		
		if (expression.isIdentifier()){
			Identifier identifier = (Identifier)expression;
			Type type = this.symbolTable.retrieveValue(identifier.getValue());
			
			if (type != null){
				if (!type.typeDoesConfirm(acceptedTypes)){
					this.issueList.putIssue(issue);
				}
			}
		}
		else {
			this.issueList.putIssue(issue);
		}
		
	}
	
	private List<Type> getExpressionType(Expression expression){
		
		if (expression.possibleReturnTypes().contains(new TypeString())){
			
			Identifier identifier = (Identifier)expression;
			
			Type type = this.symbolTable.retrieveValue(identifier.getValue());
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
			IssueObject issue = new IssueObject(IssueType.ERROR.REFERENCE_UNDEFINED, identifier, identifier.getLinesOfCode());
			this.issueList.putIssue(issue);
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
