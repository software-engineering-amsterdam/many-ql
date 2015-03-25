package uva.ql.interpreter.gui.elements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uva.ql.interpreter.gui.supporting.Size;

public class UIScrollPanel {

	private JPanel container;
	
	public JPanel randerScrollPane(Size size){
		
		JPanel masterPanel = new UIContainer().randerContainer(size);
		
		this.container = new UIContainer().randerContainer(size);
		this.container.setLayout(new GridLayout(1,1));
		
		JScrollPane scrollPane= new JScrollPane(this.container);
		
		scrollPane.setPreferredSize(new Dimension(size.getWidth(), size.getHeight()));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		masterPanel.setSize(size.getWidth(), size.getHeight());
		masterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		masterPanel.add(scrollPane);
		
		return masterPanel;
	}
	
	public void setPanelLayout(LayoutManager layout){
		this.container.setLayout(layout);
	}
	
	public void addComponent(Component component){	// Add component to jPanel
		GridLayout grid = (GridLayout) this.container.getLayout();
		grid.setVgap(1);
		
		int rows = grid.getRows() + 1;
		
		this.container.setLayout(new GridLayout(rows, 1));	
		this.container.add(component);
	}
	
	public void removeAll(){
		this.container.removeAll();
	}
	
	public void revalidateMasterPanel(){
		this.container.revalidate();
	}
	
	public void revalidateLayout(){
		if (this.container!= null){
			this.container.setLayout(new GridLayout(1, 1));
		}
	}
}
