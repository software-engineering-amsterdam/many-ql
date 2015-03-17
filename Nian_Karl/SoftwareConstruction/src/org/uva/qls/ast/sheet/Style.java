package org.uva.qls.ast.sheet;

import java.util.ArrayList;
import java.util.List;

import org.uva.qls.ast.BaseNode;
import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.style.StyleProperty;
import org.uva.qls.ast.type.Type;
import org.uva.qls.visitor.SheetVisitable;
import org.uva.qls.visitor.SheetVisitor;

public class Style extends BaseNode implements SheetVisitable {
	private final Type type;
	private final List<StyleProperty> styleProperties;

	public Style(Type type, List<StyleProperty> styleProperties, CodePosition pos) {
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

	public List<StyleProperty> getStyleProperties() {
		return styleProperties;
	}

	public void addProperty(StyleProperty property) {
		styleProperties.add(property);
	}

	@Override
	public <T> T accept(SheetVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
