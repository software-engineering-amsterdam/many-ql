package lang.ql.semantics;

import lang.ql.semantics.errors.Messages;

/**
 * Created by bore on 23/02/15.
 */
public class QuestionResult
{
    private final QuestionMap table;
    private final Messages messages;

    public QuestionResult(QuestionMap table, Messages messages)
    {
        this.table = table;
        this.messages = messages;
    }

    public QuestionMap getQuestionMap()
    {
        return this.table;
    }

    public Messages getMessages()
    {
        return this.messages;
    }

    public boolean containsErrors()
    {
        return this.messages.containError();
    }
}
