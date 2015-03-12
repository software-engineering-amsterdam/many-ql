package com.form.language.ast.stylesheet.Statement;

import java.util.List;

import com.form.language.ast.style.Style;
import com.form.language.ast.type.Type;
import com.form.language.ast.widget.Widget;

public class Default implements Statement {
	
	private Type type;
	private Widget widget; 
	private List<Style> styles;
	
	public Default(Type type, Widget widget, List<Style> styles) {
        this.type = type;
        this.widget = widget;
        this.styles = styles;
    }
	
	public Default(Type type, Widget widget) {
        this.type = type;
        this.widget = widget;
    }

	public void getType() {
		// TODO Auto-generated method stub
		
	}

	public void createGUIComponent() {
		// TODO Auto-generated method stub
		
	}

	public void initMemory() {
		// TODO Auto-generated method stub
		
	}

}
