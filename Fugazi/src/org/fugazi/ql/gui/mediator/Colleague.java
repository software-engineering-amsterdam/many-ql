package org.fugazi.ql.gui.mediator;

import org.fugazi.ql.evaluator.expression_value.ExpressionValue;

// TODO Alex is this the best naming? This does not tell you much about what it is.
// We are colleagues too.
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
