package com.klq.ast;

import com.klq.ast.impl.stmt.ComputedQuestionNode;
import com.klq.ast.impl.stmt.ConditionalNode;
import com.klq.ast.impl.stmt.QuestionNode;
import com.klq.ast.impl.stmt.QuestionnaireNode;

/**
 * Created by juriaan on 2-3-15.
 */
public interface IStatementVisitor<T>{
    public T visit(QuestionnaireNode node);
    public T visit(QuestionNode node);
    public T visit(ComputedQuestionNode node);
    public T visit(ConditionalNode node);
    public T visit(ANode node);
}
