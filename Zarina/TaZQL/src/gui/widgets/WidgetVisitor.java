package gui.widgets;

import ast.type.ChoiceType;
import ast.type.DigitsType;
import ast.type.ITypeVisitor;
import ast.type.TextType;
import ast.type.Type;
import ast.type.UndefinedType;

public class WidgetVisitor implements ITypeVisitor<IWidgetComponent>{
	
	private final String id, label;
	private final Type type;
	
	public WidgetVisitor(String id, String label, Type type) {
		this.id = id;
		this.label = label;
		this.type = type;
	}
	
	@Override
	public TextFieldWidget visit(TextType type) {
		return new TextFieldWidget(this.id, this.label, this.type);
	}

	@Override
	public TextFieldWidget visit(DigitsType type) {
		return new TextFieldWidget(id, this.label, type);
	}

	@Override
	public ChoiceWidget visit(ChoiceType type) {
		//TODO to be changed to checkbox?
		return new ChoiceWidget(id, this.label, type);
	}

	@Override
		//TODO probably set on invisible or give an error?
	public TextFieldWidget visit(UndefinedType type) {
		return new TextFieldWidget(id, this.label, type);
	}
	
}
