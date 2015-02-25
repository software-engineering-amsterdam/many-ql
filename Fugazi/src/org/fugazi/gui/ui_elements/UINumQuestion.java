package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.evaluator.expression_value.IntValue;
import org.fugazi.evaluator.expression_value.StringValue;
import org.fugazi.gui.UIMediator;
import org.fugazi.gui.widgets.NumsOnlyTextBox;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UINumQuestion extends UIQuestion {

    private Integer value;

    public UINumQuestion(UIMediator _med, Question _question) {
        super(_med, _question);
        this.value = 0; // default

        // TODO: get it from a GUI Designer
        this.widget = new NumsOnlyTextBox(_question.getLabel());

        this.widget.addDocumentListener(new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) {
                setState(
                        Integer.parseInt(
                                widget.getValue().toString()
                        )
                );
            }

            public void removeUpdate(DocumentEvent e) {
                setState(
                        Integer.parseInt(
                                widget.getValue().toString()
                        )
                );
            }

            public void changedUpdate(DocumentEvent e) {
            }
        });

        // Todo: get initial form state OR get undefined value when no default
        this.sendToMediator();
    }

    public void setState(Integer _value) {
        value = _value;
        this.sendToMediator();
    }

    @Override
    public ExpressionValue getState() {
        return new IntValue(value);
    }
}
