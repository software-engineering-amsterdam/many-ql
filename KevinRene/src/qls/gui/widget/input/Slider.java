package qls.gui.widget.input;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;
import ql.Value;
import ql.gui.DefaultChangeHandler;
import qls.ast.statement.widget.styling.property.Font;
import qls.gui.widget.InputWidget;

public abstract class Slider<T extends Value> extends DefaultChangeHandler implements InputWidget<T>, ChangeListener {
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

	protected abstract void setFont(Font font);
	
	@Override
	public void updateComponent() {
		container.repaint();
	}

	@Override
	public JComponent getComponent() {
		return container;
	}
}
