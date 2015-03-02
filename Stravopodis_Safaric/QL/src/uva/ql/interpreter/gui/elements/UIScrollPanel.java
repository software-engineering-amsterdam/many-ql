package uva.ql.interpreter.gui.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uva.ql.supporting.Tuple;

public class UIScrollPanel extends JPanel{
	
	static final long serialVersionUID = 42L; 
	
	private UIContainer jPanel;
	private JScrollPane jScrollPane;
	
	public UIScrollPanel(Tuple<Integer, Integer> frameSize){
		this.jPanel = new UIContainer(new Tuple<Integer, Integer>(500,400));
		
		this.jScrollPane = new JScrollPane(this.jPanel);
		this.jScrollPane.setPreferredSize(new Dimension(500 , 400));
		this.jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.jScrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		this.setSize(frameSize.x, frameSize.y);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add(this.jScrollPane);
	}
	
	public void addComponent(Object obj){
		GridLayout grid = (GridLayout) this.jPanel.getLayout();
		grid.setVgap(1);
		
		this.jPanel.setLayout(new GridLayout(grid.getRows()+1, 1));		
		this.jPanel.addComponent(obj);
	}
	
	public void removeAll(){
		this.jPanel.removeAll();
	}
	
	public UIContainer getPanel(){
		return this.jPanel;
	}
	
	@Override
	public void revalidate(){
		if (this.jPanel != null)
			this.jPanel.setLayout(new GridLayout(1, 1));
	}
}
