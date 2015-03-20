package uva.qls.interpreter.gui.elements;

import java.awt.Dimension;
import uva.qls.interpreter.gui.elements.Size;
import javax.swing.JTabbedPane;

public class UITabController extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	private Size size;
	
	public UITabController(Size _size) {
		this.size = _size;
		this.setUITabController();
	}
	
	private void setUITabController(){
		Dimension dimension = new Dimension(this.size.getWidth(), this.size.getHeight());
		this.setPreferredSize(dimension);
		this.setSize(dimension);
	}
	
	public Size getTabSize(){
		return this.size;
	}

	public void addTab(String name, UIScrollView scrollview){
		this.add(name, scrollview);
		this.revalidate();
	}
	
	public UIScrollView getLastAddedComponent(){
		return (UIScrollView)this.getComponents()[this.getComponentCount()-1];
	}
}
