package nl.uva.softwcons.qls.ast.widget;

import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.qls.ast.ASTNode;

public class StylizedType implements ASTNode {
    private final Type questionType;
    private final StylizedWidget widget;

    public StylizedType(final Type type, final StylizedWidget widget) {
        this.questionType = type;
        this.widget = widget;
    }

    public Type getQuestionType() {
        return questionType;
    }

    public StylizedWidget getWidget() {
        return widget;
    }

}
