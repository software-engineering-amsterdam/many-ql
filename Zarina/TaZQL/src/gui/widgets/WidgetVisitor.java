package gui.widgets;

import ast.type.ChoiceType;
import ast.type.IntegerType;
import ast.type.ITypeVisitor;
import ast.type.TextType;
import ast.type.Type;
import ast.type.UndefinedType;
import evaluator.BooleanValue;
import evaluator.IntegerValue;
import evaluator.StringValue;
import evaluator.ValueRepository;

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
		this.valueRepository.putValue(id, new StringValue(""));
		return new TextFieldWidget(this.id, this.label, this.type, this.valueRepository);
	}

	@Override
	public IntegerFieldWidget visit(IntegerType type) {
		this.valueRepository.putValue(id, new IntegerValue(0));
		return new IntegerFieldWidget(id, this.label, type, this.valueRepository);
	}

	@Override
	public ChoiceWidget visit(ChoiceType type) {
		this.valueRepository.putValue(id, new BooleanValue(false));
		return new ChoiceWidget(id, this.label, type, this.valueRepository);
	}

	@Override
	public IntegerFieldWidget visit(UndefinedType type) {
		assert false: "Unsupported type. This supposed to be checked in typechecker.";
		return null;
	}
	
}
