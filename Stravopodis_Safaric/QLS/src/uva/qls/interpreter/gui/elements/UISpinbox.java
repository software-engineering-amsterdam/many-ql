package uva.qls.interpreter.gui.elements;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JSpinner;

import uva.qls.ast.component.Spinbox;

public class UISpinbox extends UIComponent<JSpinner> {
	
	private Spinbox spinbox;
	
	public UISpinbox (Spinbox _spinbox){
		this.spinbox = _spinbox;
	}
	
	@Override
	public JSpinner getComponent() {
		JSpinner spin = new JSpinner();
		return this.applyStyles(spin);
	}

	@Override
	public JSpinner applyStyles(JSpinner toComponent) {
		Font font = new Font(spinbox.getStyle().fontName(), Font.PLAIN, spinbox.getStyle().fontSize());
		
		Dimension dimension = new Dimension(spinbox.getStyle().width(), spinbox.getStyle().height());
		toComponent.setPreferredSize(dimension);
		toComponent.setSize(dimension);
		
		toComponent.setForeground(spinbox.getStyle().color());
		toComponent.setFont(font);
		
		return toComponent;
	}

}
