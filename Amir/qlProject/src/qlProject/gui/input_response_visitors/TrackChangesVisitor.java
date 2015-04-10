package qlProject.gui.input_response_visitors;

import qlProject.ast.Questionnaire;
import qlProject.ast.statement.IStatement;
import qlProject.ast.statement.IStatementsVisitor;
import qlProject.ast.statement.IfStatement;
import qlProject.ast.statement.assignment.ComputedAssignment;
import qlProject.ast.statement.assignment.DirectAssignment;
import qlProject.ast.type.Type;
import qlProject.ast.value.Value;
import qlProject.gui.gui_building_visitors.QuestionWidget;
import qlProject.gui.listeners.ListenerSelector;
import qlProject.util.QuestionDetails;

import java.util.Map;
import java.util.Set;


public class TrackChangesVisitor implements IStatementsVisitor { 

	private final Map<String, QuestionDetails> questionsDetails;
	private final Map<String,Set<String>> deps;
	private final Map<String, QuestionWidget> questionWidgetsMap;
	private final Map<String,Set<String>> awaitingCalculationIds;
	private final Map<String, Value> valuesEnvironment;	
	
	public TrackChangesVisitor(Map<String, QuestionDetails> questionsDetails, Map<String, Value> valuesEnvironment, Map<String, Set<String>> deps, Map<String, QuestionWidget> questionWidgetsMap, Map<String,Set<String>> awaitingCalculationIds){
		this.questionsDetails = questionsDetails;
		this.deps = deps;
		this.questionWidgetsMap = questionWidgetsMap;
		this.awaitingCalculationIds = awaitingCalculationIds;
		this.valuesEnvironment = valuesEnvironment;
	}


	@Override
	public void visit(Questionnaire q) {
		for (IStatement statement : q.getStatements()){
			statement.accept(this);
		}
	}

	public void visit(IfStatement ifStatement){
		for (IStatement nestedTrueS : ifStatement.getIfTrueStatements()) {
			nestedTrueS.accept(this);
		}
		for (IStatement nestedFalseS : ifStatement.getIfFalseStatements()) {
			nestedFalseS.accept(this);
		}

		Set<String> variablesIds = ifStatement.getExpressionVariables();
		for (String observed : variablesIds){
			Type variableType = questionsDetails.get(observed).getType();
			ListenerSelector selector = (ListenerSelector)variableType.accept(new WidgetBindingVisitor(questionsDetails, questionWidgetsMap, observed, valuesEnvironment, awaitingCalculationIds));
			ifStatement.accept(selector);
		}
	}

	public void visit (ComputedAssignment assignment){
		for (String observed : deps.get(assignment.getId())){
			Type variableType = questionsDetails.get(observed).getType();
			ListenerSelector selector = (ListenerSelector)variableType.accept(new WidgetBindingVisitor(questionsDetails, questionWidgetsMap, observed, valuesEnvironment, awaitingCalculationIds));
			assignment.accept(selector);
		}
	}

	public void visit (DirectAssignment question){
		Type t = question.getType();
		ListenerSelector selector = (ListenerSelector)t.accept(new WidgetBindingVisitor(questionsDetails, questionWidgetsMap, question.getId(), valuesEnvironment, awaitingCalculationIds));
		question.accept(selector);
	}

}