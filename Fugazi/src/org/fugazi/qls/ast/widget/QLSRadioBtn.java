package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.widget.widget_types.RadioBtnType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QLSRadioBtn extends AbstractQLSWidget {

    private String actionCommandValue;
    private final String yesLabel;
    private final String noLabel;

    private JPanel panel;
    private JLabel componentLabel;
    private ButtonGroup radioButtonGroup;
    private JRadioButton yesBtn;
    private JRadioButton noBtn;

    public QLSRadioBtn() {
        this("", "yes", "no");
    }

    public QLSRadioBtn(String _yes, String _no) {
        this("", _yes, _no);
    }

    public QLSRadioBtn(String _label, String _yes, String _no) {
        this.yesLabel = _yes;
        this.noLabel = _no;

        this.panel = new JPanel();
        this.componentLabel = new JLabel(_label);

        this.yesBtn = new JRadioButton(_yes);
        this.noBtn = new JRadioButton(_no);
        this.radioButtonGroup = new ButtonGroup();

        this.radioButtonGroup.add(this.yesBtn);
        this.radioButtonGroup.add(this.noBtn);
        this.panel.add(this.componentLabel);
        this.panel.add(this.yesBtn);
        this.panel.add(this.noBtn);

        this.type = new RadioBtnType();
    }

    @Override
    public void setLabel(String _label) {
        this.componentLabel.setText(_label);
    }

    @Override
    public void applyStyle(Style _style) {
        Style style = _style;

        // inherit properties that are not set in the given style from default.
        style.inheriteFromStyle(this.getDefaultStyle());

        // todo

        Font font = new Font(
                        style.getFont(this.getDefaultFont().getValue()),
                        0,
                        style.getFontSize(this.getDefaultFontSize().getValue()));
        this.componentLabel.setFont(font);
    }

    @Override
    public void render(UIForm _canvas) {
        _canvas.addWidget(this.panel);
    }

    @Override
    public void supress(UIForm _canvas){
        _canvas.removeWidget(this.panel);
    }

    @Override
    public void addEventListener(WidgetsEventListener _listener) {
        this.yesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionCommandValue = e.getActionCommand();
                _listener.stateChanged();
            }
        });

        this.noBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionCommandValue = e.getActionCommand();
                _listener.stateChanged();
            }
        });
    }

    @Override
    public BoolValue getWidgetValue() {
        if (this.actionCommandValue.equals(this.yesLabel)) {
            return new BoolValue(true);
        }
        return new BoolValue(false);
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        BoolValue value = (BoolValue) _value;
        if (value.getValue().equals(true)) {
            this.yesBtn.setSelected(true);
            this.noBtn.setSelected(false);
        } else {
            this.yesBtn.setSelected(false);
            this.noBtn.setSelected(true);
        }
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.panel.setEnabled(false);
    }

    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>();
        supportedTypes.add(new BoolType());
        supportedTypes.add(new StringType());

        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitRadioBtn(this);
    }
}
