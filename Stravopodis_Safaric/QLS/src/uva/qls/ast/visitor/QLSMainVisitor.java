package uva.qls.ast.visitor;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import uva.qls.ast.*;
import uva.qls.ast.literal.Identifier;
import uva.qls.ast.literal.StringLiteral;
import uva.qls.ast.statements.Question;
import uva.qls.ast.statements.Section;
import uva.qls.ast.statements.Statement;
import uva.qls.ast.statements.Subsection;
import uva.qls.parser.*;
import uva.qls.parser.QLSParser.CtxBooleanLiteralContext;
import uva.qls.parser.QLSParser.CtxCheckboxContext;
import uva.qls.parser.QLSParser.CtxColorContext;
import uva.qls.parser.QLSParser.CtxComponenetContext;
import uva.qls.parser.QLSParser.CtxDefaultValueContext;
import uva.qls.parser.QLSParser.CtxDropdownContext;
import uva.qls.parser.QLSParser.CtxFontContext;
import uva.qls.parser.QLSParser.CtxFontsizeContext;
import uva.qls.parser.QLSParser.CtxHeightContext;
import uva.qls.parser.QLSParser.CtxIntegerContext;
import uva.qls.parser.QLSParser.CtxMoneyContext;
import uva.qls.parser.QLSParser.CtxPrimitiveBooleanContext;
import uva.qls.parser.QLSParser.CtxPrimitiveIntegerContext;
import uva.qls.parser.QLSParser.CtxPrimitiveMoneyContext;
import uva.qls.parser.QLSParser.CtxPrimitiveStringContext;
import uva.qls.parser.QLSParser.CtxQuestionContext;
import uva.qls.parser.QLSParser.CtxRadioContext;
import uva.qls.parser.QLSParser.CtxSectionContext;
import uva.qls.parser.QLSParser.CtxSliderContext;
import uva.qls.parser.QLSParser.CtxSpinboxContext;
import uva.qls.parser.QLSParser.CtxStyleContext;
import uva.qls.parser.QLSParser.CtxSubsectionContext;
import uva.qls.parser.QLSParser.CtxTextboxContext;
import uva.qls.parser.QLSParser.CtxWidthContext;
import uva.qls.parser.QLSParser.DefaultValueContext;
import uva.qls.parser.QLSParser.PageContext;
import uva.qls.parser.QLSParser.ProgContext;
import uva.qls.parser.QLSParser.QuestionContext;
import uva.qls.parser.QLSParser.SectionContext;
import uva.qls.parser.QLSParser.StatementContext;
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
		CodeLines codeLines = this.getCodeLines(ctx);
		return new Section(this.visitString(ctx.section().STRING().getText(),codeLines), this.visitStatement(ctx.section().stms),codeLines);
	
	}

	@Override
	public Subsection visitCtxSubsection(CtxSubsectionContext ctx) {
		CodeLines codeLines = this.getCodeLines(ctx);
		//public Subsection (String _name, Question _question, CodeLines _codeLines){
		
		return new Subsection(this.visitString(ctx.subsection().STRING().getText(),codeLines),this.visitQuestion(ctx.subsection().quest),codeLines);
	}

	@Override
	public ASTNode visitCtxQuestion(CtxQuestionContext ctx) {
		ctx.question().component().accept(this);
		return null;
	}

	@Override
	public ASTNode visitCtxDefaultValue(CtxDefaultValueContext ctx) {
		// TODO Auto-generated method stub
		// panos
		return null;
	}

	@Override
	public ASTNode visitCtxComponenet(CtxComponenetContext ctx) {
		// TODO Auto-generated method stub
		// panos
		return null;
	}

	@Override
	public ASTNode visitCtxStyle(CtxStyleContext ctx) {
		// TODO Auto-generated method stub
		// panos
		return null;
	}

	@Override
	public ASTNode visitSection(SectionContext ctx) {
		// TODO Auto-generated method stub
		// panos
		return null;
	}

	@Override
	public ASTNode visitSubsection(SubsectionContext ctx) {
		// TODO Auto-generated method stub
		// panos
		return null;
	}

	@Override
	public Question visitQuestion(QuestionContext ctx) {
		// TODO Auto-generated method stub
		// panos
		return null;
	}

	@Override
	public ASTNode visitDefaultValue(DefaultValueContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTNode visitCtxTextbox(CtxTextboxContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTNode visitCtxSpinbox(CtxSpinboxContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTNode visitCtxSlider(CtxSliderContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTNode visitCtxDropdown(CtxDropdownContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTNode visitCtxRadio(CtxRadioContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTNode visitCtxCheckbox(CtxCheckboxContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTNode visitCtxWidth(CtxWidthContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTNode visitCtxHeight(CtxHeightContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTNode visitCtxFont(CtxFontContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTNode visitCtxFontsize(CtxFontsizeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTNode visitCtxColor(CtxColorContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTNode visitCtxBooleanLiteral(CtxBooleanLiteralContext ctx) {
		// TODO Auto-generated method stub
		// panos
		return null;
	}

	@Override
	public ASTNode visitCtxInteger(CtxIntegerContext ctx) {
		// TODO Auto-generated method stub
		// panos
		return null;
	}

	@Override
	public ASTNode visitCtxMoney(CtxMoneyContext ctx) {
		// TODO Auto-generated method stub
		// panos
		return null;
	}

	@Override
	public ASTNode visitCtxPrimitiveBoolean(CtxPrimitiveBooleanContext ctx) {
		// TODO Auto-generated method stub
		// panos
		return null;
	}

	@Override
	public ASTNode visitCtxPrimitiveMoney(CtxPrimitiveMoneyContext ctx) {
		// TODO Auto-generated method stub
		// panos
		// return MoneyLiteral(
		return null;
	}

	@Override
	public ASTNode visitCtxPrimitiveString(CtxPrimitiveStringContext ctx) {
		// TODO Auto-generated method stub
		// panos
		// return StringLiteral -> this.visitString(ctx.
		return null;
	}

	@Override
	public ASTNode visitCtxPrimitiveInteger(CtxPrimitiveIntegerContext ctx) {
		// TODO Auto-generated method stub
		// panos 
		// return IntLiteral
		return null;
	}
	
	
	private List<Page> visitPages(List<PageContext> pgs){
		List<Page> pages = new ArrayList<Page>();
		for (PageContext page : pgs)
			pages.add(this.visitPage(page));
		return pages;
	}
	private StringLiteral visitString(String _value, CodeLines _codeLines){
		return new StringLiteral(_value, _codeLines);
		
	}
	private List<Statement> visitStatement(List<StatementContext> stms){
		List<Statement> statements = new ArrayList<Statement>();
		for (StatementContext statement : stms)
			statements.add((Statement)statement.accept(this));
		return statements;
	}
	
	private Identifier visitIdentifier(TerminalNode identifier, CodeLines codeLines){
		return new Identifier(identifier.getText(), codeLines);
	}
	
	private CodeLines getCodeLines(ParserRuleContext ctx){
		return new CodeLines(ctx.start.getLine(), ctx.stop.getLine());
	}
	
}
