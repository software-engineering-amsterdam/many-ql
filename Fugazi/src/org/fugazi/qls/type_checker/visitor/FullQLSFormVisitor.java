package org.fugazi.qls.type_checker.visitor;


import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.question.Question;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;
import org.fugazi.qls.ast.style.style_property.Color;
import org.fugazi.qls.ast.style.style_property.Font;
import org.fugazi.qls.ast.style.style_property.FontSize;
import org.fugazi.qls.ast.style.style_property.Width;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.widget.*;

public class FullQLSFormVisitor implements IQLSASTVisitor<Void> {


    public Void visitStyleSheet(StyleSheet _styleSheet){
        return null;
    }

    public Void visitPage(Page _page){
        return null;
    }
    public Void visitSection(Section _section){
        return null;
    }
    public Void visitQuestion(Question _section){
        return null;
    }

    public Void visitDefaultStyleDeclr(DefaultStyleDeclaration _styleDeclr){
        return null;
    }

    public Void visitColorProperty(Color _color){
        return null;
    }
    public Void visitFontProperty(Font _font){
        return null;
    }
    public Void visitFontSizeProperty(FontSize _fontSize){
        return null;
    }
    public Void visitWidthProperty(Width _width){
        return null;
    }

    public Void visitNullWidget(UndefinedWidget _widget){
        return null;
    }
    public Void visitCheckBox(CheckBox _widget){
        return null;
    }
    public Void visitTextBox(TextBox _widget){return null;}
    public Void visitSpinBox(SpinBox _widget){return null;}
    public Void visitDropDown(Dropdown _widget){return null;}
    public Void visitRadioBtn(RadioBtn _widget){return null;}
    public Void visitSlider(Slider _widget){return null;}
}
