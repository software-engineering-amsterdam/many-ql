package qls.ast.visitor.prettyprinter;

import ql.ast.QLNode;
import ql.ast.expression.Identifier;
import ql.ast.type.QLBoolean;
import ql.ast.type.QLError;
import ql.ast.type.QLFloat;
import ql.ast.type.QLForm;
import ql.ast.type.QLInteger;
import ql.ast.type.QLNumeric;
import ql.ast.type.QLString;
import ql.ast.visitor.TypeVisitor;
import qls.ast.QLSStatement;
import qls.ast.expression.literal.BooleanLiteral;
import qls.ast.expression.literal.FloatLiteral;
import qls.ast.expression.literal.IntegerLiteral;
import qls.ast.expression.literal.StringLiteral;
import qls.ast.statement.DefaultStyle;
import qls.ast.statement.DefaultWidget;
import qls.ast.statement.Page;
import qls.ast.statement.QLSBlock;
import qls.ast.statement.Question;
import qls.ast.statement.Section;
import qls.ast.statement.Stylesheet;
import qls.ast.statement.styling.StyleRule;
import qls.ast.statement.styling.StyleRuleSet;
import qls.ast.statement.styling.property.Color;
import qls.ast.statement.styling.property.Font;
import qls.ast.statement.styling.property.FontSize;
import qls.ast.statement.styling.property.Height;
import qls.ast.statement.styling.property.Width;
import qls.ast.statement.widget.Widget;
import qls.ast.statement.widget.type.Checkbox;
import qls.ast.statement.widget.type.Default;
import qls.ast.statement.widget.type.Dropdown;
import qls.ast.statement.widget.type.RadioButton;
import qls.ast.statement.widget.type.Slider;
import qls.ast.statement.widget.type.Spinbox;
import qls.ast.statement.widget.type.TextField;
import qls.ast.statement.widget.type.ValueSet;
import qls.ast.visitor.ExpressionVisitor;
import qls.ast.visitor.StatementVisitor;

public class PrettyPrinter extends StatementVisitor<Void> implements ExpressionVisitor<Void>, TypeVisitor<Void> {
	private String prefix = "";
	
	private PrettyPrinter() {
		super.setExpressionVisitor(this);
		super.setTypeVisitor(this);
	}
	
	public static void print(QLSStatement statement) {
		PrettyPrinter printer = new PrettyPrinter();
		statement.accept(printer);
	}
	
	/**
	 * Indent the prefix to indicate that a printable block
	 * of nodes has been entered.
	 */
	private void indent() {
		this.prefix += "   ";
	}
	
	/**
	 * Unindent the prefix. This happens when a block of
	 * printable nodes has been printed and the function
	 * exits. 
	 */
	private void unindent() {
		this.prefix = this.prefix.substring(0, this.prefix.length() - 3);
	}
	
	/**
	 * Print a node in the console. The node its toString
	 * method will be printed first, followed the the type
	 * of the node, separated by a colon.
	 * 
	 * @param node - The node to print.
	 */
	private Void printNode(QLNode node) {
		String type = node.getClass().getSimpleName();
		// Strip the string until only the name of the node is left.
		String nodeString = node.toString().split("\\(")[0];
		
		System.out.println(prefix + ("└── ") + nodeString + " : " + type);
		
		return null;
	}
	
	
	/*********************
	 == IDENTIFIER NODE ==
	 *********************/
	@Override
	public Void visit(Identifier identNode) {
		return printNode(identNode);
	}

	/****************
	 == TYPE NODES ==
	 ****************/
	@Override
	public Void visit(QLBoolean booleanNode) {
		return printNode(booleanNode);
	}

	@Override
	public Void visit(QLFloat floatNode) {
		return printNode(floatNode);
	}
	
	@Override
	public Void visit(QLForm formNode) {
		return printNode(formNode);
	}

	@Override
	public Void visit(QLInteger intNode) {
		return printNode(intNode);
	}

	@Override
	public Void visit(QLNumeric numericNode) {
		return printNode(numericNode);	
	}

	@Override
	public Void visit(QLString stringNode) {
		return printNode(stringNode);
	}
	
	@Override
	public Void visit(QLError qlError) {	
		return printNode(qlError);
	}

	/*******************
	 == LITERAL NODES ==
	 *******************/
	@Override
	public Void visit(BooleanLiteral booleanNode) {
		return printNode(booleanNode);
	}

	@Override
	public Void visit(FloatLiteral floatNode) {
		return printNode(floatNode);
	}

	@Override
	public Void visit(IntegerLiteral intNode) {
		return printNode(intNode);
	}

	@Override
	public Void visit(StringLiteral stringNode) {
		return printNode(stringNode);	
	}
	
	@Override
	public Void visit(Stylesheet stylesheetNode) {
		printNode(stylesheetNode);
		
		indent();
		super.visit(stylesheetNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(DefaultWidget defaultNode) {
		printNode(defaultNode);
		
		indent();
		super.visit(defaultNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(QLSBlock blockNode) {
		printNode(blockNode);
		
		indent();
		super.visit(blockNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(Question questionNode) {
		printNode(questionNode);
		
		indent();
		super.visit(questionNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(DefaultStyle defaultNode) {
		printNode(defaultNode);
		
		indent();
		super.visit(defaultNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(Widget widgetNode) {
		printNode(widgetNode);
		
		indent();
		super.visit(widgetNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(Section sectionNode) {
		printNode(sectionNode);
		
		indent();
		super.visit(sectionNode);
		unindent();
		
		return null;
	}
	
	@Override
	public Void visit(Checkbox checkboxNode) {
		return printNode(checkboxNode);
	}

	@Override
	public Void visit(Default defaultType) {
		return printNode(defaultType);
	}
	
	@Override
	public Void visit(Dropdown dropdownNode) {
		return printNode(dropdownNode);
	}

	@Override
	public Void visit(RadioButton radioButtonNode) {
		return printNode(radioButtonNode);
	}

	@Override
	public Void visit(TextField textFieldNode) {
		return printNode(textFieldNode);
	}

	@Override
	public Void visit(Spinbox spinnerNode) {
		return printNode(spinnerNode);
	}

	@Override
	public Void visit(Slider sliderNode) {
		return printNode(sliderNode);
	}

	@Override
	public Void visit(StyleRule styleRuleNode) {
		return printNode(styleRuleNode);
	}

	@Override
	public Void visit(StyleRuleSet styleRuleSetNode) {
		printNode(styleRuleSetNode);
		
		indent();
		super.visit(styleRuleSetNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(ValueSet valueSetNode) {
		printNode(valueSetNode);
		
		indent();
		super.visit(valueSetNode);
		unindent();
		
		return null;
	}
	
	@Override
	public Void visit(Page pageNode) {
		printNode(pageNode);
		
		indent();
		super.visit(pageNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(Color color) {
		printNode(color);
		
		indent();
		color.getValue().accept(this);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(Width width) {
		printNode(width);

		
		indent();
		width.getValue().accept(this);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(Height height) {
		printNode(height);

		
		indent();
		height.getValue().accept(this);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(Font font) {
		printNode(font);
		
		indent();
		font.getValue().accept(this);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(FontSize fontSize) {
		printNode(fontSize);
		
		indent();
		fontSize.getValue().accept(this);
		unindent();
		
		return null;
	}
}
