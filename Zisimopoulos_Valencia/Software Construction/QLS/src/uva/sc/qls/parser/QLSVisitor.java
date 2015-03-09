package uva.sc.qls.parser;

import java.util.ArrayList;
import java.util.List;

import uva.sc.qls.ast.INode;
import uva.sc.qls.atom.ID;
import uva.sc.qls.logic.*;
import uva.sc.qls.types.Type;
import uva.sc.qls.types.Unidentified;
import uva.sc.qls.widgetTypes.UnidentifiedWidget;
import uva.sc.qls.widgetTypes.WidgetType;

public class QLSVisitor extends QLSGrammarBaseVisitor<INode>{

	private static QLSVisitor instance = null;
	
	public static QLSVisitor getInstance() {
		if (instance == null) {
			instance = new QLSVisitor();
		}
		return instance;
	}
	
	public StyleSheet visitStylesheet(QLSGrammarParser.StylesheetContext ctx) { 
		List<Page> pages = new ArrayList<Page>();
		ID id = new ID(ctx.ID().getText());
		for (QLSGrammarParser.PageContext pageContext : ctx.pages) {
			pages.add((Page)visitPage(pageContext));
		}
		return new StyleSheet(id, pages);
	}

	public Page visitPage(QLSGrammarParser.PageContext ctx) { 
		List<Section> sections = new ArrayList<Section>();
		ID id = new ID(ctx.ID().getText());
		DefaultStyle defaultStyle = null;
		if (ctx.defaultStyle() != null) {
			defaultStyle = (DefaultStyle)visitDefaultStyle(ctx.defaultStyle());
		}
		for (QLSGrammarParser.SectionContext sectionContext : ctx.sections) {
			sections.add((Section)visitSection(sectionContext));
		}
		return new Page(id, sections, defaultStyle); 
	}

	public Section visitSection(QLSGrammarParser.SectionContext ctx) {
		SectionBody sectionBody = (SectionBody)visitSectionBody(ctx.sectionBody());
		return new Section(ctx.STRING().getText(), sectionBody); 
	}
	
	public SectionBody visitSectionBody(QLSGrammarParser.SectionBodyContext ctx) { 
		List<Question> questions = new ArrayList<Question>();
		List<Section> sections = new ArrayList<Section>();
		DefaultStyle defaultStyle = null;
		for (QLSGrammarParser.QuestionContext questionContext : ctx.questions) {
			questions.add((Question)visitQuestion(questionContext));
		}
		for (QLSGrammarParser.SectionContext sectionContext : ctx.sections) {
			sections.add((Section)visitSection(sectionContext));
		}
		if (ctx.defaultStyle() != null) {
			defaultStyle = (DefaultStyle)visitDefaultStyle(ctx.defaultStyle());
		}
		return new SectionBody(questions, sections, defaultStyle);
	}

	public Question visitQuestion(QLSGrammarParser.QuestionContext ctx) {
		ID id = new ID(ctx.ID().getText());
		Widget widget = null;
		if (ctx.widget() != null) {
			widget = (Widget)visitWidget(ctx.widget());
		}
		return new Question(id, widget); 
	}
	
	public Widget visitWidget(QLSGrammarParser.WidgetContext ctx) { 
		WidgetType widgetType = (WidgetType)visitWidgetType(ctx.widgetType());
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
		Type type = (Type)visitType(ctx.type());
		Widget widget = (Widget)visitWidget(ctx.widget());
		for(QLSGrammarParser.StylePropertyContext stylePropertyContext : ctx.styleProperties) {
			stylePropertyList.add((StyleProperty)visitStyleProperty(stylePropertyContext));
		}
		return new DefaultStyle(type, stylePropertyList, widget); 
	}
	
	public StyleProperty visitStyleProperty(QLSGrammarParser.StylePropertyContext ctx) {
		ID id = new ID(ctx.ID().getText()); 
		return new StyleProperty(id); 
	}

	public Type visitType(QLSGrammarParser.TypeContext ctx) {  
		String type = ctx.getText();
		Type result = new Unidentified();
		switch (type){
			case "boolean": 
				result = new uva.sc.qls.types.Boolean(); 
				break;
			case "number" : 
				result = new uva.sc.qls.types.Number(); 	
				break;
			case "string" : 
				result = new uva.sc.qls.types.String(); 
				break;
		}
		return result;
	}
	
	public WidgetType visitWidgetType(QLSGrammarParser.WidgetTypeContext ctx) { 
		String type = ctx.getText();
		WidgetType result = new UnidentifiedWidget();
		switch (type){
			case "checkbox": 
				result = new uva.sc.qls.widgetTypes.Checkbox(); 
				break;
			case "spinbox" : 
				result = new uva.sc.qls.widgetTypes.Spinbox(); 
				break;
			case "radio" : 
				result = new uva.sc.qls.widgetTypes.Radio(); 
				break;
		}
		return result;
	}

	public INode visitNumber(QLSGrammarParser.NumberContext ctx) { 
		return null; 
	}

	public INode visitBoolean(QLSGrammarParser.BooleanContext ctx) { 
		return null; 
	}

	public ID visitId(QLSGrammarParser.IdContext ctx) { 
		return new ID(ctx.ID().getText()); 
	}

	public INode visitString(QLSGrammarParser.StringContext ctx) { 
		return null;
	}

	public INode visitColorencode(QLSGrammarParser.ColorencodeContext ctx) { 
		return null; 
	}
}
