package qlProject.typeChecking.typeCheckVisitors;

import java.util.*;

import qlProject.ast.Questionnaire;
import qlProject.ast.expression.IExpression;
import qlProject.ast.statement.IStatement;
import qlProject.ast.statement.IStatementsVisitor;
import qlProject.ast.statement.IfStatement;
import qlProject.ast.statement.assignment.ComputedAssignment;
import qlProject.ast.statement.assignment.DirectAssignment;
import qlProject.ast.type.BooleanType;
import qlProject.ast.type.NullType;
import qlProject.ast.type.Type;
import qlProject.typeChecking.complaints.Complaint;
import qlProject.typeChecking.complaints.expression_level_complaint.ConditionTypeError;
import qlProject.typeChecking.complaints.expression_level_complaint.ExpressionTypeError;
import qlProject.util.QuestionDetails;

public class StatementsTypeCheckVisitor implements IStatementsVisitor {

	private final HashSet<Complaint> complaints;
	private final Map<String, QuestionDetails> questionsDetails;
	private final Map<String, Set<String>> deps;
	private final ExpressionsTypeCheckVisitor expressionVisitor;

	public StatementsTypeCheckVisitor(Map<String, QuestionDetails> questionsDetails, 
			HashSet<Complaint> complaints, Map<String, Set<String>> deps) {
		this.complaints = complaints;
		this.questionsDetails = questionsDetails;
		this.deps = deps;
		this.expressionVisitor = new ExpressionsTypeCheckVisitor(questionsDetails);
	}


	@Override
	public void visit(Questionnaire q) {
		for (IStatement s : q.getStatements()){
			s.accept(this);
		}
	}

	public void visit (IfStatement ifStatements){
		checkConditionCyclicReference(ifStatements);
		for (IStatement s : ifStatements.getIfTrueStatements()){
			s.accept(this);
		}
		for (IStatement s : ifStatements.getIfFalseStatements()){
			s.accept(this);
		}
		checkCondition(ifStatements.getCondition());
	}

	public void visit (ComputedAssignment q){
		Type t = (Type)q.getExpression().accept(expressionVisitor);
		if (!t.equals(q.getType())){
			complaints.add(new ExpressionTypeError(questionsDetails, q, q.getExpression(), t));
		}
	}

	public void visit (DirectAssignment q){	
	}

	public void checkCondition(IExpression e){
		Type t = (Type)e.accept(expressionVisitor);
		complaints.addAll(expressionVisitor.getComplaints());		
		if (!(t.isOfType(new NullType()))){
			if (!(t.isOfType(new BooleanType()))){
				complaints.add(new ConditionTypeError(e, t));	
			}
		}
	}

	public void showComplaints(){
		for (Complaint complaint : complaints){
			complaint.presentComplaint();
		}
	}

	public void checkConditionCyclicReference(IfStatement conditionalQs){
		Set<String> vars = conditionalQs.getExpressionVariables();
		for (String observer : vars){
			if (deps.containsKey(observer) || deps.containsValue(observer)){
				complaints.add(new ConditionCyclicReference(conditionalQs.getCondition(), observer));
			}
		}
	}

}