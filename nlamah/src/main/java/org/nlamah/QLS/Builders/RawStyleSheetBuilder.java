package org.nlamah.QLS.Builders;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QLS.QLSBaseVisitor;
import org.nlamah.QLS.QLSException;
import org.nlamah.QLS.QLSParser;
import org.nlamah.QLS.QLSParser.DefaultDeclarationContext;
import org.nlamah.QLS.QLSParser.DefaultDeclarationSingleStatementContext;
import org.nlamah.QLS.QLSParser.PageContext;
import org.nlamah.QLS.QLSParser.QuestionDeclarationContext;
import org.nlamah.QLS.QLSParser.SectionContext;
import org.nlamah.QLS.QLSParser.StyleDeclarationContext;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Abstract.WidgetType;
import org.nlamah.QLS.Model.Declaration.ColorDeclaration;
import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;
import org.nlamah.QLS.Model.Declaration.FontDeclaration;
import org.nlamah.QLS.Model.Declaration.FontSizeDeclaration;
import org.nlamah.QLS.Model.Declaration.QuestionDeclaration;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Declaration.WidthDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.QLStylesheet;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.Value.HexNumberValue;
import org.nlamah.QLS.Model.Value.IdentifierValue;
import org.nlamah.QLS.Model.Value.NumberValue;
import org.nlamah.QLS.Model.Value.TextValue;
import org.nlamah.QLS.Model.Value.Widget.CheckBoxWidgetType;
import org.nlamah.QLS.Model.Value.Widget.RadioButtonWidgetType;
import org.nlamah.QLS.Model.Value.Widget.SpinBoxWidgetType;

public class RawStyleSheetBuilder extends QLSBaseVisitor<QLSNode> 
{
	public RawStyleSheetBuilder() 
	{
		super();
	}

	public QLStylesheet build(ParseTree tree) throws QLSException
	{
		return (QLStylesheet) tree.accept(this);
	}
	
	
	private void addSourceCodePosition(QLSNode node, ParserRuleContext ctx)
	{
		node.startsOnLine = ctx.getStart().getLine();
		node.startsAtCharacterPosition = ctx.getStart().getCharPositionInLine();
		node.nodeString = ctx.getStart().getText();
		node.endsOnLine = ctx.getStop().getLine();
		
		//TODO DRY
	}
	
	@Override 
	public QLSNode visitStylesheet(QLSParser.StylesheetContext ctx) 
	{ 		
		IdentifierValue identifier = new IdentifierValue(ctx.Identifier().getText());
		
		List<Page> pages = new ArrayList<Page>();
		
		for (PageContext contextualPage : ctx.page())
		{
			Page page = (Page) contextualPage.accept(this);
			pages.add(page);
		}
		
		List<DefaultDeclaration> defaultDeclarations = new ArrayList<DefaultDeclaration>();
		
		for (DefaultDeclarationContext contextualDefaulDeclaration : ctx.defaultDeclaration())
		{
			DefaultDeclaration defaultDeclaration = (DefaultDeclaration) contextualDefaulDeclaration.accept(this);
			defaultDeclarations.add(defaultDeclaration);
		}
		
		QLStylesheet stylesheet = new QLStylesheet(identifier, pages, defaultDeclarations);
		
		addSourceCodePosition(stylesheet, ctx);
		
		return stylesheet;
	}
	
	@Override 
	public QLSNode visitPage(QLSParser.PageContext ctx) 
	{ 
		IdentifierValue identifier = new IdentifierValue(ctx.Identifier().getText());
		
		List<Section> sections = new ArrayList<Section>();
		
		for (SectionContext contextualSection : ctx.section())
		{
			Section sectionDeclaration = (Section) contextualSection.accept(this);
			sections.add(sectionDeclaration);
		}
		
		List<DefaultDeclaration> defaultDeclarations = new ArrayList<DefaultDeclaration>();
		
		for (DefaultDeclarationContext contextualDefaulDeclaration : ctx.defaultDeclaration())
		{
			DefaultDeclaration defaultDeclaration = (DefaultDeclaration) contextualDefaulDeclaration.accept(this);
			defaultDeclarations.add(defaultDeclaration);
		}
		
		Page page = new Page(identifier, sections, defaultDeclarations);
		
		addSourceCodePosition(page, ctx);
		
		return page;
	}
	
	@Override 
	public QLSNode visitSection(QLSParser.SectionContext ctx) 
	{ 
		TextValue titleValue = new TextValue(QBaseHelper.removeSurroundingQuotes(ctx.Text().getText()));
		
		List<Section> sections = new ArrayList<Section>();
		
		for (SectionContext contextualSection : ctx.section())
		{
			Section section = (Section) contextualSection.accept(this);
			sections.add(section);
		}
		
		List<QuestionDeclaration> questionDeclarations = new ArrayList<QuestionDeclaration>();
		
		for (QuestionDeclarationContext contextualQuestionDeclaration : ctx.questionDeclaration())
		{
			QuestionDeclaration questionDeclaration = (QuestionDeclaration) contextualQuestionDeclaration.accept(this);
			questionDeclarations.add(questionDeclaration);
		}
		
		List<DefaultDeclaration> defaultDeclarations = new ArrayList<DefaultDeclaration>();
		
		for (DefaultDeclarationContext contextualDefaultDeclaration : ctx.defaultDeclaration())
		{
			DefaultDeclaration defaultDeclaration = (DefaultDeclaration) contextualDefaultDeclaration.accept(this);
			defaultDeclarations.add(defaultDeclaration);
		}
		
		Section section = new Section(titleValue, sections, questionDeclarations, defaultDeclarations);
		
		addSourceCodePosition(section, ctx);
		
		return section;
	}
	
	@Override 
	public QLSNode visitQuestionDeclaration(QLSParser.QuestionDeclarationContext ctx) 
	{ 
		IdentifierValue identifier = new IdentifierValue(ctx.Identifier().getText());
		
		WidgetDeclaration widgetDeclaration = null;
		
		if (ctx.widgetDeclaration() != null)
		{
			widgetDeclaration = (WidgetDeclaration) ctx.widgetDeclaration().accept(this);
		}
		
		QuestionDeclaration questionDeclaration = new QuestionDeclaration(identifier, widgetDeclaration);
		
		addSourceCodePosition(questionDeclaration, ctx);
		
		return questionDeclaration; 
	}
	
	@Override 
	public QLSNode visitDefaultDeclarationBlock(QLSParser.DefaultDeclarationBlockContext ctx) 
	{ 
		String questionTypeString = ctx.QuestionType().getText().toUpperCase();;
		
		QBaseQuestionType questionType = null;
		
		try 
		{
			questionType = QBaseQuestionType.valueOf(questionTypeString);
		} 
		catch(Exception ex) 
		{	
			//TODO
//			errors.add(new EnumRecognitionError(type, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
		}
		
		List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();
		
		for (StyleDeclarationContext contextualStyleDeclaration : ctx.styleDeclaration())
		{
			StyleDeclaration styleDeclaration = (StyleDeclaration)contextualStyleDeclaration.accept(this);
			styleDeclarations.add(styleDeclaration);
		}
		
		DefaultDeclaration defaultDeclaration = new DefaultDeclaration(questionType, styleDeclarations);
		
		addSourceCodePosition(defaultDeclaration, ctx);
		
		return defaultDeclaration; 
	}
	
	@Override 
	public QLSNode visitDefaultDeclarationSingleStatement(DefaultDeclarationSingleStatementContext ctx) 
	{ 
		String questionTypeString = ctx.QuestionType().getText();
		
		QBaseQuestionType questionType = null;
		
		try 
		{
			questionType = QBaseQuestionType.valueOf(questionTypeString);
		} 
		catch(Exception ex) 
		{
			//TODO
//			errors.add(new EnumRecognitionError(type, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine()));
		}
		
		List<StyleDeclaration> styleDeclarations = new ArrayList<StyleDeclaration>();
		
		StyleDeclaration styleDeclaration = (StyleDeclaration)ctx.styleDeclaration().accept(this);
		styleDeclarations.add(styleDeclaration);
		
		DefaultDeclaration defaultDeclaration = new DefaultDeclaration(questionType, styleDeclarations);
		
		addSourceCodePosition(defaultDeclaration, ctx);
		
		return defaultDeclaration; 
	}
	
	@Override 
	public QLSNode visitWidthDeclaration(QLSParser.WidthDeclarationContext ctx) 
	{ 
		NumberValue numberValue = new NumberValue(ctx.Number().getText());
		
		WidthDeclaration widthDeclaration = new WidthDeclaration(numberValue);
		
		addSourceCodePosition(widthDeclaration, ctx);
		
		return widthDeclaration; 
	}
	
	@Override 
	public QLSNode visitFontDeclaration(QLSParser.FontDeclarationContext ctx) 
	{ 
		IdentifierValue fontValue = new IdentifierValue(ctx.Identifier().getText());
		
		FontDeclaration fontDeclaration = new FontDeclaration(fontValue);
		
		addSourceCodePosition(fontDeclaration, ctx);
		
		return fontDeclaration; 
	}
	
	@Override 
	public QLSNode visitFontSizeDeclaration(QLSParser.FontSizeDeclarationContext ctx) 
	{ 
		NumberValue numberValue = new NumberValue(ctx.Number().getText());
		
		FontSizeDeclaration fontSizeDeclaration = new FontSizeDeclaration(numberValue);
		
		addSourceCodePosition(fontSizeDeclaration, ctx);
		
		return fontSizeDeclaration;
	}
	
	@Override 
	public QLSNode visitColorDeclaration(QLSParser.ColorDeclarationContext ctx) 
	{ 
		HexNumberValue hexNumberValue = new HexNumberValue(ctx.HexNumber().getText());
		
		ColorDeclaration colorDeclaration = new ColorDeclaration(hexNumberValue);
		
		addSourceCodePosition(colorDeclaration, ctx);
		
		return colorDeclaration;
	}
	
	@Override 
	public QLSNode visitWidgetDeclaration(QLSParser.WidgetDeclarationContext ctx) 
	{ 
		WidgetType widgetType = (WidgetType) ctx.widgetType().accept(this);
		
		WidgetDeclaration widgetDeclaration = new WidgetDeclaration(widgetType);
		
		addSourceCodePosition(widgetDeclaration, ctx);
		
		return widgetDeclaration;
	}
	
	@Override 
	public QLSNode visitCheckBoxType(QLSParser.CheckBoxTypeContext ctx) 
	{ 		
		CheckBoxWidgetType checkBoxWidgetType = new CheckBoxWidgetType();
		
		addSourceCodePosition(checkBoxWidgetType, ctx);
		
		return checkBoxWidgetType; 
	}
	
	@Override 
	public QLSNode visitSpinBoxType(QLSParser.SpinBoxTypeContext ctx) 
	{
		SpinBoxWidgetType spinBoxWidgetType = new SpinBoxWidgetType();
		
		addSourceCodePosition(spinBoxWidgetType, ctx);
		
		return spinBoxWidgetType; 
	}
	
	@Override 
	public QLSNode visitRadioButtonType(QLSParser.RadioButtonTypeContext ctx) 
	{ 
		List<TextValue> answers = new ArrayList<TextValue>();
		
		for (org.antlr.v4.runtime.Token contextualTextValue : ctx.answer)
		{
			TextValue answer = new TextValue(QBaseHelper.removeSurroundingQuotes(contextualTextValue.getText()));
			answers.add(answer);
		}
		
		RadioButtonWidgetType radioButtonWidgetType = new RadioButtonWidgetType(answers);
		
		addSourceCodePosition(radioButtonWidgetType, ctx);
		
		return radioButtonWidgetType; 
	}
}
