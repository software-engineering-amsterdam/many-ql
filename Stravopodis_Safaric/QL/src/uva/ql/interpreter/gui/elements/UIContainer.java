package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JPanel;

public class UIContainer extends JPanel{

	static final long serialVersionUID = 42L; 
	private Size containerSize;

	public UIContainer(Size _containerSize){
		this.containerSize = _containerSize;
		this.setContainer();
	}
	
	private void setContainer(){
		this.setSize(this.containerSize.getWidth(), this.containerSize.getHeight());
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	
	public Size getContainerSize(){
		return this.containerSize;
	}
	
	public Component getChildComponent(){
		for (Component component : this.getComponents()){
			if (!component.getClass().equals(UILabel.class)){
				return component;
			}
		}
		return null;
	}
	
	public void addComponents(List<Object> objects){
		for (Object obj : objects){
			this.addComponent(obj);
		}
	}
	
	private void addComponent(Object obj){
		this.add((Component) obj);
	}
	
}
