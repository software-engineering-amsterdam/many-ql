package uva.qls.ast.visitor;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import uva.qls.ast.type.TypeBoolean;
import uva.qls.ast.type.TypeInteger;
import uva.qls.ast.type.TypeMoney;
import uva.qls.ast.type.TypeString;
import uva.qls.ast.*;
import uva.qls.ast.component.*;
import uva.qls.ast.style.*;
import uva.qls.ast.style.availableStyles.AvailableStyles;
import uva.qls.ast.style.visitor.StyleTable;
import uva.qls.ast.literal.BooleanLiteral;
import uva.qls.ast.literal.Identifier;
import uva.qls.ast.literal.IntLiteral;
import uva.qls.ast.literal.MoneyLiteral;
import uva.qls.ast.literal.StringLiteral;
import uva.qls.ast.statements.DefaultValue;
import uva.qls.ast.statements.Question;
import uva.qls.ast.statements.Section;
import uva.qls.ast.statements.Statement;
import uva.qls.ast.statements.Subsection;
import uva.qls.ast.type.Type;
import uva.qls.parser.*;
import uva.qls.parser.QLSParser.CtxBooleanLiteralContext;
import uva.qls.parser.QLSParser.CtxCheckboxContext;
import uva.qls.parser.QLSParser.CtxColorContext;
import uva.qls.parser.QLSParser.CtxComponentContext;
import uva.qls.parser.QLSParser.CtxDropdownContext;
import uva.qls.parser.QLSParser.CtxFontContext;
import uva.qls.parser.QLSParser.CtxFontsizeContext;
import uva.qls.parser.QLSParser.CtxHeightContext;
import uva.qls.parser.QLSParser.CtxIntegerContext;
import uva.qls.parser.QLSParser.CtxMoneyContext;
import uva.qls.parser.QLSParser.CtxQuestionContext;
import uva.qls.parser.QLSParser.CtxRadioContext;
import uva.qls.parser.QLSParser.CtxSectionContext;
import uva.qls.parser.QLSParser.CtxSliderContext;
import uva.qls.parser.QLSParser.CtxSpinboxContext;
import uva.qls.parser.QLSParser.CtxStyleContext;
import uva.qls.parser.QLSParser.CtxSubsectionContext;
import uva.qls.parser.QLSParser.CtxTextboxContext;
import uva.qls.parser.QLSParser.CtxWidthContext;
import uva.qls.parser.QLSParser.PageContext;
import uva.qls.parser.QLSParser.ProgContext;
import uva.qls.parser.QLSParser.QuestionContext;
import uva.qls.parser.QLSParser.SectionContext;
import uva.qls.parser.QLSParser.StatementContext;
import uva.qls.parser.QLSParser.StyleContext;
import uva.qls.parser.QLSParser.StylesheetContext;
import uva.qls.parser.QLSParser.SubsectionContext;

public class QLSMainVisitor extends QLSBaseVisitor<ASTNode>{

	@Override
	public ASTNode visitProg(ProgContext ctx) {
		return new Prog(this.visitStylesheet(ctx.stylesheet()), this.getCodeLines(ctx));
	}

	@Override
	public StyleSheet visitStylesheet(StylesheetContext ctx) {
		CodeLines codeLines = this.getCodeLines(ctx);
		return new StyleSheet(this.visitIdentifier(ctx.Identifier(), codeLines), this.visitPages(ctx.pgs), codeLines);
	}

	@Override
	public Page visitPage(PageContext ctx) {
		CodeLines codeLines = this.getCodeLines(ctx);
		return new Page(this.visitIdentifier(ctx.Identifier(), codeLines), this.visitStatement(ctx.stms), codeLines);
	}

	@Override
	public Section visitCtxSection(CtxSectionContext ctx) {
		return this.visitSection(ctx.section());	
	}

	@Override
	public Subsection visitCtxSubsection(CtxSubsectionContext ctx) {
		return this.visitSubsection(ctx.subsection());
	}

	@Override
	public Question visitCtxQuestion(CtxQuestionContext ctx) {
		return this.visitQuestion(ctx.question());
	}

	@Override 
	public DefaultValue visitCtxDefaultComponent(QLSParser.CtxDefaultComponentContext ctx) { 
		CodeLines codeLines = this.getCodeLines(ctx);
		Type type = (Type)ctx.primitiveType().accept(this);
		Component component = (Component)ctx.component().accept(this);
		
		return new DefaultValue(type, component ,codeLines);
	}

	@Override 
	public DefaultValue visitCtxDefaultStatement(QLSParser.CtxDefaultStatementContext ctx) { 
		CodeLines codeLines = this.getCodeLines(ctx);
		Type type = (Type)ctx.primitiveType().accept(this);
		
		return new DefaultValue(type, this.visitStyles(ctx.stms), codeLines);
	}

	@Override
	public Component visitCtxComponent(CtxComponentContext ctx) {
		return (Component)ctx.component().accept(this);
	}

	@Override
	public Style visitCtxStyle(CtxStyleContext ctx) {
		return (Style)ctx.style().accept(this);
	}

	@Override
	public Section visitSection(SectionContext ctx) {
		CodeLines codeLines = this.getCodeLines(ctx);
		return new Section(this.visitString(ctx.STRING().getText(),codeLines), this.visitStatement(ctx.stms),codeLines);
	
	}

	@Override
	public Subsection visitSubsection(SubsectionContext ctx) {
		CodeLines codeLines = this.getCodeLines(ctx);
		return new Subsection(this.visitString(ctx.STRING().getText(),codeLines),this.visitQuestion(ctx.quest),codeLines);
	}

	@Override
	public Question visitQuestion(QuestionContext ctx) {
		CodeLines codeLines = this.getCodeLines(ctx);
		Component comp = null;
		
		try{
			comp = (Component)ctx.component().accept(this);
		}
		catch (Exception e){
			System.out.println("Component is null");
		}
		
		return new Question(this.visitIdentifier(ctx.Identifier(), codeLines), comp ,codeLines);
	}


	@Override
	public Textbox visitCtxTextbox(CtxTextboxContext ctx) {
		return new Textbox(this.getCodeLines(ctx), this.visitStyles(ctx.stls));
	}

	@Override
	public Spinbox visitCtxSpinbox(CtxSpinboxContext ctx) {
		return new Spinbox(this.getCodeLines(ctx), this.visitStyles(ctx.stls));
	}

	@Override
	public Slider visitCtxSlider(CtxSliderContext ctx) {
		return new Slider(ctx.v1.getText(), ctx.v2.getText(), this.visitStyles(ctx.stls), this.getCodeLines(ctx));
	}

	@Override
	public Dropdown visitCtxDropdown(CtxDropdownContext ctx) {
		return new Dropdown(ctx.v1.getText(), ctx.v2.getText(), this.visitStyles(ctx.stls), this.getCodeLines(ctx));
	}

	@Override
	public Radio visitCtxRadio(CtxRadioContext ctx) {
		return new Radio(ctx.v1.getText(), ctx.v2.getText(), this.visitStyles(ctx.stls), this.getCodeLines(ctx));
	}

	@Override
	public Checkbox visitCtxCheckbox(CtxCheckboxContext ctx) {
		CodeLines codeLines = this.getCodeLines(ctx);
		return new Checkbox(this.visitString(ctx.STRING().getText(), codeLines), this.visitStyles(ctx.stls), codeLines);
	}

	@Override
	public Width visitCtxWidth(CtxWidthContext ctx) {
		CodeLines codeLines = this.getCodeLines(ctx);
		return new Width(this.visitCtxInteger(ctx.Integer().getText(), codeLines), this.getCodeLines(ctx));
	}

	@Override
	public Height visitCtxHeight(CtxHeightContext ctx) {
		CodeLines codeLines = this.getCodeLines(ctx);
		return new Height(this.visitCtxInteger(ctx.Integer().getText(), codeLines), this.getCodeLines(ctx));
	}

	@Override
	public FontName visitCtxFont(CtxFontContext ctx) {
		CodeLines codeLines = this.getCodeLines(ctx);
		return new FontName(this.visitString(ctx.STRING().getText(), codeLines), codeLines);
	}

	@Override
	public FontSize visitCtxFontsize(CtxFontsizeContext ctx) {
		CodeLines codeLines = this.getCodeLines(ctx);
		return new FontSize(this.visitCtxInteger(ctx.Integer().getText(), codeLines), codeLines);
	}

	@Override
	public Color visitCtxColor(CtxColorContext ctx) {
		return new Color(ctx.v.getText(), this.getCodeLines(ctx));
	}

	@Override
	public BooleanLiteral visitCtxBooleanLiteral(CtxBooleanLiteralContext ctx) {
		return new BooleanLiteral(Boolean.valueOf(ctx.getText()), this.getCodeLines(ctx));
	}

	private IntLiteral visitCtxInteger(String ctx, CodeLines codeLines){
		return new IntLiteral(Integer.valueOf(ctx), codeLines);
	}
	
	@Override
	public IntLiteral visitCtxInteger(CtxIntegerContext ctx) {
		return new IntLiteral(Integer.valueOf(ctx.Integer().getText()), this.getCodeLines(ctx));
	}

	@Override
	public MoneyLiteral visitCtxMoney(CtxMoneyContext ctx) {
		return new MoneyLiteral(Integer.valueOf(ctx.getText()), this.getCodeLines(ctx));
	}
	
	@Override 
	public TypeBoolean visitCtxPrimitiveBoolean(QLSParser.CtxPrimitiveBooleanContext ctx) {
		return new TypeBoolean(this.getCodeLines(ctx));
	}
	
	@Override 
	public TypeMoney visitCtxPrimitiveMoney(QLSParser.CtxPrimitiveMoneyContext ctx) {
		return new TypeMoney(this.getCodeLines(ctx)); 
	}
	
	@Override 
	public TypeString visitCtxPrimitiveString(QLSParser.CtxPrimitiveStringContext ctx) { 
		return new TypeString(this.getCodeLines(ctx));
	}

	@Override 
	public TypeInteger visitCtxPrimitiveInteger(QLSParser.CtxPrimitiveIntegerContext ctx) { 
		return new TypeInteger(this.getCodeLines(ctx)); 
	}
	
	
	private List<Page> visitPages(List<PageContext> pgs){
		List<Page> pages = new ArrayList<Page>();
		for (PageContext page : pgs)
			pages.add(this.visitPage(page));
		return pages;
	}
	
	private List<Statement> visitStatement(List<StatementContext> stms){
		List<Statement> statements = new ArrayList<Statement>();
		for (StatementContext statement : stms)
			statements.add((Statement)statement.accept(this));
		return statements;
	}
	
	private StyleTable visitStyles(List<StyleContext> stls){
		StyleTable table = AvailableStyles.getAvailableStyles();
		
		for (StyleContext s : stls){
			Style style = (Style)s.accept(this);
			table.putValue(style.getClass().getSimpleName(), style);
		}
		
		return table;
	}
	
	private StringLiteral visitString(String _value, CodeLines _codeLines){
		return new StringLiteral(_value, _codeLines);	
	}
	
	private Identifier visitIdentifier(TerminalNode identifier, CodeLines codeLines){
		return new Identifier(identifier.getText(), codeLines);
	}
	
	private CodeLines getCodeLines(ParserRuleContext ctx){
		return new CodeLines(ctx.start.getLine(), ctx.stop.getLine());
	}
	
}
