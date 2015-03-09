package lang.qls.ast.Rule;

/**
 * Created by bore on 03/03/15.
 */
public interface RuleVisitor<T>
{
    T visit(IntRule r);
    T visit(StrRule r);
    T visit(WidgetRule r);
}
