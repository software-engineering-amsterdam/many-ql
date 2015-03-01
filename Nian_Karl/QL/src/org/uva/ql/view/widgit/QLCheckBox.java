package org.uva.ql.view.widgit;

import java.awt.Color;

import javax.swing.JCheckBox;

public class QLCheckBox extends JCheckBox implements QLWidget<Boolean>{

	private static final long serialVersionUID = 1L;

	private final String identifier;
		
	public QLCheckBox(String identifier) {
		this.identifier = identifier;
		setOpaque(false);
	}

	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public Boolean getValue() {
		return getValue();
	}
	
}
