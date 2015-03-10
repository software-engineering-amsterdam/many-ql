package org.uva.qls.view.widget;

import javax.swing.JSlider;

import org.uva.qls.ast.QLSNode;

public class Slider extends JSlider {

	private static final long serialVersionUID = -7374082203125807531L;
	private final QLSNode widgetModel;
	
	
	public Slider(QLSNode widgetModel) {
//		super(widgetModel.getMin(), widgetModel.getMax());
		this.widgetModel = widgetModel;	
	}
}
