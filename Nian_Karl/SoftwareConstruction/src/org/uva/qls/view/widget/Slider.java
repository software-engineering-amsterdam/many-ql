package org.uva.qls.view.widget;

import javax.swing.JComponent;
import javax.swing.JSlider;

import org.uva.qls.ast.QLSNode;

public class Slider extends Widget<QLSNode>{

	private static final long serialVersionUID = -7374082203125807531L;
	private final JSlider slider;
	
	
	public Slider(QLSNode widgetModel) {
		super(widgetModel);
//		super(widgetModel.getMin(), widgetModel.getMax());
		slider = new JSlider();	
	}

	@Override
	public JComponent getWidget() {
		return slider;
	}
}
