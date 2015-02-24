package org.fugazi.gui;

import org.fugazi.gui.mediator.Colleague;
import org.fugazi.gui.mediator.IMediator;

import java.util.ArrayList;

public class UIMediator implements IMediator {

    private ArrayList<Colleague> colleagues;

    public UIMediator() {
        this.colleagues = new ArrayList<>();
    }

    public void addColleague(Colleague _colleague) {
        this.colleagues.add(_colleague);
    }

    public void notify(Colleague _origin) {
        System.out.println(_origin);
    }
}
