package org.fugazi.qls.ast;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
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

    public DefaultStyleHandler(StyleSheet styleSheet) {
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
        List<DefaultStyleDeclaration> parentSegmentDefaultStyles =
                currentSegment.getDefaultStyleDeclarations();

        // Change current segment
        currentSegment = section;
        List<DefaultStyleDeclaration> currentSegmentDefaultStyles =
                currentSegment.getDefaultStyleDeclarations();

        // for every base declaration.
        for (DefaultStyleDeclaration baseDeclaration : parentSegmentDefaultStyles) {
            Type baseDeclarationType = baseDeclaration.getQuestionType();
            Style baseDeclarationStyle = baseDeclaration.getStyle();

            // for every current declaration.
            for (DefaultStyleDeclaration currentDeclaration : currentSegmentDefaultStyles) {
                Type currentDeclarationType = currentDeclaration.getQuestionType();
                Style currentDeclarationStyle = currentDeclaration.getStyle();

                // if the base declaration for a type exists in the current declarations.
                // then inherit style from parent.
                if (baseDeclarationType.equals(currentDeclarationType)) {
                    currentDeclarationStyle.inheriteFromStyle(baseDeclarationStyle);
                }
            }
        }

        // for every base declaration.
        for (DefaultStyleDeclaration baseDeclaration : parentSegmentDefaultStyles) {

            // if there is no such declaration on current segment,
            // add it from the parent.
            if (!currentSegmentDefaultStyles.contains(baseDeclaration)) {
                currentSegment.addDefaultStyleDeclaration(baseDeclaration);
            }
        }

        for (Question question : section.getQuestions()) {
            Type questionType = getQuestionType(question);

            for (DefaultStyleDeclaration currentDeclaration : currentSegmentDefaultStyles) {
                Type currentDeclarationType = currentDeclaration.getQuestionType();

                // if there is a style declaration for the question's type
                if (questionType.equals(currentDeclarationType)) {

                    Widget currentDeclarationWidget = currentDeclaration.getWidget();
                    // if the widget is undefined, set the default widget fot that type.
                    if (currentDeclarationWidget.isUndefined()) {
                        currentDeclarationWidget = getDefaultWidgetForType(questionType);
                    }

                    Style currentDeclarationStyle = currentDeclaration.getStyle();
                    // if the style is undefined, set the default style of that widget.
                    // otherwise set the right style.
                    if (currentDeclarationStyle.isUndefined()) {
                        currentDeclarationWidget.resetStyleToDefault();
                    } else {
                        currentDeclarationWidget.applyStyle(currentDeclarationStyle);
                    }

                    // set widget to the question.
                    question.setWidget(currentDeclarationWidget);
                } else {
                    // if there is no default style declaration, set defaults
                    Widget defaultWidget = getDefaultWidgetForType(questionType);
                    defaultWidget.resetStyleToDefault();
                    question.setWidget(defaultWidget);
                }
            }
        }

        // visit sub sections.
        for (Section subsection : section.getSections()) {
            subsection.accept(this);
        }

        return null;
    }

    private Type getQuestionType(Question _question) {
        // todo
        return new IntType();
    }

    private Widget getDefaultWidgetForType(Type _questionType) {
        DefaultWidgetsFactory defaultWidgetsFactory = new DefaultWidgetsFactory();
        return defaultWidgetsFactory.getDefaultWidget(_questionType);
    }
}