package org.fugazi.gui.mediator;

import org.fugazi.evaluator.expression_value.ExpressionValue;

public abstract class Colleague {
    private final IMediator mediator;

    public Colleague(IMediator _med) {
        this.mediator = _med;
    }

    protected void sendToMediator() {
        this.mediator.notify(this);
    }

    // todo: YANGI? Do I need to send messages from mediator to colleagues?
    public abstract void receive(String message);

    public abstract ExpressionValue getState();
    public abstract String getId();
}
