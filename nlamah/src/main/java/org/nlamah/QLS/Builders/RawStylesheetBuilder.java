package org.nlamah.QLS.Builders;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QBase.Error.EnumRecognitionError;
import org.nlamah.QBase.Error.QBaseParsingError;
import org.nlamah.QLS.QLSBaseVisitor;
import org.nlamah.QLS.QLSParser;
import org.nlamah.QLS.QLSParser.DefaultBlockContext;
import org.nlamah.QLS.QLSParser.PageContext;
import org.nlamah.QLS.QLSParser.SectionContext;
import org.nlamah.QLS.QLSParser.StyleDeclarationContext;
import org.nlamah.QLS.QLSParser.StylesheetBlockContext;
import org.nlamah.QLS.Error.FontRecognitionError;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Abstract.WidgetType;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.DefaultBlock;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.Value.FontValue;
import org.nlamah.QLS.Model.Value.ColorValue;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.NumberValue;
import org.nlamah.QLS.Model.Value.TextValue;
import org.nlamah.QLS.Model.Value.Widget.CheckBoxWidgetType;
import org.nlamah.QLS.Model.Value.Widget.RadioButtonWidgetType;
import org.nlamah.QLS.Model.Value.Widget.SpinBoxWidgetType;

public class RawStylesheetBuilder extends QLSBaseVisitor<QLSNode> 
{
	private List<QBaseParsingError> errors;
	
	private int sectionDepthLevel = -1;

	public RawStylesheetBuilder() 
	{
		super();

		errors = new ArrayList<QBaseParsingError>();
	}

	public List<QBaseParsingError> errors()
	{
		return this.errors;
	}

	public Stylesheet build(ParseTree tree)
	{
		return (Stylesheet) tree.accept(this);
	}

	@Override 
	public QLSNode visitStylesheet(QLSParser.StylesheetContext ctx) 
	{ 		
		IdentifierValue identifier = new IdentifierValue(ctx.Identifier().getText());
		QBaseHelper.addSourceCodePosition(identifier, ctx);
		
		List<Page> pages = new ArrayList<Page>();

		for (PageContext contextualPage : ctx.page())
		{
			Page page = (Page) contextualPage.accept(this);
			pages.add(page);
		}

		List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();

		for (DefaultBlockContext contextualDefaultBlock : ctx.defaultBlock())
		{
			DefaultBlock defaultBlock = (DefaultBlock) contextualDefaultBlock.accept(this);
			defaultBlocks.add(defaultBlock);
		}

		Stylesheet stylesheet = new Stylesheet(identifier, pages, defaultBlocks);
		QBaseHelper.addSourceCodePosition(stylesheet, ctx);

		return stylesheet;
	}

	@Override 
	public QLSNode visitPage(QLSParser.PageContext ctx) 
	{ 
		IdentifierValue identifier = new IdentifierValue(ctx.Identifier().getText());
		QBaseHelper.addSourceCodePosition(identifier, ctx);
		
		List<Section> sections = new ArrayList<Section>();

		for (SectionContext contextualSection : ctx.section())
		{
			Section section = (Section) contextualSection.accept(this);
			sections.add(section);
		}

		List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();

		for (DefaultBlockContext contextualDefaultBlock : ctx.defaultBlock())
		{
			DefaultBlock defaultBlock = (DefaultBlock) contextualDefaultBlock.accept(this);
			defaultBlocks.add(defaultBlock);
		}

		Page page = new Page(identifier, sections, defaultBlocks);
		QBaseHelper.addSourceCodePosition(page, ctx);

		return page;
	}

	@Override 
	public QLSNode visitSection(QLSParser.SectionContext ctx) 
	{
		sectionDepthLevel++;
		
		TextValue titleValue = new TextValue(QBaseHelper.removeSurroundingQuotes(ctx.Text().getText()));
		QBaseHelper.addSourceCodePosition(titleValue, ctx);
		
		List<SectionItem> sectionItems = new ArrayList<SectionItem>();

		for (StylesheetBlockContext contextualSection : ctx.stylesheetBlock())
		{
			SectionItem sectionItem = (SectionItem) contextualSection.accept(this);
			sectionItems.add(sectionItem);
		}

		List<DefaultBlock> defaultBlocks = new ArrayList<DefaultBlock>();

		for (DefaultBlockContext contextualDefaultBlock : ctx.defaultBlock())
		{
			DefaultBlock defaultBlock = (DefaultBlock) contextualDefaultBlock.accept(this);
			defaultBlocks.add(defaultBlock);
		}

		Section section = new Section(titleValue, sectionItems, defaultBlocks, sectionDepthLevel);
		QBaseHelper.addSourceCodePosition(section, ctx);
		
		sectionDepthLevel--;

		return section;
	}

	@Override 
	public QLSNode visitStyledQuestion(QLSParser.StyledQuestionContext ctx)
	{ 
		IdentifierValue identifier = new IdentifierValue(ctx.Identifier().getText());
		QBaseHelper.addSourceCodePosition(identifier, ctx);
			
		WidgetDeclaration widgetDeclaration = null;

		if (ctx.widgetDeclaration() != null)
		{
			widgetDeclaration = (WidgetDeclaration) ctx.widgetDeclaration().accept(this);
		}

		StyledQuestion styledQuestion = new StyledQuestion(identifier, widgetDeclaration);
		QBaseHelper.addSourceCodePosition(styledQuestion, ctx);

		return styledQuestion; 
	}
	
	@Override
	public QLSNode visitDefaultBlock(QLSParser.DefaultBlockContext ctx)
	{
		String questionTypeString = ctx.QuestionType() != null ? ctx.QuestionType().getText().toUpperCase() : null;
		
		QBaseQuestionType questionType = null;
		
		if (questionTypeString != null)
		{
			try 
			{
				questionType = QBaseQuestionType.valueOf(questionTypeString);
			} 
			catch(Exception ex) 
			{	
				errors.add(new EnumRecognitionError(questionTypeString, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
			}
		}
		else
		{
			questionType = QBaseQuestionType.ALL;
		}
		
		List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();
		
		for (StyleDeclarationContext contextualStyleDeclaration : ctx.styleDeclaration())
		{
			StyleDeclaration styleDeclaration = (StyleDeclaration)contextualStyleDeclaration.accept(this);
			styleDeclarations.add(styleDeclaration);
		}
		
		DefaultBlock defaultBlock = new DefaultBlock(questionType, styleDeclarations);
		QBaseHelper.addSourceCodePosition(defaultBlock, ctx);

		return defaultBlock;
	}

	@Override 
	public QLSNode visitWidthDeclaration(QLSParser.WidthDeclarationContext ctx) 
	{ 
		String numberValueString = ctx.Number().getText();

		int numberValue = Integer.parseInt(numberValueString); 

		WidthDeclaration widthDeclaration = new WidthDeclaration(new NumberValue(numberValue));
		QBaseHelper.addSourceCodePosition(widthDeclaration, ctx);

		return widthDeclaration;
	}

	@Override 
	public QLSNode visitFontDeclaration(QLSParser.FontDeclarationContext ctx) 
	{ 
		String fontValueString = QBaseHelper.removeSurroundingQuotes(ctx.Text().getText());

		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();

		String[] availableFontFamilyNames = graphicsEnvironment.getAvailableFontFamilyNames();

		if (Arrays.asList(availableFontFamilyNames).indexOf(fontValueString) < 0)
		{
			errors.add(new FontRecognitionError(fontValueString, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
		}

		Font font = Font.decode(fontValueString);

		FontDeclaration fontDeclaration = new FontDeclaration(new FontValue(font));
		QBaseHelper.addSourceCodePosition(fontDeclaration, ctx);

		return fontDeclaration; 
	}

	@Override 
	public QLSNode visitFontSizeDeclaration(QLSParser.FontSizeDeclarationContext ctx) 
	{ 
		String numberValueString = ctx.Number().getText();

		int numberValue = Integer.parseInt(numberValueString); 

		FontSizeDeclaration fontSizeDeclaration = new FontSizeDeclaration(new NumberValue(numberValue));
		QBaseHelper.addSourceCodePosition(fontSizeDeclaration, ctx);

		return fontSizeDeclaration;
	}

	@Override 
	public QLSNode visitColorDeclaration(QLSParser.ColorDeclarationContext ctx) 
	{ 
		String hexNumberValueString = ctx.HexNumber().getText();

		Color color = Color.decode(hexNumberValueString);

		ColorDeclaration colorDeclaration = new ColorDeclaration(new ColorValue(color));
		QBaseHelper.addSourceCodePosition(colorDeclaration, ctx);

		return colorDeclaration;
	}

	@Override 
	public QLSNode visitWidgetDeclaration(QLSParser.WidgetDeclarationContext ctx) 
	{ 
		WidgetType widgetType = (WidgetType) ctx.widgetType().accept(this);

		WidgetDeclaration widgetDeclaration = new WidgetDeclaration(widgetType);
		QBaseHelper.addSourceCodePosition(widgetDeclaration, ctx);

		return widgetDeclaration;
	}

	@Override 
	public QLSNode visitCheckBoxType(QLSParser.CheckBoxTypeContext ctx) 
	{ 		
		CheckBoxWidgetType checkBoxWidgetType = new CheckBoxWidgetType();
		QBaseHelper.addSourceCodePosition(checkBoxWidgetType, ctx);

		return checkBoxWidgetType; 
	}

	@Override 
	public QLSNode visitSpinBoxType(QLSParser.SpinBoxTypeContext ctx) 
	{
		SpinBoxWidgetType spinBoxWidgetType = new SpinBoxWidgetType();
		QBaseHelper.addSourceCodePosition(spinBoxWidgetType, ctx);

		return spinBoxWidgetType; 
	}

	@Override 
	public QLSNode visitRadioButtonType(QLSParser.RadioButtonTypeContext ctx) 
	{ 
		List<TextValue> answers = new ArrayList<TextValue>();

		for (org.antlr.v4.runtime.Token contextualTextValue : ctx.answer)
		{
			TextValue answer = new TextValue(QBaseHelper.removeSurroundingQuotes(contextualTextValue.getText()));
			QBaseHelper.addSourceCodePosition(answer, ctx);
			answers.add(answer);
		}

		RadioButtonWidgetType radioButtonWidgetType = new RadioButtonWidgetType(answers);

		QBaseHelper.addSourceCodePosition(radioButtonWidgetType, ctx);

		return radioButtonWidgetType; 
	}
}
