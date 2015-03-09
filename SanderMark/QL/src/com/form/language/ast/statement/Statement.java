package com.form.language.ast.statement;

import com.form.language.ast.type.Type;
import com.form.language.error.ErrorCollector;
import com.form.language.gui.components.FormComponent;
import com.form.language.gui.components.GUIBuilder;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;
import com.form.language.memory.RuntimeMemory;
import com.form.language.memory.TypeMemory;

public interface Statement {
		public void createGUIComponent(GUIBuilder guiBuilder, FormComponent formGUI, RuntimeMemory rm);
		public Type getType(TypeMemory mem);
//		public abstract void getErrors(ErrorCollector errorCollector);
		public abstract void collectIds(IdCollector idCollector);
		public abstract void setType(IdTypeTable ids);
		public void initMemory(RuntimeMemory mem);
		public abstract void getReferences(IdCollector idCollector);
}
