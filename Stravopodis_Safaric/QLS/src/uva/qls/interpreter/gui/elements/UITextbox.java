package uva.qls.interpreter.gui.elements;

import java.awt.Dimension;
import java.awt.Font;

import uva.qls.ast.component.Textbox;

import javax.swing.JTextField;

public class UITextbox extends UIComponent<JTextField> {
	
	private Textbox textbox;
	
	public UITextbox(Textbox _textbox) {
		this.textbox=_textbox;
	}

	@Override
	public JTextField getComponent() {
		JTextField field = new JTextField();
		return this.applyStyles(field);
	}

	@Override
	public JTextField applyStyles(JTextField toComponent) {
		Font font = new Font(textbox.getStyle().fontName(), Font.PLAIN, textbox.getStyle().fontSize());
		
		Dimension dimension = new Dimension(textbox.getStyle().width(), textbox.getStyle().height());
		toComponent.setPreferredSize(dimension);
		toComponent.setSize(dimension);
		
		toComponent.setForeground(textbox.getStyle().color());
		toComponent.setFont(font);
		
		return toComponent;
	}

}
