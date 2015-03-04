package uva.qls.ast.visitor;

import uva.qls.ast.ASTNode;
import uva.qls.ast.Page;
import uva.qls.ast.Prog;
import uva.qls.ast.StyleSheet;
import uva.qls.ast.component.Checkbox;
import uva.qls.ast.component.Dropdown;
import uva.qls.ast.component.Radio;
import uva.qls.ast.component.Slider;
import uva.qls.ast.component.Spinbox;
import uva.qls.ast.component.Textbox;
import uva.qls.ast.literal.BooleanLiteral;
import uva.qls.ast.literal.Identifier;
import uva.qls.ast.literal.IntLiteral;
import uva.qls.ast.literal.Literal;
import uva.qls.ast.literal.MoneyLiteral;
import uva.qls.ast.literal.StringLiteral;
import uva.qls.ast.primitive.Type;
import uva.qls.ast.statements.DefaultValue;
import uva.qls.ast.statements.Question;
import uva.qls.ast.statements.Section;
import uva.qls.ast.statements.Statement;
import uva.qls.ast.statements.Subsection;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.style.Color;
import uva.qls.ast.style.Font;
import uva.qls.ast.style.FontName;
import uva.qls.ast.style.FontSize;
import uva.qls.ast.style.Height;
import uva.qls.ast.style.Style;
import uva.qls.ast.style.Width;

public class Visitor implements StatementVisitor<Object>{

	@Override
	public Style visitStyle(Style style) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color visitColor(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Font visitFont(Font font) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitFontsize(FontSize fontSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitFontName(FontName fontName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitHeight(Height height) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitWidth(Width width) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCheckBox(Checkbox checkBox) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDropDown(Dropdown dropDown) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitRadio(Radio radio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitSlider(Slider slider) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitSpinbox(Spinbox spinbox) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTextbox(Textbox textbox) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitBooleanLiteral(BooleanLiteral literal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitIntLiteral(IntLiteral literal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitIdentifier(Identifier identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitLiteral(Literal literal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitMoneyLiteral(MoneyLiteral literal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitStringLiteral(StringLiteral literal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitType(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitASTNode(ASTNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prog visitProg(Prog prog) {
		prog.getStyleSheet().accept(this);
		return null;
	}

	@Override
	public Object visitPage(Page page) {
		System.out.println("Visiting page:" + page.getIdentifier().evaluatedValue());
		return null;
	}

	@Override
	public StyleSheet visitStyleSheet(StyleSheet styleSheet) {
		System.out.println("Visiting stylesheet: " + styleSheet.getIdentifier().evaluatedValue());
		styleSheet.getIdentifier().accept(this);
		
		for (Page p : styleSheet.getPage())
			p.accept(this);
		
		return null;
	}

	@Override
	public Object visitStatement(Statement statement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDefaultValueComponent(DefaultValue defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDefaultValueStatements(DefaultValue defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitSection(Section section) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitSubsection(Subsection subsection) {
		// TODO Auto-generated method stub
		return null;
	}

}
