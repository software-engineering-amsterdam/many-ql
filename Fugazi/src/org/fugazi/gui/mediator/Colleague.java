package org.fugazi.gui.mediator;

import org.fugazi.evaluator.expression_value.ExpressionValue;

public abstract class Colleague {
    private final IMediator mediator;

    public Colleague(IMediator _med) {
        this.mediator = _med;
    }

    protected void sendToMediator() {
        this.mediator.getChangeFromColleagues(this);
    }
    
    public abstract ExpressionValue getState();
    public abstract String getId();
}
