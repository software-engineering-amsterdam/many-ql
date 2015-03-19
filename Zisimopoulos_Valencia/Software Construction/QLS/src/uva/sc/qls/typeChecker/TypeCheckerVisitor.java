package uva.sc.qls.typeChecker;

import java.util.ArrayList;
import java.util.List;

import uva.sc.ql.gui.GUIVisitor;
import uva.sc.qls.ast.IQLSNodeVisitor;
import uva.sc.qls.ast.IQLSNode;
import uva.sc.qls.logic.ID;
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
import uva.sc.core.INode;
import uva.sc.core.types.Boolean;
import uva.sc.core.types.Number;
import uva.sc.core.types.String;
import uva.sc.core.types.Type;
import uva.sc.core.types.Undefined;
import uva.sc.qls.widgetTypes.Checkbox;
import uva.sc.qls.widgetTypes.Radio;
import uva.sc.qls.widgetTypes.Spinbox;
import uva.sc.qls.widgetTypes.UnidentifiedWidget;
import uva.sc.qls.widgetTypes.WidgetType;

public class TypeCheckerVisitor implements IQLSNodeVisitor<INode> {

	List<java.lang.String>	errors;
	List<java.lang.String>	placedQuestions;
	GUIVisitor				qlGUIVisitor;

	public TypeCheckerVisitor() {
		this.errors = new ArrayList<java.lang.String>();
		this.placedQuestions = new ArrayList<java.lang.String>();
	}

	public TypeCheckerVisitor(GUIVisitor visitor) {
		qlGUIVisitor = visitor;
		this.errors = new ArrayList<java.lang.String>();
		this.placedQuestions = new ArrayList<java.lang.String>();
		System.out.println(qlGUIVisitor.getComponentList());
	}

	public List<java.lang.String> getErrors() {
		return errors;
	}

	public List<java.lang.String> getPlacedQuestions() {
		return placedQuestions;
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
		Type widgetType = (Type) widget.accept(this);
		if (!type.equals(widgetType)) {
			errors.add("Widget incompatibility, cannot resolve type <" + type.toString() + "> to widget type <" + widget.getWidgetType().toString() + ">");
		}

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

	public Type visit(Widget widget) {
		WidgetType widgetType = widget.getWidgetType();
		widgetType = (WidgetType) widgetType.accept(this);
		return widgetType.getType();
	}

	public StyleProperty visit(StyleProperty styleProperty) {
		return null;
	}

	public Boolean visit(Boolean bool) {
		return null;
	}

	public IQLSNode visit(String str) {
		return null;
	}

	public IQLSNode visit(Number number) {
		return null;
	}

	public IQLSNode visit(Undefined unidentified) {
		return null;
	}

	public IQLSNode visit(ID id) {
		return null;
	}

	public IQLSNode visit(UnidentifiedWidget unidentifiedWidget) {
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

	public IQLSNode visit(Arial arial) {
		return new Arial();
	}

	public IQLSNode visit(Bazooka bazooka) {
		return new Bazooka();
	}

	public IQLSNode visit(BookAntiqua bookAntiqua) {
		return new BookAntiqua();
	}

	public IQLSNode visit(Courier courier) {
		return new Courier();
	}

	public IQLSNode visit(Dialog dialog) {
		return new Dialog();
	}

	public IQLSNode visit(TimesNewRoman timesNewRoman) {
		return new TimesNewRoman();
	}

	public IQLSNode visit(UndefinedFont undefinedFont) {
		return new UndefinedFont();
	}

}
