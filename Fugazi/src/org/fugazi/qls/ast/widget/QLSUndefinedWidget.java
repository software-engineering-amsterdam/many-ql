package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.UndefinedValue;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class QLSUndefinedWidget extends AbstractQLSWidget {

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
    public JComponent getJComponent() {
        throw new AssertionError();
    }

    @Override
    public UndefinedValue getValue() {
        throw new AssertionError();
    }

    @Override
    public void setValue(ExpressionValue _value) {
        throw new AssertionError();
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        throw new AssertionError();
    }

    @Override
    public void addEventListener(EventListener _listener) {
        throw new AssertionError();
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitUndefinedWidget(this);
    }
}
