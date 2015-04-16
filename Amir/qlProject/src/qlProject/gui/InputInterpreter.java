package qlProject.gui;

import java.util.List;
import java.util.Map;
import java.util.Set;

import qlProject.ast.expression.IExpression;
import qlProject.ast.statement.IStatement;
import qlProject.ast.statement.IfStatement;
import qlProject.ast.statement.assignment.ComputedAssignment;
import qlProject.ast.type.Type;
import qlProject.ast.value.BoolValue;
import qlProject.ast.value.NullValue;
import qlProject.ast.value.Value;
import qlProject.auxiliary_expression_visitors.ExpressionEvaluationVisitor;
import qlProject.gui.gui_building_visitors.QuestionWidget;
import qlProject.gui.input_response_visitors.InputTypeVisitor;
import qlProject.gui.input_response_visitors.InputUpdaterVisitor;
import qlProject.gui.input_response_visitors.SetEditabilityVisitor;
import qlProject.util.QuestionDetails;

public class InputInterpreter {

	private final Map<String, QuestionWidget> questionWidgetsMap;
	private final Map<String,Set<String>> awaitingCalculationIds;
	private final Map<String, QuestionDetails> questionsDetails;
	private final Map<String, Value> valuesEnvironment;

	public InputInterpreter(Map<String, QuestionDetails> questionsDetails, Map<String, QuestionWidget> questionWigdetsMap, 
			Map<String, Value> valuesEnvironment, Map<String, Set<String>> awaitingCalculationIds) {
		this.questionsDetails = questionsDetails;
		this.valuesEnvironment = valuesEnvironment;
		this.questionWidgetsMap = questionWigdetsMap;
		this.awaitingCalculationIds = awaitingCalculationIds;
	}


	public void updateInputValue(String id){
		//TODO duplicate equals vs isOfType
		Type t = questionsDetails.get(id).getType();
		Value v = (Value)t.accept(new InputTypeVisitor(questionWidgetsMap.get(id).getComponent()));
		valuesEnvironment.put(id, v);
	}

	public void updateComputedValue (String id, Value v){
		valuesEnvironment.put(id, v);
		Type typeObserver = questionsDetails.get(id).getType();
		typeObserver.accept(new InputUpdaterVisitor(questionWidgetsMap.get(id),v));
	}

	public void updateComputedValues(ComputedAssignment a){
		Value v = evaluateExpression(a.getExpression());

		if (!v.equals(new NullValue())){
			updateComputedValue (a.getId(), v);
		}
		updateDependentCalculations(a);
	}

	public Value evaluateExpression(IExpression e){
		return (Value)(e.accept(new ExpressionEvaluationVisitor(valuesEnvironment)));		
	}

	public boolean evaluateCondition (IfStatement s){
		Value v = evaluateExpression(s.getCondition());
		if (v.equals(new NullValue()))
			return false;
		else return ((BoolValue)v).getValue();
	}

	public void setEditability(List<IStatement> statements, boolean editable){
		for(IStatement nestedS : statements){
			nestedS.accept(new SetEditabilityVisitor(valuesEnvironment, questionWidgetsMap, editable));			
		}
	}

	public void applyVisibilityCondition(IfStatement s) {
		boolean condition = evaluateCondition(s);
		setEditability(s.getIfTrueStatements(), condition);
		setEditability(s.getIfFalseStatements(), !condition);
	}


	/* As at the earlier stage of intermediating calculations were removed,
	 * in the following method they are propagating the update to the calculations
	 * depending on them, not before they are first being updated */
	public void updateDependentCalculations(ComputedAssignment q){
		if (awaitingCalculationIds.keySet().contains(q.getId())){
			for (String s : awaitingCalculationIds.get(q.getId())){
				ComputedAssignment a = (ComputedAssignment)questionsDetails.get(s).getQuestion();
				updateComputedValues(a);
			}
		}
	}

}