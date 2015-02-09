package anotherOne.gui.input;

import javax.swing.JComponent;

import anotherOne.ast.question.ValueStorage;

public interface WidgetTemplate {
	
	public void storeValue (JComponent component, ValueStorage values);

}
