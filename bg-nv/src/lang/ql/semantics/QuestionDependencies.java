package lang.ql.semantics;

import lang.ql.ast.statement.Question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by bore on 17/02/15.
 */
public class QuestionDependencies
{
    private Map<String, Set<Question>> dependencies;
    private Map<String, Question> idToQuestion;

    public QuestionDependencies()
    {
        this.dependencies = new HashMap<String, Set<Question>>();
        this.idToQuestion = new HashMap<String, Question>();
    }

    public Question getQuestionById(String id)
    {
        return this.idToQuestion.get(id);
    }

    public void addDependency(Question q)
    {
        String id = q.getId();
        if (!(this.dependencies.containsKey(id)))
        {
            this.idToQuestion.put(id, q);
            this.dependencies.put(id, new HashSet<Question>());
        }
    }

    public void addDependency(Question q, Question dep)
    {
        String id = q.getId();
        if (this.dependencies.containsKey(id))
        {
            this.dependencies.get(id).add(dep);
        }

        this.addDependency(q);
        this.dependencies.get(id).add(dep);
    }
}
