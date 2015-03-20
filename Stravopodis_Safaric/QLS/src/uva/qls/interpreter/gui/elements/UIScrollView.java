package uva.qls.interpreter.gui.elements;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class UIScrollView extends JPanel{

static final long serialVersionUID = 42L; 
	
	private UIContainer scrollViewContainer;
	private JScrollPane scrollView;
	private GridLayout scrollLayout;
	
	public UIScrollView(Size frameSize){
		this.scrollViewContainer = new UIContainer(frameSize);
		this.scrollView = new JScrollPane(this.scrollViewContainer);
		
		this.initSelf(frameSize);
	}
	
	private void initSelf(Size frameSize){
		this.setSize(frameSize.getHeight(), frameSize.getWidth());
		this.setBorder(BorderFactory.createEmptyBorder());
		
		this.initScrollView(frameSize);
		this.add(this.scrollView);
	}
	
	private void initScrollView(Size frameSize){
		this.scrollView.setPreferredSize(new Dimension(frameSize.getWidth() , frameSize.getHeight()+25));
		
		this.scrollView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.scrollView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollView.setBorder(BorderFactory.createEmptyBorder());
		
		this.scrollLayout = new GridLayout(0,1);
	}
	
	public void addComponent(Component obj){
		this.scrollLayout.setVgap(1);
		this.scrollLayout = new GridLayout(this.scrollLayout.getRows()+1, 1);
		
		this.scrollViewContainer.setLayout(this.scrollLayout);
		this.scrollViewContainer.add(obj);
	}

	public JPanel getPanel(){
		return this.scrollViewContainer;
	}
	
	public JScrollPane getScrollView(){
		return this.scrollView;
	}
	
	@Override
	public void revalidate(){
		if (this.scrollViewContainer != null)
			this.scrollViewContainer.setLayout(this.scrollLayout);
	}
	
}
