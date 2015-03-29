package qls.ast.visitor.prettyprinter;

import ql.ast.Expression;
import ql.ast.QLNode;
import ql.ast.QLType;
import ql.ast.expression.Identifier;
import ql.ast.type.QLBoolean;
import ql.ast.type.QLError;
import ql.ast.type.QLFloat;
import ql.ast.type.QLForm;
import ql.ast.type.QLInteger;
import ql.ast.type.QLNumeric;
import ql.ast.type.QLString;
import ql.ast.visitor.TypeVisitor;
import ql.ast.visitor.prettyprinter.PrintWriter;
import qls.ast.Statement;
import qls.ast.expression.literal.BooleanLiteral;
import qls.ast.expression.literal.FloatLiteral;
import qls.ast.expression.literal.IntegerLiteral;
import qls.ast.expression.literal.StringLiteral;
import qls.ast.statement.DefaultStyle;
import qls.ast.statement.DefaultWidget;
import qls.ast.statement.Page;
import qls.ast.statement.Block;
import qls.ast.statement.Question;
import qls.ast.statement.Section;
import qls.ast.statement.Stylesheet;
import qls.ast.statement.widget.Widget;
import qls.ast.statement.widget.styling.Property;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.ast.statement.widget.styling.property.Color;
import qls.ast.statement.widget.styling.property.Font;
import qls.ast.statement.widget.styling.property.FontSize;
import qls.ast.statement.widget.styling.property.Height;
import qls.ast.statement.widget.styling.property.Width;
import qls.ast.statement.widget.type.Checkbox;
import qls.ast.statement.widget.type.Default;
import qls.ast.statement.widget.type.Spinbox;
import qls.ast.statement.widget.type.TextField;
import qls.ast.statement.widget.type.parameterised.Dropdown;
import qls.ast.statement.widget.type.parameterised.RadioButton;
import qls.ast.statement.widget.type.parameterised.Slider;
import qls.ast.visitor.ExpressionVisitor;
import qls.ast.visitor.StatementVisitor;

public class PrettyPrinter extends StatementVisitor<String> implements ExpressionVisitor<String>, TypeVisitor<String> {
	/* 
	 * Expression with custom prefix 
	 */
	public static void print(Expression expression, PrintWriter printWriter) {
		PrettyPrinter printer = new PrettyPrinter();
		printWriter.printString(expression.accept(printer));
	}
	
	/* 
	 * Statement with custom prefix 
	 */
	public static void print(Statement statement, PrintWriter printWriter) {
		PrettyPrinter printer = new PrettyPrinter();
		printWriter.printString(statement.accept(printer));
	}
	
	/* 
	 * Statement with custom prefix 
	 */
	public static void print(QLType type, PrintWriter printWriter) {
		PrettyPrinter printer = new PrettyPrinter();
		printWriter.printString(type.accept(printer));
	}
	
	private String prefix = "";
	
	private PrettyPrinter() {
		super.setExpressionVisitor(this);
		super.setTypeVisitor(this);
	}
	
	/**
	 * Indent the prefix to indicate that a printable block
	 * of nodes has been entered.
	 */
	private void indent() {
		this.prefix += "   ";
	}
	
	/**
	 * Print a node in the console. The node its toString
	 * method will be printed first, followed the the type
	 * of the node, separated by a colon.
	 * 
	 * @param node - The node to print.
	 */
	private String printNode(QLNode node) {
		String type = node.getClass().getSimpleName();
		// Strip the string until only the name of the node is left.
		String nodeString = node.toString().split("\\(")[0];
		
		return prefix + ("└── ") + nodeString + " : " + type + "\n";
	}
	
	/**
	 * Unindent the prefix. This happens when a block of
	 * printable nodes has been printed and the function
	 * exits. 
	 */
	private void unindent() {
		this.prefix = this.prefix.substring(0, this.prefix.length() - 3);
	}
	
	
	@Override
	public String visit(BooleanLiteral booleanNode) {
		return printNode(booleanNode);
	}

	@Override
	public String visit(Checkbox checkboxNode) {
		return printNode(checkboxNode);
	}

	@Override
	public String visit(Color color) {
		StringBuilder colorString = new StringBuilder(printNode(color));
		
		indent();
		colorString.append(color.getLiteral().accept(this));
		unindent();
		
		return colorString.toString();
	}
	
	@Override
	public String visit(Default defaultType) {
		return printNode(defaultType);
	}

	@Override
	public String visit(DefaultStyle defaultNode) {
		StringBuilder defaultStyleString = new StringBuilder(printNode(defaultNode));
		
		indent();
		defaultStyleString.append(defaultNode.getType().accept(this));
		defaultStyleString.append(defaultNode.getStyleProperties().accept(this));
		unindent();
		
		return defaultStyleString.toString();
	}

	@Override
	public String visit(DefaultWidget defaultNode) {
		StringBuilder defaultWidgetString = new StringBuilder(printNode(defaultNode));
		
		indent();
		defaultWidgetString.append(defaultNode.getType().accept(this));
		defaultWidgetString.append(defaultNode.getWidget().accept(this));
		unindent();
		
		return defaultWidgetString.toString();
	}

	@Override
	public String visit(Dropdown dropdownNode) {
		StringBuilder dropdownString = new StringBuilder(printNode(dropdownNode));
		
		indent();
		dropdownString.append(dropdownNode.getFirstValue().accept(this));
		dropdownString.append(dropdownNode.getSecondValue().accept(this));
		unindent();
		
		return dropdownString.toString();
	}
	
	@Override
	public String visit(FloatLiteral floatNode) {
		return printNode(floatNode);
	}

	@Override
	public String visit(Font font) {
		StringBuilder fontString = new StringBuilder(printNode(font));
		
		indent();
		fontString.append(font.getLiteral().accept(this));
		unindent();
		
		return fontString.toString();
	}

	@Override
	public String visit(FontSize fontSize) {
		StringBuilder fontSizeString = new StringBuilder(printNode(fontSize));
		
		indent();
		fontSizeString.append(fontSize.getLiteral().accept(this));
		unindent();
		
		return fontSizeString.toString();
	}

	@Override
	public String visit(Height height) {
		StringBuilder heightString = new StringBuilder(printNode(height));
		
		indent();
		heightString.append(height.getLiteral().accept(this));
		unindent();
		
		return heightString.toString();
	}

	@Override
	public String visit(Identifier identNode) {
		return printNode(identNode);
	}
	
	@Override
	public String visit(IntegerLiteral intNode) {
		return printNode(intNode);
	}
	
	@Override
	public String visit(Page pageNode) {
		StringBuilder pageString = new StringBuilder(printNode(pageNode));
		
		indent();
		pageString.append(pageNode.getIdentifier().accept(this));
		pageString.append(pageNode.getStatements().accept(this));
		unindent();
		
		return pageString.toString();
	}
	
	@Override
	public String visit(QLBoolean booleanNode) {
		return printNode(booleanNode);
	}
	
	@Override
	public String visit(QLError qlError) {	
		return printNode(qlError);
	}
	
	@Override
	public String visit(QLFloat floatNode) {
		return printNode(floatNode);
	}

	@Override
	public String visit(QLForm formNode) {
		return printNode(formNode);
	}

	@Override
	public String visit(QLInteger intNode) {
		return printNode(intNode);
	}

	@Override
	public String visit(QLNumeric numericNode) {
		return printNode(numericNode);	
	}
	
	@Override
	public String visit(Block blockNode) {
		StringBuilder blockString = new StringBuilder(printNode(blockNode));
		
		indent();
		for(Statement statement : blockNode.getStatements()) {
			blockString.append(statement.accept(this));
		}
		unindent();
		
		return blockString.toString();
	}

	@Override
	public String visit(QLString stringNode) {
		return printNode(stringNode);
	}
	
	@Override
	public String visit(Question questionNode) {
		StringBuilder questionString = new StringBuilder(printNode(questionNode));
		
		indent();
		questionString.append(questionNode.getIdentifier().accept(this));
		questionString.append(questionNode.getWidget().accept(this));
		unindent();
		
		return questionString.toString();
	}

	@Override
	public String visit(RadioButton radioNode) {
		StringBuilder radioString = new StringBuilder(printNode(radioNode));
		
		indent();
		radioString.append(radioNode.getFirstValue().accept(this));
		radioString.append(radioNode.getSecondValue().accept(this));
		unindent();
		
		return radioString.toString();
	}

	@Override
	public String visit(Section sectionNode) {
		StringBuilder sectionString = new StringBuilder(printNode(sectionNode));
		
		indent();
		sectionString.append(sectionNode.getHeader().accept(this));
		sectionString.append(sectionNode.getStatements().accept(this));
		unindent();
		
		return sectionString.toString();
	}

	@Override
	public String visit(Slider sliderNode) {
		StringBuilder sliderString = new StringBuilder(printNode(sliderNode));
		
		indent();
		sliderString.append(sliderNode.getFirstValue().accept(this));
		sliderString.append(sliderNode.getSecondValue().accept(this));
		unindent();
		
		return sliderString.toString();
	}

	@Override
	public String visit(Spinbox spinnerNode) {
		return printNode(spinnerNode);
	}

	@Override
	public String visit(StringLiteral stringNode) {
		return printNode(stringNode);	
	}

	@Override
	public String visit(StyleProperties styleNode) {
		StringBuilder styleString = new StringBuilder(printNode(styleNode));
		
		indent();
		for(Property property : styleNode.getProperties().values()) {
			styleString.append(property.accept(this));
		}
		unindent();
		
		return styleString.toString();
	}
	
	

	@Override
	public String visit(Stylesheet stylesheetNode) {
		StringBuilder stylesheetString = new StringBuilder(printNode(stylesheetNode));
		
		indent();
		stylesheetString.append(stylesheetNode.getIdentifier().accept(this));
		stylesheetString.append(stylesheetNode.getPages().accept(this));
		unindent();
		
		return stylesheetString.toString();
	}

	@Override
	public String visit(TextField textFieldNode) {
		return printNode(textFieldNode);
	}

	@Override
	public String visit(Widget widgetNode) {
		StringBuilder widgetString = new StringBuilder(printNode(widgetNode));
		
		indent();
		widgetString.append(widgetNode.getStyleRules().accept(this));
		widgetString.append(widgetNode.getWidgetType().accept(this));
		unindent();
		
		return widgetString.toString();
	}

	@Override
	public String visit(Width width) {
		StringBuilder widthString = new StringBuilder(printNode(width));
		
		indent();
		widthString.append(width.getLiteral().accept(this));
		unindent();
		
		return widthString.toString();
	}
}
