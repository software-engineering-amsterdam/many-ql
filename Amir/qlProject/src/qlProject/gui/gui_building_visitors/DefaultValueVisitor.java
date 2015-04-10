package qlProject.gui.gui_building_visitors;

import qlProject.ast.type.BooleanType;
import qlProject.ast.type.ITypeVisitor;
import qlProject.ast.type.IntType;
import qlProject.ast.type.StringType;
import qlProject.ast.value.BoolValue;
import qlProject.ast.value.NullValue;
import qlProject.ast.value.StringValue;
import qlProject.ast.value.Value;

public class DefaultValueVisitor implements ITypeVisitor {

	public Value visit (StringType type){
		return new StringValue("");
	}

	public Value visit(IntType type){
		return new NullValue();
	}

	public Value visit(BooleanType type){
		return new BoolValue(false);
	}

}