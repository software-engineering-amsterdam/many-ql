package org.uva.qls.ast.value;

import java.awt.Color;

public class ColorValue extends Value {
	
	private final Color value;
	
	public ColorValue(Color value) {
		this.value = value;
	}
	
	@Override
	public Color value() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	
	@Override
	public boolean isDefined() {
		if (value != null) {
			return true;
		}
		return false;
	}
}
