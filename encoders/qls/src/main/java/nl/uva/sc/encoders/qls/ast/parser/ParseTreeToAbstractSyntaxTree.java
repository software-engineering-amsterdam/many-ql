package nl.uva.sc.encoders.qls.ast.parser;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.qls.EncodersQLSBaseVisitor;
import nl.uva.sc.encoders.qls.EncodersQLSParser.CheckBoxContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.DefaultStyleContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.NumberFieldContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.PageContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.QuestionContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.RadioContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.SectionContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.StylePropertyContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.StylesheetContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.TextFieldContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.WidgetContext;
import nl.uva.sc.encoders.qls.ast.AstNode;
import nl.uva.sc.encoders.qls.ast.DefaultStyle;
import nl.uva.sc.encoders.qls.ast.DefaultStyleProperty;
import nl.uva.sc.encoders.qls.ast.Page;
import nl.uva.sc.encoders.qls.ast.Section;
import nl.uva.sc.encoders.qls.ast.Stylesheet;
import nl.uva.sc.encoders.qls.ast.widget.CheckBox;
import nl.uva.sc.encoders.qls.ast.widget.NumberField;
import nl.uva.sc.encoders.qls.ast.widget.Radio;
import nl.uva.sc.encoders.qls.ast.widget.TextField;
import nl.uva.sc.encoders.qls.ast.widget.Widget;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

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
		TextLocation textLocation = getTextLocation(ctx);
		String name = ctx.name.getText();
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
		TextLocation textLocation = getTextLocation(ctx);
		String name = ctx.name.getText();
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
		TextLocation textLocation = getTextLocation(ctx);
		String dataType = ctx.DATATYPE().getText();
		WidgetContext widgetContext = ctx.widget();
		Widget defaultStyleWidget = (Widget) widgetContext.accept(this);
		DefaultStyle defaultStyle = new DefaultStyle(textLocation, dataType, defaultStyleWidget);

		for (StylePropertyContext stylePropertyContext : ctx.styleProperty()) {
			String defaultStylePropertyText = stylePropertyContext.getText();
			DefaultStyleProperty defaultStyleProperty = new DefaultStyleProperty(textLocation, defaultStylePropertyText);
			defaultStyle.addDefaultStyleProperty(defaultStyleProperty);
		}
		return defaultStyle;
	}

	@Override
	public CheckBox visitCheckBox(CheckBoxContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		return new CheckBox(textLocation);
	}

	@Override
	public Radio visitRadio(RadioContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		List<TerminalNode> stringliteral = ctx.STRINGLITERAL();
		List<String> options = new ArrayList<>();
		for (TerminalNode terminalNode : stringliteral) {
			options.add(terminalNode.getText());
		}
		return new Radio(textLocation, options);
	}

	@Override
	public NumberField visitNumberField(NumberFieldContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		return new NumberField(textLocation);
	}

	@Override
	public TextField visitTextField(TextFieldContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		return new TextField(textLocation);
	}

	private TextLocation getTextLocation(ParserRuleContext ctx) {
		Token start = ctx.getStart();
		int line = start.getLine();
		int column = start.getCharPositionInLine();
		return new TextLocation(line, column);
	}

}
