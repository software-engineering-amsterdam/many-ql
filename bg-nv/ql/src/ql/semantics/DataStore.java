package ql.semantics;

import ql.semantics.errors.*;
import ql.semantics.values.Value;

import java.io.File;

/**
 * Created by Nik on 22-03-2015
 */
public abstract class DataStore
{
    private final CondQuestionTable questions;
    private final ValueTable valueTable;
    private Message message;

    public DataStore(CondQuestionTable questions, ValueTable valueTable)
    {
        this.questions = questions;
        this.valueTable = valueTable;
    }

    public Message getMessage()
    {
        return this.message;
    }

    protected CondQuestionTable getQuestions()
    {
        return this.questions;
    }

    protected Value getAnswer(String questionId)
    {
        return this.valueTable.getValue(questionId);
    }

    protected void addMessage(Message message)
    {
        this.message = message;
    }

    //TODO: why does this take a file? that makes no sense!
    public abstract Boolean save(File file);
}
