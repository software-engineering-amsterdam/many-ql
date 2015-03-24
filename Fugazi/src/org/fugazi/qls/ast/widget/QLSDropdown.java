package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.widget.widget_types.DropdownType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QLSDropdown extends AbstractQLSWidget {

    private final String yesLabel;
    private final String noLabel;

    private final JPanel panel;
    private final JLabel componentLabel;
    private final JComboBox comboBox;

    public QLSDropdown() {
        this("", "yes", "no");
    }

    public QLSDropdown(String _yes, String _no) {
        this("", _yes, _no);
    }

    public QLSDropdown(String _label, String _yes, String _no) {
        this.yesLabel = _yes;
        this.noLabel = _no;

        this.panel = new JPanel();
        this.componentLabel = new JLabel(_label);

        String[] valueArray = {this.yesLabel, this.noLabel};
        this.comboBox = new JComboBox(valueArray);

        this.panel.add(this.componentLabel);
        this.panel.add(this.comboBox);

        this.type = new DropdownType();
    }

    @Override
    public void applyStyle(Style _style) {
        Style style = _style;

        // inherit properties that are not set in the given style from default.
        style.inheriteFromStyle(this.getDefaultStyle());

        Font font = new Font(
            _style.getFont(this.getDefaultFont().getValue()), 0,
            _style.getFontSize(this.getDefaultFontSize().getValue())
        );
        this.componentLabel.setFont(font);

        Color color = style.getColor(this.getDefaultColor().getValue());
        this.componentLabel.setForeground(color);

        this.comboBox.setPreferredSize(new Dimension(
                this.getDefaultWidth().getValue(),
                (int) this.comboBox.getPreferredSize().getHeight()
        ));
    }

    @Override
    public void render(UIForm _canvas) {
        _canvas.addWidget(this.panel);
    }

    @Override
    public void suppress(UIForm _canvas){
        _canvas.removeWidget(this.panel);
    }

    @Override
    public void addEventListener(WidgetsEventListener _listener) {
        this.comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _listener.stateChanged();
            }
        });
    }

    @Override
    public BoolValue getWidgetValue() {
        String selectedValue = (String) this.comboBox.getSelectedItem();
        if (selectedValue.equals(this.yesLabel)) {
            return  new BoolValue(true);
        }
        return new BoolValue(false);
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        BoolValue value = (BoolValue) _value;
        if (value.getValue().equals(true)) {
            this.comboBox.setSelectedItem(this.yesLabel);
        } else {
            this.comboBox.setSelectedItem(this.noLabel);
        }
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.comboBox.setEnabled(false);
    }

    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new BoolType());

        return supportedTypes;
    }

    @Override
    public void setLabel(String _label) {
        this.componentLabel.setText(_label);
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitDropDown(this);
    }
}
