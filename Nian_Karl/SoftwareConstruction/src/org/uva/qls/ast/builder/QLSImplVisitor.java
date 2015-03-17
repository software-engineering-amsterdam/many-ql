package org.uva.qls.ast.builder;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.uva.qls.antlr.QLSBaseVisitor;
import org.uva.qls.antlr.QLSParser.BackgroundColorStyleContext;
import org.uva.qls.antlr.QLSParser.BoolTypeContext;
import org.uva.qls.antlr.QLSParser.CheckboxContext;
import org.uva.qls.antlr.QLSParser.DropdownContext;
import org.uva.qls.antlr.QLSParser.FontContext;
import org.uva.qls.antlr.QLSParser.FontSizeStyleContext;
import org.uva.qls.antlr.QLSParser.FontStyleContext;
import org.uva.qls.antlr.QLSParser.HeightStyleContext;
import org.uva.qls.antlr.QLSParser.IntTypeContext;
import org.uva.qls.antlr.QLSParser.PageContext;
import org.uva.qls.antlr.QLSParser.QuestionContext;
import org.uva.qls.antlr.QLSParser.RadioContext;
import org.uva.qls.antlr.QLSParser.RgbContext;
import org.uva.qls.antlr.QLSParser.SectionContext;
import org.uva.qls.antlr.QLSParser.SheetContext;
import org.uva.qls.antlr.QLSParser.SliderContext;
import org.uva.qls.antlr.QLSParser.SpinboxContext;
import org.uva.qls.antlr.QLSParser.StrTypeContext;
import org.uva.qls.antlr.QLSParser.StyleContext;
import org.uva.qls.antlr.QLSParser.StylePropContext;
import org.uva.qls.antlr.QLSParser.TextboxContext;
import org.uva.qls.antlr.QLSParser.WidgetStyleContext;
import org.uva.qls.antlr.QLSParser.WidthStyleContext;
import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.Node;
import org.uva.qls.ast.literal.ColorLiteral;
import org.uva.qls.ast.literal.IdentifierLiteral;
import org.uva.qls.ast.literal.IntLiteral;
import org.uva.qls.ast.literal.StrLiteral;
import org.uva.qls.ast.sheet.Page;
import org.uva.qls.ast.sheet.Question;
import org.uva.qls.ast.sheet.Section;
import org.uva.qls.ast.sheet.Sheet;
import org.uva.qls.ast.sheet.Style;
import org.uva.qls.ast.style.BackgroundColor;
import org.uva.qls.ast.style.Font;
import org.uva.qls.ast.style.Fontsize;
import org.uva.qls.ast.style.Height;
import org.uva.qls.ast.style.StyleProperty;
import org.uva.qls.ast.style.Width;
import org.uva.qls.ast.style.widget.CheckboxModel;
import org.uva.qls.ast.style.widget.DropdownModel;
import org.uva.qls.ast.style.widget.RadioModel;
import org.uva.qls.ast.style.widget.SliderModel;
import org.uva.qls.ast.style.widget.SpinboxModel;
import org.uva.qls.ast.style.widget.TextboxModel;
import org.uva.qls.ast.type.BoolType;
import org.uva.qls.ast.type.IntType;
import org.uva.qls.ast.type.StrType;
import org.uva.qls.ast.type.Type;
import org.uva.qls.ast.value.StrValue;

public class QLSImplVisitor extends QLSBaseVisitor<Node> {

	@Override
	public Node visitSlider(SliderContext ctx) {
		System.out.println("Visiting slider Style");
		CodePosition pos = CodePosition.getCodePosition(ctx);
		IntLiteral min = new IntLiteral(Integer.parseInt(ctx.min.getText()), pos);
		IntLiteral max = new IntLiteral(Integer.parseInt(ctx.max.getText()), pos);
		return new SliderModel(min, max, pos);
	}

	@Override
	public Node visitFont(FontContext ctx) {
		System.out.println("Visiting Font Style");
		CodePosition pos = CodePosition.getCodePosition(ctx);
		StrLiteral strLiterael = new StrLiteral(ctx.getText(), pos);
		Font font = new Font(strLiterael, pos);
		return font;
	}

	@Override
	public Node visitRgb(RgbContext ctx) {
		System.out.println("Visiting RGB Style");
		CodePosition pos = CodePosition.getCodePosition(ctx);
		int red = Integer.parseInt(ctx.red.getText());
		int green = Integer.parseInt(ctx.green.getText());
		int blue = Integer.parseInt(ctx.blue.getText());
		return new ColorLiteral(red, green, blue, pos);
	}

	@Override
	public Node visitIntType(IntTypeContext ctx) {
		return new IntType();
	}

	@Override
	public Node visitBoolType(BoolTypeContext ctx) {
		return new BoolType();
	}

	@Override
	public Node visitStrType(StrTypeContext ctx) {
		return new StrType();
	}

	@Override
	public Node visitDropdown(DropdownContext ctx) {
		System.out.println("Visiting dropdown Style");
		CodePosition pos = CodePosition.getCodePosition(ctx);
		DropdownModel model = new DropdownModel(ctx.firstLabel.getText(), ctx.secondLabel.getText(), pos);
		return (Node) model;
	}

	@Override
	public Node visitSpinbox(SpinboxContext ctx) {
		System.out.println("Visiting Spinbox Style");
		CodePosition pos = CodePosition.getCodePosition(ctx);
		List<IntLiteral> intLiteralList = new ArrayList<IntLiteral>();
		for (TerminalNode node : ctx.IntegerLiteral()) {
			int value = Integer.parseInt(node.getText());
			IntLiteral intLiteral = new IntLiteral(value, pos);
			intLiteralList.add(intLiteral);
		}
		SpinboxModel model = new SpinboxModel(intLiteralList, pos);
		return model;
	}

	@Override
	public Node visitTextbox(TextboxContext ctx) {
		System.out.println("Visiting TextBox Style");
		return new TextboxModel(CodePosition.getCodePosition(ctx));
	}

	@Override
	public Node visitCheckbox(CheckboxContext ctx) {
		System.out.println("Visiting Checkbox Style");
		return new CheckboxModel(CodePosition.getCodePosition(ctx));
	}

	@Override
	public Node visitRadio(RadioContext ctx) {
		System.out.println("Visiting Radio Style");
		CodePosition pos = CodePosition.getCodePosition(ctx);
		return new RadioModel(ctx.firstLabel.getText(), ctx.secondLabel.getText(), pos);
	}

	@Override
	public Node visitStyle(StyleContext ctx) {
		System.out.println("visiting style.");
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Type type = (Type) ctx.type().accept(this);
		Style style = new Style(type, pos);
		for (StylePropContext styleCtx : ctx.styleProp()) {
			System.out.println("WOOHOO");
			style.addProperty((StyleProperty) styleCtx.accept(this));
		}
		return style;
	}

	@Override
	public Node visitSection(SectionContext ctx) {
		System.out.println("Visiting Section Style");
		StrValue name = new StrValue(ctx.StringLiteral().getText());
		CodePosition pos = CodePosition.getCodePosition(ctx);
		StrLiteral sectionTitle = new StrLiteral(name, pos);

		List<Style> styleList = new ArrayList<Style>();
		for (StyleContext styleCtx : ctx.style()) {
			styleList.add((Style) styleCtx.accept(this));
		}
		List<Question> questionList = new ArrayList<Question>();
		for (QuestionContext quetionCtx : ctx.question()) {
			questionList.add((Question) quetionCtx.accept(this));
		}
		Section section = new Section(sectionTitle, styleList, questionList, pos);
		return section;
	}

	@Override
	public Node visitPage(PageContext ctx) {
		System.out.println("Visiting page");
		StrValue name = new StrValue(ctx.Identifier().getText());
		CodePosition pos = CodePosition.getCodePosition(ctx);
		IdentifierLiteral identifier = new IdentifierLiteral(name, pos);
		List<Style> styleList = new ArrayList<Style>();
		for (StyleContext styleCtx : ctx.style()) {
			styleList.add((Style) styleCtx.accept(this));
		}
		List<Section> sectionList = new ArrayList<Section>();
		for (SectionContext sectionCtx : ctx.section()) {
			sectionList.add((Section) sectionCtx.accept(this));
		}
		Page page = new Page(identifier, sectionList, styleList, pos);
		return page;
	}

	@Override
	public Node visitQuestion(QuestionContext ctx) {
		System.out.println("Visiting Question Style");
		StrValue name = new StrValue(ctx.Identifier().getText());
		CodePosition pos = CodePosition.getCodePosition(ctx);
		IdentifierLiteral identifier = new IdentifierLiteral(name, pos);
		Question question = new Question(identifier, pos);
		return question;
	}

	@Override
	public Node visitSheet(SheetContext ctx) {
		System.out.println("Visiting Sheet");
		StrValue name = new StrValue(ctx.Identifier().getText());
		CodePosition pos = CodePosition.getCodePosition(ctx);
		IdentifierLiteral identifier = new IdentifierLiteral(name, pos);
		Sheet sheet = new Sheet(identifier, pos);
		for (PageContext pageCtx : ctx.page()) {
			sheet.addPage((Page) pageCtx.accept(this));
		}
		return sheet;
	}

	@Override
	public Node visitFontSizeStyle(FontSizeStyleContext ctx) {
		System.out.println("Visiting Font ize Style");
		CodePosition pos = CodePosition.getCodePosition(ctx);
		int size = Integer.parseInt(ctx.fontSizeProp.getText());
		return new Fontsize(size, pos);
	}

	@Override
	public Node visitFontStyle(FontStyleContext ctx) {
		System.out.println("Visiting Font Style");
		CodePosition pos = CodePosition.getCodePosition(ctx);
		return new Font(ctx.fontProp.getText(), pos);
	}

	@Override
	public Node visitWidthStyle(WidthStyleContext ctx) {
		System.out.println("Visiting Width Style");
		CodePosition pos = CodePosition.getCodePosition(ctx);
		int width = Integer.parseInt(ctx.widthProp.getText());
		return new Width(width, pos);
	}

	@Override
	public Node visitBackgroundColorStyle(BackgroundColorStyleContext ctx) {
		System.out.println("Visiting Color Style");
		CodePosition pos = CodePosition.getCodePosition(ctx);
		ColorLiteral colorLit = (ColorLiteral) ctx.colorProp.accept(this);
		BackgroundColor color = new BackgroundColor(colorLit, pos);
		return color;
	}

	@Override
	public Node visitHeightStyle(HeightStyleContext ctx) {
		System.out.println("Visiting Height Style");
		CodePosition pos = CodePosition.getCodePosition(ctx);
		int height = Integer.parseInt(ctx.heightProp.getText());
		return new Height(height, pos);
	}

	@Override
	public Node visitWidgetStyle(WidgetStyleContext ctx) {
		System.out.println("Visiting Widget Style");
		return super.visitWidgetStyle(ctx);
	}

}
