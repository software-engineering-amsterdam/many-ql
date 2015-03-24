package org.fugazi.qls.ast.style;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.widget.widget_types.IWidgetType;

public class DefaultStyleDeclaration extends AbstractASTNode {

    private Style style;
    private final IWidgetType widgetType;
    private final Type questionType;

    public DefaultStyleDeclaration(
            Style _style, IWidgetType _widgetType, Type _questionType)
    {
        this.style = _style;
        this.widgetType = _widgetType;
        this.questionType = _questionType;
    }

    public Style getStyle() {
        return this.style;
    }

    public void setStyle(Style _style) {
        this.style = _style;
    }

    public IWidgetType getWidgetType() {
        return widgetType;
    }

    public Type getQuestionType() {
        return questionType;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitDefaultStyleDeclr(this);
    }

    @Override
    public boolean equals(Object o){
        if (o == null) {
            return false;
        }

        if (!(o instanceof DefaultStyleDeclaration)) {
            return false;
        }

        DefaultStyleDeclaration other = (DefaultStyleDeclaration) o;
        return (this.questionType.toString() == other.questionType.toString());
    }
}
