package uva.ql.interpreter.gui.elements;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import uva.ql.supporting.*;

public class UIFrame extends JFrame{
	
	static final long serialVersionUID = 42L; 
	
	private String frameTitle;
	private Tuple<Integer, Integer> frameSize;
	
	public UIFrame(String _frameTitle, Tuple<Integer, Integer> _frameSize){
		this.frameTitle = _frameTitle;
		this.frameSize = _frameSize;
	}
	public Tuple<Integer, Integer> getFrameSize(){
		return this.frameSize;
	}
	public void randerFrame(){
		
		Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setLocation(dimensions.width/2-this.frameSize.x/2, dimensions.height/2-this.frameSize.y/2);
		this.setSize(this.frameSize.x, this.frameSize.y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(this.frameSize.x,this.frameSize.y));
		this.pack();
		this.setVisible(true);
	}
	public String getFrameTitle(){
		return this.frameTitle;
	}
	public void addElement(UIElement _element){
		
	}
}
