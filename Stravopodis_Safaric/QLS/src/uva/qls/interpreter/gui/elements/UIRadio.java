package uva.qls.interpreter.gui.elements;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JRadioButton;

import uva.qls.ast.component.Radio;

public class UIRadio extends UIComponent<List<JRadioButton>> {
	
	private Radio radio;
	
	public UIRadio (Radio _radio){
		this.radio=_radio;
	}
	
	@Override
	public List<JRadioButton> getComponent() {
		JRadioButton buttonX = new JRadioButton(radio.getRadioValues().getX());
		JRadioButton buttonY = new JRadioButton(radio.getRadioValues().getY());
		
		return this.applyStyles(Arrays.asList(buttonX, buttonY));
	}

	@Override
	public List<JRadioButton> applyStyles(List<JRadioButton> toComponent) {
		
		for (JRadioButton _radio : toComponent){
			Font font = new Font(radio.getStyle().fontName(), Font.PLAIN, radio.getStyle().fontSize());
			
			Dimension dimension = new Dimension(radio.getStyle().width(),radio.getStyle().height());
			_radio.setPreferredSize(dimension);
			_radio.setSize(dimension);
			
			_radio.setForeground(radio.getStyle().color());
			_radio.setFont(font);
			
			Collections.replaceAll(toComponent, _radio, _radio);
		}
		
		
		return toComponent;
	}

}
