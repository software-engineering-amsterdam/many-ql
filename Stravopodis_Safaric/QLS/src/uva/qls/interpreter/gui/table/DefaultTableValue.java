package uva.qls.interpreter.gui.table;

import java.util.List;

import uva.qls.ast.component.Component;
import uva.qls.ast.primitive.Type;
import uva.qls.ast.style.Style;

public class DefaultTableValue {

	private List<Style> style;
	private Component component;
	private Type type;
	
	public DefaultTableValue(List<Style> _style, Type _type){
		this.style = _style;
		this.type = _type;
	}
	
	public DefaultTableValue(Component _component, Type _type){
		this.component = _component;
		this.type = _type;
	}
	
	public DefaultTableValue(List<Style> _style, Component _component, Type _type){
		this.style = _style;
		this.component = _component;
		this.type = _type;
	}
	
	public List<Style> getStyle(){
		return this.style;
	}
	
	public Component getComponent(){
		return this.component;
	}
	
	public Type getType(){
		return this.type;
	}
	
	@Override
	public String toString(){
		return "DefaultTableValue(" + this.style + "," + this.component + "," + this.type + ")";
	}
}
