package org.uva.qls.view.widget;

import javax.swing.JComponent;
import javax.swing.JSlider;

import org.uva.ql.ast.QLNode;

public class Slider extends Widget<QLNode>{

	private static final long serialVersionUID = -7374082203125807531L;
	private final JSlider slider;
	
	
	public Slider(QLNode widgetModel) {
		super(widgetModel);
		slider = new JSlider();
	}

	@Override
	public JComponent getWidget() {
		return slider;
	}
}
