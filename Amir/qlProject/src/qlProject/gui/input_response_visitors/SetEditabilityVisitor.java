package qlProject.gui.input_response_visitors;

import java.util.List;
import java.util.Map;

import qlProject.ast.Questionnaire;
import qlProject.ast.expression.IExpression;
import qlProject.ast.statement.IStatement;
import qlProject.ast.statement.IStatementsVisitor;
import qlProject.ast.statement.IfStatement;
import qlProject.ast.statement.assignment.Assignment;
import qlProject.ast.statement.assignment.ComputedAssignment;
import qlProject.ast.statement.assignment.DirectAssignment;
import qlProject.ast.value.BoolValue;
import qlProject.ast.value.NullValue;
import qlProject.ast.value.Value;
import qlProject.auxiliary_expression_visitors.ExpressionEvaluationVisitor;
import qlProject.gui.gui_building_visitors.QuestionWidget;

public class SetEditabilityVisitor implements IStatementsVisitor {

	private Map <String, Value> valuesEnvironment;
	private Map<String, QuestionWidget> questionWidgetsMap;
	private boolean enabled;

	public SetEditabilityVisitor(Map <String, Value> valuesEnvironment, Map<String, QuestionWidget> questionWidgetsMap, boolean enabled){
		this.questionWidgetsMap = questionWidgetsMap;
		this.enabled = enabled;
		this.valuesEnvironment = valuesEnvironment;
	}


	@Override
	public void visit(Questionnaire q) {
		for (IStatement s : q.getStatements()){
			s.accept(this);
		}
	}

	@Override
	public void visit(IfStatement s) {

		boolean nestedCondition = evaluateCondition(s.getCondition());
		manageTrueAndFalseNestedSs(s, nestedCondition);
	}

	@Override
	public void visit(ComputedAssignment a) {
	}

	@Override
	public void visit(DirectAssignment a) {
		setEnabled(a);
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

	public void enableNestedStatements(List<IStatement> statementsList, boolean nestedCondition){
		for(IStatement nestedS : statementsList){
			nestedS.accept(new SetEditabilityVisitor(valuesEnvironment, questionWidgetsMap, nestedCondition && enabled));
		}
	}

	public void manageTrueAndFalseNestedSs(IfStatement s, boolean nestedCondition){
		enableNestedStatements(s.getIfTrueStatements(), nestedCondition);
		enableNestedStatements(s.getIfFalseStatements(), !nestedCondition);
	}

	public void setEnabled(Assignment a){
		questionWidgetsMap.get(a.getId()).getLabel().setEnabled(enabled);
		questionWidgetsMap.get(a.getId()).getComponent().setEnabled(enabled);
	}
}