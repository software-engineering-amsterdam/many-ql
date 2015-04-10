package qlProject.gui.gui_building_visitors;

import qlProject.ast.Questionnaire;
import qlProject.ast.expression.IExpression;
import qlProject.ast.statement.IStatement;
import qlProject.ast.statement.IStatementsVisitor;
import qlProject.ast.statement.IfStatement;
import qlProject.ast.statement.assignment.Assignment;
import qlProject.ast.statement.assignment.ComputedAssignment;
import qlProject.ast.statement.assignment.DirectAssignment;
import qlProject.ast.type.Type;
import qlProject.ast.value.BoolValue;
import qlProject.ast.value.NullValue;
import qlProject.ast.value.Value;
import qlProject.auxiliary_expression_visitors.ExpressionEvaluationVisitor;
import qlProject.gui.input_response_visitors.SetEditabilityVisitor;

import javax.swing.*;

import java.util.LinkedHashMap;
import java.util.Map;


public class WidgetsCreationVisitor implements IStatementsVisitor {

	private final Map<String, QuestionWidget> questionWidgetsMap = new LinkedHashMap<String, QuestionWidget>();
	private final Map<String, Value> valuesEnvironment;


	public WidgetsCreationVisitor(Map<String, Value> valuesEnvironment) {
		this.valuesEnvironment = valuesEnvironment;
	}

	public Map<String, QuestionWidget> getQuestionWidgets(){
		return this.questionWidgetsMap;
	}

	@Override
	public void visit(Questionnaire q) {
		for (IStatement statement : q.getStatements()){
			statement.accept(this);
		}
	}

	public Value evaluateExpression(IExpression e){
		return (Value)(e.accept(new ExpressionEvaluationVisitor(valuesEnvironment)));		
	}

	public boolean evaluateCondition(IExpression e) {
		Value v = evaluateExpression(e);
		if (v.equals(new NullValue()))
			return false;
		else 
			return ((BoolValue)v).getValue();
	}

	@Override
	public void visit(IfStatement s){
		boolean enabled = evaluateCondition(s.getCondition());
		for (IStatement nestedTrueS : s.getIfTrueStatements()){
			nestedTrueS.accept(this);
		}
		for (IStatement nestedFalseS : s.getIfFalseStatements()){
			nestedFalseS.accept(this);
		}
		s.accept(new SetEditabilityVisitor(valuesEnvironment, questionWidgetsMap, enabled));
	}

	@Override
	public void visit (ComputedAssignment assignment){
		createWidgets(assignment, false);
	}

	@Override
	public void visit (DirectAssignment assignment){
		createWidgets(assignment, true);
	}

	public void createWidgets(Assignment a, boolean editable){
		Type t = a.getType();
		JComponent component = (JComponent)(t.accept(new TypeWidgetMatchingVisitor()));
		component.setEnabled(editable);
		QuestionWidget qw = new QuestionWidget(new JLabel(a.getQuestionText()), component);
		questionWidgetsMap.put(a.getId(), qw);
	}

}