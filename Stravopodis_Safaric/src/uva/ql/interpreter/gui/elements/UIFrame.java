package uva.ql.interpreter.gui.elements;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uva.ql.supporting.*;

public class UIFrame extends JFrame{
	
	static final long serialVersionUID = 42L; 
	
	private String frameTitle;
	private Tuple<Integer, Integer> frameSize;
	private JScrollPane scrollPane;
	
	
	public UIFrame(String _frameTitle, Tuple<Integer, Integer> _frameSize){
		this.frameTitle = _frameTitle;
		this.frameSize = _frameSize;
		
		scrollPane = new JScrollPane();
    
		
	}
	public Tuple<Integer, Integer> getFrameSize(){
		return this.frameSize;
	}
	public void randerFrame(){
		//JScrollPane scroll = new JScrollPane(this);
		Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
		
		//JPanel panTopCenter = new JPanel(new GridLayout());
		//this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        //this.scrollPane.setBounds(50, 30, 300, 50);
		
		this.setLocation(dimensions.width/2-this.frameSize.x/2, dimensions.height/2-this.frameSize.y/2);
		this.setSize(this.frameSize.x, this.frameSize.y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(this.frameSize.x,this.frameSize.y));
		scrollPane.getVerticalScrollBar().setUnitIncrement(dimensions.height);
		scrollPane.getViewport().setPreferredSize(new Dimension(this.frameSize.x,this.frameSize.y));
		this.add(scrollPane);
		
		
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
        
	}
	public String getFrameTitle(){
		return this.frameTitle;
	}
	public void addElement(UIElement _element){
		
	}
}
