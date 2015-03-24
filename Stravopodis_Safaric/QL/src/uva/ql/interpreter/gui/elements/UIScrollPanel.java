package uva.ql.interpreter.gui.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uva.ql.interpreter.gui.supporting.Size;

public class UIScrollPanel extends JPanel{
	
	static final long serialVersionUID = 42L; 
	
	private UIContainer jPanel;
	private JScrollPane jScrollPane;
	
	public UIScrollPanel(Size frameSize){
		this.jPanel = new UIContainer(frameSize);
		
		this.jScrollPane = new JScrollPane(this.jPanel);
		this.jScrollPane.setPreferredSize(new Dimension(frameSize.getWidth(), frameSize.getHeight()));
		this.jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.jScrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		this.setSize(frameSize.getWidth(), frameSize.getHeight());
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add(this.jScrollPane);
	}
	
	public void addComponent(Object obj){
		GridLayout grid = (GridLayout) this.jPanel.getLayout();
		grid.setVgap(1);
		
		this.jPanel.setLayout(new GridLayout(grid.getRows()+1, 1));		
		this.jPanel.addComponents(Arrays.asList(obj));
	}
	
	public void removeAll(){
		this.jPanel.removeAll();
	}
	
	public UIContainer getPanel(){
		return this.jPanel;
	}
	
	public void revalidatePanel(){
		this.getPanel().revalidate();
	}
	
	@Override
	public void revalidate(){
		if (this.jPanel != null)
			this.jPanel.setLayout(new GridLayout(1, 1));
	}
}
