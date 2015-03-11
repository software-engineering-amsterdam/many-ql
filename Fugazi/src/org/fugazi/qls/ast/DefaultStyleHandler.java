package org.fugazi.qls.ast;

import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.question.Question;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.segment.Segment;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.visitor.FullQLSFormVisitor;
import org.fugazi.qls.ast.widget.Widget;

import java.util.List;

public class DefaultStyleHandler extends FullQLSFormVisitor {

    private final StyleSheet styledStyleSheet;
    private Segment currentSegment;
    private final QLFormDataStorage formDataStorage;

    public DefaultStyleHandler(QLFormDataStorage _formDataStorage, StyleSheet styleSheet) {
        this.formDataStorage = _formDataStorage;
        this.styledStyleSheet = styleSheet;
        this.styledStyleSheet.accept(this);
    }

    public StyleSheet getStylesheetWithStyles() {
        return styledStyleSheet;
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
        currentSegment = page;

        for (Section section : page.getSections()) {
            section.accept(this);
        }
        return null;
    }

    public Void visitSection(Section section) {

        // CurrentSegment is the parent.
        List<DefaultStyleDeclaration> parentSegmentDefaultStyles = currentSegment.getDefaultStyleDeclarations();

        // Change current segment
        currentSegment = section;

        List<DefaultStyleDeclaration> currentSegmentDefaultStyles = currentSegment.getDefaultStyleDeclarations();

        this.inheritStyles(parentSegmentDefaultStyles, currentSegmentDefaultStyles);

        this.addDeclarationsFromParent(parentSegmentDefaultStyles, currentSegmentDefaultStyles);

        for (Question question : section.getQuestions()) {
            this.setStyleToQuestion(question, currentSegmentDefaultStyles);
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

            for (DefaultStyleDeclaration currentDeclaration : _derivedSegmentDefaultStyles) {
                Type currentDeclarationType = currentDeclaration.getQuestionType();
                Style currentDeclarationStyle = currentDeclaration.getStyle();

                if (baseDeclarationType.equals(currentDeclarationType)) {
                    currentDeclarationStyle.inheriteFromStyle(baseDeclarationStyle);
                }
            }
        }
    }

    private void addDeclarationsFromParent(
            List<DefaultStyleDeclaration> _parentSegmentDefaultStyles,
            List<DefaultStyleDeclaration> _derivedSegmentDefaultStyles)
    {
        for (DefaultStyleDeclaration baseDeclaration : _parentSegmentDefaultStyles) {
            if (!_derivedSegmentDefaultStyles.contains(baseDeclaration)) {
                currentSegment.addDefaultStyleDeclaration(baseDeclaration);
            }
        }
    }

    private void setStyleToQuestion(
            Question _question, List<DefaultStyleDeclaration> _segmentDefaultStyles)
    {
        Type questionType = getQLQuestionType(_question);

        // The question does not exist in the QL Form.
        if (questionType != null) {
            if (_segmentDefaultStyles.size() == 0) {
                // if there is no default style declaration, set defaults
                this.setDefaultWidgetToQuestion(_question);
            } else {
                for (DefaultStyleDeclaration currentDeclaration : _segmentDefaultStyles) {
                    Type currentDeclarationType = currentDeclaration.getQuestionType();

                    // if there is a style declaration for the question's type
                    if (questionType.equals(currentDeclarationType)) {
                        this.setWidgetToQuestion(_question, currentDeclaration);
                    } else {
                        // if there is no default style declaration for this type, set defaults
                        this.setDefaultWidgetToQuestion(_question);
                    }
                }
            }
        }
    }

    private void setWidgetToQuestion(Question _question, DefaultStyleDeclaration _styleDeclr) {
        Type questionType = getQLQuestionType(_question);
        String questionLabel = getQLQuestionLabel(_question);

        if (questionType != null) {
            Widget currentDeclarationWidget = _styleDeclr.getWidget();
            // if the widget is undefined, set the default widget fot that type.
            if (currentDeclarationWidget.isUndefined()) {
                currentDeclarationWidget = getDefaultWidgetForType(questionType, questionLabel);
            }

            Style currentDeclarationStyle = _styleDeclr.getStyle();
            // if the style is undefined, set the default style of that widget.
            // otherwise set the right style.
            if (currentDeclarationStyle.isUndefined()) {
                currentDeclarationWidget.resetStyleToDefault();
            } else {
                currentDeclarationWidget.applyStyle(currentDeclarationStyle);
            }

            // set widget to the question.
            _question.setWidget(currentDeclarationWidget);
        }
    }

    private void setDefaultWidgetToQuestion(Question _question) {
        Type questionType = getQLQuestionType(_question);
        String questionLabel = getQLQuestionLabel(_question);

        if (questionType != null) {
            Widget defaultWidget = getDefaultWidgetForType(questionType, questionLabel);
            defaultWidget.resetStyleToDefault();
            _question.setWidget(defaultWidget);
        }
    }

    private Type getQLQuestionType(Question _question) {
        List<org.fugazi.ql.ast.statement.Question> qlQuestions = this.formDataStorage.getAllQuestions();
        for (org.fugazi.ql.ast.statement.Question qlQuestion : qlQuestions) {
            if (qlQuestion.getIdName().equals(_question.getIdName())) {
                return qlQuestion.getType();
            }
        }
        return null;
    }

    private String getQLQuestionLabel(Question _question) {
        List<org.fugazi.ql.ast.statement.Question> qlQuestions = this.formDataStorage.getAllQuestions();
        for (org.fugazi.ql.ast.statement.Question qlQuestion : qlQuestions) {
            if (qlQuestion.getIdName().equals(_question.getIdName())) {
                return qlQuestion.getLabel();
            }
        }
        return "";
    }

    private Widget getDefaultWidgetForType(Type _questionType, String _questionLabel) {
        DefaultWidgetsFactory defaultWidgetsFactory = new DefaultWidgetsFactory();
        return defaultWidgetsFactory.getDefaultWidget(_questionType, _questionLabel);
    }
}