package lang.qls.ast.rule.widget;

import com.sun.tools.javac.comp.Check;

/**
 * Created by bore on 10/03/15.
 */
public interface WidgetVisitor<T>
{
    T visit(Checkbox w);
    T visit(Dropdown w);
    T visit(Radio w);
    T visit(Slider w);
    T visit(Spinbox w);
    T visit(Textbox w);

}
