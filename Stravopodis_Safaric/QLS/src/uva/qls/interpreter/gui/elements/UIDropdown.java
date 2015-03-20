package uva.qls.interpreter.gui.elements;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;

import uva.qls.ast.component.Dropdown;

public class UIDropdown extends UIComponent<JComboBox<String>> {

	private Dropdown dropdown;
	
	public UIDropdown (Dropdown _dropdown){
		this.dropdown=_dropdown;	
	}
	
	private JComboBox<String> addItems(JComboBox<String> toComponent){
		
		for (String item : this.dropdown.getComponents()){
			toComponent.addItem(item);
		}
		return toComponent;
	}
	
	@Override
	public JComboBox<String> getComponent(){
		JComboBox<String> box = new JComboBox<String>();
		box = this.addItems(box);
		return this.applyStyles(box);
	}

	@Override
	public JComboBox<String> applyStyles(JComboBox<String> toComponent) {
		Font font = new Font(dropdown.getStyle().fontName(), Font.PLAIN, dropdown.getStyle().fontSize());
		
		Dimension dimension = new Dimension(dropdown.getStyle().width(), dropdown.getStyle().height());
		toComponent.setPreferredSize(dimension);
		toComponent.setSize(dimension);
		
		toComponent.setForeground(dropdown.getStyle().color());
		toComponent.setFont(font);
		
		return toComponent;
	}
	
	@Override
	public String toString(){
		return "UIDropdown(" + this.getComponent().getFont() + "," + this.getComponent().getSize() + ")";
	}
}
