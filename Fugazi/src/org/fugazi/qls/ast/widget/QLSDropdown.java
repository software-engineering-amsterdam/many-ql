package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

        String[] valueArray = {this.yesLabel, this.noLabel};
        this.component = new JComboBox(valueArray);
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
        this.component.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _listener.stateChanged();
            }
        });
    }

    @Override
    public BoolValue getWidgetValue() {
        String selectedValue = (String) this.component.getSelectedItem();
        if (selectedValue.equals(this.yesLabel)) {
            return  new BoolValue(true);
        }
        return new BoolValue(false);
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        BoolValue value = (BoolValue) _value;
        if (value.getValue().equals(true)) {
            this.component.setSelectedItem(this.yesLabel);
        } else {
            this.component.setSelectedItem(this.noLabel);
        }
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.component.setEnabled(false);
    }

    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new BoolType());

        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitDropDown(this);
    }
}
