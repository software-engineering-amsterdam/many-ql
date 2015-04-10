package qlProject.typeChecking.typeCheckVisitors;
import java.util.HashSet;
import java.util.Map;

import qlProject.ast.expression.BinaryExpression;
import qlProject.ast.expression.IExpressionVisitor;
import qlProject.ast.expression.Id;
import qlProject.ast.expression.ParenthesisExpr;
import qlProject.ast.expression.UnaryExpression;
import qlProject.ast.expression.StringExpr.ConcatenationExpr;
import qlProject.ast.expression.StringExpr.StringLiteral;
import qlProject.ast.expression.arithmeticExpr.AdditionExpr;
import qlProject.ast.expression.arithmeticExpr.DivisionExpr;
import qlProject.ast.expression.arithmeticExpr.IntLiteral;
import qlProject.ast.expression.arithmeticExpr.MultiplicationExpr;
import qlProject.ast.expression.arithmeticExpr.NegationExpr;
import qlProject.ast.expression.arithmeticExpr.SubtractionExpr;
import qlProject.ast.expression.booleanExpr.BoolLiteral;
import qlProject.ast.expression.booleanExpr.comparisonExpression.BiggerEqExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.BiggerThanExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.EqualExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.SmallerEqExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.SmallerThanExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.UnequalExpr;
import qlProject.ast.expression.booleanExpr.logicalExpression.AndExpr;
import qlProject.ast.expression.booleanExpr.logicalExpression.NotExpr;
import qlProject.ast.expression.booleanExpr.logicalExpression.OrExpr;
import qlProject.ast.type.BooleanType;
import qlProject.ast.type.IntType;
import qlProject.ast.type.StringType;
import qlProject.ast.type.Type;
import qlProject.typeChecking.complaints.Complaint;
import qlProject.typeChecking.complaints.expression_level_complaint.ReferenceToUndefinedQError;
import qlProject.typeChecking.complaints.expression_level_complaint.operation_error.EqualityOperationError;
import qlProject.typeChecking.complaints.expression_level_complaint.operation_error.OperationError;
import qlProject.util.QuestionDetails;

public class ExpressionsTypeCheckVisitor implements IExpressionVisitor{

	private final Map<String,QuestionDetails> questionsDetails;
	private final HashSet<Complaint> complaints = new HashSet<Complaint>();
	
	public ExpressionsTypeCheckVisitor(Map<String,QuestionDetails> questionsDetails){
		this.questionsDetails = questionsDetails;
	}

	public HashSet<Complaint> getComplaints(){
		return complaints;
	}
	
	public void checkBinarySubExprs(BinaryExpression e, Type t){
		Type typeLeft = (Type)e.getLeft().accept(this);
		Type typeRight = (Type)e.getRight().accept(this);
		if (!typeLeft.equals(t))
			complaints.add(new OperationError(e.getLeft(), typeLeft, t));
		if (!typeRight.equals(t))
			complaints.add(new OperationError(e.getRight(), typeRight, t));
	}

	public void checkUnarySubExprs2(UnaryExpression e, Type expectedT){
		Type type = (Type)e.getSubExpression().accept(this);
		if (!type.equals(expectedT))
			complaints.add(new OperationError(e.getSubExpression(), type, expectedT));
	}

	public void checkSubExprsMatching2(BinaryExpression e){
		Type typeLeft = (Type)e.getLeft().accept(this);
		Type typeRight = (Type)e.getRight().accept(this);
		if(!typeLeft.equals(typeRight))
			complaints.add(new EqualityOperationError (e.getLeft(), e.getRight(), typeLeft, typeRight));
	}

	@Override
	public Type visit (NotExpr e){ 
		checkUnarySubExprs2(e, new BooleanType());
		return new BooleanType();
	}
	
	@Override
	public Type visit(NegationExpr e) {
		checkUnarySubExprs2(e, new IntType());
		return new IntType();
	}

	@Override
	public Type visit(ParenthesisExpr e) {
		Type t = (Type)e.getSubExpression().accept(this); 
		return t;
	}

	@Override
	public Type visit (Id id){

		if (!(questionsDetails.containsKey(id.getIdString())))
			complaints.add(new ReferenceToUndefinedQError (id.getIdString()));
		
		return questionsDetails.get(id.getIdString()).getType();
	}

	@Override
	public Type visit (IntLiteral intLiteral){
		return new IntType();
	}

	@Override
	public Type visit (BoolLiteral boolLiteral){
		return new BooleanType();
	}

	@Override
	public Type visit (StringLiteral stringLiteral) {
		return new StringType();
	}

	@Override
	public Type visit (EqualExpr e){
		checkSubExprsMatching2(e);
		return new BooleanType();
	}

	@Override
	public Type visit (UnequalExpr e){
		checkSubExprsMatching2(e);
		return new BooleanType();
	}

	@Override
	public Type visit(BiggerThanExpr e) {
		checkBinarySubExprs(e, new IntType());
		return new BooleanType();
	}

	@Override
	public Type visit(BiggerEqExpr e) {
		checkBinarySubExprs(e, new IntType());
		return new BooleanType();
	}

	@Override
	public Type visit(SmallerThanExpr e) {
		checkBinarySubExprs(e, new IntType());
		return new BooleanType();
	}

	@Override
	public Type visit(SmallerEqExpr e) {
		checkBinarySubExprs(e, new IntType());
		return new BooleanType();
	}

	@Override
	public Type visit(OrExpr e) {
		checkBinarySubExprs(e, new BooleanType());
		return new BooleanType();
	}

	@Override
	public Type visit(AndExpr e) {
		checkBinarySubExprs(e, new BooleanType());
		return new BooleanType();
	}

	@Override
	public Type visit(AdditionExpr e) {
		checkBinarySubExprs(e, new IntType());
		return new IntType();
	}

	@Override
	public Type visit(DivisionExpr e) {
		checkBinarySubExprs(e, new IntType());
		return new IntType();
	}

	@Override
	public Type visit(MultiplicationExpr e) {
		checkBinarySubExprs(e, new IntType());
		return new IntType();
	}

	@Override
	public Type visit(SubtractionExpr e) {
		checkBinarySubExprs(e, new IntType());
		return new IntType();
	}
	
	@Override
	public Type visit(ConcatenationExpr e) {
		checkBinarySubExprs(e, new StringType());
		return new StringType();
	}
	
}