package qls.ast.statement.widget.styling;

import java.util.HashMap;
import java.util.Map;

import qls.ast.Statement;
import qls.ast.statement.widget.styling.property.Color;
import qls.ast.statement.widget.styling.property.Font;
import qls.ast.statement.widget.styling.property.FontSize;
import qls.ast.statement.widget.styling.property.Height;
import qls.ast.statement.widget.styling.property.Width;
import qls.ast.visitor.StatementVisitor;

public class StyleProperties extends Statement {
	private Map<Property, Property> properties;
	
	public StyleProperties() {
		properties = new HashMap<Property, Property>();
	}
	
	public StyleProperties(Property property) {
		this();
		setProperty(property);
	}
	
	public StyleProperties(Property property, StyleProperties properties) {
		this();
		this.properties.putAll(properties.getProperties());
		setProperty(property);
	}
	
	public void setProperty(Property property) {
		properties.put(property, property);
	}
	
	public Font getFont() {
		return (Font) properties.get(new Font(null));
	}
	
	public FontSize getFontSize() {
		return (FontSize) properties.get(new FontSize(null));
	}
	
	public Height getHeight() {
		return (Height) properties.get(new Height(null));
	}
	
	public Width getWidth() {
		return (Width) properties.get(new Width(null));
	}
	
	public Color getColor() {
		return (Color) properties.get(new Color(null));
	}
	
	public Map<Property, Property> getProperties() {
		return properties;
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("StyleProperties(");
		
		for(Property rule : properties.keySet()) {
			sb.append(rule.toString() + ", ");
		}
		
		if (properties.size() > 0) {
			sb.setLength(sb.length() - 2);
		}
		sb.append(")");
		
		return sb.toString();
	}

}
