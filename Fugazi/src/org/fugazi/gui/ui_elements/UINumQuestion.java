package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.evaluator.expression_value.IntValue;
import org.fugazi.evaluator.expression_value.StringValue;
import org.fugazi.gui.UIMediator;
import org.fugazi.gui.widgets.NumsOnlyTextBox;
import org.fugazi.gui.widgets.TextBox;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UINumQuestion extends UIQuestion {

    private String value;

    public UINumQuestion(UIMediator _med, Question _question) {
        super(_med, _question);
        value = "";

        // TODO: get it from a GUI Designer
        this.widget = new NumsOnlyTextBox(_question.getLabel());

        this.widget.addDocumentListener(new DocumentListener() {

            // todo: looks bad...
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
        value = _value;
        this.sendToMediator();
    }

    @Override
    public ExpressionValue getState() {
        return new StringValue(value);
    }
}
