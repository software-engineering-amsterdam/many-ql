package qls.gui.widget.input;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;
import ql.Value;
import ql.gui.widget.InputWidget;

public abstract class Slider<T extends Value> extends InputWidget<T> implements ChangeListener {
	protected JPanel container;
	protected JSlider slider;
	protected JLabel label;
	
	public Slider() {
		this(0, Integer.MAX_VALUE);
	}
	public Slider (int min, int max) {
		slider = new JSlider(JSlider.HORIZONTAL, min, max, 0);
		
		slider.setMaximumSize(new Dimension(slider.getPreferredSize().width, 
				slider.getPreferredSize().height * 2));
		slider.addChangeListener(this);
		
		label = new JLabel();
    	label.setFont(new Font("Serif", Font.BOLD, 20));
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
