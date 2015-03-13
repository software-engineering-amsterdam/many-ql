package org.fugazi.ql.gui.ui_elements;

import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.StringValue;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.widgets.TextBox;
import org.fugazi.ql.gui.widgets.WidgetsFactory;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UITextQuestion extends UIQuestion {

    private String value;
    
    public UITextQuestion(IMediator _med, Question _question) {
        super(_med, _question);
        this.value = ""; // default

        WidgetsFactory widgetsFactory = new WidgetsFactory();

        this.widget = widgetsFactory.getDefaultWidgetForType(_question.getType(), _question.getLabel());
        
        this.widget.addEventListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                setState(
                        widget.getValue().toString()
                );
            }
            public void removeUpdate(DocumentEvent e) {}
            public void changedUpdate(DocumentEvent e) {}
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
