package com.form.language.ast.statement;

import com.form.language.ast.ASTNode;
import com.form.language.gui.components.FormComponent;
import com.form.language.gui.components.GUIBuilder;
import com.form.language.memory.Context;

public interface Statement extends ASTNode {
		public void createGUIComponent(GUIBuilder guiBuilder, FormComponent formGUI, Context context);
		public void initMemory(Context context);
}
