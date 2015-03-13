package uva.qls.interpreter.gui.visitor;

import java.util.List;

import uva.qls.ast.ASTNode;
import uva.qls.ast.Page;
import uva.qls.ast.Prog;
import uva.qls.ast.StyleSheet;
import uva.qls.ast.component.Checkbox;
import uva.qls.ast.component.Component;
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
import uva.qls.ast.statements.visitor.*;
import uva.qls.ast.style.Color;
import uva.qls.ast.style.Font;
import uva.qls.ast.style.FontName;
import uva.qls.ast.style.FontSize;
import uva.qls.ast.style.Height;
import uva.qls.ast.style.Style;
import uva.qls.ast.style.Width;
import uva.qls.interpreter.gui.table.DefaultTableValue;
import uva.qls.interpreter.gui.table.QuestionValueTable;

public class Renderer implements StatementVisitor<Object>{

	private QuestionValueTable table;
	
	public Renderer(QuestionValueTable _table){
		this.table = _table;
		this.visitQuestionTable(this.table);
	}
	
	public void visitQuestionTable(QuestionValueTable _table){
		
		for (Question question : this.table.getTable().keySet()){
			question.accept(this);
		}
		
	}

	@Override
	public Object visitQuestion(Question question) {
		// TODO Auto-generated method stub
		// visit the question itself
		
		DefaultTableValue value = this.table.retrieveValue(question);
		Component questionComponent = value.getComponent();
		List<Style> questionStyle = value.getStyle();
		
		//System.out.println("Component check: "  + question.getIdentifier().evaluatedValue() + " ==== "+ questionComponent);
		questionComponent.accept(this);
		questionComponent.componentStyle(questionStyle);
		
		return null;
	}

	@Override
	public Checkbox visitCheckBox(Checkbox checkBox) {
		System.out.println("Return a check box UIComponent");
		return null;
	}

	@Override
	public Dropdown visitDropDown(Dropdown dropDown) {
		System.out.println("Return drop down UIComponent");
		return null;
	}

	@Override
	public Radio visitRadio(Radio radio) {
		System.out.println("Return a radio UIComponent");
		return null;
	}

	@Override
	public Object visitSlider(Slider slider) {
		System.out.println("Return a slider UIComponent");
		return null;
	}

	@Override
	public Object visitSpinbox(Spinbox spinbox) {
		System.out.println("Return a spinbox UIComponent");
		return null;
	}

	@Override
	public Object visitTextbox(Textbox textbox) {
		System.out.println("Return a textbox UIComponent");
		return null;
	}
	
	@Override
	public Object visitASTNode(ASTNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitProg(Prog prog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitStyleSheet(StyleSheet styleSheet) {
		// TODO Auto-generated method stub
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
	public Object visitSection(Section section) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitSubsection(Subsection subsection) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object visitStyle(Style style) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitColor(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitFont(Font font) {
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
}
