package uva.sc.qls.parser;

import java.util.ArrayList;
import java.util.List;

import uva.sc.core.INode;
import uva.sc.core.types.Boolean;
import uva.sc.core.types.Number;
import uva.sc.core.types.String;
import uva.sc.core.types.Type;
import uva.sc.qls.logic.*;
import uva.sc.qls.logic.fonts.Arial;
import uva.sc.qls.logic.fonts.Bazooka;
import uva.sc.qls.logic.fonts.BookAntiqua;
import uva.sc.qls.logic.fonts.Courier;
import uva.sc.qls.logic.fonts.Dialog;
import uva.sc.qls.logic.fonts.FontType;
import uva.sc.qls.logic.fonts.TimesNewRoman;
import uva.sc.qls.logic.style.Color;
import uva.sc.qls.logic.style.DefaultStyle;
import uva.sc.qls.logic.style.Font;
import uva.sc.qls.logic.style.FontSize;
import uva.sc.qls.logic.style.StyleProperty;
import uva.sc.qls.logic.style.Width;
import uva.sc.qls.widgetTypes.Checkbox;
import uva.sc.qls.widgetTypes.Radio;
import uva.sc.qls.widgetTypes.Spinbox;
import uva.sc.qls.widgetTypes.WidgetType;

public class ASTGeneratorVisitor extends QLSGrammarBaseVisitor<INode> {

	public StyleSheet visitStylesheet(QLSGrammarParser.StylesheetContext ctx) {
		List<Page> pages = new ArrayList<Page>();
		ID id = new ID(ctx.ID().getText());
		for (QLSGrammarParser.PageContext pageContext : ctx.pages) {
			pages.add((Page) visitPage(pageContext));
		}
		return new StyleSheet(id, pages);
	}

	public Page visitPage(QLSGrammarParser.PageContext ctx) {
		List<Section> sections = new ArrayList<Section>();
		ID id = new ID(ctx.ID().getText());
		DefaultStyle defaultStyle = null;
		if (ctx.defaultStyle() != null) {
			defaultStyle = (DefaultStyle) visitDefaultStyle(ctx.defaultStyle());
		}
		for (QLSGrammarParser.SectionContext sectionContext : ctx.sections) {
			sections.add((Section) visitSection(sectionContext));
		}
		return new Page(id, sections, defaultStyle);
	}

	public Section visitSection(QLSGrammarParser.SectionContext ctx) {
		SectionBody sectionBody = (SectionBody) visitSectionBody(ctx.sectionBody());
		return new Section(ctx.STRING().getText(), sectionBody);
	}

	public SectionBody visitSectionBody(QLSGrammarParser.SectionBodyContext ctx) {
		List<Question> questions = new ArrayList<Question>();
		List<Section> sections = new ArrayList<Section>();
		DefaultStyle defaultStyle = null;
		for (QLSGrammarParser.QuestionContext questionContext : ctx.questions) {
			questions.add((Question) visitQuestion(questionContext));
		}
		for (QLSGrammarParser.SectionContext sectionContext : ctx.sections) {
			sections.add((Section) visitSection(sectionContext));
		}
		if (ctx.defaultStyle() != null) {
			defaultStyle = (DefaultStyle) visitDefaultStyle(ctx.defaultStyle());
		}
		return new SectionBody(questions, sections, defaultStyle);
	}

	public Question visitQuestion(QLSGrammarParser.QuestionContext ctx) {
		ID id = new ID(ctx.ID().getText());
		Widget widget = null;
		if (ctx.widget() != null) {
			widget = (Widget) visitWidget(ctx.widget());
		}
		return new Question(id, widget);
	}

	public Widget visitWidget(QLSGrammarParser.WidgetContext ctx) {
		WidgetType widgetType = (WidgetType) this.visit(ctx.widgetType());
		Widget widget = null;
		if (ctx.STRING(0) == null || ctx.STRING(1) == null) {
			widget = new Widget(widgetType);
		}
		else {
			widget = new Widget(widgetType, ctx.STRING(0).getText(), ctx.STRING(1).getText());
		}
		return widget;
	}

	public DefaultStyle visitDefaultStyle(QLSGrammarParser.DefaultStyleContext ctx) {
		List<StyleProperty> stylePropertyList = new ArrayList<StyleProperty>();
		Type type = (Type) this.visit(ctx.type());
		Widget widget = (Widget) visitWidget(ctx.widget());
		for (QLSGrammarParser.StylePropertyContext stylePropertyContext : ctx.styleProperties) {
			stylePropertyList.add((StyleProperty) this.visit(stylePropertyContext));
		}
		return new DefaultStyle(type, stylePropertyList, widget);
	}

	public Boolean visitBoolean(QLSGrammarParser.BooleanContext ctx) {
		return new Boolean();
	}

	public Number visitNumber(QLSGrammarParser.NumberContext ctx) {
		return new Number();
	}

	public String visitString(QLSGrammarParser.StringContext ctx) {
		return new String();
	}

	public Width visitWidth(QLSGrammarParser.WidthContext ctx) {
		return new Width(Integer.parseInt(ctx.NUMBER().getText()));
	}

	public Font visitFontName(QLSGrammarParser.FontNameContext ctx) {
		FontType fontType = (FontType) this.visit(ctx.font());
		return new Font(fontType);
	}

	public FontSize visitFontsize(QLSGrammarParser.FontsizeContext ctx) {
		return new FontSize(Integer.parseInt(ctx.NUMBER().getText()));
	}

	public Color visitColor(QLSGrammarParser.ColorContext ctx) {
		return new Color(ctx.COLORENCODE().getText());
	}

	public Checkbox visitCheckbox(QLSGrammarParser.CheckboxContext ctx) {
		return new Checkbox();
	}

	public Spinbox visitSpinbox(QLSGrammarParser.SpinboxContext ctx) {
		return new Spinbox();
	}

	public Radio visitRadio(QLSGrammarParser.RadioContext ctx) {
		return new Radio();
	}

	public Arial visitArial(QLSGrammarParser.ArialContext ctx) {
		return new Arial();
	}

	public TimesNewRoman visitTimesNewRoman(QLSGrammarParser.TimesNewRomanContext ctx) {
		return new TimesNewRoman();
	}

	public Bazooka visitBazooka(QLSGrammarParser.BazookaContext ctx) {
		return new Bazooka();
	}

	public BookAntiqua visitBookAntiqua(QLSGrammarParser.BookAntiquaContext ctx) {
		return new BookAntiqua();
	}

	public Courier visitCourier(QLSGrammarParser.CourierContext ctx) {
		return new Courier();
	}

	public Dialog visitDialog(QLSGrammarParser.DialogContext ctx) {
		return new Dialog();
	}

}
