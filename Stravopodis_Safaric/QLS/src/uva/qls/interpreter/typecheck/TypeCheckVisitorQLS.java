package uva.qls.interpreter.typecheck;

import uva.qls.ast.ASTNode;
import uva.qls.interpreter.typecheck.CheckWidget;
import uva.qls.interpreter.typecheck.table.SymbolTable;
import uva.qls.interpreter.typecheck.table.SymbolTableValue;
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
import uva.qls.ast.type.Type;
import uva.qls.ast.type.TypeBoolean;
import uva.qls.ast.type.TypeInteger;
import uva.qls.ast.type.TypeMoney;
import uva.qls.ast.type.TypeString;

public class TypeCheckVisitorQLS implements StatementVisitor<Object>{
	
	private TypeCheckQLS typeCheck;
	protected SymbolTable symbolTable;
	protected CheckWidget widget;
	
	public TypeCheckVisitorQLS (TypeCheckQLS _typeCheck, SymbolTable table){	
		this.typeCheck = _typeCheck;
		this.symbolTable= table;
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
	public Object visitPage(Page page) {
		for (Statement statement : page.getStatement())
			this.visitStatement(statement);
		
		return null;
	}

	@Override
	public StyleSheet visitStyleSheet(StyleSheet styleSheet) {
		styleSheet.getIdentifier().accept(this);
		
		for (Page p : styleSheet.getPage())
			p.accept(this);
		
		return null;
	}

	@Override
	public Object visitStatement(Statement statement) {
		statement.accept(this);
		return null;
	}

	@Override
	public Object visitDefaultValueComponent(DefaultValue defaultValue) {
		
		String type = defaultValue.getType().getPrimitiveType().getName();
		String componentName = defaultValue.getComponent().getName();
		
		this.typeCheck.isCompatibleDefaultValue(defaultValue, type, componentName);
		
		return null;
	}

	@Override
	public Object visitDefaultValueStatements(DefaultValue defaultValue) {
		return null;
	}

	@Override
	public Object visitQuestion(Question question) {
		
		String identifier = question.getIdentifier().evaluatedValue();
		
		this.typeCheck.isUndefined(question.getIdentifier());
		this.typeCheck.isMultiple(question.getIdentifier());
		
		SymbolTableValue value = new SymbolTableValue(question.getLOC());
		this.symbolTable.putValue(question.getIdentifier(), value);
		

		if (question.getComponent() != null){
			if (this.typeCheck.getTypeCheckQL().getSymbolTable().keyExists(identifier)){
				
				String type = this.typeCheck.getTypeCheckQL().getSymbolTable().retrieveValue(identifier).getPrimitiveType().getName();
				String componentName = question.getComponent().getName();
				
				this.typeCheck.isCompatibleQuestionType(question, type, componentName);
			}
		}
		
		
		return null;
	}

	@Override
	public Object visitSection(Section section) {
		for (Statement statement : section.getStatement())
			statement.accept(this);
		
		return null;
	}

	@Override
	public Object visitSubsection(Subsection subsection) {
		subsection.getQuestion().accept(this);
		return null;
	}
	
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
	public Object visitTypeBoolean(TypeBoolean booleanType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTypeInteger(TypeInteger integerType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTypeMoney(TypeMoney moneyType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTypeString(TypeString stringType) {
		// TODO Auto-generated method stub
		return null;
	}


}
