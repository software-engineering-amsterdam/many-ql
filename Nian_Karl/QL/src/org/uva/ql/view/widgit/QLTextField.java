package org.uva.ql.view.widgit;

import java.awt.Dimension;

import javax.swing.JTextField;

public class QLTextField extends JTextField implements QLWidget<String> {

	private static final long serialVersionUID = -4761288106171787127L;
	private final String identifier;
	
	public QLTextField(String identifier) {
		this.identifier = identifier;
		setPreferredSize(new Dimension(100, 25));
	}
	
	@Override
	public String getValue() {
		return getValue();
	}

	@Override
	public String getIdentifier() {
		return  identifier;
	}

}
