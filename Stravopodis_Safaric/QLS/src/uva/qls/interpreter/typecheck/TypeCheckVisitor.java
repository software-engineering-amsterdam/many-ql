package uva.qls.interpreter.typecheck;

import uva.qls.ast.ASTNode;
import uva.qls.interpreter.typecheck.CheckWidget;
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
import uva.qls.interpreter.typecheck.table.SymbolTable;
import uva.qls.interpreter.typecheck.table.SymbolTableValue;

public class TypeCheckVisitor implements StatementVisitor<Object>{
	
	private TypeCheckQLS typeCheck;
	protected uva.qls.interpreter.typecheck.table.SymbolTable symbolTable;
	protected CheckWidget widget;
	
	public TypeCheckVisitor (TypeCheckQLS _typeCheck, uva.qls.interpreter.typecheck.table.SymbolTable table){
		
		this.typeCheck = _typeCheck;
		this.symbolTable= table;
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
	public Object visitProg(Prog prog) {
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
		//List<Identifier> names = new ArrayList(question.getIdentifier(), question.getLOC());
		//for (SymbolTableValue s : value){
			
	//	}
			
		this.typeCheck.getSymbolTable().getTable().containsKey(question.getIdentifier());
		//(this.symbolTable.keyExists(question.getIdentifier())) ? 
		 
		this.typeCheck.isMultiple(question.getIdentifier());
		// no references to questions that are not in the QL program
		// Create a TypeCheck class like we have in QL
			// Check if key exists, if does -> add this to the error table
				// when you start type checking for the QLS, create an instance of the ErrorTable
				// Create TypeCheck class as exists (similar) within QL, but only in QLS
		
		//this.symbolTable.keyExists(identifier);
		// add this question.identifier() to the symbol table
		
		// all questions of the QL program are placed by the QLS program.
		
		
		// all questions of the QL program are placed by the QLS program.
			// iterate through all the keys of the QL symbol table
				// set condition that for each key of QL symbol table, this instance (question) exists in the QLS
					// something like 
					/*
					 * for (String (or Identifier) : QL.symbolTable)
					 * 	if (! qls.symbolTable.exists(from this id))
					 * 		// add to the error table some message and code lines
					 */
		
		// you cannot place a single question multiple times.
			// referecence yourself here with the this.qls.symboltable.exists(this question -> identifier)
				// if the identifier is already in the symbol table, 
					// then go to the error table
		
		/*
		 * (default) widget assignments are compatible with question types (e.g. no radio button for integer widgets).
		 * define an enumurator
		 * 	define objects such as
		 * 			enum ComponentTypes {
		 * 
		 * 				radioButton("boolean")
		 * 
		 * 
		 */ 
		this.typeCheck.correctWidget(question.getClass().getName().toString(), widget.detectType(question.getComponent().getClass().toString()).toString(), question.getLOC());
		
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
