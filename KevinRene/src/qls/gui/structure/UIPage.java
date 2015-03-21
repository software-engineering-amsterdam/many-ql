package qls.gui.structure;

import java.util.List;

import javax.swing.BoxLayout;

import ql.ast.expression.Identifier;
import ql.gui.UIComponent;
import ql.gui.structure.Panel;

public class UIPage extends Panel {
	private Identifier pageName;
	
	public UIPage(Identifier pageName) {
		super();
		
		getPanel().setLayout(new BoxLayout(getPanel(), BoxLayout.Y_AXIS));
		
		this.pageName = pageName;
	}
	
	public UIPage(Identifier pageName, UIComponent handler) {
		this(pageName);		
		setHandler(handler);
	}
	
	public void setSections(List<UIComponent> components) {
		components.stream().forEach(component -> addComponent(component));
	}
	
	@Override
	public String toString() {
		return pageName.toString();
	}
}
