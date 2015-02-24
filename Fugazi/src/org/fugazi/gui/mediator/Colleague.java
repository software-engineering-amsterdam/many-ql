package org.fugazi.gui.mediator;

public abstract class Colleague {
    protected final IMediator mediator;

    public Colleague(IMediator _med) {
        this.mediator = _med;
    }

    public void send(String message) {
        this.mediator.send(message, this);
    }

    public IMediator getMediator() {
        return this.mediator;
    }

    public abstract void receive(String message);
}
