package com.form.language.ast.statement;

import com.form.language.ast.type.Type;
import com.form.language.gui.components.FormComponent;
import com.form.language.gui.components.GUIBuilder;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;

public interface Statement {
		public void createGUIComponent(GUIBuilder guiBuilder, FormComponent formGUI, Context rm);
		public Type getType(Context mem);
//		public abstract void getErrors(ErrorCollector errorCollector);
		public abstract void collectIds(IdCollector idCollector);
		public abstract void setType(IdTypeTable ids);
		public void initMemory(Context mem);
		public abstract void getReferences(IdCollector idCollector);
}
