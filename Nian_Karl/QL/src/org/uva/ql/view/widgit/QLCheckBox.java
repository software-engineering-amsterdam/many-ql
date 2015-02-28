package org.uva.ql.view.widgit;

import java.awt.Checkbox;

public class QLCheckBox extends Checkbox implements QLWidget<Boolean>{

	private static final long serialVersionUID = 1L;

	private final String identifier;
	
	public QLCheckBox(String identifier) {
		this.identifier = identifier;
	}
	
	@Override
	public Boolean getValue() {
		return this.getState();
	}


	@Override
	public String getIdentifier() {
		return identifier;
	}
	
}
