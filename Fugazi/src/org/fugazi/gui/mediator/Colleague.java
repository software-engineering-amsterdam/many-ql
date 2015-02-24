package org.fugazi.gui.mediator;

public abstract class Colleague {
    private final IMediator mediator;

    public Colleague(IMediator _med) {
        this.mediator = _med;
    }

    protected void send() {
        this.mediator.notify(this);
    }

    // todo: YANGI?
    public abstract void receive(String message);
}
