package qlProject.gui.gui_building_visitors;

import java.text.NumberFormat;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import qlProject.ast.type.BooleanType;
import qlProject.ast.type.ITypeVisitor;
import qlProject.ast.type.IntType;
import qlProject.ast.type.StringType;

public class TypeWidgetMatchingVisitor implements ITypeVisitor {

	public JComponent visit (StringType type){
		return new JTextField(15);
	}

	public JComponent visit(IntType type){
		NumberFormat nf = NumberFormat.getIntegerInstance();
		JFormattedTextField tf = new JFormattedTextField(nf);
		tf.setColumns(7); //TODO addLabel
		return tf;
	}

	public JComponent visit(BooleanType type){
		return new JCheckBox();
	}

}