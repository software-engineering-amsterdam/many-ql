package qls.ast.visitor.domaincreator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ql.Value;
import ql.ast.Expression;
import ql.ast.expression.booleanalgebra.And;
import ql.ast.visitor.evaluator.Evaluator;
import ql.ast.visitor.evaluator.ValueEnvironment;
import ql.gui.Component;
import ql.value.BooleanValue;

public class ConditionalDomain {
	private Expression conditionalExpression;
	private ValueEnvironment valueEnvironment;
	private List<Component> ifComponents, elseComponents;
	
	public ConditionalDomain(Expression conditionalExpression, ValueEnvironment valueEnvironment) {
		this.conditionalExpression = conditionalExpression;
		this.valueEnvironment = valueEnvironment;
		
		ifComponents = new ArrayList<Component>();
		elseComponents = new ArrayList<Component>();
	}
	
	public void setPrerequisites(List<Expression> prerequisites) {
		conditionalExpression = 
				prerequisites.stream()
				.reduce(conditionalExpression, (x, y) -> new And(x, y));
	}
	
	public void setIfComponent(List<Component> ifComponents) {
		this.ifComponents.addAll(ifComponents);
	}
	
	public void setElseComponent(List<Component> elseComponents) {
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
		
		if(((BooleanValue) value).getPrimitive()) {
			activateIfPanel();
		} else {
			activateElsePanel();
		}
	}
	
	@Override
	public String toString() {
		String ifComps = "-- IF --\n" 
				+ ifComponents.stream()
					.map(Component::toString)
					.collect(Collectors.joining("\n"));
		
		String elseComps = "\n-- ELSE --\n"
				+ elseComponents.stream()
					.map(Component::toString)
					.collect(Collectors.joining("\n"));
		
		return ifComps + elseComps;
	}
}
