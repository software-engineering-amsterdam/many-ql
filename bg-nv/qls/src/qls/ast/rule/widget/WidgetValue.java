package qls.ast.rule.widget;

import ql.ast.AstNode;
import ql.ast.type.Type;

/**
 * Created by bore on 08/03/15.
 */
public abstract class WidgetValue extends AstNode
{
    public abstract boolean isCompatibleWithType(Type t);

    public abstract <T> T accept(WidgetVisitor<T> visitor);
}
