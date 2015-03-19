package qls.gui.structure;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ql.ast.expression.Identifier;
import ql.gui.UIComponent;
import ql.gui.structure.Panel;

public class UIPage extends Panel {
	private Identifier pageName;
	
	public UIPage(Identifier pageName) {		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
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
