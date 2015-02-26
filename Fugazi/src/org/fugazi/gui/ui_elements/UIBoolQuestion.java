package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;
import org.fugazi.evaluator.expression_value.BoolValue;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.gui.mediator.IMediator;
import org.fugazi.gui.widgets.CheckBox;
import java.awt.event.ItemEvent;

public class UIBoolQuestion extends UIQuestion {

    private Boolean value;

    public UIBoolQuestion(IMediator _med, Question _question) {
        super(_med, _question);
        this.value = false; // default

        // TODO: get it from a GUI Designer
        this.widget = new CheckBox(_question.getLabel());
        this.widget.addItemListener(event -> itemChanged(event));
    }

    private void itemChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            this.setState(true);
        } else {
            this.setState(false);
        }
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
