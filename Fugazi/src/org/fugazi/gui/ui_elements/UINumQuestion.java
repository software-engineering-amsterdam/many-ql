package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.evaluator.expression_value.IntValue;
import org.fugazi.gui.mediator.IMediator;
import org.fugazi.gui.widgets.IntegerOnlyTextBox;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UINumQuestion extends UIQuestion {

    private Integer value;

    public UINumQuestion(IMediator _med, Question _question) {
        super(_med, _question);
        this.value = 0; // default

        // TODO: get it from a GUI Designer
        this.widget = new IntegerOnlyTextBox(_question.getLabel());

        this.widget.addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                setState(widget.getValue().toString());
            }

            public void removeUpdate(DocumentEvent e) {
                setState(widget.getValue().toString());
            }

            public void changedUpdate(DocumentEvent e) {
            }
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
