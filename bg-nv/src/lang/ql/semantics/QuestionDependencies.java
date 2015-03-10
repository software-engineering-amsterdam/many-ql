package lang.ql.semantics;

import lang.ql.ast.statement.Question;

import java.util.*;

/**
 * Created by bore on 17/02/15.
 */
public class QuestionDependencies
{
    private Map<String, Set<String>> dependencies;
    private List<String> cyclicIds;

    public QuestionDependencies()
    {
        this.dependencies = new HashMap<>();
    }

    public void addQuestion(Question q)
    {
        String id = q.getId();
        if (!(this.dependencies.containsKey(id)))
        {
            this.dependencies.put(id, new HashSet<>());
        }
    }

    public void addDependency(Question q, Question dep)
    {
        String id = q.getId();

        assert this.dependencies.containsKey(id);

        this.dependencies.get(id).add(dep.getId());
    }

    public boolean containsCycle()
    {
        for (String k : this.dependencies.keySet())
        {
            Stack<String> path = new Stack<>();
            path.add(k);
            if (this.searchNeighborForCycle(path))
            {
                return true;
            }
        }

        return false;
    }

    public List<String> getCycle()
    {
        return this.cyclicIds;
    }

    private boolean searchNeighborForCycle(Stack<String> path)
    {
        String lastElement = path.lastElement();
        Set<String> neighbours = this.dependencies.get(lastElement);

        for (String n : neighbours)
        {
            if (this.isNClosingCycle(path, n))
            {
                return true;
            }

            path.push(n);
            if (this.searchNeighborForCycle(path))
            {
                return true;
            }
            path.pop();
        }

        return false;
    }

    private boolean isNClosingCycle(Stack<String> path, String n)
    {
        String firstElement = path.firstElement();
        if (firstElement.equals(n))
        {
            this.cyclicIds = new ArrayList<>();
            this.cyclicIds.addAll(path);
            return true;
        }

        return false;
    }
}