package org.uva.qls.view.widget;

import javax.swing.JComponent;
import javax.swing.JSlider;

import org.uva.ql.ast.Node;

public class Slider extends Widget<Node>{

	private static final long serialVersionUID = -7374082203125807531L;
	private final JSlider slider;
	
	
	public Slider(Node widgetModel) {
		super(widgetModel);
		slider = new JSlider();
	}

	@Override
	public JComponent getWidget() {
		return slider;
	}
}
