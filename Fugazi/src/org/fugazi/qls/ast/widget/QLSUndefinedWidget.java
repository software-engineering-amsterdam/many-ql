package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.UndefinedValue;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.widget.widget_types.UndefinedWidgetType;

import java.util.ArrayList;
import java.util.List;

public class QLSUndefinedWidget extends AbstractQLSWidget {

    public QLSUndefinedWidget() {
        this.type = new UndefinedWidgetType();
    }

    @Override
    public void applyStyle(Style _style) {
        throw new AssertionError();
    }

    @Override
    public boolean isUndefined() {
        return true;
    }

    public List<Type> getSupportedQuestionTypes() {
        return new ArrayList<>();
    }

    @Override
    public void render(UIForm _canvas) {
        throw new AssertionError();
    }

    @Override
    public void suppress(UIForm _canvas){
        throw new AssertionError();
    }

    @Override
    public UndefinedValue getWidgetValue() {
        throw new AssertionError();
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        throw new AssertionError();
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        throw new AssertionError();
    }

    @Override
    public void addEventListener(WidgetsEventListener _listener) {
        throw new AssertionError();
    }

    @Override
    public void setLabel(String _label) {
        throw new AssertionError();
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitUndefinedWidget(this);
    }
}
