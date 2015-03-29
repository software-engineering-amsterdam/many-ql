package nl.uva.sc.encoders.qls.parser;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.qls.EncodersQLSBaseVisitor;
import nl.uva.sc.encoders.qls.EncodersQLSParser.CheckBoxContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.ColorContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.DefaultStyleContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.FontContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.FontSizeContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.NumberFieldContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.PageContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.QuestionContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.RadioContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.SectionContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.StylePropertyContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.StylesheetContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.TextFieldContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.WidgetContext;
import nl.uva.sc.encoders.qls.EncodersQLSParser.WidthContext;
import nl.uva.sc.encoders.qls.ast.AstNode;
import nl.uva.sc.encoders.qls.ast.DefaultStyle;
import nl.uva.sc.encoders.qls.ast.Page;
import nl.uva.sc.encoders.qls.ast.Section;
import nl.uva.sc.encoders.qls.ast.Stylesheet;
import nl.uva.sc.encoders.qls.ast.property.Color;
import nl.uva.sc.encoders.qls.ast.property.DefaultStyleProperty;
import nl.uva.sc.encoders.qls.ast.property.Font;
import nl.uva.sc.encoders.qls.ast.property.FontSize;
import nl.uva.sc.encoders.qls.ast.property.Width;
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
		List<String> questionNames = new ArrayList<>();
		List<Section> subSections = new ArrayList<>();
		List<DefaultStyle> sectionDefaultStyles = new ArrayList<>();
		for (QuestionContext questionContext : ctx.question()) {
			String questionName = questionContext.name.getText();
			questionNames.add(questionName);
		}
		for (SectionContext subSectionContext : ctx.section()) {
			Section subSection = visitSection(subSectionContext);
			subSections.add(subSection);
		}
		for (DefaultStyleContext defaultStyleContext : ctx.defaultStyle()) {
			DefaultStyle defaultStyle = (DefaultStyle) defaultStyleContext.accept(this);
			sectionDefaultStyles.add(defaultStyle);
		}
		return new Section(textLocation, name, questionNames, subSections, sectionDefaultStyles);
	}

	@Override
	public DefaultStyle visitDefaultStyle(DefaultStyleContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		String dataType = ctx.DATATYPE().getText();
		WidgetContext widgetContext = ctx.widget();
		Widget defaultStyleWidget = (Widget) widgetContext.accept(this);
		DefaultStyle defaultStyle = new DefaultStyle(textLocation, dataType, defaultStyleWidget);

		for (StylePropertyContext stylePropertyContext : ctx.styleProperty()) {
			DefaultStyleProperty defaultStyleProperty = (DefaultStyleProperty) stylePropertyContext.accept(this);
			defaultStyle.addDefaultStyleProperty(defaultStyleProperty);
		}
		return defaultStyle;
	}

	@Override
	public Color visitColor(ColorContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		String value = ctx.value.getText();
		return new Color(textLocation, value);
	}

	@Override
	public Font visitFont(FontContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		String value = ctx.value.getText();
		return new Font(textLocation, value);
	}

	@Override
	public FontSize visitFontSize(FontSizeContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		Integer value = Integer.valueOf(ctx.value.getText());
		return new FontSize(textLocation, value);
	}

	@Override
	public Width visitWidth(WidthContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		Integer value = Integer.valueOf(ctx.value.getText());
		return new Width(textLocation, value);
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
