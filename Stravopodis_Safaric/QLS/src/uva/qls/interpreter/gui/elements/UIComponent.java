package uva.qls.interpreter.gui.elements;
import uva.qls.ast.component.Component;

public abstract class UIComponent<T> {

	protected Component comp;
	public abstract T getComponent();
	public abstract T applyStyles(T toComponent);
	
}
