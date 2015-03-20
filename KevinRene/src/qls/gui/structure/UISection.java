package qls.gui.structure;

import java.util.List;

import javax.swing.BorderFactory;

import ql.gui.UIComponent;
import ql.gui.structure.Panel;
import qls.ast.expression.literal.StringLiteral;

public class UISection extends Panel {
	public UISection(StringLiteral borderHeader) {		
		super();
		panel.setBorder(BorderFactory.createTitledBorder(borderHeader.getValue().getValue()));
	}
	
	public UISection(StringLiteral borderHeader, UIComponent handler) {
		super(handler);
		panel.setBorder(BorderFactory.createTitledBorder(borderHeader.getValue().getValue()));
	}
	
	public void setComponents(List<UIComponent> components) {
		components.stream().forEach(component -> addComponent(component));
	}
}
