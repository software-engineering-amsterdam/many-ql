package com.klq.ast;

import com.klq.ast.impl.*;
import com.klq.ast.impl.StringNode;
import com.klq.ast.impl.NumberNode;

/**
 * Created by juriaan on 10-2-15.
 */
public interface IVisitor {
    public void visit(QuestionnaireNode node);
    public void visit(QuestionNode node);
    public void visit(ComputedQuestionNodeNode node);
    public void visit(StringNode node);
    public void visit(NumberNode node);
    public void visit(DateNode node);
    public void visit(ANode node);
}
