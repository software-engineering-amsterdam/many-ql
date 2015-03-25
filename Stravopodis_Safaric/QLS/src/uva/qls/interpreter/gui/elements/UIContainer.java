package uva.qls.interpreter.gui.elements;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class UIContainer extends JPanel{

	private static final long serialVersionUID = 41L;
	private Size size;
	
	public UIContainer(Size _size){
		this.size = _size;
		this.setContainer();
	}
	
	public void setContainer(){
		Dimension d = new Dimension(this.size.getWidth(), this.size.getHeight());
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setPreferredSize(d);
		this.setMinimumSize(d);
		this.setSize(d);
	}
	
	public void  addComponent(Component _component){
		this.add(_component);
	}
}
