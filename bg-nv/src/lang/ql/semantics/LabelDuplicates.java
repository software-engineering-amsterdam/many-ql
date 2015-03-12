package lang.ql.semantics;

import java.util.*;

/**
 * Created by bore on 12/03/15.
 */
public class LabelDuplicates implements Iterable<Identifiers>
{
    private final Set<Identifiers> duplicates;

    public LabelDuplicates()
    {
        this.duplicates = new HashSet<>();
    }

    public void add(Identifiers duplicates)
    {
        this.duplicates.add(duplicates);
    }

    public Iterator<Identifiers> iterator()
    {
        return this.duplicates.iterator();
    }
}
