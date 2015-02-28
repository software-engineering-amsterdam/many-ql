package gui.widgets;

import javax.swing.JComponent;
import ast.type.Type;

public interface IWidgetComponent {
	
	public JComponent getWidget();  // textfield, radio etc.
	public String getIdWidget();	// id
	public Type getWidgetType();	// choice/digits/text
	public String getLabel();		// question text, label to sync visibility with component
	public boolean visibility();	// visibility of components...not sure yet
	public void addDocListener();
	public String getValue();			// inserted text (String to be changed in something neutral later)
	public void setValue(String value);
}
