package com.klq.ast;

import com.klq.ast.impl.ComputedQuestionNode;
import com.klq.ast.impl.ConditionalNode;
import com.klq.ast.impl.QuestionNode;
import com.klq.ast.impl.QuestionnaireNode;

/**
 * Created by juriaan on 2-3-15.
 */
public interface IStatementVisitor<T> extends IVisitor{
    @Override
    public T visit(QuestionnaireNode node);
    @Override
    public T visit(QuestionNode node);
    @Override
    public T visit(ComputedQuestionNode node);
    @Override
    public T visit(ConditionalNode node);
}
