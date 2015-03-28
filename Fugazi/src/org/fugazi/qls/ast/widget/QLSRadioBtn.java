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
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QLSRadioBtn extends AbstractQLSWidget {

    private static final String DEFAULT_YES_TEXT = "Yes";
    private static final String DEFAULT_NO_TEXT = "No";
    
    private String actionCommandValue;
    private final String yesLabel;
    private final String noLabel;
    
    private ButtonGroup radioButtonGroup;
    private JRadioButton yesBtn;
    private JRadioButton noBtn;

    public QLSRadioBtn() {
        this("", DEFAULT_YES_TEXT, DEFAULT_NO_TEXT);
    }

    public QLSRadioBtn(String _yes, String _no) {
        this("", _yes, _no);
    }

    public QLSRadioBtn(String _label, String _yes, String _no) {
        this.yesLabel = _yes;
        this.noLabel = _no;

        this.componentLabel.setText(_label);

        this.yesBtn = new JRadioButton(_yes);
        this.noBtn = new JRadioButton(_no);
        this.radioButtonGroup = new ButtonGroup();

        this.radioButtonGroup.add(this.yesBtn);
        this.radioButtonGroup.add(this.noBtn);
        this.component.add(this.componentLabel);
        this.component.add(this.yesBtn);
        this.component.add(this.noBtn);

        this.type = new RadioBtnType();
    }
    
    @Override
    public void applyStyle(Style _style) {
        _style.inheriteFromStyle(this.getDefaultStyle());

        Font font = new Font(
            _style.getFont(this.getDefaultFont().getValue()), 0,
            _style.getFontSize(this.getDefaultFontSize().getValue())
        );
        this.componentLabel.setFont(font);

        Color color = _style.getColor(this.getDefaultColor().getValue());
        this.componentLabel.setForeground(color);

        this.yesBtn.setPreferredSize(new Dimension(
                this.getDefaultWidth().getValue(),
                (int) this.yesBtn.getPreferredSize().getHeight()
        ));
        this.noBtn.setPreferredSize(new Dimension(
                this.getDefaultWidth().getValue(),
                (int) this.noBtn.getPreferredSize().getHeight()
        ));
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
        } else if (this.actionCommandValue.equals(this.noLabel)) {
            return new BoolValue(false);
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
        this.component.setEnabled(false);
    }

    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>(
                Arrays.asList(
                        new BoolType(),
                        new StringType()
                )
        );
        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitRadioBtn(this);
    }
}
