package org.fugazi.gui;

import org.fugazi.gui.mediator.Colleague;
import org.fugazi.gui.mediator.IMediator;

import java.util.ArrayList;

public class UIMediator implements IMediator {

    private ArrayList<Colleague> colleagues;

    public UIMediator() {
        this.colleagues = new ArrayList<Colleague>();
    }

    public void addColleague(Colleague _colleague) {
        this.colleagues.add(_colleague);
    }

    public void notify(Colleague _origin) {
        // log change
        System.out.println(_origin.getId() + " : " + _origin.getState().getValue());

        // todo
        // 1. evaluate
        // 2. render
    }
}
