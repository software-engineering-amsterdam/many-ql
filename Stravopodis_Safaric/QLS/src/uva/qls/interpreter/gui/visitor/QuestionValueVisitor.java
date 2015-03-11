package uva.qls.interpreter.gui.visitor;

import java.util.ArrayList;
import java.util.List;

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
import uva.qls.interpreter.gui.GUI;
import uva.qls.interpreter.gui.table.DefaultTableValue;
import uva.qls.interpreter.typecheck.TypeCheckQLS;

public class QuestionValueVisitor implements StatementVisitor<Object> {

	private GUI gui;
	
	public QuestionValueVisitor(GUI _gui){
		this.gui = _gui;
	}
	
	@Override
	public Object visitASTNode(ASTNode node) {
		return null;
	}

	@Override
	public Prog visitProg(Prog prog) {
		prog.getStyleSheet().accept(this);
		return null;
	}

	@Override
	public Page visitPage(Page page) {
		
		this.defaultValues(page.getStatement());
		this.visitStatements(page.getStatement());
		this.gui.table.clearStacks();
		
		return null;
	}

	@Override
	public Object visitStyleSheet(StyleSheet styleSheet) {
		
		for (Page p : styleSheet.getPage()){
			p.accept(this);
		}
		
		return null;
	}

	@Override
	public Object visitSection(Section section) {
		List<String> pushedTypes = this.defaultValues(section.getStatement());
		
		if (pushedTypes.size() > 1){
			for (String type : pushedTypes)
				this.gui.table.pop(type);
		}
		
		this.visitStatements(section.getStatement());
		return null;
	}
	
	@Override
	public Object visitQuestion(Question question) {
		
		TypeCheckQLS typeCheck = this.gui.getTypeCheck();
		
		String identifier = question.getIdentifier().evaluatedValue();
		String questionType = typeCheck.getTypeCheckQL().getSymbolTable().retrieveValue(identifier).getPrimitiveType().getName();
		
		if (question.getComponent() == null){
			this.gui.getQuestionValueTable().putValue(question, this.gui.table.retrieveValue(questionType).peek());
		}
		
		return null;
	}
	
	private List<String> defaultValues(List<Statement> statements){
		List<String> typesPushed = new ArrayList<String>();
		
		for (Statement s : statements){
			
			if (s.getClass().equals(DefaultValue.class)){
				
				DefaultValue _value = (DefaultValue)s;
				DefaultTableValue value = new DefaultTableValue(_value.getStyle(), _value.getComponent(), _value.getType());
				
				this.gui.table.push(_value.getType().getTypeName(), value);
				typesPushed.add(_value.getType().getTypeName());
			}
		}
		return typesPushed;
	}
	
	private void visitStatements(List<Statement> statements){
		for (Statement statement : statements){
			statement.accept(this);
		}
	}

	@Override
	public Object visitStatement(Statement statement) {
		statement.accept(this);
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
	
}
