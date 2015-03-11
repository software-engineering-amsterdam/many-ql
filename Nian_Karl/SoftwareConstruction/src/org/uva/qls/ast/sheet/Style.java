package org.uva.qls.ast.sheet;

import java.util.ArrayList;

import org.uva.qls.ast.BaseNode;
import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.style.StyleProperty;
import org.uva.qls.ast.type.Type;

public class Style extends BaseNode {
	private final Type type;
	private final ArrayList<StyleProperty> styleProperties;

	public Style(Type type, ArrayList<StyleProperty> styleProperties,CodePosition pos) {
		super(pos);
		this.type = type;
		this.styleProperties = styleProperties;
	}

	public Style(Type type, CodePosition pos) {
		super(pos);
		this.type = type;
		this.styleProperties = new ArrayList<StyleProperty>();
	}

	public Type getType() {
		return type;
	}

	public ArrayList<StyleProperty> getStyleProperties() {
		return styleProperties;
	}

	public void addProperty(StyleProperty property) {
		styleProperties.add(property);
	}

}
