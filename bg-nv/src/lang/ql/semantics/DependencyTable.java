package lang.ql.semantics;

import java.util.*;

/**
 * Created by Nik on 24-2-15.
 */
public class DependencyTable
{
    private Map<String, Set<String>> dependencies;

    public DependencyTable()
    {
        this.dependencies = new HashMap<String, Set<String>>();
    }

    public void addDependant(String subject, String dependant)
    {
        if (!this.dependencies.containsKey(subject)){
            this.dependencies.put(subject, new HashSet<String>());
        }

        this.dependencies.get(subject).add(dependant);
    }

    public Set<String> getDependants(String subject)
    {
        if (!this.dependencies.containsKey(subject))
        {
            // TODO: I'm not sure I want to do this
            return Collections.emptySet();
        }
        return dependencies.get(subject);
    }
}
