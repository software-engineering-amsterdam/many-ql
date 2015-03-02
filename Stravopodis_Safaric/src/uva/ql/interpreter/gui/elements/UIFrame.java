package uva.ql.interpreter.gui.elements;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import uva.ql.interpreter.gui.elements.UIScrollPanel;
import uva.ql.supporting.*;

public class UIFrame extends JFrame{
	
	static final long serialVersionUID = 42L; 
	
	private UIScrollPanel container;
	private Tuple<Integer, Integer> frameSize;
	
	public UIFrame(Tuple<Integer, Integer> _frameSize, UIScrollPanel _container){
		this.frameSize = _frameSize;
		this.container = _container;
	}
	
	public Tuple<Integer, Integer> getFrameSize(){
		return this.frameSize;
	}
	
	public void randerFrame(){

		Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dimensions.width/2-this.frameSize.x/2, dimensions.height/2-this.frameSize.y/2);
		
		this.setSize(this.frameSize.x, this.frameSize.y);
		this.setPreferredSize(new Dimension(this.frameSize.x,this.frameSize.y));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
		
		this.add(this.container);	
		this.revalidate();   
	}
}
