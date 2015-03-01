package com.klq.ast;

import com.klq.ast.impl.*;
import com.klq.ast.impl.expr.*;
import com.klq.ast.impl.expr.bool.*;
import com.klq.ast.impl.expr.math.*;

/**
 * Created by juriaan on 10-2-15.
 */
public interface IVisitor<T> {
    public T visit(QuestionnaireNode node);
    public T visit(QuestionNode node);
    public T visit(ComputedQuestionNode node);
    public T visit(StringNode node);
    public T visit(NumberNode node);
    public T visit(DateNode node);
    public T visit(ANode node);
    public T visit(MultiplyNode node);
    public T visit(DivideNode node);
    public T visit(AddNode node);
    public T visit(SubtractNode node);
    public T visit(ConditionalNode node);
    public T visit(GreaterThanNode node);
    public T visit(GreaterEqualsNode node);
    public T visit(LessThanNode node);
    public T visit(LessEqualsNode node);
    public T visit(EqualsNode node);
    public T visit(NotEqualsNode node);
    public T visit(AndNode node);
    public T visit(OrNode node);
    public T visit(IdentifierNode node);
}
