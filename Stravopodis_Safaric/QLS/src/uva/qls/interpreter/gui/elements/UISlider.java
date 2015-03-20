package uva.qls.interpreter.gui.elements;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSlider;

import uva.qls.ast.component.Slider;

public class UISlider extends UIComponent<JSlider> {
	
	private Slider slider;
	
	public UISlider(Slider _slider){
		this.slider=_slider;
	}
	
	private JSlider setSlider(JSlider toComponent){
		
		Hashtable<Integer, JLabel> labels =new Hashtable<Integer, JLabel>();
		
		
		toComponent.setMinimum(1);
	    toComponent.setMaximum(100);
		toComponent.setMinorTickSpacing(1);
		toComponent.setMajorTickSpacing(10);
		toComponent.setPaintTicks(true);
		
		labels.put(0, new JLabel(this.slider.getSliderValues().getX()));
		labels.put(100, new JLabel(this.slider.getSliderValues().getY()));
	    
		toComponent.setLabelTable(labels);
		toComponent.setPaintLabels(true);
		
		return toComponent;
	}
	

	@Override
	public JSlider getComponent() {
		JSlider myslider = new JSlider();
		myslider=this.setSlider(myslider);
		return this.applyStyles(myslider);
	}

	@Override
	public JSlider applyStyles(JSlider toComponent) {
		Font font = new Font(slider.getStyle().fontName(), Font.PLAIN, slider.getStyle().fontSize());
		
		Dimension dimension = new Dimension(slider.getStyle().width(), slider.getStyle().height());
		toComponent.setPreferredSize(dimension);
		toComponent.setSize(dimension);
		
		toComponent.setForeground(slider.getStyle().color());
		toComponent.setFont(font);
		
		return toComponent;
	}

}
