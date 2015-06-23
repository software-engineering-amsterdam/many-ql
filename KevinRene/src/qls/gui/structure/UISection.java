package qls.gui.structure;

import java.util.List;

import javax.swing.BorderFactory;

import ql.gui.Component;
import ql.gui.structure.Panel;
import qls.ast.expression.literal.StringLiteral;

public class UISection extends Panel {
	public UISection(StringLiteral borderHeader) {		
		super();
		getPanel().setBorder(BorderFactory.createTitledBorder(borderHeader.getValue().getPrimitive()));
	}
	
	public UISection(StringLiteral borderHeader, Component handler) {
		super(handler);
		getPanel().setBorder(BorderFactory.createTitledBorder(borderHeader.getValue().getPrimitive()));
	}
	
	public void setComponents(List<Component> components) {
		components.stream().forEach(component -> addComponent(component));
	}
	
	@Override
	public void updateComponent() {
		boolean hasVisibleComponents = getComponents().stream()
				.anyMatch(component -> component.getComponent().isVisible());
		
		getPanel().setVisible(hasVisibleComponents);
		
		super.updateComponent();
	}
}
