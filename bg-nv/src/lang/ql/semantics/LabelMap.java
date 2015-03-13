package lang.ql.semantics;

import lang.ql.ast.statement.Question;

import java.util.*;

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
        if (this.labelToId.containsKey(label))
        {
            this.labelToId.get(label).add(id);
        }
        else
        {
            Identifiers ids = new Identifiers();
            ids.add(id);
            this.labelToId.put(label, ids);
        }
    }

    public LabelDuplicates getLabelDuplicatesSet()
    {
        LabelDuplicates result = new LabelDuplicates();

        for (Identifiers identifiers : this.labelToId.values())
        {
            if (this.containsDuplicates(identifiers))
            {
                result.add(identifiers);
            }
        }

        return result;
    }

    private boolean containsDuplicates(Identifiers id)
    {
        return id.size() > 1;
    }
}
