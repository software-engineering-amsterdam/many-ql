package org.fugazi.gui;

import org.fugazi.ValueStorage;
import org.fugazi.gui.mediator.Colleague;
import org.fugazi.gui.mediator.IMediator;

import java.util.ArrayList;

public class UIMediator implements IMediator {

    private ArrayList<Colleague> colleagues;
    private final ValueStorage storage;

    public UIMediator(ValueStorage _storage) {
        this.storage = _storage;
        this.colleagues = new ArrayList<>();
    }

    public void addColleague(Colleague _colleague) {
        this.colleagues.add(_colleague);
    }

    public void notify(Colleague _origin) {
        // log change
        System.out.println("UI: " + _origin.getId() + " : " + _origin.getState().getValue());
        
        // Save value to storage.
        this.storage.saveValue(_origin.getId(), _origin.getState());

        // todo
        // 1. evaluate
        // 2. render
    }
}
