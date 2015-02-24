package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;
import org.fugazi.evaluator.expression_value.BoolValue;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.gui.UIMediator;
import org.fugazi.gui.widgets.CheckBox;
import java.awt.event.ItemEvent;

public class UIBoolQuestion extends UIQuestion {

    private BoolValue value;

    public UIBoolQuestion(UIMediator _med, Question _question) {
        super(_med, _question);

        // TODO: get it from a GUI Designer
        this.widget = new CheckBox(_question.getLabel());
        this.widget.addItemListener(event -> itemChanged(event));
    }

    private void itemChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            this.setState(new BoolValue(true));
        } else {
            this.setState(new BoolValue(false));
        }
    }

    public void setState(BoolValue _value) {
        value = _value;
        this.sendToMediator();
    }

    @Override
    public ExpressionValue getState() {
        return value;
    }
}
