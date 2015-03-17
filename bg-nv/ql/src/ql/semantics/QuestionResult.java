package ql.semantics;

import ql.semantics.errors.Messages;

/**
 * Created by bore on 23/02/15.
 */
public class QuestionResult
{
    private final Questions table;
    private final Messages messages;

    public QuestionResult(Questions table, Messages messages)
    {
        this.table = table;
        this.messages = messages;
    }

    public Questions getQuestionMap()
    {
        return this.table;
    }

    public Messages getMessages()
    {
        return this.messages;
    }

    public boolean containsErrors()
    {
        return this.messages.containsError();
    }
}
