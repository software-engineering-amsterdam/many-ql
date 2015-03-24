package org.fugazi.qls.ast;

import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.segment.Segment;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.visitor.FullQLSFormVisitor;
import org.fugazi.qls.ast.widget.AbstractQLSWidget;
import org.fugazi.qls.ast.widget.widget_types.IWidgetType;
import org.fugazi.qls.ast.widget.widget_types.WidgetTypeToWidgetVisitor;

import java.util.HashMap;
import java.util.List;

public class DefaultStyleHandler extends FullQLSFormVisitor {

    private final StyleSheet styledStyleSheet;
    private Segment currentSegment;
    private final QLFormDataStorage formDataStorage;
    private final DefaultWidgetsFactory defaultWidgetsFactory = new DefaultWidgetsFactory();
    private final WidgetTypeToWidgetVisitor widgetTypeToWidget = new WidgetTypeToWidgetVisitor();

    public DefaultStyleHandler(QLFormDataStorage _formDataStorage, StyleSheet _styleSheet) {
        this.formDataStorage = _formDataStorage;
        this.styledStyleSheet = _styleSheet;
        this.styledStyleSheet.accept(this);
    }

    public StyleSheet getStylesheetWithStyles() {
        return this.styledStyleSheet;
    }

    public Void visitStyleSheet(StyleSheet styleSheet){
        List<Page> pages = styleSheet.getPages();
        for (Page page : pages) {
            page.accept(this);
        }
        return null;
    }

    public Void visitPage(Page page){
        // set current segment
        this.currentSegment = page;

        for (Section section : page.getSections()) {
            section.accept(this);
        }
        return null;
    }

    public Void visitSection(Section section) {

        // currentSegment is the parent.
        List<DefaultStyleDeclaration> parentSegmentDefaultStyles = this.currentSegment.getDefaultStyleDeclarations();

        this.currentSegment = section;// Change current segment
        List<DefaultStyleDeclaration> currentSegmentDefaultStyles = this.currentSegment.getDefaultStyleDeclarations();

        this.inheritStyles(parentSegmentDefaultStyles, currentSegmentDefaultStyles);
        this.addDeclarationsFromParent(parentSegmentDefaultStyles, currentSegmentDefaultStyles);

        for (QLSQuestion question : section.getQuestions()) {
            this.constructQuestion(question, currentSegmentDefaultStyles);
        }

        // visit sub sections.
        for (Section subsection : section.getSections()) {
            subsection.accept(this);
        }

        return null;
    }

    private void inheritStyles(
            List<DefaultStyleDeclaration> _parentSegmentDefaultStyles,
            List<DefaultStyleDeclaration> _derivedSegmentDefaultStyles)
    {
        for (DefaultStyleDeclaration baseDeclaration : _parentSegmentDefaultStyles) {
            Type baseDeclarationType = baseDeclaration.getQuestionType();
            Style baseDeclarationStyle = baseDeclaration.getStyle();

            // if there is no style declaration,
            // but only widget declaration then set widget's default style.
            if (baseDeclaration.getStyle().isUndefined()) {

                // get the default style of a widget, for it's type.
                IWidgetType widgetType = baseDeclaration.getWidgetType();
                AbstractQLSWidget widget = widgetType.accept(this.widgetTypeToWidget);
                Style defaultStyleOfWidget = widget.getDefaultStyle();

                // set the style.
                baseDeclaration.setStyle(defaultStyleOfWidget);
            } else {
                this.inheriteStyleFromParent(
                        _derivedSegmentDefaultStyles, baseDeclarationType, baseDeclarationStyle);
            }
        }
    }

    private void inheriteStyleFromParent(
            List<DefaultStyleDeclaration> _derivedSegmentDefaultStyles,
            Type _baseDeclarationType,
            Style _baseDeclarationStyle)
    {
        for (DefaultStyleDeclaration currentDeclaration : _derivedSegmentDefaultStyles) {
            Type currentDeclarationType = currentDeclaration.getQuestionType();
            Style currentDeclarationStyle = currentDeclaration.getStyle();
            if (_baseDeclarationType.equals(currentDeclarationType)) {
                currentDeclarationStyle.inheriteFromStyle(_baseDeclarationStyle);
            }
        }
    }

    private void addDeclarationsFromParent(
            List<DefaultStyleDeclaration> _parentSegmentDefaultStyles,
            List<DefaultStyleDeclaration> _derivedSegmentDefaultStyles)
    {
        for (DefaultStyleDeclaration baseDeclaration : _parentSegmentDefaultStyles) {
            if (!_derivedSegmentDefaultStyles.contains(baseDeclaration)) {
                this.currentSegment.addDefaultStyleDeclaration(baseDeclaration);
            }
        }
    }

    private void constructQuestion(
            QLSQuestion _question, List<DefaultStyleDeclaration> _segmentDefaultStyles)
    {
        // The question does not exist in the QL Form, ignore (leave it as Undefined)
        if (!isQuestionExistsInQL(_question)) {
            return;
        }
        
        // if there is no default style declaration
        if (_segmentDefaultStyles.size() == 0) {

            if (_question.getWidget().isUndefined()) {
                this.setDefaultWidgetToQuestion(_question);
            } else {
                this.setDefaultStyleToWidget(_question.getWidget());
            }

        } else {
            // if is undefined, set from declarations.
            if (_question.getWidget().isUndefined()) {
                this.setWidgetFromDeclaration(_question, _segmentDefaultStyles);
            } else {
                // else set style to the widget.
                this.styleQuestionFormDeclarations(_question, _segmentDefaultStyles);
            }
        }
    }

    private void setWidgetToQuestion(QLSQuestion _question, DefaultStyleDeclaration _styleDeclr) {
        Type questionType = getQLQuestionType(_question);
        String questionLabel = getQLQuestionLabel(_question);

        IWidgetType currentDeclarationWidgetType = _styleDeclr.getWidgetType();
        AbstractQLSWidget currentDeclarationWidget
                = currentDeclarationWidgetType.accept(this.widgetTypeToWidget);

        // if the widget is undefined, set the default widget fot that type.
        if (currentDeclarationWidget.isUndefined()) {
            currentDeclarationWidget = getDefaultWidgetForType(questionType, questionLabel);
        }

        Style currentDeclarationStyle = _styleDeclr.getStyle();
        
        // if the style is undefined, set the default style of that widget.
        // otherwise set the right style.
        if (currentDeclarationStyle.isUndefined()) {
            currentDeclarationWidget.resetStyleToDefault();
            currentDeclarationWidget.setLabel(questionLabel);
        } else {
            currentDeclarationWidget.applyStyle(currentDeclarationStyle);
        }

        // set widget to the question.
        _question.setWidget(currentDeclarationWidget);
    }
    
    private void setWidgetFromDeclaration(
            QLSQuestion _question,
            List<DefaultStyleDeclaration> _segmentDefaultStyles)
    {
        boolean isSet = false;

        for (DefaultStyleDeclaration currentDeclaration : _segmentDefaultStyles) {
            Type questionType = this.getQLQuestionType(_question);
            Type currentDeclarationType = currentDeclaration.getQuestionType();

            // if there is a style declaration for the question's type
            if (questionType.equals(currentDeclarationType)) {
                this.setWidgetToQuestion(_question, currentDeclaration);
                isSet = true;
                break;
            }
        }

        // if there is no default style declaration for this type, set defaults
        if (!isSet) {
            this.setDefaultWidgetToQuestion(_question);
        }
    }
    
    private void styleQuestionFormDeclarations(QLSQuestion _question, List<DefaultStyleDeclaration> _segmentDefaultStyles) {
        boolean isWidgetFoundInDeclaration = false;

        for (DefaultStyleDeclaration currentDeclaration : _segmentDefaultStyles) {

            // if the widget has been found in declarations, set the style.
            if (_question.getWidget().getType().equals(currentDeclaration.getWidgetType())) {
                this.setWidgetToQuestion(_question, currentDeclaration);
                isWidgetFoundInDeclaration = true;
                break;
            }
        }

        // if not set default
        if (!isWidgetFoundInDeclaration) {
            this.setDefaultStyleToWidget(_question.getWidget());
        }
    }
    
    private void setDefaultWidgetToQuestion(QLSQuestion _question) {
        Type questionType = getQLQuestionType(_question);
        String questionLabel = getQLQuestionLabel(_question);

        AbstractQLSWidget defaultWidget = getDefaultWidgetForType(questionType, questionLabel);
        this.setDefaultStyleToWidget(defaultWidget);
        _question.setWidget(defaultWidget);
    }

    private void setDefaultStyleToWidget(AbstractQLSWidget _widget) {
        _widget.resetStyleToDefault();
    }

    private boolean isQuestionExistsInQL(QLSQuestion _question) {
        List<org.fugazi.ql.ast.statement.Question> qlQuestions = this.formDataStorage.getAllQuestions();
        for (org.fugazi.ql.ast.statement.Question qlQuestion : qlQuestions) {
            if (qlQuestion.getIdName().equals(_question.getIdName())) {
                return true;
            }
        }
        return false;
    }
     
    private Type getQLQuestionType(QLSQuestion _question) {
        String questionIdName = _question.getIdName();
        HashMap<String, Type> questionTypes = this.formDataStorage.getallQuestionTypes();
        return questionTypes.get(questionIdName);
    }

    private String getQLQuestionLabel(QLSQuestion _question) {
        List<org.fugazi.ql.ast.statement.Question> qlQuestions = this.formDataStorage.getAllQuestions();
        for (org.fugazi.ql.ast.statement.Question qlQuestion : qlQuestions) {
            if (qlQuestion.getIdName().equals(_question.getIdName())) {
                return qlQuestion.getLabel();
            }
        }
        return "";
    }

    private AbstractQLSWidget getDefaultWidgetForType(Type _questionType, String _questionLabel) {        
        return defaultWidgetsFactory.getDefaultWidget(_questionType, _questionLabel);
    }
}