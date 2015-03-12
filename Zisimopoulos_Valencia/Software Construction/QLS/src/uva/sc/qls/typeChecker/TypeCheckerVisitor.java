package uva.sc.qls.typeChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uva.sc.qls.ast.INodeVisitor;
import uva.sc.qls.ast.INode;
import uva.sc.qls.atom.ID;
import uva.sc.qls.logic.Page;
import uva.sc.qls.logic.Question;
import uva.sc.qls.logic.Section;
import uva.sc.qls.logic.SectionBody;
import uva.sc.qls.logic.StyleSheet;
import uva.sc.qls.logic.Widget;
import uva.sc.qls.logic.fonts.Arial;
import uva.sc.qls.logic.fonts.Bazooka;
import uva.sc.qls.logic.fonts.BookAntiqua;
import uva.sc.qls.logic.fonts.Courier;
import uva.sc.qls.logic.fonts.Dialog;
import uva.sc.qls.logic.fonts.TimesNewRoman;
import uva.sc.qls.logic.fonts.UndefinedFont;
import uva.sc.qls.logic.style.DefaultStyle;
import uva.sc.qls.logic.style.StyleProperty;
import uva.sc.qls.types.Boolean;
import uva.sc.qls.types.Number;
import uva.sc.qls.types.String;
import uva.sc.qls.types.Type;
import uva.sc.qls.types.Unidentified;
import uva.sc.qls.widgetTypes.Checkbox;
import uva.sc.qls.widgetTypes.Radio;
import uva.sc.qls.widgetTypes.Spinbox;
import uva.sc.qls.widgetTypes.UnidentifiedWidget;
import uva.sc.qls.widgetTypes.WidgetType;

public class TypeCheckerVisitor implements INodeVisitor<INode> {

	List<java.lang.String> errors;
	List<java.lang.String> placedQuestions;
	
	final Map<java.lang.String, List<java.lang.String>> widgetCompatibility;
	
	public TypeCheckerVisitor() {
		this.errors = new ArrayList<java.lang.String>();
		this.placedQuestions = new ArrayList<java.lang.String>();
		this.widgetCompatibility = new HashMap<java.lang.String, List<java.lang.String>>();
		populateWidgetCompatibilityMap();
	}
	
	public List<java.lang.String> getErrors() {
		return errors;
	}

	public List<java.lang.String> getPlacedQuestions() {
		return placedQuestions;
	}
	
	public void populateWidgetCompatibilityMap() {
		List<java.lang.String> widgets = new ArrayList<java.lang.String>();
		widgets.add("[WidgetType]: radio");
		widgets.add("[WidgetType]: checkbox");
		this.widgetCompatibility.put("[Type]: boolean", widgets);
		widgets = new ArrayList<java.lang.String>();
		widgets.add("[WidgetType]: spinbox");
		this.widgetCompatibility.put("[Type]: number", widgets);
	}

	public StyleSheet visit(StyleSheet styleSheet) {
		ID id = styleSheet.getId();
		id.accept(this);
		
		for (Page page : styleSheet.getPages()) {
			page.accept(this);
		}
		return null;
	}

	public Page visit(Page page) {
		ID id = page.getId();
		id.accept(this);
		
		for (Section section : page.getSections()) {
			section.accept(this);
		}
		
		if (page.getDefaultStyle() != null) {
			DefaultStyle defaultStyle = page.getDefaultStyle();
			defaultStyle.accept(this);
		}
		return null;
	}

	public DefaultStyle visit(DefaultStyle defaultStyle) {
		Type type = defaultStyle.getType();
		Widget widget = defaultStyle.getWidget();
		java.lang.String typeName = type.toString();
		java.lang.String widgetName = widget.getWidgetType().toString();
		List<java.lang.String> compatibleWidgets = widgetCompatibility.get(typeName);
		if (!compatibleWidgets.contains(widgetName)) {
			errors.add("Widget incompatibility, cannot resolve type <" + typeName + 
					"> to widget type <" + widgetName + ">");
		}
		
		type.accept(this);
		
		for (StyleProperty styleProperty : defaultStyle.getStyleProperty()) {
			styleProperty.accept(this);
		}

		widget.accept(this);
		return null;
	}

	public Question visit(Question question) {
		java.lang.String questionId = question.getId().toString();
		if (!placedQuestions.contains(questionId)) {
			placedQuestions.add(questionId);
		}
		else {
			errors.add("Duplicated question <" + questionId + ">");
		}
		
		ID id = question.getId();
		id.accept(this);
		
		if (question.getWidget() != null) {
			Widget widget = question.getWidget();
			widget.accept(this);
		}
		return null;
	}

	public Section visit(Section section) {
		SectionBody sectionBody = section.getSectionBody();
		sectionBody.accept(this);
		return null;
	}

	public SectionBody visit(SectionBody sectionBody) {
		for (Question question : sectionBody.getQuestions()) {
			question.accept(this);
		}
		
		for (Section section : sectionBody.getSections()) {
			section.accept(this);
		}
		
		if (sectionBody.getDefaultStyle() != null) {
			DefaultStyle defaultStyle = sectionBody.getDefaultStyle();
			defaultStyle.accept(this);
		}
		return null;
	}

	public Widget visit(Widget widget) {
		WidgetType widgetType = widget.getWidgetType();
		widgetType.accept(this);
		return null;
	}

	public StyleProperty visit(StyleProperty styleProperty) {
		return null;
	}

	public Boolean visit(Boolean bool) {
		return null;
	}

	public INode visit(String str) {
		return null;
	}

	public INode visit(Number number) {
		return null;
	}

	public INode visit(Unidentified unidentified) {
		return null;
	}

	public INode visit(ID id) {
		return null;
	}

	public INode visit(UnidentifiedWidget unidentifiedWidget) {
		return null;
	}

	public Checkbox visit(Checkbox checkbox) {
		return new Checkbox();
	}

	public Spinbox visit(Spinbox spinbox) {
		return new Spinbox();
	}

	public Radio visit(Radio radio) {
		return new Radio();
	}

	public INode visit(Arial arial) {
		return null;
	}

	public INode visit(Bazooka bazooka) {
		return null;
	}

	public INode visit(BookAntiqua bookAntiqua) {
		return null;
	}

	public INode visit(Courier courier) {
		return null;
	}

	public INode visit(Dialog dialog) {
		return null;
	}

	public INode visit(TimesNewRoman timesNewRoman) {
		return null;
	}

	public INode visit(UndefinedFont undefinedFont) {
		return null;
	}

}
