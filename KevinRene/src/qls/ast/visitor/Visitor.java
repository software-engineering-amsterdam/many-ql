package qls.ast.visitor;

import qls.ast.Identifier;
import qls.ast.literal.BooleanLiteral;
import qls.ast.literal.FloatLiteral;
import qls.ast.literal.IntegerLiteral;
import qls.ast.literal.StringLiteral;
import qls.ast.statement.Block;
import qls.ast.statement.Page;
import qls.ast.statement.Question;
import qls.ast.statement.Section;
import qls.ast.statement.Stylesheet;
import qls.ast.type.QLSBoolean;
import qls.ast.type.QLSError;
import qls.ast.type.QLSFloat;
import qls.ast.type.QLSForm;
import qls.ast.type.QLSInteger;
import qls.ast.type.QLSNumeric;
import qls.ast.type.QLSString;
import qls.ast.widget.Checkbox;
import qls.ast.widget.Dropdown;
import qls.ast.widget.RadioButton;
import qls.ast.widget.Slider;
import qls.ast.widget.Spinner;
import qls.ast.widget.TextField;

public interface Visitor<T> {
	public T visit(Stylesheet stylesheet);
	public T visit(Page page);
	public T visit(Section section);
	public T visit(Question question);
	public T visit(Block block);
	
	public T visit(BooleanLiteral booleanLiteral);
	public T visit(FloatLiteral floatLiteral);
	public T visit(IntegerLiteral integerLiteral);
	public T visit(StringLiteral stringLiteral);
	
	public T visit(QLSBoolean booleanType);
	public T visit(QLSError errorType);
	public T visit(QLSFloat floatType);
	public T visit(QLSForm formType);
	public T visit(QLSInteger integerType);
	public T visit(QLSNumeric numericType);
	public T visit(QLSString stringType);
	
	public T visit(Checkbox checkbox);
	public T visit(Dropdown dropdown);
	public T visit(RadioButton radioButton);
	public T visit(TextField textField);
	public T visit(Spinner spinner);
	public T visit(Slider slider);
	public T visit(Identifier identifier);
}
