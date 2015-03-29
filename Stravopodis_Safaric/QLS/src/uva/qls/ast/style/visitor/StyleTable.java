package uva.qls.ast.style.visitor;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import uva.qls.ast.style.Style;

public class StyleTable{

	private Map<String, Style> table;
	
	public StyleTable(){
		this.table = new HashMap<String, Style>();
	}
	
	public Map<String, Style> getTable(){
		return this.table;
	}
	
	public Color color(){
		return (Color)this.retrieveValue("Color").evaluate().getValue();
	}
	
	public String fontName(){
		return this.retrieveValue("FontName").evaluate().getValue().toString();
	}
	
	public int fontSize(){
		return (int)this.retrieveValue("FontSize").evaluate().getValue();
	}
	
	public int width(){
		return (int)this.retrieveValue("Width").evaluate().getValue();
	}
	
	public int height(){
		return (int)this.retrieveValue("Height").evaluate().getValue();
	}
	
	public void putValue(String identifier, Style value) {
		this.table.put(identifier, value);
	}

	public Style retrieveValue(String identifier) {
		return this.table.get(identifier);
	}

	@Override
	public String toString() {
		return this.table.toString();
	}

}
