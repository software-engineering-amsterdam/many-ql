package uva.qls.interpreter.gui.elements;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class UIFrame extends JFrame {

	private static final long serialVersionUID = 41L;
	private UITabController tabController;
	private Size size;
	
	public UIFrame(Size _size, UITabController _tabController){
		this.size = _size;
		this.tabController = _tabController;
	}
	
	public void randerFrame(){
		
		Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dimensions.width/2-this.size.getWidth()/2, dimensions.height/2-this.size.getHeight()/2);
		
		Dimension frameSize = new Dimension(this.size.getWidth(), this.size.getHeight());
		this.setPreferredSize(frameSize);
		this.setSize(frameSize);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
		
		this.add(this.tabController);	
		this.revalidate();
	}
	
}
