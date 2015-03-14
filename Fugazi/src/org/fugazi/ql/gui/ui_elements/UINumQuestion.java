package org.fugazi.ql.gui.ui_elements;

import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.IntValue;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.widgets.IWidget;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UINumQuestion extends UIQuestion {

    private Integer value;

    public UINumQuestion(IMediator _med, Question _question, IWidget _widget) {
        super(_med, _question, _widget);

        this.widget.addEventListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                setState(widget.getValue().toString());
            }
            public void removeUpdate(DocumentEvent e) {}
            public void changedUpdate(DocumentEvent e) {}
        });
        this.resetState();
    }

    public void setState(String _value) {

        System.out.println(_value);
        
        if (_value.equals("")) {
            this.resetState();
        } else {
            this.value = Integer.parseInt(_value);
        }

        this.sendToMediator();
    }

    @Override
    public ExpressionValue getState() {
        return new IntValue(value);
    }

    @Override
    public void resetState() {
        this.value = 0;
        this.setState("0");
        this.widget.setValue("0");
    }
}
