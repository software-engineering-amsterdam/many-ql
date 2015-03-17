package com.form.language.ast.stylesheet.Statement;

import com.form.language.ast.widget.Widget;

public class Question implements Statement {
	
	private String id;
	private Widget widget;
	
	public Question(String id, Widget widget) {
        this.id = id;
        this.widget = widget;
    }
	
    public Question(String id) {
        this.id = id;
    }

	public void getType() {
		// TODO Auto-generated method stub
		
	}

	public String getId() {
		return this.id;
	}

	public Widget getWidget() {
		return this.widget;
	}

	public void createGUIComponent() {
		// TODO Auto-generated method stub
		
	}

	public void initMemory() {
		// TODO Auto-generated method stub
		
	}

}
