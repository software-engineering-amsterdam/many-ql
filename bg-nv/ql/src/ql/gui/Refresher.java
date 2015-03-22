package ql.gui;

import ql.gui.input.Input;
import ql.semantics.ValueTable;
import ql.semantics.values.Value;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Nik on 3-3-15.
 */
public class Refresher implements Observer
{
    private final Set<Refreshable> items;
    private final ValueTable valueTable;

    public Refresher(ValueTable valueTable)
    {
        this.valueTable = valueTable;
        this.items = new HashSet<>();
    }

    public void addItem(Refreshable item)
    {
        this.items.add(item);
    }

    public void refresh()
    {
        for (Refreshable refreshable : this.items)
        {
            refreshable.refreshElement(this.valueTable);
        }
    }

    @Override
    public void update(Observable o, Object arg)
    {
        Input input = (Input) o;
        valueTable.storeEntry(input.getId(), (Value) arg);

        this.evaluatePrerequisites(this.getPrerequisites());
        this.evaluate(this.getNonPrerequisites());

        for (Refreshable refreshable : this.items)
        {
            refreshable.refreshElement(this.valueTable);
        }
    }

    private void evaluatePrerequisites(Set<Refreshable> items)
    {
        Set<Refreshable> unresolved = this.evaluate(items);
        if (!unresolved.equals(items))
        {
            this.evaluatePrerequisites(unresolved);
        }
    }

    private Set<Refreshable> evaluate(Set<Refreshable> items)
    {
        Set<Refreshable> unresolved = new HashSet<>();
        for (Refreshable r : items)
        {
            Value val = r.evaluate(this.valueTable);
            if (val.isUndefined())
            {
                unresolved.add(r);
            }
        }
        return unresolved;
    }

    // TODO:
    private Set<Refreshable> getPrerequisites()
    {
        return this.items
                .stream()
                .filter(p -> p.isRefreshPrerequisite())
                .collect(Collectors.toCollection(HashSet::new));
    }

    private Set<Refreshable> getNonPrerequisites()
    {
        return this.items
                .stream()
                .filter(p -> !p.isRefreshPrerequisite())
                .collect(Collectors.toCollection(HashSet::new));
    }
}
