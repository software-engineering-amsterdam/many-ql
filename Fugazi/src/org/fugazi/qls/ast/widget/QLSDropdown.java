package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.widget.widget_types.DropdownType;

import javax.swing.*;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class QLSDropdown extends AbstractQLSWidget {

    private final String yesLabel;
    private final String noLabel;

    private final JComboBox component;

    public QLSDropdown() {
        this("", "yes", "no");
    }

    public QLSDropdown(String _yes, String _no) {
        this("", _yes, _no);
    }

    public QLSDropdown(String _label, String _yes, String _no) {
        this.yesLabel = _yes;
        this.noLabel = _no;
        this.label = _label;
        this.component = new JComboBox();
        this.type = new DropdownType();
    }

    public String getYesLabel() {
        return yesLabel;
    }
    
    public String getNoLabel() {
        return noLabel;        
    }

    @Override
    public void applyStyle(Style _style) {
        this.style = _style;

        // inherit properties that are not set in the given style from default.
        this.style.inheriteFromStyle(this.getDefaultStyle());

        // todo
    }

    @Override
    public void render(UIForm _canvas) {
        _canvas.addWidget(this.component);
    }

    @Override
    public void supress(UIForm _canvas){
        _canvas.removeWidget(this.component);
    }

    @Override
    public void addEventListener(WidgetsEventListener _listener) {
        //todo
    }

    @Override
    public BoolValue getWidgetValue() {
        return new BoolValue(false);
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        // todo
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        // todo
    }

    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new BoolType());
        supportedTypes.add(new IntType());
        supportedTypes.add(new StringType());

        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitDropDown(this);
    }
}
