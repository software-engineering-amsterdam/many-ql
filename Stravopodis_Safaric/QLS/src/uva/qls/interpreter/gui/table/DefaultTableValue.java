package uva.qls.interpreter.gui.table;

import uva.qls.ast.Page;
import uva.qls.ast.component.Component;
import uva.qls.ast.style.visitor.StyleTable;

public class DefaultTableValue {

	private StyleTable style;
	private Component component;
	private Page page;
	
	
	public DefaultTableValue(StyleTable _style, Component _component, Page _page){
		this.style = _style;
		this.component = _component;
		this.page = _page;
	}
	
	public StyleTable getStyle(){
		return this.style;
	}
	
	public Component getComponent(){
		return this.component;
	}
	
	public Page getPage(){
		return this.page;
	}
	
	@Override
	public String toString(){
		return "DefaultTableValue(" + this.getStyle() + "," + this.component + "," + this.page + ")";
	}
}
