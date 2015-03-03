package com.form.language.ast.statement;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.form.language.ast.type.Type;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;

public interface Statement {
		public JComponent createGUIComponent(JPanel panel);
		public Type getType();
		public abstract void getErrors(ErrorCollector errorCollector);
		public abstract void fillMemory(IdCollector idCollector);
		public abstract void setType(IdTypeTable ids);
}
