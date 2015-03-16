package ql.gui;

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
    private Set<Refreshable> items;

    public Refresher()
    {
        this.items = new HashSet<>();
    }

    public void addItem(Refreshable item)
    {
        this.items.add(item);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        ValueTable valueTable = (ValueTable) arg;

        this.evaluatePrerequisites(this.getPrerequisites(), valueTable);
        this.evaluate(this.getNonPrerequisites(), valueTable);

        for (Refreshable r : this.items)
        {
            r.refreshElement(valueTable);
        }
    }

    private void evaluatePrerequisites(Set<Refreshable> items, ValueTable valueTable)
    {
        Set<Refreshable> unresolved = this.evaluate(items, valueTable);
        if (!unresolved.equals(items))
        {
            this.evaluatePrerequisites(unresolved, valueTable);
        }
    }

    private Set<Refreshable> evaluate(Set<Refreshable> items, ValueTable valueTable)
    {
        Set<Refreshable> unresolved = new HashSet<>();
        for (Refreshable r : items)
        {
            Value val = r.evaluate(valueTable);
            if (val.isUndefined())
            {
                unresolved.add(r);
            }
        }
        return unresolved;
    }

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
