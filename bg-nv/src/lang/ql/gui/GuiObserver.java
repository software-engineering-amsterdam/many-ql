package lang.ql.gui;

import lang.ql.semantics.ValueTable;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

/**
 * Created by Nik on 3-3-15.
 */
public class GuiObserver implements Observer
{
    private Set<Refreshable> refreshables;

    public GuiObserver(Set<Refreshable> refreshables)
    {
        this.refreshables = refreshables;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        ValueTable valueTable = (ValueTable)arg;
        for (Refreshable r : this.refreshables)
        {
            r.update(valueTable);
        }
    }
}
