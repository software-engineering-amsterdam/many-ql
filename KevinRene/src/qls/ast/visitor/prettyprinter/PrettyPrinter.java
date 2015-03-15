package qls.ast.visitor.prettyprinter;

import ql.ast.QLNode;
import ql.ast.expression.Identifier;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.type.QLBoolean;
import ql.ast.type.QLError;
import ql.ast.type.QLFloat;
import ql.ast.type.QLForm;
import ql.ast.type.QLInteger;
import ql.ast.type.QLNumeric;
import ql.ast.type.QLString;
import ql.ast.visitor.ExpressionVisitor;
import qls.ast.statement.Default;
import qls.ast.statement.Page;
import qls.ast.statement.QLSBlock;
import qls.ast.statement.Question;
import qls.ast.statement.Section;
import qls.ast.statement.Stylesheet;
import qls.ast.stylerule.StyleRule;
import qls.ast.stylerule.StyleRuleSet;
import qls.ast.stylerule.property.Color;
import qls.ast.stylerule.property.Font;
import qls.ast.stylerule.property.FontSize;
import qls.ast.stylerule.property.Height;
import qls.ast.stylerule.property.Width;
import qls.ast.visitor.QLSVisitor;
import qls.ast.widget.Checkbox;
import qls.ast.widget.DefaultWidget;
import qls.ast.widget.Dropdown;
import qls.ast.widget.RadioButton;
import qls.ast.widget.Slider;
import qls.ast.widget.Spinner;
import qls.ast.widget.TextField;
import qls.ast.widget.ValueSet;

public class PrettyPrinter extends QLSVisitor<Void> implements ExpressionVisitor<Void> {
	private String prefix = "";
	
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
	public Void visit(Default defaultNode) {
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
	public Void visit(Section sectionNode) {
		printNode(sectionNode);
		
		indent();
		super.visit(sectionNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(DefaultWidget defaultWidget) {
		return printNode(defaultWidget);			
	}
	
	@Override
	public Void visit(Checkbox checkboxNode) {
		return printNode(checkboxNode);
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
	public Void visit(Spinner spinnerNode) {
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
