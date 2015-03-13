package org.fugazi.ql.gui.ui_elements;

import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.widgets.WidgetsFactory;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UIBoolQuestion extends UIQuestion {

    class BoolQuestionListener implements ItemListener {

        private final UIBoolQuestion question;
        BoolQuestionListener(UIBoolQuestion _question) {
            this.question = _question;
        }

        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                question.setState(true);
            } else {
                question.setState(false);
            }
        }
    }

    private Boolean value;

    public UIBoolQuestion(IMediator _med, Question _question) {
        super(_med, _question);
        this.value = false; // default

        WidgetsFactory widgetsFactory = new WidgetsFactory();

        this.widget = widgetsFactory.getDefaultWidgetForType(_question.getType(), _question.getLabel());
        this.widget.addEventListener(new BoolQuestionListener(this));
    }

    public void setState(Boolean _value) {
        value = _value;
        this.sendToMediator();
    }

    @Override
    public ExpressionValue getState() {
        return new BoolValue(value);
    }
}
