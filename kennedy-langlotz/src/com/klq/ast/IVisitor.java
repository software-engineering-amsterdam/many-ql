package com.klq.ast;

import com.klq.ast.impl.*;
import com.klq.ast.impl.expr.*;

/**
 * Created by juriaan on 10-2-15.
 */
public interface IVisitor {
    public void visit(QuestionnaireNode node);
    public void visit(QuestionNode node);
    public void visit(ComputedQuestionNode node);
    public void visit(StringNode node);
    public void visit(NumberNode node);
    public void visit(DateNode node);
    public void visit(ANode node);
    public void visit(MultiplyNode node);
    public void visit(DivideNode node);
    public void visit(AddNode node);
    public void visit(SubtractNode node);
    public void visit(ConditionalNode node);
    public void visit(GreaterThanNode node);
}
