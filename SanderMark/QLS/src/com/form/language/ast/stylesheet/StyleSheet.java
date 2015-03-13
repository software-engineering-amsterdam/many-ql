package com.form.language.ast.stylesheet;

import java.util.List;

import com.form.language.ast.ASTNode;

public class StyleSheet implements ASTNode {
	
	private final String name;
	private final List<Page> pages;

	public StyleSheet(String name, List<Page> pages) {
		this.name = name;
		this.pages = pages;
	}
	
	public String getName() {
        return this.name;
    }

    public List<Page> getPages() {
        return this.pages;
    }
	
	public void getType() {
		// TODO Auto-generated method stub
		
	}

}
