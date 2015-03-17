package org.fugazi.qls.ast.stylesheet.stylesheet_data.visitor;


import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;
import org.fugazi.qls.ast.style.style_property.Color;
import org.fugazi.qls.ast.style.style_property.Font;
import org.fugazi.qls.ast.style.style_property.FontSize;
import org.fugazi.qls.ast.style.style_property.Width;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.widget.*;

import java.util.List;

/*
 This class performs a full QLS AST Tree traversal.
 Class can inherit and override methods where they
 need to perform additional actions.
 */
public abstract class FullQLSFormVisitor implements IQLSASTVisitor<Void> {

    public Void visitStyleSheet(StyleSheet styleSheet) {
        List<Page> pages = styleSheet.getPages();

        for (Page page : pages) {
            page.accept(this);
        }

        return null;
    }

    public Void visitPage(Page page) {
        List<Section> sections = page.getSections();
        List<DefaultStyleDeclaration> defaultStyles = page.getDefaultStyleDeclarations();

        for (Section section : sections) {
            section.accept(this);
        }
        for (DefaultStyleDeclaration declaration : defaultStyles) {
            declaration.accept(this);
        }

        return null;
    }

    public Void visitSection(Section section) {
        List<Section> subsections = section.getSections();
        List<DefaultStyleDeclaration> defaultStyles = section.getDefaultStyleDeclarations();
        List<QLSQuestion> questions = section.getQuestions();

        for (Section subsection : subsections) {
            subsection.accept(this);
        }
        for (DefaultStyleDeclaration declaration : defaultStyles) {
            declaration.accept(this);
        }
        for (QLSQuestion question : questions) {
            question.accept(this);
        }

        return null;
    }

    public Void visitQuestion(QLSQuestion question) {
        AbstractQLSWidget widget = question.getWidget();
        widget.accept(this);

        return null;
    }

    public Void visitDefaultStyleDeclr(DefaultStyleDeclaration styleDeclr) {
        return null;
    }

    public Void visitColorProperty(Color _color) {
        return null;
    }
    
    public Void visitFontProperty(Font _font) {
        return null;
    }
    
    public Void visitFontSizeProperty(FontSize _fontSize) {
        return null;
    }
    
    public Void visitWidthProperty(Width _width) {
        return null;
    }

    public Void visitUndefinedWidget(QLSUndefinedWidget _widget) {
        return null;
    }
    
    public Void visitCheckBox(QLSCheckBox _widget) {
        return null;
    }
    
    public Void visitTextBox(QLSTextBox _widget) {
        return null;
    }
    
    public Void visitSpinBox(QLSSpinBox _widget) {
        return null;
    }
    
    public Void visitDropDown(QLSDropdown _widget) {
        return null;
    }
    
    public Void visitRadioBtn(QLSRadioBtn _widget) {
        return null;
    }
    
    public Void visitSlider(QLSSlider _widget)  {
        return null;
    }
}
