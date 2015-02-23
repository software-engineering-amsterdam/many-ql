package lang.ql.semantics;

import lang.ql.ast.statement.Question;
import lang.ql.semantics.errors.Message;
import lang.ql.semantics.errors.Warning;

import java.util.*;

/**
 * Created by bore on 20/02/15.
 */
public class QuestErrInfo
{
    private List<Message> messages;
    private Set<Question> questions;
    private Map<String, String> labelToId;

    public QuestErrInfo()
    {
        this.messages = new ArrayList<Message>();
        this.questions = new HashSet<Question>();
        this.labelToId = new HashMap<String, String>();
    }

    public List<Message> getMessages()
    {
        return this.messages;
    }

    public void addMessage(Message m)
    {
        this.messages.add(m);
    }

    public void addQuestion(Question q)
    {
        this.questions.add(q);
        this.addLabelQuestion(q);
    }

    public List<Question> getQuestionsById(String id)
    {
        List<Question> result = new ArrayList<Question>();
        for (Question q : this.questions)
        {
            if (q.getId().equals(id))
            {
                result.add(q);
            }
        }

        return result;
    }

    private void addLabelQuestion(Question q)
    {
        String label = q.getLabel();
        if (this.labelToId.containsKey(label))
        {
            String id = this.labelToId.get(label);
            this.addMessage(Warning.labelDuplication(id));
        }
        else
        {
            this.labelToId.put(q.getLabel(), q.getId());
        }
    }
}
