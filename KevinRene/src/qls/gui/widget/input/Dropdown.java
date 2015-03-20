package qls.gui.widget.input;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import ql.gui.DefaultChangeHandler;
import ql.value.BooleanValue;
import ql.value.StringValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.ast.statement.widget.styling.property.Color;
import qls.ast.statement.widget.styling.property.Font;
import qls.ast.statement.widget.styling.property.FontSize;
import qls.ast.statement.widget.styling.property.Height;
import qls.ast.statement.widget.styling.property.Width;
import qls.gui.widget.InputWidget;

public class Dropdown extends DefaultChangeHandler implements InputWidget<BooleanValue>, ActionListener {
	protected JComboBox<String> comboBox;
	private String[] labels;
	
	public Dropdown(StringValue trueValue, StringValue falseValue) {
		labels = new String[]{trueValue.getValue(), falseValue.getValue()};
		
		comboBox = new JComboBox<String>(labels);
		comboBox.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		handleChange(getValue(), this);
	}

	@Override
	public void disable() {
		comboBox.setEnabled(false);
	}

	@Override
	public void setValue(BooleanValue value) {
		comboBox.setSelectedItem(value.toString());
	}

	@Override
	public BooleanValue getValue() {
		switch (comboBox.getSelectedIndex()) {
			case 0 : return new BooleanValue(true);
			default : return new BooleanValue(false);
		}
	}

	@Override
	public void updateComponent() {
		comboBox.revalidate();
		comboBox.repaint();
	}

	@Override
	public JComponent getComponent() {
		return comboBox;
	}

	@Override
	public void setStyle(StyleProperties properties) {
		setWidth(properties.getWidth());
		setHeight(properties.getHeight());
		
		setFont(properties.getFont());
		setFontSize(properties.getFontSize());
	
		setColor(properties.getColor());
	}
	
	private void setWidth(Width width) {
		if(width == null) {
			return;
		}
		
		Dimension currentDimensions = comboBox.getPreferredSize();
		currentDimensions.setSize(width.getWidth(), currentDimensions.getHeight());
		comboBox.setPreferredSize(currentDimensions);
		
		updateComponent();
	}
	
	private void setHeight(Height height) {
		if(height == null) {
			return;
		}
		
		Dimension currentDimensions = comboBox.getPreferredSize();
		currentDimensions.setSize(currentDimensions.getWidth(), height.getHeight());
		comboBox.setPreferredSize(currentDimensions);
		
		updateComponent();
	}

	private void setFont(Font font) {
		if(font == null) {
			return;
		}
		
		comboBox.setFont(new java.awt.Font(font.getFontName(), java.awt.Font.PLAIN, 13));
	}
	
	private void setFontSize(FontSize fontSize) {
		if(fontSize == null) {
			return;
		}
		
		java.awt.Font currentFont = comboBox.getFont();
		comboBox.setFont(new java.awt.Font(currentFont.getFontName(), java.awt.Font.PLAIN, fontSize.getFontSize()));
	}
	
	private void setColor(Color color) {
		if(color == null) {
			return;
		}
		
		comboBox.setBackground(new java.awt.Color(color.getColor()));
	}
}
