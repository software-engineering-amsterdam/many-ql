package org.uva.qls.ast.builder;

import java.util.ArrayList;

import org.uva.ql.ast.Node;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.qls.antlr.QLSBaseVisitor;
import org.uva.qls.antlr.QLSParser.CheckboxContext;
import org.uva.qls.antlr.QLSParser.DropdownContext;
import org.uva.qls.antlr.QLSParser.FontContext;
import org.uva.qls.antlr.QLSParser.PageBlockContext;
import org.uva.qls.antlr.QLSParser.PageContext;
import org.uva.qls.antlr.QLSParser.QuestionContext;
import org.uva.qls.antlr.QLSParser.RadioContext;
import org.uva.qls.antlr.QLSParser.RgbContext;
import org.uva.qls.antlr.QLSParser.SectionContext;
import org.uva.qls.antlr.QLSParser.SheetContext;
import org.uva.qls.antlr.QLSParser.SliderContext;
import org.uva.qls.antlr.QLSParser.SpinboxContext;
import org.uva.qls.antlr.QLSParser.StyleContext;
import org.uva.qls.antlr.QLSParser.StylingContext;
import org.uva.qls.antlr.QLSParser.TextboxContext;
import org.uva.qls.antlr.QLSParser.TypeContext;
import org.uva.qls.ast.Page;
import org.uva.qls.ast.Question;
import org.uva.qls.ast.Sheet;
import org.uva.qls.ast.style.Style;
import org.uva.utility.CodePosition;

public class QLSImplVisitor extends QLSBaseVisitor<Node> {

	@Override
	public Node visitSlider(SliderContext ctx) {

		return super.visitSlider(ctx);
	}

	@Override
	public Node visitFont(FontContext ctx) {
		return super.visitFont(ctx);
	}

	@Override
	public Node visitRgb(RgbContext ctx) {
		return super.visitRgb(ctx);
	}

	@Override
	public Node visitType(TypeContext ctx) {
		return super.visitType(ctx);
	}

	@Override
	public Node visitDropdown(DropdownContext ctx) {
		return super.visitDropdown(ctx);
	}

	@Override
	public Node visitSpinbox(SpinboxContext ctx) {
		return super.visitSpinbox(ctx);
	}

	@Override
	public Node visitSection(SectionContext ctx) {
		return super.visitSection(ctx);
	}

	@Override
	public Node visitTextbox(TextboxContext ctx) {
		return super.visitTextbox(ctx);
	}

	@Override
	public Node visitPageBlock(PageBlockContext ctx) {
		return super.visitPageBlock(ctx);
	}

	@Override
	public Node visitStyle(StyleContext ctx) {
		return super.visitStyle(ctx);
	}

	@Override
	public Node visitPage(PageContext ctx) {
		return super.visitPage(ctx);
	}

	@Override
	public Node visitCheckbox(CheckboxContext ctx) {

		return super.visitCheckbox(ctx);
	}

	@Override
	public Node visitRadio(RadioContext ctx) {
		return super.visitRadio(ctx);
	}

	@Override
	public Node visitQuestion(QuestionContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Identifier identifier = new Identifier(ctx.Identifier().getText(), pos);
		Question question = new Question(identifier, pos);
		return question;
	}

	@Override
	public Node visitStyling(StylingContext ctx) {
		Style style = new Style(CodePosition.getCodePosition(ctx));
		return style;
	}

	@Override
	public Node visitSheet(SheetContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Identifier identifier = new Identifier(ctx.Identifier().getText(), pos);
		Sheet sheet = new Sheet(identifier, pos);
		ArrayList<Page> pages = (ArrayList<Page>) ctx.accept(this);
		return sheet;
	}

}
