package com.form.language.ast.stylesheet.Statement;

import com.form.language.ast.ASTNode;

public interface Statement extends ASTNode {
	public void createGUIComponent();
	public void initMemory();
}
