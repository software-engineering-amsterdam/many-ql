package qls.ast.rule;

/**
 * Created by bore on 03/03/15.
 */
public interface RuleVisitor<T>
{
    T visit(Width r);
    T visit(Font r);
    T visit(FontSize r);
    T visit(BackColor r);
    T visit(ForeColor r);
    T visit(Widget r);
}
