package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JPanel;

import uva.ql.supporting.Tuple;

public class UIContainer extends JPanel{

	static final long serialVersionUID = 42L; 
	private Tuple<Integer, Integer> containerSize;

	public UIContainer( Tuple<Integer, Integer> _containerSize){
		this.setSize(_containerSize.x, _containerSize.y);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	
	public Tuple<Integer, Integer> getContainerSize(){
		return this.containerSize;
	}
	
	public void addComponent(Object obj){
		this.add((Component) obj);
	}
	
	public void addComponents(List<Object> objects){
		for (Object obj : objects){
			this.addComponent(obj);
		}
	}
}
