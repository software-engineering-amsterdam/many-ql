package uva.qls.interpreter.gui.visitor;

import java.awt.GridLayout;
import java.util.ArrayList;
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
import uva.qls.ast.statements.DefaultValue;
import uva.qls.ast.statements.Question;
import uva.qls.ast.statements.QuestionStringTable;
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
import uva.qls.ast.type.Type;
import uva.qls.interpreter.gui.GUI;
import uva.qls.interpreter.gui.table.DefaultTableValue;
import uva.qls.interpreter.gui.table.QuestionValueTable;
import uva.qls.interpreter.gui.elements.*;

public class Renderer implements StatementVisitor<Object>{

	private QuestionStringTable questionStringTable;
	private QuestionValueTable table;
	private GUI gui;
	
	public Renderer(QuestionValueTable _table, GUI _gui, ASTNode ast){
		this.table = _table;
		this.gui = _gui;
		
		this.questionStringTable = new QuestionStringTable();
		this.questionStringTable = this.questionStringTable.getQLQuestionStrings(
										this.gui.getTypeCheck().getTypeCheckQL(), 
										this.gui.getTypeCheck().getSymbolTable());
		
		this.visitProg((Prog)ast);
	}
	
	@Override
	public Object visitASTNode(ASTNode node) {
		return null;
	}

	@Override
	public Object visitProg(Prog prog) {
		prog.getStyleSheet().accept(this);
		return null;
	}

	@Override
	public Object visitStyleSheet(StyleSheet styleSheet) {
		for (Page page : styleSheet.getPage()){
			page.accept(this);
		}
		return null;
	}
	
	@Override
	public Object visitPage(Page page) {
		
		UIScrollView scrollView = new UIScrollView(new Size(this.gui.getLargestWidth()+320, 300));
		this.gui.getTabController().addTab(page.getIdentifier().evaluatedValue(), scrollView);
		
		for (Question question : this.getPageQuestions(page.getStatement(), new ArrayList<Question>())){
			question.accept(this);
		}
		
		return null;
	}
	
	private List<Question> getPageQuestions(List<Statement> list, List<Question> questions){
		
		for (Statement s : list){
			if (s.getClass().equals(Section.class)){
				this.getPageQuestions(((Section)s).getStatement(), questions);
			}
			else if (s.getClass().equals(Question.class)){
				questions.add((Question)s);
			}
		}
		
		return questions;
	}

	@Override
	public Object visitStatement(Statement statement) {
		statement.accept(this);
		return null;
	}

	@Override
	public Object visitQuestion(Question question) {
		
		DefaultTableValue value = this.table.retrieveValue(question);
		Component questionComponent = value.getComponent();
		
		// Get question text from QL
		String questionText = this.questionStringTable.retrieveValue(question.getIdentifier().evaluatedValue());
		questionText = questionText.replaceAll("[\"]", "");
		
		UIComponent<?> component = (UIComponent<?>)questionComponent.accept(this);
		UILabel label = new UILabel(questionText);
		label.setFont(new java.awt.Font(value.getStyle().fontName(), java.awt.Font.PLAIN, value.getStyle().fontSize()));
		
		UIContainer questionContainer = new UIContainer(new Size(value.getStyle().width(), value.getStyle().height()));
		
		questionContainer.add(label);
		questionContainer.add((java.awt.Component)component.getComponent());
		
		this.gui.addFrameComponent(questionContainer);
		
		return null;
	}

	@Override
	public UICheckbox visitCheckBox(Checkbox checkBox) {
		UICheckbox _box = new UICheckbox(checkBox);
		return _box;
	}

	@Override
	public UIDropdown visitDropDown(Dropdown dropDown) {
		UIDropdown _dropdown = new UIDropdown(dropDown);
		return _dropdown;
	}

	@Override
	public UIRadio visitRadio(Radio radio) {
		UIRadio _radio = new UIRadio(radio);
		return _radio;
	}

	@Override
	public UISlider visitSlider(Slider slider) {
		UISlider _slider = new UISlider(slider);
		return _slider;
	}

	@Override
	public UISpinbox visitSpinbox(Spinbox spinbox) {
		UISpinbox _spin = new UISpinbox(spinbox);
		return _spin;
	}

	@Override
	public UITextbox visitTextbox(Textbox textbox) {
		UITextbox _box = new UITextbox(textbox);
		return _box;
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
		style.accept(this);
		return null;
	}

	@Override
	public Object visitColor(Color color) {
		return null;
	}

	@Override
	public Object visitFont(Font font) {
		return null;
	}

	@Override
	public Object visitFontsize(FontSize fontSize) {
		return null;
	}

	@Override
	public Object visitFontName(FontName fontName) {
		return null;
	}

	@Override
	public Object visitHeight(Height height) {
		return null;
	}

	@Override
	public Object visitWidth(Width width) {
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
