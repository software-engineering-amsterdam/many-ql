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

    public void send(String _message, Colleague _origin) {

        System.out.println(_message);

        // stuff...

        // Todo: YANGI?
        for (Colleague colleague: colleagues)
            if (colleague != _origin)
                colleague.receive(_message);
    }
}
