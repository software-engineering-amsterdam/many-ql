package lang.ql.semantics;

import lang.ql.ast.statement.Statement;

import java.util.*;

/**
 * Created by Nik on 24-2-15.
 */
public class DependencyTable
{
    private Map<Statement, Set<Statement>> dependencies;

    public DependencyTable()
    {
        this.dependencies = new HashMap<Statement, Set<Statement>>();
    }

    public void addDependant(Statement subject, Statement dependant)
    {
        if (!this.dependencies.containsKey(subject)){
            this.dependencies.put(subject, new HashSet<Statement>());
        }

        this.dependencies.get(subject).add(dependant);
    }

    public Set<Statement> getDependants(Statement subject)
    {
        if (!this.dependencies.containsKey(subject))
        {
            // TODO: I'm not sure I want to do this
            return Collections.emptySet();
        }
        return dependencies.get(subject);
    }
}
