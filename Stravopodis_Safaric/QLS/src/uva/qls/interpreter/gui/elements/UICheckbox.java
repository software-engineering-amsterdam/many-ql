package uva.qls.interpreter.gui.elements;

import java.awt.Font;
import javax.swing.JCheckBox;

import uva.qls.ast.component.Checkbox;

public class UICheckbox extends UIComponent<JCheckBox> {
	
	private Checkbox checkbox;
	
	public UICheckbox(Checkbox _checkbox){
		this.checkbox=_checkbox;
	}
	
	private JCheckBox setText(JCheckBox toComponent){
		toComponent.setText(checkbox.getCheckboxValue());
		return toComponent;
	}

	@Override
	public JCheckBox getComponent() {
		JCheckBox check = new JCheckBox();
		
		check = this.setText(check);
		return this.applyStyles(check);
	}

	@Override
	public JCheckBox applyStyles(JCheckBox toComponent) {
		Font font = new Font(checkbox.getStyle().fontName(), Font.PLAIN, checkbox.getStyle().fontSize());
		
		toComponent.setForeground(checkbox.getStyle().color());
		toComponent.setFont(font);
		
		return toComponent;
	}

}
