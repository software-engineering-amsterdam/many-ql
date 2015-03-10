package org.fugazi.qls.ast;

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

public interface IQLSASTVisitor<T> {

    public T visitStyleSheet(StyleSheet _styleSheet);

    public T visitPage(Page _page);
    public T visitSection(Section _section);
    public T visitQuestion(Question _section);

    public T visitDefaultStyleDeclr(DefaultStyleDeclaration _styleDeclr);

    public T visitColorProperty(Color _color);
    public T visitFontProperty(Font _font);
    public T visitFontSizeProperty(FontSize _fontSize);
    public T visitWidthProperty(Width _width);

    public T visitNullWidget(UndefinedWidget _widget);
    public T visitCheckBox(CheckBox _widget);
    public T visitTextBox(TextBox _widget);
    public T visitSpinBox(SpinBox _widget);
    public T visitDropDown(Dropdown _widget);
    public T visitRadioBtn(RadioBtn _widget);
    public T visitSlider(Slider _widget);
}
