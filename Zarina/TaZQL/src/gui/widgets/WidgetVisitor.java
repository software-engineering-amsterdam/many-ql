package gui.widgets;

import interpreter.ValueRepository;
import ast.type.ChoiceType;
import ast.type.DigitsType;
import ast.type.ITypeVisitor;
import ast.type.TextType;
import ast.type.Type;
import ast.type.UndefinedType;

public class WidgetVisitor implements ITypeVisitor<IWidgetComponent>{
	
	private final String id, label;
	private final Type type;
	private final ValueRepository valueRepository;
	
	public WidgetVisitor(String id, String label, Type type, ValueRepository valueRepository) {
		this.id = id;
		this.label = label;
		this.type = type;
		this.valueRepository = valueRepository;
	}
	
	@Override
	public TextFieldWidget visit(TextType type) {
		return new TextFieldWidget(this.id, this.label, this.type, this.valueRepository);
	}

	@Override
	public IntegerFieldWidget visit(DigitsType type) {
		return new IntegerFieldWidget(id, this.label, type, this.valueRepository);
	}

	@Override
	public ChoiceWidget visit(ChoiceType type) {
		return new ChoiceWidget(id, this.label, type, this.valueRepository);
	}

	@Override
		//TODO probably set on invisible or give an error?
	public TextFieldWidget visit(UndefinedType type) {
		return new TextFieldWidget(id, this.label, type, this.valueRepository);
	}
	
}
