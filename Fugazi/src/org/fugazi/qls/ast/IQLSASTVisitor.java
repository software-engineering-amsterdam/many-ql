package org.fugazi.qls.ast;

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

public interface IQLSASTVisitor<T> {

    public T visitStyleSheet(StyleSheet _styleSheet);

    public T visitPage(Page _page);
    public T visitSection(Section _section);
    public T visitQuestion(QLSQuestion _section);

    public T visitDefaultStyleDeclr(DefaultStyleDeclaration _styleDeclr);

    public T visitColorProperty(Color _color);
    public T visitFontProperty(Font _font);
    public T visitFontSizeProperty(FontSize _fontSize);
    public T visitWidthProperty(Width _width);

    public T visitUndefinedWidget(QLSUndefinedWidget _widget);
    public T visitCheckBox(QLSCheckBox _widget);
    public T visitTextBox(QLSTextBox _widget);
    public T visitSpinBox(QLSSpinBox _widget);
    public T visitDropDown(QLSDropdown _widget);
    public T visitRadioBtn(QLSRadioBtn _widget);
    public T visitSlider(QLSSlider _widget);
}
