package qlProject.gui.input_response_visitors;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import qlProject.ast.type.BooleanType;
import qlProject.ast.type.ITypeVisitor;
import qlProject.ast.type.IntType;
import qlProject.ast.type.StringType;
import qlProject.ast.value.Value;
import qlProject.gui.gui_building_visitors.QuestionWidget;

public class InputUpdaterVisitor implements ITypeVisitor {

	public JComponent inputWidget;
	public Value res;
	
	public InputUpdaterVisitor(QuestionWidget questionWidget, Value res) {
		this.inputWidget = questionWidget.getComponent();
		this.res = res;
	}

	
	public JComponent visit (StringType type){
		((JTextField)inputWidget).setText(res.getValue().toString());
		return inputWidget;
	}

	public JComponent visit(IntType type){
		((JTextField)inputWidget).setText(res.getValue().toString());
		return inputWidget;
	}

	public JComponent visit(BooleanType type){
		((JCheckBox)inputWidget).setSelected((Boolean)res.getValue());
		return inputWidget;
	}

}