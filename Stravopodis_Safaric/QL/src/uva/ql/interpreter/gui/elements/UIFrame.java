package uva.ql.interpreter.gui.elements;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class UIFrame extends JFrame{
	
	static final long serialVersionUID = 42L; 
	
	private UIScrollPanel container;
	private Size frameSize;
	
	public UIFrame(Size _frameSize, UIScrollPanel _container){
		this.frameSize = _frameSize;
		this.container = _container;
	}
	
	public Size getFrameSize(){
		return this.frameSize;
	}
	
	public void randerFrame(){

		Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dimensions.width/2-this.frameSize.getWidth()/2, dimensions.height/2-this.frameSize.getHeight()/2);
		
		this.setSize(this.frameSize.getWidth(), this.frameSize.getHeight());
		this.setPreferredSize(new Dimension(this.frameSize.getWidth(), this.frameSize.getHeight()));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
		
		this.add(this.container);	
		this.revalidate();   
	}
}
