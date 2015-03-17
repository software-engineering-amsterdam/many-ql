package com.form.language.ast.statement;

import com.form.language.ast.ASTNode;
import com.form.language.ast.type.Type;
import com.form.language.error.QLToken;
import com.form.language.gui.components.FormComponent;
import com.form.language.gui.components.GUIBuilder;
import com.form.language.memory.Context;

public abstract class Statement extends ASTNode {
    public abstract void createGUIComponent(GUIBuilder guiBuilder, FormComponent formGUI, Context context);
    public abstract void initMemory(Context context);
    public abstract Type getType(Context context);

    protected Statement(QLToken tokenInfo) {
	super(tokenInfo);
    }
}
