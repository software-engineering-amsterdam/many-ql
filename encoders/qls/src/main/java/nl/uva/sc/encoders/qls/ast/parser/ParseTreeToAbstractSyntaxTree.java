package nl.uva.sc.encoders.qls.ast.parser;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.qls.EncodersQLSBaseVisitor;
import nl.uva.sc.encoders.qls.EncodersQLSParser.DefaultStyleContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.PageContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.QuestionContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.SectionContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.StylesheetContext;
import nl.uva.sc.encoders.qls.ast.AstNode;
import nl.uva.sc.encoders.qls.ast.DefaultStyle;
import nl.uva.sc.encoders.qls.ast.Page;
import nl.uva.sc.encoders.qls.ast.Section;
import nl.uva.sc.encoders.qls.ast.Stylesheet;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class ParseTreeToAbstractSyntaxTree extends EncodersQLSBaseVisitor<AstNode> {

	@Override
	public Stylesheet visitStylesheet(StylesheetContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		String name = ctx.name.getText();
		List<Page> pages = new ArrayList<>();
		for (PageContext pageContext : ctx.page()) {
			Page page = (Page) pageContext.accept(this);
			pages.add(page);
		}
		return new Stylesheet(textLocation, name, pages);
	}

	@Override
	public Page visitPage(PageContext ctx) {
		String name = ctx.name.getText();
		TextLocation textLocation = getTextLocation(ctx);
		Page page = new Page(textLocation, name);
		for (SectionContext sectionContext : ctx.section()) {
			Section section = (Section) sectionContext.accept(this);
			page.addSection(section);
		}
		for (DefaultStyleContext defaultStyleContext : ctx.defaultStyle()) {
			DefaultStyle defaultStyle = (DefaultStyle) defaultStyleContext.accept(this);
			page.addPageDefaultStyle(defaultStyle);
		}
		return page;
	}

	@Override
	public Section visitSection(SectionContext ctx) {
		String name = ctx.name.getText();
		TextLocation textLocation = getTextLocation(ctx);
		Section section = new Section(textLocation, name);
		for (QuestionContext questionContext : ctx.question()) {
			String questionName = questionContext.name.getText();
			section.addQuestion(questionName);
		}
		for (SectionContext subSectionContext : ctx.section()) {
			Section subSection = visitSection(subSectionContext);
			section.addSubSection(subSection);
		}
		for (DefaultStyleContext defaultStyleContext : ctx.defaultStyle()) {
			DefaultStyle defaultStyle = (DefaultStyle) defaultStyleContext.accept(this);
			section.addSectionDefaultStyle(defaultStyle);
		}
		return section;
	}

	@Override
	public DefaultStyle visitDefaultStyle(DefaultStyleContext ctx) {
		String dataType = ctx.DATATYPE().getText();
		String widget = ctx.widget().getText();
		TextLocation textLocation = getTextLocation(ctx);
		DefaultStyle defaultStyle = new DefaultStyle(textLocation, dataType, widget);

		return defaultStyle;
	}

	private TextLocation getTextLocation(ParserRuleContext ctx) {
		Token start = ctx.getStart();
		int line = start.getLine();
		int column = start.getCharPositionInLine();
		return new TextLocation(line, column);
	}

}
