package nl.uva.softwcons.qls.ast.widget.type;

import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.qls.ast.ASTNode;

public abstract class WidgetType implements ASTNode {

    public abstract boolean isCompatibleWith(Type type);

    public abstract <T> T accept(WidgetTypeVisitor<T> visitor);

}
