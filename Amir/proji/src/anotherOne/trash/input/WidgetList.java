package anotherOne.gui.input;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;

import anotherOne.ast.question.Question;

public class WidgetList {
	
	public List<JComponent> componentList = new ArrayList<JComponent>();
	
	public WidgetList(List<JComponent> componentList){
		this.componentList = componentList;
	}
}
