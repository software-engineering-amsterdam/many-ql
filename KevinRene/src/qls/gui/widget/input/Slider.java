package qls.gui.widget.input;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;
import ql.Value;
import ql.gui.DefaultComponent;
import ql.value.IntegerValue;
import qls.gui.widget.InputWidget;
import qls.gui.widget.WidgetStylizer;

public abstract class Slider<T extends Value> extends DefaultComponent implements InputWidget<T>, ChangeListener {
	protected JPanel container;
	protected JSlider slider;
	protected JLabel label;
	protected WidgetStylizer stylizer;
	
	public Slider(IntegerValue minValue, IntegerValue maxValue) {
		stylizer = new WidgetStylizer();
		
		slider = new JSlider(JSlider.HORIZONTAL, minValue.getPrimitive(), maxValue.getPrimitive(), minValue.getPrimitive());		
		slider.setMaximumSize(new Dimension(slider.getPreferredSize().width, 
				slider.getPreferredSize().height * 2));
		slider.addChangeListener(this);
		
		label = new JLabel();
    	label.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 20));
    	label.setVisible(true);
    	label.setText(String.valueOf(slider.getValue()));
    	
    	container = new JPanel(new MigLayout());
    	container.add(slider);
    	container.add(label);
	}

	@Override
	public void disable() {
		slider.setEnabled(false);
	}
	
	@Override
	public void updateComponent() {
		container.repaint();
	}

	@Override
	public JComponent getComponent() {
		return container;
	}
}
