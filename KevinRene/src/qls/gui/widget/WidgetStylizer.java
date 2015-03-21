package qls.gui.widget;

import java.awt.Dimension;

import javax.swing.JComponent;

import qls.ast.statement.widget.styling.StyleProperties;
import qls.ast.statement.widget.styling.property.Color;
import qls.ast.statement.widget.styling.property.Font;
import qls.ast.statement.widget.styling.property.FontSize;
import qls.ast.statement.widget.styling.property.Height;
import qls.ast.statement.widget.styling.property.Width;

public class WidgetStylizer {
	public void setStyle(JComponent component, StyleProperties properties) {
		setWidth(component, properties.getWidth());
		setHeight(component, properties.getHeight());
		
		setFont(component, properties.getFont());
		setFontSize(component, properties.getFontSize());
	
		setColor(component, properties.getColor());
	}
	
	private void setWidth(JComponent component, Width width) {
		if(width == null) {
			return;
		}
		
		Dimension currentDimensions = component.getPreferredSize();
		currentDimensions.setSize(width.getWidth(), currentDimensions.getHeight());
		component.setPreferredSize(currentDimensions);
	}
	
	private void setHeight(JComponent component, Height height) {
		if(height == null) {
			return;
		}
		
		Dimension currentDimensions = component.getPreferredSize();
		currentDimensions.setSize(currentDimensions.getWidth(), height.getHeight());
		component.setPreferredSize(currentDimensions);
	}

	private void setFont(JComponent component, Font font) {
		if(font == null) {
			return;
		}
		
		component.setFont(new java.awt.Font(font.getFontName(), java.awt.Font.PLAIN, 13));
	}
	
	private void setFontSize(JComponent component, FontSize fontSize) {
		if(fontSize == null) {
			return;
		}
		
		java.awt.Font currentFont = component.getFont();
		component.setFont(new java.awt.Font(currentFont.getFontName(), java.awt.Font.PLAIN, fontSize.getFontSize()));
	}
	
	private void setColor(JComponent component, Color color) {
		if(color == null) {
			return;
		}
		
		component.setBackground(new java.awt.Color(color.getColor()));
	}
}
