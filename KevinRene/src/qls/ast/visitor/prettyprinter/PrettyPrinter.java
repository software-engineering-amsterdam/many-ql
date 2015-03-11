package qls.ast.visitor.prettyprinter;

import ql.ast.QLNode;
import ql.ast.expression.Identifier;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.type.QLBoolean;
import ql.ast.expression.type.QLError;
import ql.ast.expression.type.QLFloat;
import ql.ast.expression.type.QLForm;
import ql.ast.expression.type.QLInteger;
import ql.ast.expression.type.QLNumeric;
import ql.ast.expression.type.QLString;
import ql.ast.visitor.ExpressionVisitor;
import qls.ast.statement.Default;
import qls.ast.statement.Page;
import qls.ast.statement.QLSBlock;
import qls.ast.statement.Question;
import qls.ast.statement.Section;
import qls.ast.statement.Stylesheet;
import qls.ast.stylerule.StyleRule;
import qls.ast.stylerule.StyleRuleSet;
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
	private void printNode(QLNode node) {
		String type = node.getClass().getSimpleName();
		// Strip the string until only the name of the node is left.
		String nodeString = node.toString().split("\\(")[0];
		
		System.out.println(prefix + ("└── ") + nodeString + " : " + type);
	}
	
	
	/*********************
	 == IDENTIFIER NODE ==
	 *********************/
	@Override
	public Void visit(Identifier identNode) {
		printNode(identNode);
		
		return null;
	}

	/****************
	 == TYPE NODES ==
	 ****************/
	@Override
	public Void visit(QLBoolean booleanNode) {
		printNode(booleanNode);
		return null;
	}

	@Override
	public Void visit(QLFloat floatNode) {
		printNode(floatNode);
		return null;
	}
	
	@Override
	public Void visit(QLForm formNode) {
		printNode(formNode);
		return null;
	}

	@Override
	public Void visit(QLInteger intNode) {
		printNode(intNode);
		return null;
	}

	@Override
	public Void visit(QLNumeric numericNode) {
		printNode(numericNode);	
		return null;
	}

	@Override
	public Void visit(QLString stringNode) {
		printNode(stringNode);
		return null;
	}
	
	@Override
	public Void visit(QLError qlError) {	
		printNode(qlError);
		return null;
	}

	/*******************
	 == LITERAL NODES ==
	 *******************/
	@Override
	public Void visit(BooleanLiteral booleanNode) {
		printNode(booleanNode);
		
		return null;
	}

	@Override
	public Void visit(FloatLiteral floatNode) {
		printNode(floatNode);
		
		return null;
	}

	@Override
	public Void visit(IntegerLiteral intNode) {
		printNode(intNode);
		return null;
	}

	@Override
	public Void visit(StringLiteral stringNode) {
		printNode(stringNode);	
		return null;
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
		printNode(defaultWidget);			
		return null;
	}
	
	@Override
	public Void visit(Checkbox checkboxNode) {
		printNode(checkboxNode);
		return null;
	}

	@Override
	public Void visit(Dropdown dropdownNode) {
		printNode(dropdownNode);
		return null;
	}

	@Override
	public Void visit(RadioButton radioButtonNode) {
		printNode(radioButtonNode);
		return null;
	}

	@Override
	public Void visit(TextField textFieldNode) {
		printNode(textFieldNode);
		return null;
	}

	@Override
	public Void visit(Spinner spinnerNode) {
		printNode(spinnerNode);
		return null;
	}

	@Override
	public Void visit(Slider sliderNode) {
		printNode(sliderNode);
		return null;
	}

	@Override
	public Void visit(StyleRule styleRuleNode) {
		printNode(styleRuleNode);
		return null;
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

	
}
