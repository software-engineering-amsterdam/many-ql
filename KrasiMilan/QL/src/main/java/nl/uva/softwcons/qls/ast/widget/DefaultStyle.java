package nl.uva.softwcons.qls.ast.widget;

import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.qls.ast.ASTNode;

public class DefaultStyle implements ASTNode {
    private final Type questionType;
    private final Widget widget;

    public DefaultStyle(final Type type, final Widget widget) {
        this.questionType = type;
        this.widget = widget;
    }

    public Type getQuestionType() {
        return questionType;
    }

    public Widget getWidget() {
        return widget;
    }

}
