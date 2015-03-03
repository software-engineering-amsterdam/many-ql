package lang.qls.ast.Rule;

import lang.qls.ast.Rule.Widget.CheckBox;
import lang.qls.ast.Rule.Widget.Radio;
import lang.qls.ast.Rule.Widget.SpinBox;

/**
 * Created by bore on 03/03/15.
 */
public interface RuleVisitor<T>
{
    T visit(Width w);
    T visit(Font f);
    T visit(FontSize fs);
    T visit(Color c);

    T visit(CheckBox c);
    T visit(Radio c);
    T visit(SpinBox c);
}
