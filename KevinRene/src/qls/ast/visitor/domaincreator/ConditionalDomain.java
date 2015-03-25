package qls.ast.visitor.domaincreator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ql.Value;
import ql.ValueEnvironment;
import ql.ast.Expression;
import ql.ast.expression.booleanalgebra.And;
import ql.ast.visitor.evaluator.Evaluator;
import ql.gui.UIComponent;
import ql.value.BooleanValue;

public class ConditionalDomain {
	private Expression conditionalExpression;
	private ValueEnvironment valueEnvironment;
	private List<UIComponent> ifComponents, elseComponents;
	
	public ConditionalDomain(Expression conditionalExpression, ValueEnvironment valueEnvironment) {
		this.conditionalExpression = conditionalExpression;
		this.valueEnvironment = valueEnvironment;
		
		ifComponents = new ArrayList<UIComponent>();
		elseComponents = new ArrayList<UIComponent>();
	}
	
	public void setPrerequisites(List<Expression> prerequisites) {
		conditionalExpression = 
				prerequisites.stream()
				.reduce(conditionalExpression, (x, y) -> new And(x, y));
	}
	
	public void setIfComponent(List<UIComponent> ifComponents) {
		this.ifComponents.addAll(ifComponents);
	}
	
	public void setElseComponent(List<UIComponent> elseComponents) {
		this.elseComponents.addAll(elseComponents);
	}
	
	public void activateIfPanel() {
		ifComponents.stream()
			.forEach(component -> component.getComponent().setVisible(true));
		elseComponents.stream()
			.forEach(component -> component.getComponent().setVisible(false));
	}
	
	public void activateElsePanel() {
		ifComponents.stream()
			.forEach(component -> component.getComponent().setVisible(false));
		elseComponents.stream()
			.forEach(component -> component.getComponent().setVisible(true));
	}
	
	public void updateDomain() {
		Value value = Evaluator.check(conditionalExpression, valueEnvironment);
		
		if(value.isUndefined()) {
			activateElsePanel();
			return;
		}
		
		if(((BooleanValue) value).getValue()) {
			activateIfPanel();
		} else {
			activateElsePanel();
		}
	}
	
	@Override
	public String toString() {
		String ifComps = "-- IF --\n" 
				+ ifComponents.stream()
				.map(UIComponent::toString)
				.collect(Collectors.joining("\n"));
		
		String elseComps = "\n-- ELSE --\n"
				+  elseComponents.stream()
				.map(UIComponent::toString)
				.collect(Collectors.joining("\n"));
		
		return ifComps + elseComps;
	}
}
