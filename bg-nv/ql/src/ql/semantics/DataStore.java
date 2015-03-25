package ql.semantics;

import ql.semantics.values.Value;

import java.io.File;

/**
 * Created by Nik on 22-03-2015
 */
public abstract class DataStore
{
    private final CondQuestionTable questions;
    private final ValueTable valueTable;

    public DataStore(CondQuestionTable questions, ValueTable valueTable)
    {
        this.questions = questions;
        this.valueTable = valueTable;
    }

    protected CondQuestionTable getQuestions()
    {
        return this.questions;
    }

    protected Value getAnswer(String questionId)
    {
        return this.valueTable.getValue(questionId);
    }

    public abstract void save(File file);
}
