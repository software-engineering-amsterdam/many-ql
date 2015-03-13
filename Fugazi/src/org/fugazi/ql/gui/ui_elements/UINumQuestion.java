package org.fugazi.ql.gui.ui_elements;

import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.IntValue;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.widgets.IntegerOnlyTextBox;
import org.fugazi.ql.gui.widgets.WidgetsFactory;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UINumQuestion extends UIQuestion {

    private Integer value;

    public UINumQuestion(IMediator _med, Question _question) {
        super(_med, _question);
        this.value = 0; // default

        WidgetsFactory widgetsFactory = new WidgetsFactory();

        this.widget = widgetsFactory.getDefaultWidgetForType(_question.getType(), _question.getLabel());

        this.widget.addEventListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                setState(widget.getValue().toString());
            }
            public void removeUpdate(DocumentEvent e) {}
            public void changedUpdate(DocumentEvent e) {}
        });
    }

    public void setState(String _value) {

        if (_value.equals("")) {
            this.value = 0;
        } else {
            this.value = Integer.parseInt(_value);
        }

        this.sendToMediator();
    }

    @Override
    public ExpressionValue getState() {
        return new IntValue(value);
    }
}
