package ql.semantics;

import ql.ast.statement.Question;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bore on 23/02/15.
 */
public class LabelMap
{
    private final Map<String, Identifiers> labelToId;

    public LabelMap()
    {
        this.labelToId = new HashMap<>();
    }

    public void registerLabel(Question q)
    {
        String label = q.getLabel();
        String id = q.getId();
        if (!(this.labelToId.containsKey(label)))
        {
            this.labelToId.put(label, new Identifiers());
        }
        this.labelToId.get(label).add(id);
    }

    public LabelDuplicates getLabelDuplicatesSet()
    {
        LabelDuplicates result = new LabelDuplicates();

        this.labelToId.values().stream()
                .filter(identifiers -> this.containsDuplicates(identifiers))
                .forEach(result::add);

        return result;
    }

    private boolean containsDuplicates(Identifiers id)
    {
        return id.size() > 1;
    }
}
