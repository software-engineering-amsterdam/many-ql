package lang.ql.semantics;

import lang.ql.ast.statement.Question;

import java.util.*;

/**
 * Created by bore on 17/02/15.
 */
public class QuestionDependencies
{
    private Map<String, Set<String>> dependencies;

    public QuestionDependencies()
    {
        this.dependencies = new HashMap<String, Set<String>>();
    }

    public void addQuestion(Question q)
    {
        String id = q.getId();
        if (!(this.dependencies.containsKey(id)))
        {
            this.dependencies.put(id, new HashSet<String>());
        }
    }

    public void addDependency(Question q, Question dep)
    {
        String id = q.getId();
        assert this.dependencies.containsKey(id);
//        if (!this.dependencies.containsKey(id))
//        {
//            this.addQuestion(q);
//        }

        this.dependencies.get(id).add(dep.getId());
    }

    public List<String> findCycle()
    {
        for (String k : this.dependencies.keySet())
        {
            List<String> buffer = new ArrayList<String>();
            buffer.add(k);
            List<String> result = this.searchNeighbours(buffer);
            if (result != null)
            {
                return result;
            }
        }
        return null;
    }

    private List<String> searchNeighbours(List<String> path)
    {
        String firstElement = path.get(0);
        String lastElement = path.get(path.size()-1);
        Set<String> neighbours = this.dependencies.get(lastElement);

        for (String n : neighbours)
        {
            if (n.equals(firstElement))
            {
                return path;
            }
            path.add(n);
            List<String> result = searchNeighbours(path);
            if (result != null)
            {
                return result;
            }
            path.remove(path.size() - 1);
        }
        return null;
    }
}