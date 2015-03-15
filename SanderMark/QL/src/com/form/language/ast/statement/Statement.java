package com.form.language.ast.statement;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.ASTNode;
import com.form.language.gui.components.FormComponent;
import com.form.language.gui.components.GUIBuilder;
import com.form.language.memory.Context;

public abstract class Statement extends ASTNode {
    public abstract void createGUIComponent(GUIBuilder guiBuilder, FormComponent formGUI, Context context);
    public abstract void initMemory(Context context);
    
    protected Statement(Token tokenInfo) {
	super(tokenInfo);
    }
}
