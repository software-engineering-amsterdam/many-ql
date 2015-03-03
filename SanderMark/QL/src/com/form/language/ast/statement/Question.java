package com.form.language.ast.statement;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.form.language.ast.expression.literal.IdLiteral;
import com.form.language.ast.type.Type;
import com.form.language.error.ErrorCollector;
import com.form.language.gui.components.FormComponent;
import com.form.language.gui.components.GUIBuilder;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;
import com.form.language.memory.RuntimeMemory;

public class Question implements Statement {
	private String id;
	private String questionLabel;
	private Type questionType;
	
	private JPanel qPanel;
	private JPanel labelContainer;
	
	public Question(String questionLabel, String id, Type questionType) {
		super();
		this.questionLabel = questionLabel;
		this.id = id;
		this.questionType = questionType;
	}
	
	@Override
	public Type getType() {
		return this.questionType;
	}

	@Override
	public void getErrors(ErrorCollector errs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collectIds(IdCollector idCollector) {		
		idCollector.addId(new IdLiteral(this.id,this.questionType,idCollector,null));
	}

	@Override
	public void setType(IdTypeTable ids) {}

	public String getText() {
		return this.questionLabel;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public void initMemory(RuntimeMemory mem){
		questionType.defaultValue().addToMemory(id, mem);
	}

	@Override
	public void createGUIComponent(GUIBuilder guiBuilder,FormComponent formGUI) {
		guiBuilder.createGUIQuestion(this, formGUI);
	}
	
}
