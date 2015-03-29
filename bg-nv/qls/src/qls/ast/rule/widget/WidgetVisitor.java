package qls.ast.rule.widget;

/**
 * Created by bore on 10/03/15.
 */
public interface WidgetVisitor<T>
{
    T visit(Checkbox w);
    T visit(Dropdown w);
    T visit(Radio w);
    T visit(DecSlider w);
    T visit(IntSlider w);
    T visit(Textbox w);
}
