package gui.widgets;

import javax.swing.JComponent;
import javax.swing.JTextField;

import ast.type.ChoiceType;
import ast.type.DigitsType;
import ast.type.ITypeVisitor;
import ast.type.TextType;
import ast.type.Type;
import ast.type.UndefinedType;

public class WidgetVisitor implements ITypeVisitor<IWidgetComponent>{
	
	//private IWidgetComponent widgetComponent;
	private JComponent widget;
	String id, label;
	Type type;
	//private final ValueRepository valueRepository; // for later, set/get value from fields
	//private SimpleQuestion q;
	public WidgetVisitor(String id, String label, Type type) {
		this.id = id;
		this.label = label;
		this.type = type;
	}
	
	
	public JComponent attachDamnWidget(){
		widget =  new JTextField("test");
		return widget;
	}
	
	@Override
	public TextFieldWidget visit(TextType type) {
		return new TextFieldWidget(this.id, this.label, this.type);
	}

	@Override
	public TextFieldWidget visit(DigitsType type) {
		// TODO to be changed
		return new TextFieldWidget(id, this.label, type);
	}

	@Override
	public TextFieldWidget visit(ChoiceType type) {
		//TODO to be changed to checkbox?
		return new TextFieldWidget(id, this.label, type);
	}

	@Override
		//TODO probably set on invisible or give an error?
	public TextFieldWidget visit(UndefinedType type) {
		return new TextFieldWidget(id, this.label, type);
	}
	
}
